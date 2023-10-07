package com.agroassist.agroassistant.controllers.fields;

import com.agroassist.agroassistant.controllers.BaseController;
import com.agroassist.agroassistant.models.Field;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FieldsController extends BaseController {

    private ObservableList<Field> fieldsData= FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> ColumnArea;

    @FXML
    private TableColumn<?, ?> ColumnCrop;

    @FXML
    private TableColumn<?, ?> ColumnFieldNumber;

    @FXML
    private TableColumn<?, ?> ColumnID;

    @FXML
    private TableColumn<?, ?> ColumnKind;

    @FXML
    private TableView<?> TableFields;

    @FXML
    private Button buttonAddField;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonDeleteField;

    @FXML
    private Button buttonEditField;

    @FXML
    void initialize(){
        buttonAddField.setOnAction(event -> {
            setScene(buttonAddField, basePath + "forms/fields/AddFields.fxml");
        });

        buttonEditField.setOnAction(event -> {
            setScene(buttonEditField, basePath + "forms/fields/EditFields.fxml");
        });

        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/Menu.fxml");
        });
    }
}
