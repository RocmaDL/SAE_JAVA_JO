# SAE_JAVA_JO

## Commande pour compiler et executer le projet sans librairie

- javac -d bin -cp src/ src/main/java/com/cdal/*.java
- java -cp bin main.java.com.cdal.Executable

## Commande pour compiler et executer le projet avec librairie de test

- javac -d bin -cp lib/junit-jupiter-api-5.3.2.jar:lib/junit-jupiter-engine-5.3.2.jar:lib/junit-platform-console-standalone-1.3.2.jar src/main/java/com/cdal/_.java src/test/java/com/cdal/_.java
- java --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls-javaagent:lib/jacocoagent.jar=destfile=jacoco.exec -cp bin:lib/junit-jupiter-api-5.3.2.jar:lib/junit-jupiter-engine-5.3.2.jar:lib/junit-platform-console-standalone-1.3.2.jar org.junit.platform.console.ConsoleLauncher --scan-class-path --class-path bin

## Commande pour executer le projet avec librairie de test et jacoco

- java -jar lib/jacococli.jar report jacoco.exec --classfiles bin --sourcefiles src/main/java --html report

## Commande pour compiler et executer le projet avec librairie de JavaFX et FXML

- javac -d bin -cp img:templates:src/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/<Chemin fichier>

Fonctonne seulement si vous placer le fichier fxml dans le dossier templates à la racine du projet, et que vous appeler le fichier fxml dans le fichier java avec le chemin `templates/<Nom du fichier>.fxml`

- java -cp img:templates:bin/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml <package>.<Nom de la classe>

## Commande pour compiler et executer le projet pour la bd

-
-

## Exemple de commande pour compiler et executer une application avec son controlleur
- javac -d bin -cp img:templates:src/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/main/java/com/cdal/controler/ControlerEpreuveResultat.java 

java -cp img:templates:bin/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml main.java.com.cdal.view.AppEnregistrerRes

