/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StartDayPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javafxapplication11.SqliteConnection;

/**
 *
 * @author Amir
 */
public class StartDayClass {

    Connection conn = SqliteConnection.Connector();

    ResultSet rs;

    PreparedStatement ps;

    public List UsersValues;
    List DrinksValues;
    List DevicesValues;
    List OrdersValues;
    List HistoryValues;

    public void Do() throws SQLException {

        UsersStartHandler();
        DrinksStartHandler();
        DevicesStartHandler();
        OrdersStartHandler();
        HistoryStartHandler();

    }
////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
//////////////////////////////////////////////////////// for users

    public void LoadNames() throws SQLException {

        //    conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "Select UserName from Users";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            UsersValues = new ArrayList();

            while (rs.next()) {
                UsersValues.add(rs.getString(1));

            }
            ps.close();
            rs.close();

        } catch (Exception eViewAllPatient) {
            System.err.println(eViewAllPatient);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(eViewAllPatient.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            ps.close();
            rs.close();
        }

    }

    public void UsersStartHandler() throws SQLException {
        LoadNames();
        //   conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {
            for (int ii = 0; ii < UsersValues.size(); ii++) {
                String query = "Update Users set Amount=?, Details=? , PrevCashPrice=?, PrevCashName=? where UserName='" + UsersValues.get(ii) + "'  ";

                ps = conn.prepareStatement(query);
                ps.setString(1, "0");
                ps.setString(2, " ");
                ps.setString(3, "");
                ps.setString(4, "");

                ps.execute();
            }
            ps.close();

        } catch (Exception e1) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e1.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e1);
            ps.close();

        }

    }
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////// end of users
////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
//////////////////////////////////////////////////////// for Drinks

    public void LoadDrinks() throws SQLException {

        //       conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "Select Name from Drinks";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            DrinksValues = new ArrayList();

            while (rs.next()) {
                DrinksValues.add(rs.getString(1));

            }
            ps.close();
            rs.close();

        } catch (Exception eViewAllPatient) {
            System.err.println(eViewAllPatient);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(eViewAllPatient.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            ps.close();
            rs.close();
        }

    }

    public void DrinksStartHandler() throws SQLException {
        LoadDrinks();

        //   conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {
            for (int ii = 0; ii < DrinksValues.size(); ii++) {
                String query = "Update Drinks set Count=? where Name='" + DrinksValues.get(ii) + "'  ";

                ps = conn.prepareStatement(query);
                ps.setString(1, "0");

                ps.execute();
            }
            ps.close();

        } catch (Exception e1) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e1.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e1);
            ps.close();
            rs.close();
        }

    }
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////// end of Drinks
    ////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
//////////////////////////////////////////////////////// for Devices

    public void LoadDevices() throws SQLException {

        //   conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "Select PlayStationType from Devices";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            DevicesValues = new ArrayList();

            while (rs.next()) {
                DevicesValues.add(rs.getString(1));

            }
            ps.close();
            rs.close();

        } catch (Exception eViewAllPatient) {
            System.err.println(eViewAllPatient);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(eViewAllPatient.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            ps.close();
            rs.close();
        }

    }

    public void DevicesStartHandler() throws SQLException {
        LoadDevices();
        //    conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {
            for (int ii = 0; ii < DevicesValues.size(); ii++) {
                String query = "Update Devices set HoursCount=?, MatchesCount=?, HoursCountM=?, MatchesCountM=? where PlayStationType='" + DevicesValues.get(ii) + "'  ";

                ps = conn.prepareStatement(query);
                ps.setString(1, "0");
                ps.setString(2, "0");
                ps.setString(3, "0");
                ps.setString(4, "0");

                ps.execute();
            }
            ps.close();

        } catch (Exception e1) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e1.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e1);
            ps.close();
            rs.close();
        }

    }
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////// end of Devices
    ////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
//////////////////////////////////////////////////////// for Devices

    public void LoadOrders() throws SQLException {

        //   conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "Select Number from Orders";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            OrdersValues = new ArrayList();

            while (rs.next()) {
                OrdersValues.add(rs.getString(1));

            }
            ps.close();
            rs.close();

        } catch (Exception eViewAllPatient) {
            System.err.println(eViewAllPatient);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(eViewAllPatient.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            ps.close();
            rs.close();
        }

    }

    public void OrdersStartHandler() throws SQLException {
        LoadOrders();
        //    conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {
            for (int ii = 0; ii < OrdersValues.size(); ii++) {
                String query = "Delete from Orders  where Number='" + OrdersValues.get(ii) + "'  ";

                ps = conn.prepareStatement(query);
                //  ps.setString(1, OrdersValues.toString());
                ps.executeUpdate();
            }
            ps.close();

        } catch (Exception e1) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e1.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e1);
            ps.close();

        }

    }
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////// end of Devices
    ////////////////////////////////////////////////////////
////////////////////////////////////////////////////////
//////////////////////////////////////////////////////// for Devices

    public void LoadHistory() throws SQLException {

        //   conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "Select date from history";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            HistoryValues = new ArrayList();

            while (rs.next()) {
                HistoryValues.add(rs.getString(1));

            }
            ps.close();
            rs.close();

        } catch (Exception eViewAllPatient) {
            System.err.println(eViewAllPatient);
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(eViewAllPatient.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            ps.close();
            rs.close();
        }

    }

    public void HistoryStartHandler() throws SQLException {
        LoadHistory();
        //    conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {
            for (int ii = 0; ii < HistoryValues.size(); ii++) {
                String query = "Delete from history  where date='" + HistoryValues.get(ii) + "'  ";

                ps = conn.prepareStatement(query);
                //  ps.setString(1, OrdersValues.toString());
                ps.executeUpdate();
            }
            ps.close();

        } catch (Exception e1) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e1.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e1);
            ps.close();

        }

    }
///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////// end of Devices

}
