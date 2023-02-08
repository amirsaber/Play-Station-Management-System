/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ActionPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import AlertMaker.AlertMaker;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafxapplication11.FXMLDocumentController;
import javafxapplication11.SqliteConnection;

/**
 *
 * @author Amir
 */
public class ActionClass {

    private Connection conn = SqliteConnection.Connector();
    private ResultSet rs;
    private PreparedStatement ps;
    public static String OrderDetails;

    AlertMaker a = new AlertMaker();
    private final ObservableList<String> optionss = FXCollections.observableArrayList();

/////////////////////////////////////////////////
/////////////////////////////////////////////////
///////////////////////////////////////////////// this for fetch price for hour
    public void PriceForHourHandle(String s, TextField t, Label l, String a, TextField tt) throws SQLException {
        // conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "Select PerHour from Devices where PlayStationType='" + s + "'  ";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                t.setText(rs.getString("PerHour"));
                t.setEditable(false);
                a = a + " Hour";
                l.setText(a);

            }
            ps.close();
            rs.close();
            tt.clear();

        } catch (Exception e) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage() + e.toString());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e);
            ps.close();
            rs.close();
        }

    }
///////////////////////////////////////////////
///////////////////////////////////////////////
///////////////////////////////////////////////
///////////////////////////////////////////////

    public void PriceForMatchHandle(String s, TextField t, Label l, String a, TextField tt) throws SQLException {

        // conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "Select PerMatch from Devices where PlayStationType='" + s + "'  ";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                t.setText(rs.getString("PerMatch"));
                t.setEditable(false);
                a = a + " Match";
                l.setText(a);

            }
            ps.close();
            rs.close();
            tt.clear();

        } catch (Exception e) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage() + e.toString());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e);
            ps.close();
            rs.close();

        }

    }

    ///////////////////////////////////////////
    ///////////////////////////////////////////
/////////////////////////////////////////////////
/////////////////////////////////////////////////
///////////////////////////////////////////////// this for fetch price for hour
    public void PriceForHourHandleM(String s, TextField t, Label l, String a, TextField tt) throws SQLException {
        // conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "Select PerHourM from Devices where PlayStationType='" + s + "'  ";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                t.setText(rs.getString("PerHourM"));
                t.setEditable(false);
                a = a + " Hour M";
                l.setText(a);

            }
            ps.close();
            rs.close();
            tt.clear();

        } catch (Exception e) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage() + e.toString());
            //  CreateNewUserErrorAlert.showAndWait();
            System.err.println(e);
            ps.close();
            rs.close();
        }

    }
