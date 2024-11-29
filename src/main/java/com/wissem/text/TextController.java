package com.wissem.text;

import com.wissem.algorithm.AES;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TextController {
  
  @FXML private TextArea encText, encRes, decText, decRes;
  @FXML private TextField encSecretKey, decSecretKey;
  
  public void encryptText() {
    try {
      String encryptedText = AES.encrypt(encText.getText(), encSecretKey.getText());
      encRes.setText(encryptedText);
    }
    catch (Exception e) {
      encRes.setText("Encryption failed: " + e.getMessage());
    }
  }
  
  public void decryptText() {
    try {
      String decryptedText = AES.decrypt(decText.getText(), decSecretKey.getText());
      decRes.setText(decryptedText);
    }
    catch (Exception e) {
      decRes.setText("Decryption failed: " + e.getMessage());
    }
  }
  
}
