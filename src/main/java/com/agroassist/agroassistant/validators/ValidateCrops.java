package com.agroassist.agroassistant.validators;

public class ValidateCrops {
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

    public String checkBrutto(String brutto) {

        if (brutto.isEmpty()) {
            return "Поле не должно быть пустым";
        } else if (brutto.length() > 10) {
            return "Брутто не должно превышать 10 символов!";
        } else if (!brutto.matches("\\d+")) {
            return "В поле брутто должны быть только цифры!";
        }

        return "";
    }

    public String checkTara(String tara) {

        if (tara.isEmpty()) {
            return "Поле не должно быть пустым";
        } else if (tara.length() > 10) {
            return "Тара не должно превышать 10 символов!";
        } else if (!tara.matches("\\d+")) {
            return "В поле тара должны быть только цифры!";
        }

        return "";
    }

    public String checkNetto(String netto) {

        if (netto.isEmpty()) {
            return "Поле не должно быть пустым";
        } else if (netto.length() > 10) {
            return "Нетто не должно превышать 10 символов!";
        } else if (!netto.matches("\\d+")) {
            return "В поле нетто должны быть только цифры!";
        }

        return "";
    }

    public String checkDate(String year) {

        if (year.isEmpty()) {
            return "Поле не должно быть пустым";
        } else if (year.length() > 10) {
            return "Дата не должна превышать 10 символов!";
        } else if (!year.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return "Поле год должно соответствовать шаблону: ГГГГ-ММ-ДД.";
        }

        return "";
    }
}