///////////////////////////////////////////////
///////////////////////////////////////////////
///////////////////////////////////////////////
///////////////////////////////////////////////

    public void PriceForMatchHandleM(String s, TextField t, Label l, String a, TextField tt) throws SQLException {

        // conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {

            String query = "Select PerMatchM from Devices where PlayStationType='" + s + "'  ";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                t.setText(rs.getString("PerMatchM"));
                t.setEditable(false);
                a = a + " Match M";
                l.setText(a);

            }
            ps.close();
            rs.close();
            tt.clear();

        } catch (Exception e) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage() + e.toString());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e);
            ps.close();
            rs.close();

        }

    }

    ///////////////////////////////////////////
    ///////////////////////////////////////////
    /////////////////////////////////////////// this for cancel button
    public void CancelButtonPs(TextField t, TextField t1, Label l) {
        Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
        CreateNewUserAlert.setTitle("Confirmation dialog");
        CreateNewUserAlert.setContentText("Are you sure to cancel?");
        CreateNewUserAlert.setHeaderText(null);
        if (t.getText().isEmpty() && t1.getText().isEmpty()) {

        } else {

            t.clear();
            t1.clear();
            l.setText("");

        }
    }

    ///////////////////////////////////////////
    ///////////////////////////////////////////
    /////////////////////////////////////////// this for save button
    public void SaveButtonPS(TextField t, TextField t1, Label l, TextField t2, TextArea t3, String ss, Tab tab, String dev) throws SQLException {
     
        
        if (t.getText().isEmpty() || t1.getText().isEmpty() ) {

            a.showSimpleAlert("Attention", "Please enter two fields");
        } else {
            tab.setStyle("-fx-text-base-color: red;");
            Float a = Float.parseFloat(t.getText()) * Float.parseFloat(t1.getText());

            Float ggg = Float.parseFloat(t1.getText());
            Float b = Float.parseFloat(t2.getText());

            String amir = new String();
            if (l.getText().equals("Ps 3 Hour M")) {
                amir = " ساعه زوجي";
            }
            if (l.getText().equals("Ps 4 Hour M")) {
                amir = "ساعه زوجي";
            }
            if (l.getText().equals("Ps 3 Hour")) {
                amir = "ساعه فردي";
            }
            if (l.getText().equals("Ps 4 Hour")) {
                amir = " ساعه فردي";
            }
            if (l.getText().equals("Ps 4 Match")) {
                amir = "ماتش فردي";
            }
            if (l.getText().equals("Ps 4 Match M")) {
                amir = "ماتش زوجي";
            }
            if (l.getText().equals("Ps 3 Match")) {
                amir = "ماتش فردي";
            }
            if (l.getText().equals("Ps 3 Match M")) {
                amir = "ماتش زوجي";
            }
            String s = Float.toString(a) + "\t\t" + t1.getText() + "\t\t" + amir;
            for (int i = s.length(); i <= 40; i++) {
                //      s += " ";
            }
            s += "\n";

            /////////////////////////////////
            /////////////////////////////////
            if (l.getText().equals("Ps 3 Hour") || l.getText().equals("Ps 4 Hour")) {
                //       conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
                float ccc = 0;
                float bbb = Float.parseFloat(t1.getText());
     //   float bbb = Float.parseFloat(t1.getText());
   //  float bbb = Float.parseFloat(t1.getText());
                if ( bbb > 0) {
                try {

                    String query = "Select * from Devices where PlayStationType='" + ss + "'  ";
                    ps = conn.prepareStatement(query);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        float aaa = Float.parseFloat(rs.getString("HoursCount"));
                        ccc = aaa + bbb;
                        System.out.println(aaa);
                        System.out.println(bbb);
                        System.out.println(ccc);

                    }
                    ps.close();
                    rs.close();

                } catch (Exception e) {
                    Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                    CreateNewUserErrorAlert.setHeaderText(null);
                    CreateNewUserErrorAlert.setContentText(e.getMessage());
                    CreateNewUserErrorAlert.showAndWait();
                    System.err.println(e);
                    ps.close();
                    rs.close();

                }
                try {
                    String query1 = "Update Devices set  HoursCount=? where PlayStationType='" + ss + "'  ";
                    ps = conn.prepareStatement(query1);

                    ps.setString(1, Float.toString(ccc));
                    ps.execute();
                    ps.close();
                } catch (Exception e) {

                    Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                    CreateNewUserErrorAlert.setHeaderText(null);
                    CreateNewUserErrorAlert.setContentText(e.getMessage());
                    CreateNewUserErrorAlert.showAndWait();
                    System.err.println(e);
                    ps.close();
                    rs.close();
                }
                try {
                    SaveToHistoryTable(amir, ggg, a, dev);
                } catch (Exception e) {

                    Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                    CreateNewUserErrorAlert.setHeaderText(null);
                    CreateNewUserErrorAlert.setContentText(e.getMessage());
                    CreateNewUserErrorAlert.showAndWait();
                    System.err.println(e);
                    ps.close();
                    rs.close();
                }
                t3.appendText(s);
                t2.setText(Float.toString(a + b));
                t.clear();
                t1.clear();
                l.setText("");
                }
           
                  else {
                    AlertMaker aase = new AlertMaker();
                    aase.showErrorMessage("خطأ ", "عدد  الساعات لا بد ان يكون رقم صحيح");

                }
            }
            /////////////////////////////////
            /////////////////////////////////
            if (l.getText().equals("Ps 3 Hour M") || l.getText().equals("Ps 4 Hour M")) {
                //       conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
                float ccc = 0;
                float bbb = Float.parseFloat(t1.getText());
   //  float bbb = Float.parseFloat(t1.getText());
                if ( bbb > 0) {
                try {

                    String query = "Select * from Devices where PlayStationType='" + ss + "'  ";
                    ps = conn.prepareStatement(query);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        float aaa = Float.parseFloat(rs.getString("HoursCountM"));
                        ccc = aaa + bbb;
                        System.out.println(aaa);
                        System.out.println(bbb);
                        System.out.println(ccc);

                    }
                    ps.close();
                    rs.close();

                } catch (Exception e) {
                    Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                    CreateNewUserErrorAlert.setHeaderText(null);
                    CreateNewUserErrorAlert.setContentText(e.getMessage());
                    CreateNewUserErrorAlert.showAndWait();
                    System.err.println(e);
                    ps.close();
                    rs.close();

                }
                try {
                    String query1 = "Update Devices set  HoursCountM=? where PlayStationType='" + ss + "'  ";
                    ps = conn.prepareStatement(query1);

                    ps.setString(1, Float.toString(ccc));
                    ps.execute();
                    ps.close();
                } catch (Exception e) {

                    Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                    CreateNewUserErrorAlert.setHeaderText(null);
                    CreateNewUserErrorAlert.setContentText(e.getMessage());
                    CreateNewUserErrorAlert.showAndWait();
                    System.err.println(e);
                    ps.close();
                    rs.close();
                }
                try {
                    SaveToHistoryTable(amir, ggg, a, dev);
                } catch (Exception e) {

                    Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                    CreateNewUserErrorAlert.setHeaderText(null);
                    CreateNewUserErrorAlert.setContentText(e.getMessage());
                    CreateNewUserErrorAlert.showAndWait();
                    System.err.println(e);
                    ps.close();
                    rs.close();
                }
                t3.appendText(s);
                t2.setText(Float.toString(a + b));
                t.clear();
                t1.clear();
                l.setText(""); 
                } 
                else {
                    AlertMaker aase = new AlertMaker();
                    aase.showErrorMessage("خطأ ", "عدد  الساعات لا بد ان يكون رقم صحيح");

                }
            } /////////////////////////////////
            /////////////////////////////////
            if (l.getText().equals("Ps 3 Match") || l.getText().equals("Ps 4 Match")) {
                //   conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
                float ccc = 0;
                float bbb = Float.parseFloat(t1.getText());
                if (bbb % 1 == 0 && bbb > 0) {
                    try {

                        String query = "Select * from Devices where PlayStationType='" + ss + "'  ";
                        ps = conn.prepareStatement(query);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            float aaa = Float.parseFloat(rs.getString("MatchesCount"));
                            ccc = aaa + bbb;
                            System.out.println(aaa);
                            System.out.println(bbb);
                            System.out.println(ccc);

                        }
                        ps.close();
                        rs.close();

                    } catch (Exception e) {
                        Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                        CreateNewUserErrorAlert.setHeaderText(null);
                        CreateNewUserErrorAlert.setContentText(e.getMessage());
                        CreateNewUserErrorAlert.showAndWait();
                        System.err.println(e);
                        ps.close();
                        rs.close();
                    }
                    try {
                        String query1 = "Update Devices set  MatchesCount=? where PlayStationType='" + ss + "'  ";
                        ps = conn.prepareStatement(query1);

                        ps.setString(1, Float.toString(ccc));
                        ps.execute();
                        ps.close();
                    } catch (Exception e) {
                        Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                        CreateNewUserErrorAlert.setHeaderText(null);
                        CreateNewUserErrorAlert.setContentText(e.getMessage());
                        CreateNewUserErrorAlert.showAndWait();
                        System.err.println(e);
                        ps.close();
                        rs.close();

                    }
                    try {
                        SaveToHistoryTable(amir, ggg, a, dev);
                    } catch (Exception e) {

                        Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                        CreateNewUserErrorAlert.setHeaderText(null);
                        CreateNewUserErrorAlert.setContentText(e.getMessage());
                        CreateNewUserErrorAlert.showAndWait();
                        System.err.println(e);
                        ps.close();
                        rs.close();
                    }
                    t3.appendText(s);
                    t2.setText(Float.toString(a + b));
                    t.clear();
                    t1.clear();
                    l.setText("");
                } else {
                    AlertMaker aase = new AlertMaker();
                    aase.showErrorMessage("خطأ ", "عدد الماتشات او الادوار لا بد ان يكون رقم صحيح");

                }
            }
            /////////////////////////////////
            if (l.getText().equals("Ps 3 Match M") || l.getText().equals("Ps 4 Match M")) {
                //   conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
                float ccc = 0;
                float bbb = Float.parseFloat(t1.getText());
                if (bbb % 1 == 0 && bbb > 0) {
                    try {

                        String query = "Select * from Devices where PlayStationType='" + ss + "'  ";
                        ps = conn.prepareStatement(query);
                        rs = ps.executeQuery();
                        while (rs.next()) {
                            float aaa = Float.parseFloat(rs.getString("MatchesCountM"));
                            ccc = aaa + bbb;
                            System.out.println(aaa);
                            System.out.println(bbb);
                            System.out.println(ccc);

                        }
                        ps.close();
                        rs.close();

                    } catch (Exception e) {
                        Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                        CreateNewUserErrorAlert.setHeaderText(null);
                        CreateNewUserErrorAlert.setContentText(e.getMessage());
                        CreateNewUserErrorAlert.showAndWait();
                        System.err.println(e);
                        ps.close();
                        rs.close();
                    }
                    try {
                        String query1 = "Update Devices set  MatchesCountM=? where PlayStationType='" + ss + "'  ";
                        ps = conn.prepareStatement(query1);

                        ps.setString(1, Float.toString(ccc));
                        ps.execute();
                        ps.close();
                    } catch (Exception e) {
                        Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                        CreateNewUserErrorAlert.setHeaderText(null);
                        CreateNewUserErrorAlert.setContentText(e.getMessage());
                        CreateNewUserErrorAlert.showAndWait();
                        System.err.println(e);
                        ps.close();
                        rs.close();

                    }
                    try {
                        SaveToHistoryTable(amir, ggg, a, dev);
                    } catch (Exception e) {

                        Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                        CreateNewUserErrorAlert.setHeaderText(null);
                        CreateNewUserErrorAlert.setContentText(e.getMessage());
                        CreateNewUserErrorAlert.showAndWait();
                        System.err.println(e);
                        ps.close();
                        rs.close();
                    }
                    t3.appendText(s);
                    t2.setText(Float.toString(a + b));
                    t.clear();
                    t1.clear();
                    l.setText("");
                } else {
                    AlertMaker aase = new AlertMaker();
                    aase.showErrorMessage("خطأ", "عدد الماتشات او الادوار لا بد ان يكون رقم صحيح");

                }

            }

        }
    }///////////////////////////////////////
    ///////////////////////////////////////////
    ///////////////////////////////////////////
    /////////////////////////////////////////// this for save button

    public void SaveButtonDrink(TextField t, TextField t1, Label l, TextField t2, TextArea t3, Tab tab, String dev) throws SQLException {

        if (t.getText().isEmpty() || t1.getText().isEmpty()) {

            a.showSimpleAlert("Attention", "Please enter two fields");
        } else {
            tab.setStyle("-fx-text-base-color: red;");
            float checccck = Float.parseFloat(t1.getText());

            if (checccck % 1 == 0 && checccck > 0) {
                Float a = Float.parseFloat(t.getText()) * Float.parseFloat(t1.getText());
                Float ggg = Float.parseFloat(t1.getText());
                Float b = Float.parseFloat(t2.getText());
                t2.setText(Float.toString(a + b));
                String a7a = l.getText();

                String s = Float.toString(a) + "\t\t" + t1.getText() + "\t\t" + a7a;
                for (int i = s.length(); i <= 40; i++) {
                    //     s += " ";
                }
                s += "\n";
                t3.appendText(s);
                String ss = l.getText();
                /////////////////////////////////
                /////////////////////////////////
                // conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
                float ccc = 0;
                float qqq = 0;
                //  int bbb = Integer.parseInt(t1.getText());
                float nnnnn = Float.parseFloat(t1.getText());
                try {

                    //String query = "Update Drinks set Name=?, Price=?, Quantity=?, Count=? where Name='" + l.getText() + "'  ";
                    String query = "Select * from Drinks where Name='" + ss + "'  ";
                    ps = conn.prepareStatement(query);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        float ddd = Float.parseFloat(rs.getString("Quantity"));
                        float aaa = Float.parseFloat(rs.getString("Count"));

                        ccc = aaa + nnnnn;
                        qqq = ddd - nnnnn;
                        System.out.println(ddd);
                        System.out.println(aaa);
                        // System.out.println(bbb);
                        System.out.println(qqq);
                        System.out.println(ccc);

                    }
                    ps.close();
                    rs.close();

                } catch (Exception e1) {
                    Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                    CreateNewUserErrorAlert.setHeaderText(null);
                    CreateNewUserErrorAlert.setContentText(e1.getMessage());
                    CreateNewUserErrorAlert.showAndWait();
                    System.err.println(e1);
                    ps.close();
                    rs.close();

                }
                try {
                    String query1 = "Update Drinks set Quantity=?, Count=? where Name='" + ss + "'  ";;
                    ps = conn.prepareStatement(query1);

                    ps.setString(1, Float.toString(qqq));
                    ps.setString(2, Float.toString(ccc));
                    ps.execute();
                    ps.close();
                } catch (Exception e) {
                    Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                    CreateNewUserErrorAlert.setHeaderText(null);
                    CreateNewUserErrorAlert.setContentText(e.getMessage());
                    CreateNewUserErrorAlert.showAndWait();
                    System.err.println(e);
                    ps.close();
                    rs.close();
                }
                try {
                    SaveToHistoryTable(ss, ggg, a, dev);
                } catch (Exception e) {
                    Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                    CreateNewUserErrorAlert.setHeaderText(null);
                    CreateNewUserErrorAlert.setContentText(e.getMessage());
                    CreateNewUserErrorAlert.showAndWait();
                    System.err.println(e);
                    ps.close();
                    rs.close();
                }

/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////
                t.clear();
                t1.clear();
                l.setText("");
            } else {
                   AlertMaker aase = new AlertMaker();
                    aase.showErrorMessage("خطأ ", "عدد  المشروب لا بد ان يكون رقم صحيح");

                //  a.showSimpleAlert("Attention", "The number of drinks can not be float number");
            }

        }

    }
    ///////////////////////////////////////

    public void FilllistvIew(ListView list) throws SQLException {

        // conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        optionss.clear();

        try {

            String query = "Select Name from Drinks";
            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.setItems(optionss);
                optionss.add(rs.getString("Name"));

            }

            ps.close();
            rs.close();

        } catch (SQLException e) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e);
            ps.close();
            rs.close();
        }

    }
    ///////////////////////////////////////

    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    public void FillFromListview(ListView list, TextField t, Label l) throws SQLException {

        //   conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        try {
            String query = "Select * from Drinks where Name = ? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, (String) list.getSelectionModel().getSelectedItem());

            rs = ps.executeQuery();

            while (rs.next()) {

                t.setText(rs.getString("Price"));
                l.setText(rs.getString("Name"));

            }
            ps.close();
            rs.close();

        } catch (Exception e) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e);
            ps.close();
            rs.close();
        }

    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    public void SaveToUserTable(String s, TextField t, TextArea tt, TextField tf, TextField tff, String table, String startt, Tab tab, Label l) throws SQLException {
        //  conn = DriverManager.getConnection("jdbc:sqlite:Clinic_Manager_DB.db");
        Float matlob = Float.parseFloat(t.getText());
        float ccc = 0;
        float res = 0;
        String as = tt.getText();
        String ress = " ";
        /////////////////////////////////
        /////////////////////////////////
        if (t.getText().equals("0") || tt.getText().isEmpty()) {
            a.showSimpleAlert("Attention", "Some information about order is missing");

        } else {
            tab.setStyle("-fx-text-base-color: black;");
            l.setText("ok");
            try {

                String query = "Select * from Users where UserName='" + s + "'  ";
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();

                // int qqq = 0;
                while (rs.next()) {
                    ccc = Float.parseFloat(rs.getString("Amount"));
                    String asa = rs.getString("Details");
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy      hh:mm a");

                    asa += "\n" + "Order at  " + dateFormat.format(date) + table + "\n";
                    res = ccc + matlob;
                    ress = asa + as;
                    System.out.println(ccc);
                    System.out.println(asa);
                    System.out.println(res);
                    System.out.println(ress);

                }
                ps.close();
                rs.close();

            } catch (Exception e1) {
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText(e1.getMessage());
                CreateNewUserErrorAlert.showAndWait();
                System.err.println(e1);
                ps.close();
                rs.close();
            }
            try {
                String query1 = "Update Users set Amount=?, Details=? where UserName='" + s + "'  ";;
                ps = conn.prepareStatement(query1);

                ps.setString(1, Float.toString(res));
                ps.setString(2, ress);
                ps.execute();
                ps.close();
            } catch (Exception e) {
                Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                CreateNewUserErrorAlert.setHeaderText(null);
                CreateNewUserErrorAlert.setContentText(e.getMessage());
                CreateNewUserErrorAlert.showAndWait();
                System.err.println(e);
                ps.close();
                rs.close();
            }
            try {
                SaveToOrderTable(s, tt.getText(), matlob, table, startt);
                startt = "null";

                ps.close();
                rs.close();
            } catch (Exception e) {
                ps.close();
                rs.close();
            }
            try {
                Date date1 = new Date();
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy/MM/dd");
                String asd = dateFormat1.format(date1);
                Date date2 = new Date();
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("hh:mm a");
                String asdd = dateFormat2.format(date2);

                SaveToOrdersAllTable(s, matlob, table.substring(5), asd, asdd);
            } catch (Exception e) {
                ps.close();
                rs.close();
            }
            PrintRecipt r = new PrintRecipt();
            r.ShowReport();
            t.setText("0");
            tt.setText(" ");
            tf.setText("");
            tff.setText("0");
            startt = "null";
        }
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    public boolean get() throws SQLException {
        boolean res = false;
        try {
            String query = "select * from OrdersAll";
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                res = true;

            }

            ps.close();
            rs.close();
        } catch (Exception e) {
            ps.close();
            rs.close();
        }
        return res;

    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    public int getId() throws SQLException {
        int res = 0;
        boolean check = get();
        if (check) {
            try {
                String query = "select Max(NumberAll) from OrdersAll";
                ps = conn.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    res = rs.getInt(1);

                }
                res += 1;
                ps.close();
                rs.close();
                return res;
            } catch (Exception e) {
                ps.close();
                rs.close();
                res = 1;
                return res;
            }
        } else {
            res = 1;
            return res;
        }

    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    public void SaveToOrderTable(String s, String a, float f, String t, String start) throws SQLException {

        /////////////////////////////////
        /////////////////////////////////
        try {
            int ordersallnumber = getId();

            String query = "INSERT INTO Orders (Cashier, OrderDetails, OrderPrice , StartTimes , EndTime , OrderAllNumber) VALUES (?,?,?,?,?,?) ";
            ps = conn.prepareStatement(query);

            // int qqq = 0;
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy  hh:mm a ");
            //  String aa = " ";
            OrderDetails = "Order At " + dateFormat.format(date) + t.substring(2) + "\n\n\n" + a;
            Date date1 = new Date();
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("hh:mm a");
            String aa1 = " ";
            aa1 += dateFormat1.format(date1);

            //  ps.setString(1,Integer.toString(ordernumber) );
            ps.setString(1, s);
            ps.setString(2, OrderDetails);
            ps.setString(3, Float.toString(f));
            ps.setString(4, start);
            ps.setString(5, aa1);
            ps.setString(6, Integer.toString(ordersallnumber));

            ps.execute();

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
        start = " ";
    }

    public void SaveToOrdersAllTable(String cashier, float price, String table, String date, String time) throws SQLException {

        /////////////////////////////////
        /////////////////////////////////
        try {

            String query = "INSERT INTO OrdersAll (CashierAll, PriceAll, TableAll, DateAll, TimeAll , Date , OrderAllDetails) VALUES (?,?,?,?,?,?,?) ";
            ps = conn.prepareStatement(query);

            Date date1 = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String aa = dateFormat.format(date1);
            //   aa += "Order At "+dateFormat.format(date) + t + "\n\n\n"+a;
            ps.setString(1, cashier);
            ps.setString(2, Float.toString(price));
            ps.setString(3, table);
            ps.setString(4, date);
            ps.setString(5, time);
            ps.setString(6, aa);
            ps.setString(7, OrderDetails);

            ps.execute();

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

    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    public void SaveToPaymentsTable(String cashier, float price, String description , String type) throws SQLException {

        /////////////////////////////////
        /////////////////////////////////
        try {

            String query = "INSERT INTO Payments (cashier, description, amount, date, time , type ) VALUES (?,?,?,?,?,?) ";
            ps = conn.prepareStatement(query);

            Date date1 = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String aa = dateFormat.format(date1);

            Date date2 = new Date();
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("hh:mm a");
            String aa1;
            aa1 = dateFormat1.format(date2);

            ps.setString(1, cashier);
            ps.setString(2, description);
            ps.setString(3, Float.toString(price));

            ps.setString(4, aa);
            ps.setString(5, aa1);
            ps.setString(6, type);

            ps.execute();

            ps.close();

            AlertMaker adsd = new AlertMaker();
            adsd.showSimpleAlert("Success", "تمت اضافه العمليه بنجاح");

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

    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    public void SaveToHistoryTable(String process, float number, float price, String device) throws SQLException {

        /////////////////////////////////
        /////////////////////////////////
        try {

            String query = "INSERT INTO history (process, number, price, device, date, time , cashier ) VALUES (?,?,?,?,?,?,?) ";
            ps = conn.prepareStatement(query);

            Date date1 = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String aa = dateFormat.format(date1);

            Date date2 = new Date();
            SimpleDateFormat dateFormat1 = new SimpleDateFormat("HH:mm");
            String aa1;
            aa1 = dateFormat1.format(date2);

            ps.setString(1, process);
            ps.setString(2, Float.toString(number));
            ps.setString(3, Float.toString(price));
            ps.setString(4, device);
            ps.setString(5, aa);
            ps.setString(6, aa1);
            ps.setString(7, FXMLDocumentController.UserNameSave);
            ps.execute();

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

    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
    //////////////////////////////////////////
}
