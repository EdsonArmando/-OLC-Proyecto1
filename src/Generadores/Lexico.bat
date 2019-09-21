SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_141\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd ..
cd ..
cd lib
SET JFLEX_HOME= %CD%
cd ..
cd src\Analizadores
java -jar %JFLEX_HOME%\jflex-full-1.7.0.jar a_lexico.jflex
cd ..
cd Generadores
pause