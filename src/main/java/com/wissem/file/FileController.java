package com.wissem.file;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class FileController {
  
  
  @FXML private TextField encFilePath, decFilePath;
  @FXML private TextField encSecretKey, decSecretKey;
  @FXML private Label encOutput, decOutput;
  @FXML private Pane encAlertBox, decAlertBox;
  
  // choose file for encryption
  public void encChooseFile() {
    // hide alert box if it's visible
    encAlertBox.setVisible(false);
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open File");
    File selectedFile = fileChooser.showOpenDialog(new Stage());
    if (selectedFile != null) {
      encFilePath.setText(selectedFile.getAbsolutePath());
    }
  }
  
  // choose file for decryption
  public void decChooseFile() {
    // hide alert box if it's visible
    decAlertBox.setVisible(false);
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open File");
    File selectedFile = fileChooser.showOpenDialog(new Stage());
    if (selectedFile != null) {
      decFilePath.setText(selectedFile.getAbsolutePath());
    }
  }
  
  public void encryptFile() {
    try {
      String output = FileEncryption.encryptFile(encFilePath.getText(), encSecretKey.getText());
      encOutput.setText(output);
      encAlertBox.setVisible(true);
    }
    catch (Exception e) {
      e.printStackTrace();
      encOutput.setText("An error occurred during file encryption: " + e.getMessage());
    }
  }
  
  public void decryptFile() {
    try {
      String output = FileEncryption.decryptFile(decFilePath.getText(), decSecretKey.getText());
      decOutput.setText(output);
      decAlertBox.setVisible(true);
    }
    catch (Exception e) {
      e.printStackTrace();
      decOutput.setText("An error occurred during file decryption: " + e.getMessage());
    }
  }
  
  public void goHome(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/com/wissem/MainScene.fxml"));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
  
  
}
