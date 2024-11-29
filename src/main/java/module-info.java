module com.wissem.cryptography {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.wissem.cryptography to javafx.fxml;
    exports com.wissem.cryptography;
}