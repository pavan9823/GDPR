module com.gdpr {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gdpr to javafx.fxml;
    exports com.gdpr;
}