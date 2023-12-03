package com.agroassist.agroassistant.controllers.crops;

import com.agroassist.agroassistant.controllers.BaseController;
import com.agroassist.agroassistant.models.Crop;
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

public class CropsController extends BaseController {
    @FXML
    private TableColumn<Crop, String> ColumnFieldNumber;

    @FXML
    private TableColumn<Crop, Integer> ColumnID;

    @FXML
    private TableColumn<Crop, Integer> ColumnBrutto;

    @FXML
    private TableColumn<Crop, Integer> ColumnTara;

    @FXML
    private TableColumn<Crop, Integer> ColumnNetto;

    @FXML
    private TableColumn<Crop, Date> ColumnDate;

    @FXML
    private TableView<Crop> TableCrops;

    @FXML
    private Button buttonAddCrops;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonCalculateGrow;

    @FXML
    private Button buttonCompare;

    @FXML
    private Button buttonDeleteCrops;

    @FXML
    private Button buttonEditCrops;

    @FXML
    private Button buttonCalculateCentner;

    protected static int idCrop;

    @FXML
    void initialize(){
        ObservableList<Crop> cropsData = initData();

        // устанавливаем тип и значение которое должно хранится в колонке
        ColumnID.setCellValueFactory(new PropertyValueFactory<Crop, Integer>("id"));
        ColumnFieldNumber.setCellValueFactory(new PropertyValueFactory<Crop, String>("fieldNumber"));
        ColumnBrutto.setCellValueFactory(new PropertyValueFactory<Crop, Integer>("brutto"));
        ColumnTara.setCellValueFactory(new PropertyValueFactory<Crop, Integer>("tara"));
        ColumnNetto.setCellValueFactory(new PropertyValueFactory<Crop, Integer>("netto"));
        ColumnDate.setCellValueFactory(new PropertyValueFactory<Crop, Date>("date"));

        // заполняем таблицу данными
        TableCrops.setItems(cropsData);

        TableView.TableViewSelectionModel<Crop> selectionModel = TableCrops.getSelectionModel();
        selectionModel.selectedItemProperty().addListener(new ChangeListener<Crop>(){

            public void changed(ObservableValue<? extends Crop> val, Crop oldVal, Crop newVal){
                if(newVal != null){
                    idCrop = newVal.getId();
                }
            }
        });

        buttonDeleteCrops.setOnAction(event ->{
            if (deleteCrop(idCrop)){
                System.out.println("Данные об урожае удалены");
            }

            ObservableList<Crop> cropsData1 = initData();

            // устанавливаем тип и значение которое должно хранится в колонке
            ColumnID.setCellValueFactory(new PropertyValueFactory<Crop, Integer>("id"));
            ColumnFieldNumber.setCellValueFactory(new PropertyValueFactory<Crop, String>("fieldNumber"));
            ColumnBrutto.setCellValueFactory(new PropertyValueFactory<Crop, Integer>("brutto"));
            ColumnTara.setCellValueFactory(new PropertyValueFactory<Crop, Integer>("tara"));
            ColumnNetto.setCellValueFactory(new PropertyValueFactory<Crop, Integer>("netto"));
            ColumnDate.setCellValueFactory(new PropertyValueFactory<Crop, Date>("date"));

            // заполняем таблицу данными
            TableCrops.setItems(cropsData1);
        });

        buttonAddCrops.setOnAction(event -> {
            setScene(buttonAddCrops, basePath + "forms/crops/addCrops.fxml");
        });

        buttonEditCrops.setOnAction(event -> {
            setScene(buttonEditCrops, basePath + "forms/crops/EditCrops.fxml");
        });

        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/Menu.fxml");
        });
    }

    private ObservableList<Crop> initData(){
        return getCrops();
    }
}
