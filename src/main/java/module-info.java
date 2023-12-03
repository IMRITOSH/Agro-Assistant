module com.agroassist.agroassistant {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens com.agroassist.agroassistant to javafx.fxml;
    opens com.agroassist.agroassistant.controllers to javafx.fxml;
    opens com.agroassist.agroassistant.controllers.crops to javafx.fxml;
    opens com.agroassist.agroassistant.controllers.fields to javafx.fxml;
    opens com.agroassist.agroassistant.models to javafx.base;

    exports com.agroassist.agroassistant;
    exports com.agroassist.agroassistant.controllers;
    exports com.agroassist.agroassistant.controllers.crops;
    exports com.agroassist.agroassistant.controllers.fields;
    exports com.agroassist.agroassistant.models;
}