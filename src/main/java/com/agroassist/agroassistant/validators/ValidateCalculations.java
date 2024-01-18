package com.agroassist.agroassistant.validators;

public class ValidateCalculations {
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

    public String checkDate(String year) {

        if (year.isEmpty()) {
            return "Поле не должно быть пустым";
        } else if (year.length() > 4) {
            return "Поле не должно превышать 4 символов!";
        } else if (!year.matches("\\d+")){
            return "Поле должно содержать только цифры.";
        }

        return "";
    }
}
