package com.wissem.file;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

public class FileEncryption {
  
  // Method to encrypt a file
  public static String encryptFile(String filePath, String secretKey) throws Exception {
    // Read the file's bytes
    byte[] fileBytes = Files.readAllBytes(new File(filePath).toPath());
    
    // Encrypt the bytes
    byte[] encryptedBytes = processFile(fileBytes, secretKey, Cipher.ENCRYPT_MODE);
    
    // Create new file name with enc_ prefix
    File originalFile = new File(filePath);
    String directoryPath = originalFile.getParent();
    String originalFileName = originalFile.getName();
    String encryptedFileName = "enc_" + originalFileName;
    String encryptedFilePath = directoryPath + File.separator + encryptedFileName;
    
    // Write encrypted bytes to the new file
    try (FileOutputStream fos = new FileOutputStream(encryptedFilePath)) {
      fos.write(encryptedBytes);
    }
    return encryptedFilePath;
  }
  
  // Method to decrypt a file
  public static String decryptFile(String filePath, String secretKey) throws Exception {
    // Read the encrypted file's bytes
    byte[] fileBytes = Files.readAllBytes(new File(filePath).toPath());
    
    // Decrypt the bytes
    byte[] decryptedBytes = processFile(fileBytes, secretKey, Cipher.DECRYPT_MODE);
    
    // Create new file name with dec_ prefix
    File originalFile = new File(filePath);
    String directoryPath = originalFile.getParent();
    String originalFileName = originalFile.getName();
    String decryptedFileName;
    
    if (originalFileName.startsWith("enc_")) {
      decryptedFileName = "dec_" + originalFileName.substring(4);
    } else {
      decryptedFileName = "dec_" + originalFileName;
    }
    
    String decryptedFilePath = directoryPath + File.separator + decryptedFileName;
    
    // Write decrypted bytes to the new file
    try (FileOutputStream fos = new FileOutputStream(decryptedFilePath)) {
      fos.write(decryptedBytes);
    }
    return decryptedFilePath;
  }
  
  // Helper method to process file bytes (encrypt or decrypt)
  private static byte[] processFile(byte[] inputBytes, String secretKey, int mode) throws Exception {
    // Generate AES key from the secretKey
    SecretKeySpec keySpec = generateKey(secretKey);
    
    // Initialize Cipher
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(mode, keySpec);
    
    // Process the input bytes (encrypt or decrypt)
    return cipher.doFinal(inputBytes);
  }
  
  // Helper method to generate a SecretKeySpec from a secretKey string
  private static SecretKeySpec generateKey(String secretKey) throws Exception {
    byte[] key = secretKey.getBytes();
    byte[] keyBytes = new byte[16]; // AES key must be 16 bytes
    System.arraycopy(key, 0, keyBytes, 0, Math.min(key.length, keyBytes.length));
    return new SecretKeySpec(keyBytes, "AES");
  }
  
  // Main method to demonstrate file encryption and decryption
  public static void main(String[] args) {
    try {
      String secretKey = "mySecretKey12345"; // Secret key
      String inputFilePath = "C:/Users/wissem/Desktop/file.txt"; // Path to the input file
      String encryptedFilePath = "C:/Users/wissem/Desktop/enc_file.txt"; // Encrypted file path
      // Encrypt the file
      encryptFile(inputFilePath, secretKey);
      
      // Decrypt the file
      decryptFile(encryptedFilePath, secretKey);
      
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}
