module com.wissem {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.sql;
  
  opens com.wissem to javafx.fxml;
  exports com.wissem;
  exports com.wissem.text;
  opens com.wissem.text to javafx.fxml;
  exports com.wissem.file;
  opens com.wissem.file to javafx.fxml;
}
