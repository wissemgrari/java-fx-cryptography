package com.wissem.text;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class TextEncryption {
  
  // Method to encrypt a plaintext using AES
  public static String encrypt(String plainText, String secretKey) throws Exception {
    // Generate AES key from the secretKey
    SecretKeySpec keySpec = generateKey(secretKey);
    
    // Initialize Cipher in encryption mode
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, keySpec);
    
    // Perform encryption
    byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
    
    // Return Base64-encoded encrypted string
    return Base64.getEncoder().encodeToString(encryptedBytes);
  }
  
  // Method to decrypt an encrypted text using AES
  public static String decrypt(String encryptedText, String secretKey) throws Exception {
    // Generate AES key from the secretKey
    SecretKeySpec keySpec = generateKey(secretKey);
    
    // Initialize Cipher in decryption mode
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.DECRYPT_MODE, keySpec);
    
    // Perform decryption
    byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
    
    // Return decrypted text as a String
    return new String(decryptedBytes);
  }
  
  // Helper method to generate a SecretKeySpec from a secretKey string
  private static SecretKeySpec generateKey(String secretKey) throws Exception {
    // Create a key generator based on a consistent seed (the secretKey)
    byte[] key = secretKey.getBytes();
    byte[] keyBytes = new byte[16]; // AES key must be 16 bytes
    System.arraycopy(key, 0, keyBytes, 0, Math.min(key.length, keyBytes.length));
    return new SecretKeySpec(keyBytes, "AES");
  }
  
}
