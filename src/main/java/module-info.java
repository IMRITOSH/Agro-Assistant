module com.agroassist.agroassistant {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.agroassist.agroassistant to javafx.fxml;
    exports com.agroassist.agroassistant;
    exports com.agroassist.agroassistant.controllers;
    opens com.agroassist.agroassistant.controllers to javafx.fxml;
    exports com.agroassist.agroassistant.controllers.crops;
    opens com.agroassist.agroassistant.controllers.crops to javafx.fxml;
    opens com.agroassist.agroassistant.controllers.fields to javafx.fxml;
    exports com.agroassist.agroassistant.controllers.fields;
}