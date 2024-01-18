package com.agroassist.agroassistant.validators;

public class ValidateFields {
    public String checkFieldNumber(String fieldNumber) {

        if (fieldNumber.isEmpty()) {
            return "Поле не должно быть пустым";
        } else if (fieldNumber.length() > 15) {
            return "Номер поля не должен превышать 15 символов!";
        } else if (!fieldNumber.matches("[а-яА-Яa-zA-Z0-9]+")) {
            return "Номер поля должен содеражать только буквы и цифры!";
        }

        return "";
    }

    public String checkArea(String area) {

        if (area.isEmpty()) {
            return "Поле не должно быть пустым";
        } else if (area.length() > 10) {
            return "Площадь не должна превышать 10 символов!";
        } else if (!area.matches("\\d+")) {
            return "В поле площадь должны быть только цифры!";
        }

        return "";
    }

    public String checkCrop(String crop) {

        if (crop.isEmpty()) {
            return "Поле не должно быть пустым";
        } else if (crop.length() > 15) {
            return "Культура не должна превышать 15 символов!";
        } else if (!crop.matches("[а-яА-Яa-zA-Z]+")) {
            return "В поле культура должны быть только буквенные символы!";
        }

        return "";
    }

    public String checkKind(String kind) {

        if (kind.isEmpty()) {
            return "Поле не должно быть пустым";
        } else if (kind.length() > 15) {
            return "Сорт не должен превышать 15 символов!";
        } else if (!kind.matches("[а-яА-Яa-zA-Z]+")) {
            return "В поле сорт должны быть только буквенные символы!";
        }

        return "";
    }

    public String checkDate(String date) {

        if (date.isEmpty()) {
            return "Поле не должно быть пустым";
        } else if (date.length() > 10) {
            return "Дата не должна превышать 10 символов!";
        } else if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return "Поле год должно соответствовать шаблону: ГГГГ-ММ-ДД.";
        }

        return "";
    }
}
