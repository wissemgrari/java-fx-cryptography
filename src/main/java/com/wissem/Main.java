package com.wissem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
  
  public static void main(String[] args) {
    launch();
  }
  
  @Override
  public void start(Stage stage) throws IOException {
    // Load the MainScene
    FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainScene.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    
    // add css stylesheet
    String css = Objects.requireNonNull(this.getClass().getResource("/styles.css")).toExternalForm();
    scene.getStylesheets().add(css);
    
    // set the application icon
    Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/icon.png")));
    stage.getIcons().add(icon);
    
    stage.setScene(scene);
    stage.setTitle("Cryptography");
    stage.setResizable(false);
    stage.show();
  }
}
