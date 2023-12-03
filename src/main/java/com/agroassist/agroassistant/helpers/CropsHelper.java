package com.agroassist.agroassistant.helpers;

import com.agroassist.agroassistant.validators.ValidateCrops;
import com.agroassist.agroassistant.validators.ValidateFields;
import javafx.scene.control.Label;

public class CropsHelper {
    public Boolean validateCrop(String fieldsNumber, String brutto, String tara, String netto, String year, Label[] labels){
        ValidateCrops validator = new ValidateCrops();
        boolean flag = true;

        String errorFieldNumber = validator.checkFieldNumber(fieldsNumber);
        if (!errorFieldNumber.isEmpty()){
            labels[0].setText(errorFieldNumber);
            labels[0].setVisible(true);
            flag = false;
        } else {
            labels[0].setText(errorFieldNumber);
            labels[0].setVisible(true);
        }

        String errorBrutto = validator.checkBrutto(brutto);
        if (!errorBrutto.isEmpty()){
            labels[1].setText(errorBrutto);
            labels[1].setVisible(true);
            flag = false;
        } else {
            labels[1].setText(errorBrutto);
            labels[1].setVisible(true);
        }

        String errorTara = validator.checkTara(tara);
        if (!errorTara.isEmpty()){
            labels[2].setText(errorTara);
            labels[2].setVisible(true);
            flag = false;
        } else {
            labels[2].setText(errorTara);
            labels[2].setVisible(true);
        }

        String errorNetto = validator.checkNetto(netto);
        if (!errorNetto.isEmpty()){
            labels[3].setText(errorNetto);
            labels[3].setVisible(true);
            flag = false;
        } else {
            labels[3].setText(errorNetto);
            labels[3].setVisible(true);
        }

        String errorDate = validator.checkDate(year);
        if (!errorDate.isEmpty()){
            labels[4].setText(errorDate);
            labels[4].setVisible(true);
            flag = false;
        } else {
            labels[4].setText(errorDate);
            labels[4].setVisible(false);
        }

        return flag;
    }

    public void changeDefaultLabel(Label[] labels){
        for (Label label : labels){
            label.setText("");
            label.setVisible(false);
        }
    }
}
