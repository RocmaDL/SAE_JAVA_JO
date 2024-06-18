# SAE_JAVA_JO

## Commande pour compiler et executer le projet sans librairie
- javac -d bin -cp src/ src/main/java/com/cdal/*.java
- java -cp bin main.java.com.cdal.Executable

## Commande pour compiler et executer le projet avec librairie de test
- javac -d bin -cp lib/junit-jupiter-api-5.3.2.jar:lib/junit-jupiter-engine-5.3.2.jar:lib/junit-platform-console-standalone-1.3.2.jar src/main/java/com/cdal/*.java src/test/java/com/cdal/*.java
- java --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls-javaagent:lib/jacocoagent.jar=destfile=jacoco.exec -cp bin:lib/junit-jupiter-api-5.3.2.jar:lib/junit-jupiter-engine-5.3.2.jar:lib/junit-platform-console-standalone-1.3.2.jar org.junit.platform.console.ConsoleLauncher --scan-class-path --class-path bin

## Commande pour executer le projet avec librairie de test et jacoco
- java -jar lib/jacococli.jar report jacoco.exec --classfiles bin --sourcefiles src/main/java --html report

## Commande pour compiler et executer le projet avec librairie de JavaFX et FXML
- 
- 