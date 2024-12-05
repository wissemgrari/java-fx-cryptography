package com.wissem.text;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class TextController {
  
  @FXML private TextArea encText, encRes, decText, decRes;
  @FXML private TextField encSecretKey, decSecretKey;
  
  public void encryptText() {
    try {
      String encryptedText = TextEncryption.encrypt(encText.getText(), encSecretKey.getText());
      encRes.setText(encryptedText);
    }
    catch (Exception e) {
      encRes.setText("Encryption failed: " + e.getMessage());
    }
  }
  
  public void decryptText() {
    try {
      String decryptedText = TextEncryption.decrypt(decText.getText(), decSecretKey.getText());
      decRes.setText(decryptedText);
    }
    catch (Exception e) {
      decRes.setText("Decryption failed: " + e.getMessage());
    }
  }
  
  public void goHome(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/wissem/MainScene.fxml")));
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
  
}
