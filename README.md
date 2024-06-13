# SAE_JAVA_JO

Commandes pour commpiler et  executer :

javac -d bin -cp lib/junit-jupiter-api-5.3.2.jar:lib/junit-jupiter-engine-5.3.2.jar:lib/junit-platform-console-standalone-1.3.2.jar src/main/java/com/cdal/*.java src/test/java/com/cdal/*.java

java -javaagent:lib/jacocoagent.jar=destfile=jacoco.exec -cp bin:lib/junit-jupiter-api-5.3.2.jar:lib/junit-jupiter-engine-5.3.2.jar:lib/junit-platform-console-standalone-1.3.2.jar org.junit.platform.console.ConsoleLauncher --scan-class-path --class-path bin

java --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls-javaagent:lib/jacocoagent.jar=destfile=jacoco.exec -cp bin:lib/junit-jupiter-api-5.3.2.jar:lib/junit-jupiter-engine-5.3.2.jar:lib/junit-platform-console-standalone-1.3.2.jar org.junit.platform.console.ConsoleLauncher --scan-class-path --class-path bin

