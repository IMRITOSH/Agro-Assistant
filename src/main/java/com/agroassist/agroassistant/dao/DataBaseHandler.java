package com.agroassist.agroassistant.dao;

import com.agroassist.agroassistant.models.Crop;
import com.agroassist.agroassistant.models.Field;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public abstract class DataBaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }

    public ObservableList<Field> getFields() {
        ObservableList<Field> fields = FXCollections.observableArrayList();
        Field field;

        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM fields");
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String fieldNumber = resultSet.getString(2);
                int area = resultSet.getInt(3);
                String crop = resultSet.getString(4);
                String kind = resultSet.getString(5);
                Date year = resultSet.getDate(6);

                field = new Field(id, fieldNumber, area, crop, kind, year);
                fields.add(field);
            }
            return fields;
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex.getMessage());
        }

        return fields;
    }

    public ObservableList<Crop> getCrops() {
        ObservableList<Crop> crops = FXCollections.observableArrayList();
        Crop crop;

        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Crops");
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String fieldNumber = resultSet.getString(2);
                int brutto = resultSet.getInt(3);
                int tara = resultSet.getInt(4);
                int netto = resultSet.getInt(5);
                Date date = resultSet.getDate(6);

                crop = new Crop(id, fieldNumber, brutto, tara, netto, date);
                crops.add(crop);
            }
            return crops;
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex.getMessage());
        }

        return crops;
    }

    public Boolean addField(String fieldNumber, int area, String crop, String kind, String year) {
        String insertQuery = String.format("INSERT fields(number_field, area, crop, kind, year) VALUES ('%s', %d, '%s', '%s', '%s')",
                fieldNumber, area, crop, kind, year);

        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();

            int rows = statement.executeUpdate(insertQuery);

            if (rows > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Не удалось добавить поле");

            System.out.println(ex.getMessage());
        }

        return false;
    }

    public Boolean editField(int idField, String fieldNumber, int area, String crop, String kind, String year) {
        String updateQuery = String.format("UPDATE fields SET number_field = '%s', area = %d, crop = '%s', kind = '%s', year = '%s' WHERE id = %d",
                fieldNumber, area, crop, kind, year, idField);

        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();

            int rows = statement.executeUpdate(updateQuery);

            if (rows > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Не удалось изменить данные о поле");

            System.out.println(ex.getMessage());
        }

        return false;
    }

    public Boolean deleteField(int id) {
        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();

            int rows = statement.executeUpdate(String.format("DELETE FROM fields WHERE id = %d", id));

            if (rows > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Не удалось удалить поле");

            System.out.println(ex.getMessage());
        }

        return false;
    }

    public Field getField(int idField) {
        Field field = null;

        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM fields WHERE id = %d", idField));
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String fieldNumber = resultSet.getString(2);
                int area = resultSet.getInt(3);
                String crop = resultSet.getString(4);
                String kind = resultSet.getString(5);
                Date year = resultSet.getDate(6);

                field = new Field(id, fieldNumber, area, crop, kind, year);
            }
            return field;
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex.getMessage());
        }

        return field;
    }

    public Boolean addCrop(String fieldNumber, int brutto, int tara, int netto, String year) {
        String insertQuery = String.format("INSERT crops(Field_Number, Brutto, Tara, Netto, Date) VALUES ('%s', %d, '%d', '%d', '%s')",
                fieldNumber, brutto, tara, netto, year);

        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();

            int rows = statement.executeUpdate(insertQuery);

            if (rows > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Не удалось добавить данные об урожае");

            System.out.println(ex.getMessage());
        }

        return false;
    }

    public Boolean editCrop(int idCrop, String fieldNumber, int brutto, int tara, int netto, String year) {
        String updateQuery = String.format("UPDATE crops SET Field_Number = '%s', Brutto = %d, Tara = '%d', Netto = '%d', Date = '%s' WHERE id = %d",
                fieldNumber, brutto, tara, netto, year, idCrop);

        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();

            int rows = statement.executeUpdate(updateQuery);

            if (rows > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Не удалось изменить данные об урожае");

            System.out.println(ex.getMessage());
        }

        return false;
    }

    public Boolean deleteCrop(int id) {
        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();

            int rows = statement.executeUpdate(String.format("DELETE FROM crops WHERE id = %d", id));

            if (rows > 0) {
                return true;
            }

        } catch (Exception ex) {
            System.out.println("Не удалось удалить данные об урожае");
            System.out.println(ex.getMessage());
        }

        return false;
    }

    public Crop getCrop(int idCrop) {
        Crop crop = null;

        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM crops WHERE id = %d", idCrop));
            while (resultSet.next()) {

                int id = resultSet.getInt(1);
                String fieldNumber = resultSet.getString(2);
                int brutto = resultSet.getInt(3);
                int tara = resultSet.getInt(4);
                int netto = resultSet.getInt(5);
                Date year = resultSet.getDate(6);

                crop = new Crop(id, fieldNumber, brutto, tara, netto, year);
            }
            return crop;
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex.getMessage());
        }

        return crop;
    }

    public Integer getAllNettofromOneField(String fieldNumber, String date) {
        int allNetto = 0;

        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT SUM(Netto) FROM Crops WHERE Field_Number = '%s' and YEAR(Date) = %s",
                    fieldNumber, date));
            while (resultSet.next()) {
                allNetto = resultSet.getInt(1);
            }

            return allNetto;
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex.getMessage());
        }
        return allNetto;
    }

    public Integer getAllNetto(String date) {
        int allNetto = 0;

        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT SUM(Netto) FROM Crops WHERE YEAR(Date) = %s", date));
            while (resultSet.next()) {
                allNetto = resultSet.getInt(1);
            }

            return allNetto;
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex.getMessage());
        }
        return allNetto;
    }

    public Integer getAreaField(String fieldNumber) {
        int area = 0;

        try (Connection conn = getDbConnection()) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT area FROM Fields WHERE number_field = '%s'", fieldNumber));
            while (resultSet.next()) {
                area = resultSet.getInt(1);
            }

            return area;
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex.getMessage());
        }
        return area;
    }
}
