#!/bin/bash
javac -cp ./src/main/java ./src/main/java/com/epam/training/javajunior/home_work2/*.java -d ./out/ -classpath ./libs/junit-4.12.jar
cp libs/junit-4.12.jar ./out/
cd ./out
unzip junit-4.12.jar
rm junit-4.12.jar
cd ..
jar cvfm ./out/Main.jar ./src/main/resources/META-INF/MANIFEST.MF -C ./out/ .
java -jar Main.jar
