package com.agroassist.agroassistant.controllers.fields;

import com.agroassist.agroassistant.controllers.BaseController;
import com.agroassist.agroassistant.models.Field;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class FieldsController extends BaseController {

    @FXML
    private TableColumn<Field, String> ColumnArea;

    @FXML
    private TableColumn<Field, String> ColumnCrop;

    @FXML
    private TableColumn<Field, String> ColumnFieldNumber;

    @FXML
    private TableColumn<Field, Integer> ColumnID;

    @FXML
    private TableColumn<Field, String> ColumnKind;

    @FXML
    private TableColumn<Field, Date> ColumnDate;

    @FXML
    private TableView<Field> TableFields;

    @FXML
    private Button buttonAddField;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonDeleteField;

    @FXML
    private Button buttonEditField;

    protected static int idField;

    @FXML
    void initialize(){
        ObservableList<Field> fieldsData = initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        setColumnsValue();

        // заполняем таблицу данными
        TableFields.setItems(fieldsData);

        TableView.TableViewSelectionModel<Field> selectionModel = TableFields.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Field>(){

            public void changed(ObservableValue<? extends Field> val, Field oldVal, Field newVal){
                if(newVal != null){
                    idField = newVal.getId();
                }
            }
        });

        buttonDeleteField.setOnAction(event ->{
            if (deleteField(idField)){
                System.out.println("Поле удалено");
            }

            // устанавливаем тип и значение которое должно хранится в колонке
            setColumnsValue();

            // заполняем таблицу данными
            TableFields.setItems(initData());
        });

        buttonAddField.setOnAction(event -> {
            setScene(buttonAddField, basePath + "forms/fields/AddFields.fxml");
        });

        buttonEditField.setOnAction(event -> {
            if (idField != 0) {
                setScene(buttonEditField, basePath + "forms/fields/EditFields.fxml");
            }
        });

        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/Menu.fxml");
        });
    }

    private ObservableList<Field> initData(){
        return getFields();
    }

    private void setColumnsValue() {
        ColumnID.setCellValueFactory(new PropertyValueFactory<Field, Integer>("id"));
        ColumnFieldNumber.setCellValueFactory(new PropertyValueFactory<Field, String>("fieldNumber"));
        ColumnArea.setCellValueFactory(new PropertyValueFactory<Field, String>("area"));
        ColumnCrop.setCellValueFactory(new PropertyValueFactory<Field, String>("crop"));
        ColumnKind.setCellValueFactory(new PropertyValueFactory<Field, String>("kind"));
        ColumnDate.setCellValueFactory(new PropertyValueFactory<Field, Date>("date"));
    }
}
