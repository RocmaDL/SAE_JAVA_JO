if [ ! -d "bin" ]; then
  mkdir bin
fi
javac -d bin -cp img:templates:src/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/main/java/com/cdal/*.java
javac -d bin -cp img:templates:src/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/main/java/com/cdal/model/*.java
javac -d bin -cp img:templates:src/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/main/java/com/cdal/view/*.java
javac -d bin -cp img:templates:src/ --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml src/main/java/com/cdal/controler/*.java
java -cp img:templates:bin:/usr/share/java/mariadb-java-client.jar --module-path /usr/share/openjfx/lib/ --add-modules javafx.controls,javafx.fxml main.java.com.cdal.view.AppPrincipale