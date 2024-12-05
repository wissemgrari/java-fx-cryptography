package com.wissem;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Controller {
  private Stage stage;
  private Scene scene;
  private Parent root;
  
  
  public void switchToTextCryptoScene(ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TextCryptoScene.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
  
  public void switchToFileCryptoScene(ActionEvent event) throws IOException {
    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("FileCryptoScene.fxml")));
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
  
}

