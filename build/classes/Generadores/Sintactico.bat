SET JAVA_HOME="C:\Program Files\Java\jdk1.8.0_141\bin"
SET PATH=%JAVA_HOME%;%PATH%
SET CLASSPATH=%JAVA_HOME%;
cd ..
cd ..
cd lib
SET CUP_HOME=%CD%
cd ..
cd src\Analizadores
java -jar %CUP_HOME%\java-cup-11b.jar -parser analisis_sintactico -symbols Simbolos A_Sintactico.cup
cd ..
cd Generadores
pause
