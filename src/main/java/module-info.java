module com.wissem {
  requires javafx.controls;
  requires javafx.fxml;
  
  opens com.wissem to javafx.fxml;
  exports com.wissem;
  exports com.wissem.algorithm;
  opens com.wissem.algorithm to javafx.fxml;
  exports com.wissem.text;
  opens com.wissem.text to javafx.fxml;
}
