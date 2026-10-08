from pathlib import Path
import subprocess, os, json, xml.etree.ElementTree as ET
r=Path(__file__).resolve().parent
java='/opt/homebrew/opt/openjdk@21/bin/java'
javac='/opt/homebrew/opt/openjdk@21/bin/javac'
jar='/Users/betosilva/.vscode/extensions/shengchen.vscode-checkstyle-1.4.2/server/checkstyle-9.3-all.jar'
env=dict(os.environ, JAVA_HOME='/opt/homebrew/opt/openjdk@21/libexec/openjdk.jdk/Contents/Home', SEMGREP_SEND_METRICS='off')
def run(args, output=None, ok=(0,)):
    p=subprocess.run(args,cwd=r,env=env,text=True,capture_output=True)
    if output:
        (r/'relatorios'/output).write_text(p.stdout)
        (r/'relatorios'/(output+'.stderr')).write_text(p.stderr)
    if p.returncode not in ok:
        raise RuntimeError(str(args)+str(p.returncode)+'\n'+p.stderr+'\n'+p.stdout)
    return p
summary={}
for parte in ['antes','depois']:
    source=str(r/parte/'src/ProcessadorPagamento.java')
    run([javac,'-encoding','UTF-8','-g','-d',str(r/parte/'bin'),source])
    for config,label in [('google-4-espacos.xml','checkstyle'),('google-original.xml','google-original'),('metricas.xml','metricas')]:
        run([java,'-Duser.language=en','-jar',jar,'-c',str(r/'config'/config),'-f','xml',source],f'{parte}-{label}.xml',ok=tuple(range(256)))
        ET.parse(r/'relatorios'/f'{parte}-{label}.xml')
    run(['/opt/homebrew/bin/spotbugs','-textui','-effort:max','-low','-xml:withMessages','-output',str(r/'relatorios'/f'{parte}-spotbugs.xml'),str(r/parte/'bin')],f'{parte}-spotbugs.log')
    run(['/opt/homebrew/bin/semgrep','scan','--config',str(r/'config/semgrep.yaml'),'--metrics=off','--disable-version-check','--json',source],f'{parte}-semgrep.json')
    data=json.loads((r/'relatorios'/f'{parte}-semgrep.json').read_text())
    assert not data['errors'], data['errors']
    summary[parte]={
      'Checkstyle':len(ET.parse(r/'relatorios'/f'{parte}-checkstyle.xml').findall('.//error')),
      'Google original':len(ET.parse(r/'relatorios'/f'{parte}-google-original.xml').findall('.//error')),
      'SpotBugs':len(ET.parse(r/'relatorios'/f'{parte}-spotbugs.xml').findall('.//BugInstance')),
      'Semgrep':len(data['results'])}
run([javac,'-encoding','UTF-8','-cp',str(r/'depois/bin'),'-d',str(r/'testes/bin'),str(r/'testes/TesteAt11.java')])
p=run([java,'-cp',str(r/'depois/bin')+':'+str(r/'testes/bin'),'TesteAt11',str(r/'antes/bin')],'testes.txt')
print(p.stdout)
(r/'relatorios/resumo.json').write_text(json.dumps(summary,indent=2))
print(json.dumps(summary,indent=2))
