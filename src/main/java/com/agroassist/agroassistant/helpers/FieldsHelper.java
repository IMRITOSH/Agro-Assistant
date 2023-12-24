package com.agroassist.agroassistant.helpers;

import com.agroassist.agroassistant.validators.ValidateFields;
import javafx.scene.control.Label;

public class FieldsHelper {
    public Boolean validateField(String fieldsNumber, String area, String crop, String kind, String year, Label[] labels) {
        ValidateFields validator = new ValidateFields();
        boolean flag = true;

        String errorFieldNumber = validator.checkFieldNumber(fieldsNumber);
        if (!errorFieldNumber.isEmpty()) {
            labels[0].setText(errorFieldNumber);
            labels[0].setVisible(true);
            flag = false;
        } else {
            labels[0].setText(errorFieldNumber);
            labels[0].setVisible(true);
        }

        String errorArea = validator.checkArea(area);
        if (!errorArea.isEmpty()) {
            labels[1].setText(errorArea);
            labels[1].setVisible(true);
            flag = false;
        } else {
            labels[1].setText(errorArea);
            labels[1].setVisible(true);
        }

        String errorCrop = validator.checkCrop(crop);
        if (!errorCrop.isEmpty()) {
            labels[2].setText(errorCrop);
            labels[2].setVisible(true);
            flag = false;
        } else {
            labels[2].setText(errorCrop);
            labels[2].setVisible(true);
        }

        String errorKind = validator.checkKind(kind);
        if (!errorKind.isEmpty()) {
            labels[3].setText(errorKind);
            labels[3].setVisible(true);
            flag = false;
        } else {
            labels[3].setText(errorKind);
            labels[3].setVisible(true);
        }

        String errorDate = validator.checkDate(year);
        if (!errorDate.isEmpty()) {
            labels[4].setText(errorDate);
            labels[4].setVisible(true);
            flag = false;
        } else {
            labels[4].setText(errorDate);
            labels[4].setVisible(false);
        }

        return flag;
    }

    public void changeDefaultLabel(Label[] labels) {
        for (Label label : labels) {
            label.setText("");
            label.setVisible(false);
        }
    }

}
