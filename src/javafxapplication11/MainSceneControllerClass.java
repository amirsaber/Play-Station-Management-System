/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication11;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static javafxapplication11.FXMLDocumentController.UserNameSave;
import UsersDatabasePackage.*;
import javafx.scene.control.PasswordField;
import AlertMaker.AlertMaker;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import DrinksDatabasePackage.*;
import DevicesDatabasePackage.*;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import ActionPackage.ActionClass;
import ActionPackage.PrintRecipt;
import EditTitlePackage.EditTitleFXMLController;
import HistoryPackage.HistoryFXMLController;
import OrdersPackage.OrdersEditFXMLController;
import PaymentsPackage.PaymentsAllFXMLController;
import PaymentsPackage.PaymentsFXMLController;
import ReportsPackage.ReportsFXMLController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import StartDayPackage.StartDayClass;
import additionalpackage.AdditionalClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.textfield.TextFields;

/**
 *
 * @author Amir
 */
public class MainSceneControllerClass implements Initializable {

    ///////////////////////////////////////
    /////////////////////////////////////// this section for define FXML components
    @FXML
    private PasswordField AdminPass;
    TextField PreviousCashierName = new TextField();
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    @FXML
    Tab tab;
    @FXML
    Tab tab1;
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    ////////////////////////////////////////////////////// this is for define FXML components for ps3i
    @FXML
    private Text ps3itext;
    @FXML
    private TextField Ps3iPriceTextField;
    @FXML
    private TextField Ps3iDrinkNumberTextField;
    @FXML
    private TextField Ps3iDrinkPriceTextField;
    @FXML
    private TextField Ps3iNumberTextField;
    @FXML
    ListView ps3ilist;
    @FXML
    private Label ps3iLabel;
    @FXML
    private Label ps3iDrinkLabel;
    @FXML
    private TextField ps3iMatlob;
    @FXML
    private TextField ps3iMadfo3;
    @FXML
    private TextField ps3iBaqy;
    @FXML
    private TextArea ps3iTextarea;
    @FXML
    private Button StartTimer;
    @FXML
    private Button ResrtTimer;
    /////////////////////////////////////////////
    ///////////////////////////////////////////// end of ps3i components

    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    ////////////////////////////////////////////////////// this is for define FXML components for ps3ii
    @FXML
    private Text ps3itext1;
    @FXML
    private TextField Ps3iPriceTextField1;
    @FXML
    private TextField Ps3iDrinkNumberTextField1;
    @FXML
    private TextField Ps3iDrinkPriceTextField1;
    @FXML
    private TextField Ps3iNumberTextField1;
    @FXML
    ListView ps3ilist1;
    @FXML
    private Label ps3iLabel1;
    @FXML
    private Label ps3iDrinkLabel1;
    @FXML
    private TextField ps3iMatlob1;
    @FXML
    private TextField ps3iMadfo31;
    @FXML
    private TextField ps3iBaqy1;
    @FXML
    private TextArea ps3iTextarea1;
    @FXML
    private Button StartTimer1;
    @FXML
    private Button ResrtTimer1;
    /////////////////////////////////////////////
    ///////////////////////////////////////////// end of ps3ii components
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    ////////////////////////////////////////////////////// this is for define FXML components for ps3iii
    @FXML
    private Text ps3itext2;
    @FXML
    private TextField Ps3iPriceTextField2;
    @FXML
    private TextField Ps3iDrinkNumberTextField2;
    @FXML
    private TextField Ps3iDrinkPriceTextField2;
    @FXML
    private TextField Ps3iNumberTextField2;
    @FXML
    ListView ps3ilist2;
    @FXML
    private Label ps3iLabel2;
    @FXML
    private Label ps3iDrinkLabel2;
    @FXML
    private TextField ps3iMatlob2;
    @FXML
    private TextField ps3iMadfo32;
    @FXML
    private TextField ps3iBaqy2;
    @FXML
    private TextArea ps3iTextarea2;
    @FXML
    private Button StartTimer2;
    @FXML
    private Button ResrtTimer2;
    /////////////////////////////////////////////
    ///////////////////////////////////////////// end of ps3iii components
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    ////////////////////////////////////////////////////// this is for define FXML components for ps3iv
    @FXML
    private Text ps3itext3;
    @FXML
    private TextField Ps3iPriceTextField3;
    @FXML
    private TextField Ps3iDrinkNumberTextField3;
    @FXML
    private TextField Ps3iDrinkPriceTextField3;
    @FXML
    private TextField Ps3iNumberTextField3;
    @FXML
    ListView ps3ilist3;
    @FXML
    private Label ps3iLabel3;
    @FXML
    private Label ps3iDrinkLabel3;
    @FXML
    private TextField ps3iMatlob3;
    @FXML
    private TextField ps3iMadfo33;
    @FXML
    private TextField ps3iBaqy3;
    @FXML
    private TextArea ps3iTextarea3;
    @FXML
    private Button StartTimer3;
    @FXML
    private Button ResrtTimer3;
    /////////////////////////////////////////////
    ///////////////////////////////////////////// end of ps3iv components
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    ////////////////////////////////////////////////////// this is for define FXML components for ps3v
    @FXML
    private Text ps3itext4;
    @FXML
    private TextField Ps3iPriceTextField4;
    @FXML
    private TextField Ps3iDrinkNumberTextField4;
    @FXML
    private TextField Ps3iDrinkPriceTextField4;
    @FXML
    private TextField Ps3iNumberTextField4;
    @FXML
    ListView ps3ilist4;
    @FXML
    private Label ps3iLabel4;
    @FXML
    private Label ps3iDrinkLabel4;
    @FXML
    private TextField ps3iMatlob4;
    @FXML
    private TextField ps3iMadfo34;
    @FXML
    private TextField ps3iBaqy4;
    @FXML
    private TextArea ps3iTextarea4;
    @FXML
    private Button StartTimer4;
    @FXML
    private Button ResrtTimer4;
    /////////////////////////////////////////////
    ///////////////////////////////////////////// end of ps3v components
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    ////////////////////////////////////////////////////// this is for define FXML components for ps4i
    @FXML
    private Text ps3itext5;
    @FXML
    private TextField Ps3iPriceTextField5;
    @FXML
    private TextField Ps3iDrinkNumberTextField5;
    @FXML
    private TextField Ps3iDrinkPriceTextField5;
    @FXML
    private TextField Ps3iNumberTextField5;
    @FXML
    ListView ps3ilist5;
    @FXML
    private Label ps3iLabel5;
    @FXML
    private Label ps3iDrinkLabel5;
    @FXML
    private TextField ps3iMatlob5;
    @FXML
    private TextField ps3iMadfo35;
    @FXML
    private TextField ps3iBaqy5;
    @FXML
    private TextArea ps3iTextarea5;
    @FXML
    private Button StartTimer5;
    @FXML
    private Button ResrtTimer5;
    /////////////////////////////////////////////
    ///////////////////////////////////////////// end of ps4i components
    //////////////////////////////////////////////////////
    //////////////////////////////////////////////////////
    ////////////////////////////////////////////////////// this is for define FXML components for ps4ii
    @FXML
    private Text ps3itext6;
    @FXML
    private TextField Ps3iPriceTextField6;
    @FXML
    private TextField Ps3iDrinkNumberTextField6;
    @FXML
    private TextField Ps3iDrinkPriceTextField6;
    @FXML
    private TextField Ps3iNumberTextField6;
    @FXML
    ListView ps3ilist6;
    @FXML
    private Label ps3iLabel6;
    @FXML
    private Label ps3iDrinkLabel6;
    @FXML
    private TextField ps3iMatlob6;
    @FXML
    private TextField ps3iMadfo36;
    @FXML
    private TextField ps3iBaqy6;
    @FXML
    private TextArea ps3iTextarea6;
    @FXML
    private Button StartTimer6;
    @FXML
    private Button ResrtTimer6;
    /////////////////////////////////////////////
    ///////////////////////////////////////////// end of ps4i components
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    //////////////////////////////////////////// buttons ps3i

    @FXML
    public Button button1 = new Button();
    @FXML
    public Button button2 = new Button();
    @FXML
    public Button button3 = new Button();
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    //////////////////////////////////////////// buttons ps3ii

    @FXML
    public Button button4 = new Button();
    @FXML
    public Button button5 = new Button();
    @FXML
    public Button button6 = new Button();

    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    //////////////////////////////////////////// buttons ps3iii
    @FXML
    public Button button7 = new Button();
    @FXML
    public Button button8 = new Button();
    @FXML
    public Button button9 = new Button();

    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    //////////////////////////////////////////// buttons ps3iv
    @FXML
    public Button button10 = new Button();
    @FXML
    public Button button11 = new Button();
    @FXML
    public Button button12 = new Button();
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    //////////////////////////////////////////// buttons ps3v

    @FXML
    public Button button13 = new Button();
    @FXML
    public Button button14 = new Button();
    @FXML
    public Button button15 = new Button();
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    //////////////////////////////////////////// buttons ps4i

    @FXML
    public Button button16 = new Button();
    @FXML
    public Button button17 = new Button();
    @FXML
    public Button button18 = new Button();
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    //////////////////////////////////////////// buttons ps4ii

    @FXML
    public Button button19 = new Button();
    @FXML
    public Button button20 = new Button();
    @FXML
    public Button button21 = new Button();
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    ////////////////////////////////////////////
    //////////////////////////////////////////// buttons ps4ii

    @FXML
    Button UserButton = new Button();
    @FXML
    Button DevicesButton = new Button();
    @FXML
    Button DrinksButton = new Button();
    @FXML
    Button ReportsButton = new Button();
    @FXML
    Button StartDayButton = new Button();
    @FXML
    Button RestoreDataButton = new Button();
    @FXML
    Button EditTitleButton = new Button();
    @FXML
    Button SaveAdminPassButton = new Button();
    @FXML
    Button CheckUserNameButton = new Button();
    @FXML
    private Button RestoreDataButton1;
    @FXML
    private AnchorPane AnchorPanePassword;
    @FXML
    private TextField UpdatePassTextField;

    ///////////////////////////////////////
    /////////////////////////////////////// this section for create objects and
    /////////////////////////////////////// variables
    UsersDatabaseStageClass UsersObject = new UsersDatabaseStageClass();
    DrinksDatabaseStageClass DrinkObject = new DrinksDatabaseStageClass();
    DevicesDatabaseStageClass DeviceObject = new DevicesDatabaseStageClass();
    ActionClass ActionClassObject = new ActionClass();
    StartDayClass StartDayObject = new StartDayClass();

    private AlertMaker alert = new AlertMaker();
    //public String AdminPasswordFinall = "1811216";
    public String AdminPasswordFinall = "a";
    public String AdminPasswordStringMainn = "";
    Connection conn = SqliteConnection.Connector();
    PreparedStatement ps;
    ResultSet rs;

    ///////////////////////////////////
    ///////////////////////////////////
    ///////////////////////////////////
    public String Ps3iStartTime = "null";
    public String Ps3iiStartTime = "null";
    public String Ps3iiiStartTime = "null";
    public String Ps3ivStartTime = "null";
    public String Ps3vStartTime = "null";
    public String Ps4iStartTime = "null";
    public String Ps4iiStartTime = "null";
    @FXML
    private Tab ttab1;
    @FXML
    private Tab ttab2;
    @FXML
    private Tab ttab3;
    @FXML
    private Tab ttab4;
    @FXML
    private Tab ttab5;
    @FXML
    private Tab ttab6;
    @FXML
    private Tab ttab7;
    @FXML
    private Button ReportsButton1;
    @FXML
    private Button ReportsButton11;
    @FXML
    private Button OrdersButton;

    ///////////////////////////////////
    ///////////////////////////////////
    Label l1 = new Label(" ");
    Label l2 = new Label(" ");
    Label l3 = new Label(" ");
    Label l4 = new Label(" ");
    Label l5 = new Label(" ");
    Label l6 = new Label(" ");
    Label l7 = new Label(" ");
    ///////////////////////////////////
    ///////////////////////////////////
    ///////////////////////////////////
    Timeline timeline;
    Timeline timeline1;
    Timeline timeline2;
    Timeline timeline3;
    Timeline timeline4;
    Timeline timeline5;
    Timeline timeline6;

    ///////////////////////////////////
    ///////////////////////////////////
    ///////////////////////////////////
    ///////////////////////////////////
    ///////////////////////////////////
    /////////////////////////////////// this for logout button
    @FXML
    public void BackToMainScene(ActionEvent event) throws IOException, SQLException {
        Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
        CreateNewUserAlert.setTitle("Confirmation dialog");
        CreateNewUserAlert.setContentText("Are you sure ?");
        CreateNewUserAlert.setHeaderText(null);

        try {
            String query = "Select * from Users";
            ps = conn.prepareStatement(query);

            Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
            if (action.get() == ButtonType.OK) {

                AdditionalClass asdweiwe = new AdditionalClass();
                asdweiwe.closestage();
                Parent root11 = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

                Scene scene11 = new Scene(root11);

                Stage window11 = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window11.setScene(scene11);
                window11.setMaximized(false);
                //      window11.setFullScreen(false);
                window11.setMaxWidth(590);
                window11.setMaxHeight(550);
                window11.setMinWidth(590);
                window11.setMinHeight(550);
                window11.setY(100);
                window11.setX(400);

            }
            ps.close();
        } catch (SQLException e) {
            alert.showSimpleAlert("Attention", e.getMessage());
            ps.close();

        }
    }

    /////////////////////////////////
    ///////////////////////////////// this for open new stage which contain
    ///////////////////////////////// login user name
    @FXML
    public void CheckUserNameExist() throws IOException, SQLException {
        TextField CashPrice = new TextField();
        CashPrice.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                CashPrice.setText(newValue.replaceAll("[\\D]", "."));
            }
        });
        Button CheckButton = new Button("Save");

        StackPane sp = new StackPane();
        Text label1 = new Text("Start Shift");
        label1.setFont(Font.font("SanSerif", 20));
        label1.setFill(Color.WHITE);
        Text label2 = new Text(UserNameSave);
        label2.setFill(Color.WHITE);

        label2.setFont(Font.font("SanSerif", 20));
        HBox hbox = new HBox(10, label1);
        hbox.setAlignment(Pos.CENTER);
        Text label3 = new Text("Enter previous cashier Name");
        label3.setFont(Font.font("Titillium web", 20));
        label3.setFill(Color.WHITE);
        TextField CashName = new TextField();
        CashName.setPromptText("Enter previous cashier Name");
        CashName.setFont(Font.font("Titillium web", 20));
        CashName.setMinWidth(300);
        HBox hbox2 = new HBox(10, label3, CashName);
        Text label4 = new Text("Enter previous cashier price");
        label4.setFont(Font.font("SanSerif", 20));
        label4.setFill(Color.WHITE);

        CashPrice.setPromptText("Enter previous cashier price");

        CashPrice.setFont(Font.font("SanSerif", 20));
        CashPrice.setMinWidth(300);
        HBox hbox3 = new HBox(10, label4, CashPrice);
        VBox vbox1 = new VBox(50, hbox, hbox2, hbox3, CheckButton);
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setPadding(new Insets(30, 30, 30, 30));
        sp.getChildren().addAll(vbox1);
        Scene scene = new Scene(sp, 600, 400);

        scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
        Stage check = new Stage();
        check.setScene(scene);

        check.setX(400);
        check.setY(50);
        check.setMinHeight(400);
        check.setMinWidth(600);
        check.setTitle("Cashier: " + UserNameSave);

        check.show();
        StartDayClass startday = new StartDayClass();
        startday.LoadNames();

        TextFields.bindAutoCompletion(CashName, startday.UsersValues);
        check.getIcons().add(new Image("person.png"));
        CheckButton.setOnAction(e -> {

            if (CashName.getText().isEmpty() || CashPrice.getText().isEmpty()) {
                alert.showSimpleAlert("Attention", "Please enter two fields");

            } else {
                String cp = "";//this for cashier price
                String cn = "";// this for cash name

                try {
                    String query = "select PrevCashPrice , PrevCashName from Users where UserName='"
                            + UserNameSave + "'  ";
                    ps = conn.prepareStatement(query);
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        cp = rs.getString("PrevCashPrice");
                        cn = rs.getString("PrevCashName");

                    }
                    ps.close();
                    rs.close();
                } catch (Exception ee) {
                    Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                    CreateNewUserErrorAlert.setHeaderText(null);
                    CreateNewUserErrorAlert.setContentText(ee.getMessage());
                    CreateNewUserErrorAlert.showAndWait();
                    System.err.println(ee);
                    try {
                        ps.close();
                        rs.close();

                    } catch (SQLException ex) {
                        Logger.getLogger(MainSceneControllerClass.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                try {

                    String query = "Update Users set PrevCashPrice=?, PrevCashName=? where UserName='"
                            + UserNameSave + "'  ";

                    ps = conn.prepareStatement(query);

                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy  -  hh:mm a");

                    cp += "\n" + CashPrice.getText();
                    cn += "\n" + CashName.getText() + "  " + dateFormat.format(date);
                    ps.setString(1, cp);
                    ps.setString(2, cn);

                    ps.execute();

                    ps.close();

                } catch (SQLException e1) {
                    Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                    CreateNewUserErrorAlert.setHeaderText(null);
                    CreateNewUserErrorAlert.setContentText(e1.getMessage());
                    CreateNewUserErrorAlert.showAndWait();
                    System.err.println(e1);
                    try {
                        ps.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainSceneControllerClass.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                CashPrice.clear();
                CashName.clear();
                button1.setDisable(false);
                button2.setDisable(false);
                button3.setDisable(false);
                button4.setDisable(false);
                button5.setDisable(false);
                button6.setDisable(false);
                button7.setDisable(false);
                button8.setDisable(false);
                button9.setDisable(false);
                button10.setDisable(false);
                button11.setDisable(false);
                button12.setDisable(false);
                button13.setDisable(false);
                button14.setDisable(false);
                button15.setDisable(false);
                button16.setDisable(false);
                button17.setDisable(false);
                button18.setDisable(false);
                button19.setDisable(false);
                button20.setDisable(false);
                button21.setDisable(false);
                tab.setDisable(false);
                tab1.setDisable(false);
                CheckUserNameButton.setDisable(true);
                check.close();

            }

        });

    }
/////////////////////////////////////////////////
/////////////////////////////////////////////////
/////////////////////////////////////////////////
/////////////////////////////////////////////////
//////////////////////////////////////
//////////////////////////////////////
//////////////////////////////////////this for load password admin

    private void LoadPass() {
        try {

            String query = "select pass from AdminPasswordTable where number =1 ";

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            while (rs.next()) {

                AdminPasswordFinall = rs.getString(1);
            }

            ps.close();
            rs.close();
        } catch (SQLException e1) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText(e1.getMessage());
            CreateNewUserErrorAlert.showAndWait();
            System.err.println(e1);
            try {
                ps.close();
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MainSceneControllerClass.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    ///////////////////////////////////
    /////////////////////////////////// this for open user database
    @FXML
    public void SetAdminPassword() throws IOException {
        if (AdminPass.getText().isEmpty()) {
            alert.showSimpleAlert("Attention", "Please enter an admin password");

        } else {
            LoadPass();
            AdminPasswordStringMainn = AdminPass.getText();
            AdminPass.clear();
            if (AdminPasswordStringMainn.equals(AdminPasswordFinall)) {
                UserButton.setDisable(false);
                DevicesButton.setDisable(false);
                DrinksButton.setDisable(false);
                ReportsButton.setDisable(false);
                ReportsButton1.setDisable(false);
                ReportsButton11.setDisable(false);
                StartDayButton.setDisable(false);
                RestoreDataButton.setDisable(false);
                RestoreDataButton1.setDisable(false);
                EditTitleButton.setDisable(false);
                OrdersButton.setDisable(false);

                button1.setDisable(false);
                button2.setDisable(false);
                button3.setDisable(false);
                button4.setDisable(false);
                button5.setDisable(false);
                button6.setDisable(false);
                button7.setDisable(false);
                button8.setDisable(false);
                button9.setDisable(false);
                button10.setDisable(false);
                button11.setDisable(false);
                button12.setDisable(false);
                button13.setDisable(false);
                button14.setDisable(false);
                button15.setDisable(false);
                button16.setDisable(false);
                button17.setDisable(false);
                button18.setDisable(false);
                button19.setDisable(false);
                button20.setDisable(false);
                button21.setDisable(false);
                tab.setDisable(false);
                tab1.setDisable(false);
                SaveAdminPassButton.setDisable(true);
                CheckUserNameButton.setDisable(true);
            }
        }
    }

    ///////////////////////////////////
    /////////////////////////////////// this for open user database
    @FXML
    public void UserDatabaseHandler() throws IOException {

        if (AdminPasswordStringMainn.equals(AdminPasswordFinall)) {
            UsersObject.UsersDatabaseStageMethod();
            UsersObject.setAdminStageCount(0);
        } else {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("The password entered in incorrect");
            a.setTitle("Attention");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void DrinksDatabaseHandler() throws IOException {

        if (AdminPasswordStringMainn.equals(AdminPasswordFinall)) {
            DrinkObject.DrinksDatabaseStageMethod();

        } else {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("The password entered in incorrect");
            a.setTitle("Attention");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void DevicesDatabaseHandler() throws IOException {

        if (AdminPasswordStringMainn.equals(AdminPasswordFinall)) {
            DeviceObject.DrinksDatabaseStageMethod();

        } else {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("The password entered in incorrect");
            a.setTitle("Attention");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void ReportsHandler() throws IOException {

        if (AdminPasswordStringMainn.equals(AdminPasswordFinall)) {
            ReportsFXMLController r = new ReportsFXMLController();
            r.ReportsStageMethod();
        } else {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("The password entered in incorrect");
            a.setTitle("Attention");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void OrdersHandler() throws IOException {

        if (AdminPasswordStringMainn.equals(AdminPasswordFinall)) {
            OrdersEditFXMLController r = new OrdersEditFXMLController();
            r.StageMethod();
        } else {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("The password entered in incorrect");
            a.setTitle("Attention");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void StartDayHandler() throws IOException, SQLException {

        if (AdminPasswordStringMainn.equals(AdminPasswordFinall)) {
            Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
            CreateNewUserAlert.setTitle("Confirmation dialog");
            CreateNewUserAlert.setContentText("Are you sure to start daily count?");
            CreateNewUserAlert.setHeaderText(null);

            Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
            if (action.get() == ButtonType.OK) {
                StartDayObject.Do();
            }

        } else {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("The password entered in incorrect");
            a.setTitle("Attention");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void RestoreDataButtonMethod() throws IOException, SQLException {

        if (AdminPasswordStringMainn.equals(AdminPasswordFinall)) {
            Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
            CreateNewUserAlert.setTitle("Confirmation dialog");
            CreateNewUserAlert.setContentText("Are you sure to restore last backup?");
            CreateNewUserAlert.setHeaderText(null);

            Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
            if (action.get() == ButtonType.OK) {
                FileChannel sourceChannel = null;
                FileChannel destChannel = null;
                File dest = new File("C:\\ProgramData\\Miicrosoft Ps_Help\\Mydatabase\\Clinic_Manager_DB.db");
                File source = new File("D:\\TMPSBup\\Psbup.db");
                //     File source = new File("D:\\TMPSBup\\Clinic_Manager_DB.db");
                //   File source = new File("F:\\TMPSBup\\Clinic_Manager_DB.db");
                try {
                    sourceChannel = new FileInputStream(source).getChannel();
                    destChannel = new FileOutputStream(dest).getChannel();
                    destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
                } finally {
                    sourceChannel.close();
                    destChannel.close();
                }
            }

        } else {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("The password entered in incorrect");
            a.setTitle("Attention");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void UpdatePassButtonMethod() throws IOException, SQLException, InterruptedException {

        if (AdminPasswordStringMainn.equals(AdminPasswordFinall)) {
            AnchorPanePassword.setOpacity(1);
            AnchorPanePassword.setDisable(false);

        } else {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("The password entered in incorrect");
            a.setTitle("Attention");
            a.setHeaderText(null);
            a.showAndWait();
        }

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void UpdatePassButtonMethodDB() throws IOException, SQLException {
        //   AnchorPanePassword.setDisable(false);
        if (UpdatePassTextField.getText().isEmpty()) {
            Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
            CreateNewUserErrorAlert.setHeaderText(null);
            CreateNewUserErrorAlert.setContentText("Please enter the new password");
            CreateNewUserErrorAlert.showAndWait();

        } else {
            Alert CreateNewUserAlert1 = new Alert(Alert.AlertType.CONFIRMATION);
            CreateNewUserAlert1.setTitle("Confirmation dialog");
            CreateNewUserAlert1.setContentText("Are you sure to update password");
            CreateNewUserAlert1.setHeaderText(null);

            Optional<ButtonType> action = CreateNewUserAlert1.showAndWait();
            if (action.get() == ButtonType.OK) {
                try {

                    String query = "Update AdminPasswordTable set pass=? where number =1";

                    ps = conn.prepareStatement(query);

                    ps.setString(1, UpdatePassTextField.getText());

                    ps.execute();

                    Alert CreateNewUserAlert = new Alert(Alert.AlertType.INFORMATION,
                            "Admin Password has been successfully updated");

                    CreateNewUserAlert.setHeaderText(null);
                    CreateNewUserAlert.showAndWait();

                    ps.close();
                    UpdatePassTextField.clear();
                } catch (SQLException e1) {
                    Alert CreateNewUserErrorAlert = new Alert(Alert.AlertType.ERROR);
                    CreateNewUserErrorAlert.setHeaderText(null);
                    CreateNewUserErrorAlert.setContentText(e1.getMessage());
                    CreateNewUserErrorAlert.showAndWait();
                    System.err.println(e1);
                    try {
                        ps.close();
                        rs.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MainSceneControllerClass.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                AnchorPanePassword.setOpacity(0);
                //  RestoreDataButton1.setDisable(true);
                UserButton.setDisable(true);
                DevicesButton.setDisable(true);
                DrinksButton.setDisable(true);
                ReportsButton.setDisable(true);
                ReportsButton1.setDisable(true);
                ReportsButton11.setDisable(true);
                StartDayButton.setDisable(true);
                RestoreDataButton.setDisable(true);
                RestoreDataButton1.setDisable(true);
                EditTitleButton.setDisable(true);
                AnchorPanePassword.setDisable(true);
                OrdersButton.setDisable(true);

                SaveAdminPassButton.setDisable(false);
            }
        }
    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void PrintLastOrder() throws IOException, SQLException {

        PrintRecipt r = new PrintRecipt();
        r.ShowReport();

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void OpenCalc() {

        Runtime app = Runtime.getRuntime();
        try {
            //open notepad
            //    app.exec("notepad");
            Runtime.getRuntime().exec("calc");
            //open calculator
            //  app.exec("calc");
        } catch (Exception Ex) {
            System.out.println("Error: " + Ex.toString());
        }

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void PaymentsOpen() throws IOException {

        PaymentsFXMLController f = new PaymentsFXMLController();
        f.PaymentsStageMethod();

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void PaymentsHandler() throws IOException {

        PaymentsAllFXMLController ad = new PaymentsAllFXMLController();
        ad.StageMethod();

    }

    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    ///////////////////////////////
    @FXML
    public void HistoryHandler() throws IOException {

        HistoryFXMLController ad = new HistoryFXMLController();
        ad.StageMethod();

    }

    /////////// this actions for ps3i
    ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void Ps3iPriceForHour() throws SQLException {
        ActionClassObject.PriceForHourHandle("ps3i", Ps3iPriceTextField, ps3iLabel, "Ps 3", Ps3iNumberTextField);
        if (Ps3iStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3iStartTime = dateFormat.format(date) + "\n";

        }

    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3iPriceForMatch() throws SQLException {
        ActionClassObject.PriceForMatchHandle("ps3i", Ps3iPriceTextField, ps3iLabel, "Ps 3", Ps3iNumberTextField);
        if (Ps3iStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3iStartTime = dateFormat.format(date) + "\n";

        }

    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void Ps3iPriceForHourM() throws SQLException {
        ActionClassObject.PriceForHourHandleM("ps3i", Ps3iPriceTextField, ps3iLabel, "Ps 3", Ps3iNumberTextField);
        if (Ps3iStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3iStartTime = dateFormat.format(date) + "\n";

        }

    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3iPriceForMatchM() throws SQLException {
        ActionClassObject.PriceForMatchHandleM("ps3i", Ps3iPriceTextField, ps3iLabel, "Ps 3", Ps3iNumberTextField);
        if (Ps3iStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3iStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3iSaveButtonPs() throws SQLException {
        ActionClassObject.SaveButtonPS(Ps3iPriceTextField, Ps3iNumberTextField, ps3iLabel, ps3iMatlob, ps3iTextarea,
                "ps3i", ttab1, "Playstation 3 Table 1");
        //  ttab1.setStyle("-fx-text-base-color: red;");

    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iCancelBButtonPs() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iPriceTextField, Ps3iNumberTextField, ps3iLabel);
    }
    //////////////////////////////////////////
    /////////////////////////////////////////

    @FXML
    public void Ps3iSaveButtonDrink() throws SQLException {
        ActionClassObject.SaveButtonDrink(Ps3iDrinkPriceTextField, Ps3iDrinkNumberTextField, ps3iDrinkLabel, ps3iMatlob,
                ps3iTextarea, ttab1, "Playstation 3 Table 1");
        //    ttab1.setStyle("-fx-text-base-color: red;");

    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iCancelBButtonDrink() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iDrinkPriceTextField, Ps3iDrinkNumberTextField, ps3iDrinkLabel);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iFillListView() throws SQLException {
        ActionClassObject.FilllistvIew(ps3ilist);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iFillLFromistView() throws SQLException {
        ActionClassObject.FillFromListview(ps3ilist, Ps3iDrinkPriceTextField, ps3iDrinkLabel);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void handleAutomatic() throws SQLException {
        Float a = Float.parseFloat(ps3iMatlob.getText());
        Float b = Float.parseFloat(ps3iMadfo3.getText());
        Float c = b - a;
        ps3iBaqy.setText(Float.toString(c));
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iSaveUserButton() throws SQLException {
        ActionClassObject.SaveToUserTable(UserNameSave, ps3iMatlob, ps3iTextarea, ps3iMadfo3, ps3iBaqy, "  At PS3 table 1",
                Ps3iStartTime, ttab1, l1);
        if (l1.getText().equals("ok")) {
            Ps3iStartTime = "null";
            l1.setText(" ");
            Ps3iCancelBButtonPs();
            Ps3iCancelBButtonDrink();
            timeline.pause();
            timeline.stop();
            mins = 0;
            secs = 0;
            millis = 0;
            hourrr = 0;

            ps3itext.setText("00:00:00");
            Image play = new Image("rsz_play_50px.png");
            ImageView imgView = new ImageView(play);
            sos31 = true;
            imgView.setImage(play);
            StartTimer.setGraphic(imgView);

        }

    }
///////////////////////////////////////////////////////
/////////////////////////////////////////////////////// end of ps3i actions 
    ///////////
    ////////
    /////////// this actions for ps3ii
    ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @FXML
    public void Ps3iiPriceForHour() throws SQLException {
        ActionClassObject.PriceForHourHandle("ps3ii", Ps3iPriceTextField1, ps3iLabel1, "Ps 3", Ps3iNumberTextField1);

        if (Ps3iiStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3iiStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3iiPriceForMatch() throws SQLException {
        ActionClassObject.PriceForMatchHandle("ps3ii", Ps3iPriceTextField1, ps3iLabel1, "Ps 3", Ps3iNumberTextField1);

        if (Ps3iiStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3iiStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @FXML
    public void Ps3iiPriceForHourM() throws SQLException {
        ActionClassObject.PriceForHourHandleM("ps3ii", Ps3iPriceTextField1, ps3iLabel1, "Ps 3", Ps3iNumberTextField1);

        if (Ps3iiStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3iiStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3iiPriceForMatchM() throws SQLException {
        ActionClassObject.PriceForMatchHandleM("ps3ii", Ps3iPriceTextField1, ps3iLabel1, "Ps 3", Ps3iNumberTextField1);

        if (Ps3iiStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3iiStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3iiSaveButtonPs() throws SQLException {
        ActionClassObject.SaveButtonPS(Ps3iPriceTextField1, Ps3iNumberTextField1, ps3iLabel1, ps3iMatlob1, ps3iTextarea1,
                "ps3ii", ttab2, "Playstation 3 Table 2");
        //    ttab2.setStyle("-fx-text-base-color: red;");

    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iiCancelBButtonPs() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iPriceTextField1, Ps3iNumberTextField1, ps3iLabel1);

    }
    //////////////////////////////////////////
    /////////////////////////////////////////

    @FXML
    public void Ps3iiSaveButtonDrink() throws SQLException {
        ActionClassObject.SaveButtonDrink(Ps3iDrinkPriceTextField1, Ps3iDrinkNumberTextField1, ps3iDrinkLabel1,
                ps3iMatlob1, ps3iTextarea1, ttab2, "Playstation 3 Table 2");
        //ttab2.setStyle("-fx-text-base-color: red;");
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iiCancelBButtonDrink() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iDrinkPriceTextField1, Ps3iDrinkNumberTextField1, ps3iDrinkLabel1);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iiFillListView() throws SQLException {
        ActionClassObject.FilllistvIew(ps3ilist1);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iiFillLFromistView() throws SQLException {
        ActionClassObject.FillFromListview(ps3ilist1, Ps3iDrinkPriceTextField1, ps3iDrinkLabel1);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void handleAutomatic1() throws SQLException {
        Float a = Float.parseFloat(ps3iMatlob1.getText());
        Float b = Float.parseFloat(ps3iMadfo31.getText());
        Float c = b - a;
        ps3iBaqy1.setText(Float.toString(c));
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iiSaveUserButton() throws SQLException {
        ActionClassObject.SaveToUserTable(UserNameSave, ps3iMatlob1, ps3iTextarea1, ps3iMadfo31, ps3iBaqy1,
                "  At PS3 table 2",
                Ps3iiStartTime, ttab2, l2);
        if (l2.getText().equals("ok")) {
            Ps3iiStartTime = "null";
            l2.setText(" ");

            Ps3iiCancelBButtonPs();
            Ps3iiCancelBButtonDrink();
            timeline1.pause();
            timeline1.stop();

            mins1 = 0;
            secs1 = 0;
            millis1 = 0;
            hourrr1 = 0;

            ps3itext1.setText("00:00:00");
            Image play = new Image("rsz_play_50px.png");
            ImageView imgView = new ImageView(play);
            sos32 = true;
            imgView.setImage(play);
            StartTimer1.setGraphic(imgView);

        }

    }
///////////////////////////////////////////////////////
/////////////////////////////////////////////////////// end of ps3ii actions 
    ///////////
    ////////
    ///////////////
    /////////// this actions for ps3iii
    ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @FXML
    public void Ps3iiiPriceForHour() throws SQLException {
        ActionClassObject.PriceForHourHandle("ps3iii", Ps3iPriceTextField2, ps3iLabel2, "Ps 3", Ps3iNumberTextField2);

        if (Ps3iiiStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3iiiStartTime = dateFormat.format(date) + "\n";

        }

    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3iiiPriceForMatch() throws SQLException {
        ActionClassObject.PriceForMatchHandle("ps3iii", Ps3iPriceTextField2, ps3iLabel2, "Ps 3", Ps3iNumberTextField2);

        if (Ps3iiiStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3iiiStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @FXML
    public void Ps3iiiPriceForHourM() throws SQLException {
        ActionClassObject.PriceForHourHandleM("ps3iii", Ps3iPriceTextField2, ps3iLabel2, "Ps 3", Ps3iNumberTextField2);

        if (Ps3iiiStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3iiiStartTime = dateFormat.format(date) + "\n";

        }

    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3iiiPriceForMatchM() throws SQLException {
        ActionClassObject.PriceForMatchHandleM("ps3iii", Ps3iPriceTextField2, ps3iLabel2, "Ps 3", Ps3iNumberTextField2);

        if (Ps3iiiStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3iiiStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3iiiSaveButtonPs() throws SQLException {
        ActionClassObject.SaveButtonPS(Ps3iPriceTextField2, Ps3iNumberTextField2, ps3iLabel2,
                ps3iMatlob2, ps3iTextarea2, "ps3iii", ttab3, "Playstation 3 Table 3");
        // ttab3.setStyle("-fx-text-base-color: red;");
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iiiCancelBButtonPs() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iPriceTextField2, Ps3iNumberTextField2, ps3iLabel2);
    }
    //////////////////////////////////////////
    /////////////////////////////////////////

    @FXML
    public void Ps3iiiSaveButtonDrink() throws SQLException {
        ActionClassObject.SaveButtonDrink(Ps3iDrinkPriceTextField2, Ps3iDrinkNumberTextField2,
                ps3iDrinkLabel2, ps3iMatlob2, ps3iTextarea2, ttab3, "Playstation 3 Table 3");
        // ttab3.setStyle("-fx-text-base-color: red;");
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iiiCancelBButtonDrink() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iDrinkPriceTextField2, Ps3iDrinkNumberTextField2, ps3iDrinkLabel2);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iiiFillListView() throws SQLException {
        ActionClassObject.FilllistvIew(ps3ilist2);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iiiFillLFromistView() throws SQLException {
        ActionClassObject.FillFromListview(ps3ilist2, Ps3iDrinkPriceTextField2, ps3iDrinkLabel2);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void handleAutomatic2() throws SQLException {
        Float a = Float.parseFloat(ps3iMatlob2.getText());
        Float b = Float.parseFloat(ps3iMadfo32.getText());
        Float c = b - a;
        ps3iBaqy2.setText(Float.toString(c));
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3iiiSaveUserButton() throws SQLException {
        ActionClassObject.SaveToUserTable(UserNameSave, ps3iMatlob2, ps3iTextarea2, ps3iMadfo32, ps3iBaqy2, "  At PS3 table 3",
                Ps3iiiStartTime, ttab3, l3);

        if (l3.getText().equals("ok")) {
            Ps3iiiStartTime = "null";
            l3.setText(" ");
            Ps3iiiCancelBButtonPs();
            Ps3iiiCancelBButtonDrink();
            timeline2.pause();
            timeline2.stop();
            mins2 = 0;
            secs2 = 0;
            millis2 = 0;
            hourrr2 = 0;

            ps3itext2.setText("00:00:00");
            Image play = new Image("rsz_play_50px.png");
            ImageView imgView = new ImageView(play);
            sos33 = true;
            imgView.setImage(play);
            StartTimer2.setGraphic(imgView);
        }

    }
///////////////////////////////////////////////////////
/////////////////////////////////////////////////////// end of ps3iii actions 
    ///////////
    ////////
    ///////////////
    /////////// this actions for ps3iv
    ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @FXML
    public void Ps3ivPriceForHour() throws SQLException {
        ActionClassObject.PriceForHourHandle("ps3iv", Ps3iPriceTextField3, ps3iLabel3, "Ps 3", Ps3iNumberTextField3);
        if (Ps3ivStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3ivStartTime = dateFormat.format(date) + "\n";

        }

    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3ivPriceForMatch() throws SQLException {
        ActionClassObject.PriceForMatchHandle("ps3iv", Ps3iPriceTextField3, ps3iLabel3, "Ps 3", Ps3iNumberTextField3);
        if (Ps3ivStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3ivStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @FXML
    public void Ps3ivPriceForHourM() throws SQLException {
        ActionClassObject.PriceForHourHandleM("ps3iv", Ps3iPriceTextField3, ps3iLabel3, "Ps 3", Ps3iNumberTextField3);
        if (Ps3ivStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3ivStartTime = dateFormat.format(date) + "\n";

        }

    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3ivPriceForMatchM() throws SQLException {
        ActionClassObject.PriceForMatchHandleM("ps3iv", Ps3iPriceTextField3, ps3iLabel3, "Ps 3", Ps3iNumberTextField3);
        if (Ps3ivStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3ivStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3ivSaveButtonPs() throws SQLException {
        ActionClassObject.SaveButtonPS(Ps3iPriceTextField3, Ps3iNumberTextField3, ps3iLabel3,
                ps3iMatlob3, ps3iTextarea3, "ps3iv", ttab4, "Playstation 3 Table 4");
        //      ttab4.setStyle("-fx-text-base-color: red;");
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3ivCancelBButtonPs() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iPriceTextField3, Ps3iNumberTextField3, ps3iLabel3);
    }
    //////////////////////////////////////////
    /////////////////////////////////////////

    @FXML
    public void Ps3ivSaveButtonDrink() throws SQLException {
        ActionClassObject.SaveButtonDrink(Ps3iDrinkPriceTextField3, Ps3iDrinkNumberTextField3, ps3iDrinkLabel3,
                ps3iMatlob3, ps3iTextarea3, ttab4, "Playstation 3 Table 4");
        //   ttab4.setStyle("-fx-text-base-color: red;");
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3ivCancelBButtonDrink() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iDrinkPriceTextField3, Ps3iDrinkNumberTextField3, ps3iDrinkLabel3);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3ivFillListView() throws SQLException {
        ActionClassObject.FilllistvIew(ps3ilist3);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3ivFillLFromistView() throws SQLException {
        ActionClassObject.FillFromListview(ps3ilist3, Ps3iDrinkPriceTextField3, ps3iDrinkLabel3);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void handleAutomatic3() throws SQLException {
        Float a = Float.parseFloat(ps3iMatlob3.getText());
        Float b = Float.parseFloat(ps3iMadfo33.getText());
        Float c = b - a;
        ps3iBaqy3.setText(Float.toString(c));
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3ivSaveUserButton() throws SQLException {
        ActionClassObject.SaveToUserTable(UserNameSave, ps3iMatlob3, ps3iTextarea3, ps3iMadfo33, ps3iBaqy3, "  At PS3 table 4",
                Ps3ivStartTime, ttab4, l4);
        if (l4.getText().equals("ok")) {
            Ps3ivStartTime = "null";
            l4.setText(" ");
            Ps3ivCancelBButtonPs();
            Ps3ivCancelBButtonDrink();
            timeline3.pause();
            timeline3.stop();
            mins3 = 0;
            secs3 = 0;
            millis3 = 0;
            hourrr3 = 0;

            ps3itext3.setText("00:00:00");
            Image play = new Image("rsz_play_50px.png");
            ImageView imgView = new ImageView(play);
            sos34 = true;
            imgView.setImage(play);
            StartTimer3.setGraphic(imgView);

        }

    }
///////////////////////////////////////////////////////
/////////////////////////////////////////////////////// end of ps3iv actions 
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    /////////// this actions for ps3v
    ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @FXML
    public void Ps3vPriceForHour() throws SQLException {
        ActionClassObject.PriceForHourHandle("ps3v", Ps3iPriceTextField4, ps3iLabel4, "Ps 3", Ps3iNumberTextField4);
        if (Ps3vStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3vStartTime = dateFormat.format(date) + "\n";

        }

    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3vPriceForMatch() throws SQLException {
        ActionClassObject.PriceForMatchHandle("ps3v", Ps3iPriceTextField4, ps3iLabel4, "Ps 3", Ps3iNumberTextField4);
        if (Ps3vStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3vStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @FXML
    public void Ps3vPriceForHourM() throws SQLException {
        ActionClassObject.PriceForHourHandleM("ps3v", Ps3iPriceTextField4, ps3iLabel4, "Ps 3", Ps3iNumberTextField4);
        if (Ps3vStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3vStartTime = dateFormat.format(date) + "\n";

        }

    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3vPriceForMatchM() throws SQLException {
        ActionClassObject.PriceForMatchHandleM("ps3v", Ps3iPriceTextField4, ps3iLabel4, "Ps 3", Ps3iNumberTextField4);
        if (Ps3vStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps3vStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps3vSaveButtonPs() throws SQLException {
        ActionClassObject.SaveButtonPS(Ps3iPriceTextField4, Ps3iNumberTextField4, ps3iLabel4, ps3iMatlob4,
                ps3iTextarea4, "ps3v", ttab5, "Playstation 3 Table 5");
        //   ttab5.setStyle("-fx-text-base-color: red;");
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3vCancelBButtonPs() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iPriceTextField4, Ps3iNumberTextField4, ps3iLabel4);
    }
    //////////////////////////////////////////
    /////////////////////////////////////////

    @FXML
    public void Ps3vSaveButtonDrink() throws SQLException {
        ActionClassObject.SaveButtonDrink(Ps3iDrinkPriceTextField4, Ps3iDrinkNumberTextField4, ps3iDrinkLabel4,
                ps3iMatlob4, ps3iTextarea4, ttab5, "Playstation 3 Table 5");
        //  ttab5.setStyle("-fx-text-base-color: red;");
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3vCancelBButtonDrink() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iDrinkPriceTextField4, Ps3iDrinkNumberTextField4, ps3iDrinkLabel4);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3vFillListView() throws SQLException {
        ActionClassObject.FilllistvIew(ps3ilist4);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3vFillLFromistView() throws SQLException {
        ActionClassObject.FillFromListview(ps3ilist4, Ps3iDrinkPriceTextField4, ps3iDrinkLabel4);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void handleAutomatic4() throws SQLException {
        Float a = Float.parseFloat(ps3iMatlob4.getText());
        Float b = Float.parseFloat(ps3iMadfo34.getText());
        Float c = b - a;
        ps3iBaqy4.setText(Float.toString(c));
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps3vSaveUserButton() throws SQLException {
        ActionClassObject.SaveToUserTable(UserNameSave, ps3iMatlob4, ps3iTextarea4, ps3iMadfo34, ps3iBaqy4,
                "  At PS3 table 5",
                Ps3vStartTime, ttab5, l5);

        if (l5.getText().equals("ok")) {
            Ps3vStartTime = "null";
            l5.setText(" ");

            Ps3vCancelBButtonPs();
            Ps3vCancelBButtonDrink();
            timeline4.pause();
            timeline4.stop();
            mins4 = 0;
            secs4 = 0;
            millis4 = 0;
            hourrr4 = 0;

            ps3itext4.setText("00:00:00");
            Image play = new Image("rsz_play_50px.png");
            ImageView imgView = new ImageView(play);
            sos35 = true;
            imgView.setImage(play);
            StartTimer4.setGraphic(imgView);

        }

    }
///////////////////////////////////////////////////////
/////////////////////////////////////////////////////// end of ps3v actions 
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    /////////// this actions for ps3v
    ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @FXML
    public void Ps4iPriceForHour() throws SQLException {
        ActionClassObject.PriceForHourHandle("ps4i", Ps3iPriceTextField5, ps3iLabel5, "Ps 4", Ps3iNumberTextField5);
        if (Ps4iStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps4iStartTime = dateFormat.format(date) + "\n";

        }

    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps4iPriceForMatch() throws SQLException {
        ActionClassObject.PriceForMatchHandle("ps4i", Ps3iPriceTextField5, ps3iLabel5, "Ps 4", Ps3iNumberTextField5);
        if (Ps4iStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps4iStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @FXML
    public void Ps4iPriceForHourM() throws SQLException {
        ActionClassObject.PriceForHourHandleM("ps4i", Ps3iPriceTextField5, ps3iLabel5, "Ps 4", Ps3iNumberTextField5);
        if (Ps4iStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps4iStartTime = dateFormat.format(date) + "\n";

        }

    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps4iPriceForMatchM() throws SQLException {
        ActionClassObject.PriceForMatchHandleM("ps4i", Ps3iPriceTextField5, ps3iLabel5, "Ps 4", Ps3iNumberTextField5);
        if (Ps4iStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps4iStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps4iSaveButtonPs() throws SQLException {
        ActionClassObject.SaveButtonPS(Ps3iPriceTextField5, Ps3iNumberTextField5, ps3iLabel5, ps3iMatlob5,
                ps3iTextarea5, "ps4i", ttab6, "Playstation 4 Table 1");
        //     ttab6.setStyle("-fx-text-base-color: red;");
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps4iCancelBButtonPs() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iPriceTextField5, Ps3iNumberTextField5, ps3iLabel5);
    }
    //////////////////////////////////////////
    /////////////////////////////////////////

    @FXML
    public void Ps4iSaveButtonDrink() throws SQLException {
        ActionClassObject.SaveButtonDrink(Ps3iDrinkPriceTextField5, Ps3iDrinkNumberTextField5, ps3iDrinkLabel5,
                ps3iMatlob5, ps3iTextarea5, ttab6, "Playstation 4 Table 1");
        //    ttab6.setStyle("-fx-text-base-color: red;");
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps4iCancelBButtonDrink() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iDrinkPriceTextField5, Ps3iDrinkNumberTextField5, ps3iDrinkLabel5);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps4iFillListView() throws SQLException {
        ActionClassObject.FilllistvIew(ps3ilist5);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps4iFillLFromistView() throws SQLException {
        ActionClassObject.FillFromListview(ps3ilist5, Ps3iDrinkPriceTextField5, ps3iDrinkLabel5);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void handleAutomatic5() throws SQLException {
        Float a = Float.parseFloat(ps3iMatlob5.getText());
        Float b = Float.parseFloat(ps3iMadfo35.getText());
        Float c = b - a;
        ps3iBaqy5.setText(Float.toString(c));
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps4iSaveUserButton() throws SQLException {
        ActionClassObject.SaveToUserTable(UserNameSave, ps3iMatlob5, ps3iTextarea5, ps3iMadfo35, ps3iBaqy5, "  At PS4 table 1",
                Ps4iStartTime, ttab6, l6);
        if (l6.getText().equals("ok")) {
            Ps4iStartTime = "null";
            l6.setText(" ");

            Ps4iCancelBButtonPs();
            Ps4iCancelBButtonDrink();
            timeline5.pause();
            timeline5.stop();
            mins5 = 0;
            secs5 = 0;
            millis5 = 0;
            hourrr5 = 0;

            ps3itext5.setText("00:00:00");
            Image play = new Image("rsz_play_50px.png");
            ImageView imgView = new ImageView(play);
            sos41 = true;
            imgView.setImage(play);
            StartTimer5.setGraphic(imgView);

        }

    }
///////////////////////////////////////////////////////
/////////////////////////////////////////////////////// end of ps4i actions 
    ///////////
    /////////// this actions for ps4ii
    ////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @FXML
    public void Ps4iiPriceForHour() throws SQLException {
        ActionClassObject.PriceForHourHandle("ps4ii", Ps3iPriceTextField6, ps3iLabel6, "Ps 4", Ps3iNumberTextField6);
        if (Ps4iiStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps4iiStartTime = dateFormat.format(date) + "\n";

        }

    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps4iiPriceForMatch() throws SQLException {
        ActionClassObject.PriceForMatchHandle("ps4ii", Ps3iPriceTextField6, ps3iLabel6, "Ps 4", Ps3iNumberTextField6);
        if (Ps4iiStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps4iiStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////

    @FXML
    public void Ps4iiPriceForHourM() throws SQLException {
        ActionClassObject.PriceForHourHandleM("ps4ii", Ps3iPriceTextField6, ps3iLabel6, "Ps 4", Ps3iNumberTextField6);
        if (Ps4iiStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps4iiStartTime = dateFormat.format(date) + "\n";

        }

    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps4iiPriceForMatchM() throws SQLException {
        ActionClassObject.PriceForMatchHandleM("ps4ii", Ps3iPriceTextField6, ps3iLabel6, "Ps 4", Ps3iNumberTextField6);
        if (Ps4iiStartTime.equals("null")) {
            Date date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
            Ps4iiStartTime = dateFormat.format(date) + "\n";

        }
    }
    //////////////////////////////////////////
    //////////////////////////////////////////

    @FXML
    public void Ps4iiSaveButtonPs() throws SQLException {
        ActionClassObject.SaveButtonPS(Ps3iPriceTextField6, Ps3iNumberTextField6, ps3iLabel6, ps3iMatlob6,
                ps3iTextarea6, "ps4ii", ttab7, "Playstation 4 Table 2");
        // ttab7.setStyle("-fx-text-base-color: red;");
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps4iiCancelBButtonPs() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iPriceTextField6, Ps3iNumberTextField6, ps3iLabel6);
    }
    //////////////////////////////////////////
    /////////////////////////////////////////

    @FXML
    public void Ps4iiSaveButtonDrink() throws SQLException {
        ActionClassObject.SaveButtonDrink(Ps3iDrinkPriceTextField6, Ps3iDrinkNumberTextField6, ps3iDrinkLabel6,
                ps3iMatlob6, ps3iTextarea6, ttab7, "Playstation 4 Table 2");
        //    ttab7.setStyle("-fx-text-base-color: red;");
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps4iiCancelBButtonDrink() throws SQLException {
        ActionClassObject.CancelButtonPs(Ps3iDrinkPriceTextField6, Ps3iDrinkNumberTextField6, ps3iDrinkLabel6);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps4iiFillListView() throws SQLException {
        ActionClassObject.FilllistvIew(ps3ilist6);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps4iiFillLFromistView() throws SQLException {
        ActionClassObject.FillFromListview(ps3ilist6, Ps3iDrinkPriceTextField6, ps3iDrinkLabel6);
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void handleAutomatic6() throws SQLException {
        Float a = Float.parseFloat(ps3iMatlob6.getText());
        Float b = Float.parseFloat(ps3iMadfo36.getText());
        Float c = b - a;
        ps3iBaqy6.setText(Float.toString(c));
    }

    //////////////////////////////////////////
    //////////////////////////////////////////
    @FXML
    public void Ps4iiSaveUserButton() throws SQLException {
        ActionClassObject.SaveToUserTable(UserNameSave, ps3iMatlob6, ps3iTextarea6, ps3iMadfo36, ps3iBaqy6,
                "  At PS4 table 2",
                Ps4iiStartTime, ttab7, l7);
        if (l7.getText().equals("ok")) {
            Ps4iiStartTime = "null";
            l7.setText(" ");
            Ps4iiCancelBButtonPs();
            Ps4iiCancelBButtonDrink();
            timeline6.pause();
            timeline6.stop();
            mins6 = 0;
            secs6 = 0;
            millis6 = 0;
            hourrr6 = 0;

            ps3itext6.setText("00:00:00");
            Image play = new Image("rsz_play_50px.png");
            ImageView imgView = new ImageView(play);
            sos42 = true;
            imgView.setImage(play);
            StartTimer6.setGraphic(imgView);

        }

    }
///////////////////////////////////////////////////////
/////////////////////////////////////////////////////// end of ps4ii actions 
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////

    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    @FXML
    private void add() throws IOException {
        AdditionalClass a = new AdditionalClass();
        a.UsersDatabaseStageMethod();

    }

    ////////
    ///////////////
    /////////////////
    @FXML
    private void Minimizee() throws IOException {
        //AdditionalClass a = new AdditionalClass();
        //  a.MinimizeStage();

    }

    ////////
    ///////////////
    ///////////////
    /////////////////
    @FXML
    private void Hide() throws IOException {
        AnchorPanePassword.setDisable(true);
        AnchorPanePassword.setOpacity(0);

    }

    ////////
    ///////////////
    ///////////////
    /////////////////
    @FXML
    private void EditTitleMethod() throws IOException {
        EditTitleFXMLController f = new EditTitleFXMLController();
        f.EditTitleStageMethod();

    }
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    ///////////
    ////////
    ///////////////
    /////////////////
    @FXML
    private AnchorPane anchoooooor;
    @FXML
    private AnchorPane anchoooooor1;
    ///////////
    ////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////
    //////////////////////////////////////////////
    ////////////////////////////////////////////// timelines

    /*
     * Timeline timeline Timeline timeline Timeline timeline
     */
////////////////////////////////////////
////////////////////////////////////////
////////////////////////////////////////
//////////////////////////////////////// booleans 
    boolean sos31 = true;
    boolean sos32 = true;
    boolean sos33 = true;
    boolean sos34 = true;
    boolean sos35 = true;
    boolean sos41 = true;
    boolean sos42 = true;
//////////////////////////////////////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
////////////////////////////////////////////////// change text Method
    int hourrr = 0, mins = 0, secs = 0, millis = 0;

    void change(Text text) {
        if (millis == 1000) {
            secs++;
            millis = 0;
        }
        if (secs == 60) {
            mins++;
            secs = 0;
        }
        if (mins == 60) {
            hourrr++;
            mins = 0;
        }

        text.setText((((hourrr / 10) == 0) ? "0" : "") + hourrr + ":" + (((mins / 10) == 0) ? "0" : "") + mins + ":"
                + (((secs / 10) == 0) ? "0" : "") + secs + ":"
                + (((millis / 10) == 0) ? "00" : (((millis / 100) == 0) ? "0" : "")) + millis++);
    }

    ///////////////
    /////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
////////////////////////////////////////////////// change text Method
    int hourrr1 = 0, mins1 = 0, secs1 = 0, millis1 = 0;

    void change1(Text text) {
        if (millis1 == 1000) {
            secs1++;
            millis1 = 0;
        }
        if (secs1 == 60) {
            mins1++;
            secs1 = 0;
        }
        if (mins1 == 60) {
            hourrr1++;
            mins1 = 0;
        }

        text.setText((((hourrr1 / 10) == 0) ? "0" : "") + hourrr1 + ":" + (((mins1 / 10) == 0) ? "0" : "") + mins1 + ":"
                + (((secs1 / 10) == 0) ? "0" : "") + secs1 + ":"
                + (((millis1 / 10) == 0) ? "00" : (((millis1 / 100) == 0) ? "0" : "")) + millis1++);
    }

    ///////////////
    /////////////////
    ///////////////
    /////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
////////////////////////////////////////////////// change text Method
    int hourrr2 = 0, mins2 = 0, secs2 = 0, millis2 = 0;

    void change2(Text text) {
        if (millis2 == 1000) {
            secs2++;
            millis2 = 0;
        }
        if (secs2 == 60) {
            mins2++;
            secs2 = 0;
        }
        if (mins2 == 60) {
            hourrr2++;
            mins2 = 0;
        }

        text.setText((((hourrr2 / 10) == 0) ? "0" : "") + hourrr2 + ":" + (((mins2 / 10) == 0) ? "0" : "") + mins2 + ":"
                + (((secs2 / 10) == 0) ? "0" : "") + secs2 + ":"
                + (((millis2 / 10) == 0) ? "00" : (((millis2 / 100) == 0) ? "0" : "")) + millis2++);
    }

    ///////////////
    /////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
////////////////////////////////////////////////// change text Method
    int hourrr3 = 0, mins3 = 0, secs3 = 0, millis3 = 0;

    void change3(Text text) {
        if (millis3 == 1000) {
            secs3++;
            millis3 = 0;
        }
        if (secs3 == 60) {
            mins3++;
            secs3 = 0;
        }
        if (mins3 == 60) {
            hourrr3++;
            mins3 = 0;
        }

        text.setText((((hourrr3 / 10) == 0) ? "0" : "") + hourrr3 + ":" + (((mins3 / 10) == 0) ? "0" : "") + mins3 + ":"
                + (((secs3 / 10) == 0) ? "0" : "") + secs3 + ":"
                + (((millis3 / 10) == 0) ? "00" : (((millis3 / 100) == 0) ? "0" : "")) + millis3++);
    }

    ///////////////
    /////////////////
    /////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
////////////////////////////////////////////////// change text Method
    int hourrr4 = 0, mins4 = 0, secs4 = 0, millis4 = 0;

    void change4(Text text) {
        if (millis4 == 1000) {
            secs4++;
            millis4 = 0;
        }
        if (secs4 == 60) {
            mins4++;
            secs4 = 0;
        }
        if (mins4 == 60) {
            hourrr4++;
            mins4 = 0;
        }

        text.setText((((hourrr4 / 10) == 0) ? "0" : "") + hourrr4 + ":" + (((mins4 / 10) == 0) ? "0" : "") + mins4 + ":"
                + (((secs4 / 10) == 0) ? "0" : "") + secs4 + ":"
                + (((millis4 / 10) == 0) ? "00" : (((millis4 / 100) == 0) ? "0" : "")) + millis4++);
    }

    ///////////////
    /////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
////////////////////////////////////////////////// change text Method
    int hourrr5 = 0, mins5 = 0, secs5 = 0, millis5 = 0;

    void change5(Text text) {
        if (millis5 == 1000) {
            secs5++;
            millis5 = 0;
        }
        if (secs5 == 60) {
            mins5++;
            secs5 = 0;
        }
        if (mins5 == 60) {
            hourrr5++;
            mins5 = 0;
        }

        text.setText((((hourrr5 / 10) == 0) ? "0" : "") + hourrr5 + ":" + (((mins5 / 10) == 0) ? "0" : "") + mins5 + ":"
                + (((secs5 / 10) == 0) ? "0" : "") + secs5 + ":"
                + (((millis5 / 10) == 0) ? "00" : (((millis5 / 100) == 0) ? "0" : "")) + millis5++);
    }

    ///////////////
    /////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////
////////////////////////////////////////////////// change text Method
    int hourrr6 = 0, mins6 = 0, secs6 = 0, millis6 = 0;

    void change6(Text text) {
        if (millis6 == 1000) {
            secs6++;
            millis6 = 0;
        }
        if (secs6 == 60) {
            mins6++;
            secs6 = 0;
        }
        if (mins6 == 60) {
            hourrr6++;
            mins6 = 0;
        }

        text.setText((((hourrr6 / 10) == 0) ? "0" : "") + hourrr6 + ":" + (((mins6 / 10) == 0) ? "0" : "") + mins6 + ":"
                + (((secs6 / 10) == 0) ? "0" : "") + secs6 + ":"
                + (((millis6 / 10) == 0) ? "00" : (((millis6 / 100) == 0) ? "0" : "")) + millis6++);
    }

    ///////////////
    /////////////////
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        RestoreDataButton.setDisable(true);
        EditTitleButton.setDisable(true);

        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        //////////////////////////// start for ps3i
        Ps3iPriceTextField.setEditable(false);
        ps3iBaqy.setEditable(false);
        ps3iMatlob.setEditable(false);
        ps3iTextarea.setEditable(false);
        Ps3iDrinkPriceTextField.setEditable(false);
        //////////////////////////////
        //////////////////////////////

        /////////////////////////////////////////
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for timeline Ps3i
        timeline = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                change(ps3itext);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse(false);
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for images for ps3i
        Image pause = new Image("rsz_pause_50px.png");
        Image play = new Image("rsz_play_50px.png");
        Image reset = new Image("rsz_restart_50px.png");
        ImageView imgView = new ImageView(play);
        StartTimer.setGraphic(imgView);
        ImageView imgViewreset = new ImageView(reset);
        ResrtTimer.setGraphic(imgViewreset);
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        /////////////////////////////////////////////// Actions for ps3i

        StartTimer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (sos31) {

                    if (!(Ps3iStartTime.equals("null"))) {
                        timeline.play();
                        sos31 = false;

                        imgView.setImage(pause);
                        StartTimer.setGraphic(imgView);
                        ttab1.setStyle("-fx-text-base-color: red;");
                    } else {
                        alert.showErrorMessage("Attention", "Please Select type of order");

                    }

                } else {
                    timeline.pause();
                    sos31 = true;

                    imgView.setImage(play);
                    StartTimer.setGraphic(imgView);

                    String hourD = ps3itext.getText().substring(0, 2);
                    float hourfloat = Float.parseFloat(hourD);
                    String minusD = ps3itext.getText().substring(3, 5);
                    float minufloat = Float.parseFloat(minusD) / 60;
                    minufloat = (float) (Math.round(minufloat * 100.0) / 100.0);
                    float sum = hourfloat + minufloat;
                    Ps3iNumberTextField.setText(Float.toString(sum));

                }
            }

        });
        ResrtTimer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
                CreateNewUserAlert.setTitle("Confirmation dialog");
                CreateNewUserAlert.setContentText("Are you sure to reset time ?");
                CreateNewUserAlert.setHeaderText(null);

                Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    mins = 0;
                    secs = 0;
                    millis = 0;
                    hourrr = 0;
                    timeline.pause();
                    ps3itext.setText("00:00:00");

                    if (!sos31) {
                        sos31 = true;
                        imgView.setImage(play);
                        StartTimer.setGraphic(imgView);
                    }
                }
            }
        });
        ///////////////////////////////////
        ///////////////////////////////////
        /////////////////////////////////// end of ps3i
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        //////////////////////////// start for ps3ii
        Ps3iPriceTextField1.setEditable(false);
        ps3iBaqy1.setEditable(false);
        ps3iMatlob1.setEditable(false);
        ps3iTextarea1.setEditable(false);
        Ps3iDrinkPriceTextField1.setEditable(false);
        //////////////////////////////
        //////////////////////////////

        /////////////////////////////////////////
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for timeline Ps3ii
        timeline1 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                change1(ps3itext1);
            }
        }));
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.setAutoReverse(false);
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for images for ps3ii
        Image pause1 = new Image("rsz_pause_50px.png");
        Image play1 = new Image("rsz_play_50px.png");
        Image reset1 = new Image("rsz_restart_50px.png");
        ImageView imgView1 = new ImageView(play1);
        StartTimer1.setGraphic(imgView1);
        ImageView imgViewreset1 = new ImageView(reset1);
        ResrtTimer1.setGraphic(imgViewreset1);
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        /////////////////////////////////////////////// Actions for ps3ii
        StartTimer1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (sos32) {

                    if (!(Ps3iiStartTime.equals("null"))) {
                        timeline1.play();
                        sos32 = false;
                        // StartTimer.setText("Stop");
                        // StartTimer.setStyle("-fx-graphic:Replay_48px.png");
                        imgView1.setImage(pause1);
                        StartTimer1.setGraphic(imgView1);
                        ttab2.setStyle("-fx-text-base-color: red;");
                    } else {
                        alert.showErrorMessage("Attention", "Please Select type of order");
                    }
                } else {
                    timeline1.pause();
                    sos32 = true;
                    // StartTimer.setText("");
                    imgView1.setImage(play1);
                    StartTimer1.setGraphic(imgView1);
                    String hourD = ps3itext1.getText().substring(0, 2);
                    float hourfloat = Float.parseFloat(hourD);
                    String minusD = ps3itext1.getText().substring(3, 5);
                    float minufloat = Float.parseFloat(minusD) / 60;
                    minufloat = (float) (Math.round(minufloat * 100.0) / 100.0);
                    float sum = hourfloat + minufloat;
                    Ps3iNumberTextField1.setText(Float.toString(sum));

                }
            }
        });
        ResrtTimer1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
                CreateNewUserAlert.setTitle("Confirmation dialog");
                CreateNewUserAlert.setContentText("Are you sure to reset time ?");
                CreateNewUserAlert.setHeaderText(null);

                Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    mins1 = 0;
                    secs1 = 0;
                    millis1 = 0;
                    hourrr1 = 0;
                    timeline1.pause();
                    ps3itext1.setText("00:00:00");
                    if (!sos32) {
                        sos32 = true;
                        imgView1.setImage(play1);
                        StartTimer1.setGraphic(imgView1);
                    }
                }
            }
        });
        ///////////////////////////////////
        ///////////////////////////////////
        /////////////////////////////////// end of ps3ii
        //
        //
        //
        //
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        //////////////////////////// start for ps3iii
        Ps3iPriceTextField2.setEditable(false);
        ps3iBaqy2.setEditable(false);
        ps3iMatlob2.setEditable(false);
        ps3iTextarea2.setEditable(false);
        Ps3iDrinkPriceTextField2.setEditable(false);
        //////////////////////////////
        //////////////////////////////

        /////////////////////////////////////////
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for timeline Ps3iii
        timeline2 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                change2(ps3itext2);
            }
        }));
        timeline2.setCycleCount(Timeline.INDEFINITE);
        timeline2.setAutoReverse(false);
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for images for ps3iii
        Image pause2 = new Image("rsz_pause_50px.png");
        Image play2 = new Image("rsz_play_50px.png");
        Image reset2 = new Image("rsz_restart_50px.png");
        ImageView imgView2 = new ImageView(play2);
        StartTimer2.setGraphic(imgView2);
        ImageView imgViewreset2 = new ImageView(reset2);
        ResrtTimer2.setGraphic(imgViewreset2);
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        /////////////////////////////////////////////// Actions for ps3iii
        StartTimer2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (sos33) {
                    if (!(Ps3iiiStartTime.equals("null"))) {
                        timeline2.play();
                        sos33 = false;
                        // StartTimer.setText("Stop");
                        // StartTimer.setStyle("-fx-graphic:Replay_48px.png");
                        imgView2.setImage(pause2);
                        StartTimer2.setGraphic(imgView2);
                        ttab3.setStyle("-fx-text-base-color: red;");
                    } else {
                        alert.showErrorMessage("Attention", "Please Select type of order");
                    }
                } else {
                    timeline2.pause();
                    sos33 = true;
                    // StartTimer.setText("");
                    imgView2.setImage(play2);
                    StartTimer2.setGraphic(imgView2);
                    String hourD = ps3itext2.getText().substring(0, 2);
                    float hourfloat = Float.parseFloat(hourD);
                    String minusD = ps3itext2.getText().substring(3, 5);
                    float minufloat = Float.parseFloat(minusD) / 60;
                    minufloat = (float) (Math.round(minufloat * 100.0) / 100.0);
                    float sum = hourfloat + minufloat;
                    Ps3iNumberTextField2.setText(Float.toString(sum));

                }
            }
        });
        ResrtTimer2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
                CreateNewUserAlert.setTitle("Confirmation dialog");
                CreateNewUserAlert.setContentText("Are you sure to reset time ?");
                CreateNewUserAlert.setHeaderText(null);

                Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    mins2 = 0;
                    secs2 = 0;
                    millis2 = 0;
                    hourrr2 = 0;
                    timeline2.pause();
                    ps3itext2.setText("00:00:00");
                    if (!sos33) {
                        sos33 = true;
                        imgView2.setImage(play2);
                        StartTimer2.setGraphic(imgView2);
                    }
                }
            }
        });
        ///////////////////////////////////
        ///////////////////////////////////
        /////////////////////////////////// end of ps3iii
        //
        //
        //
        //
        //
        //
        //
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        //////////////////////////// start for ps3iv
        Ps3iPriceTextField3.setEditable(false);
        ps3iBaqy3.setEditable(false);
        ps3iMatlob3.setEditable(false);
        ps3iTextarea3.setEditable(false);
        Ps3iDrinkPriceTextField3.setEditable(false);
        //////////////////////////////
        //////////////////////////////

        /////////////////////////////////////////
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for timeline Ps3iv
        timeline3 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                change3(ps3itext3);
            }
        }));
        timeline3.setCycleCount(Timeline.INDEFINITE);
        timeline3.setAutoReverse(false);
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for images for ps3iv
        Image pause3 = new Image("rsz_pause_50px.png");
        Image play3 = new Image("rsz_play_50px.png");
        Image reset3 = new Image("rsz_restart_50px.png");
        ImageView imgView3 = new ImageView(play3);
        StartTimer3.setGraphic(imgView3);
        ImageView imgViewreset3 = new ImageView(reset3);
        ResrtTimer3.setGraphic(imgViewreset3);
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        /////////////////////////////////////////////// Actions for ps3iv
        StartTimer3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (sos34) {
                    if (!(Ps3ivStartTime.equals("null"))) {
                        timeline3.play();
                        sos34 = false;
                        // StartTimer.setText("Stop");
                        // StartTimer.setStyle("-fx-graphic:Replay_48px.png");
                        imgView3.setImage(pause3);
                        StartTimer3.setGraphic(imgView3);
                        ttab4.setStyle("-fx-text-base-color: red;");
                    } else {
                        alert.showErrorMessage("Attention", "Please Select type of order");
                    }
                } else {
                    timeline3.pause();
                    sos34 = true;
                    // StartTimer.setText("");
                    imgView3.setImage(play3);
                    StartTimer3.setGraphic(imgView3);
                    String hourD = ps3itext3.getText().substring(0, 2);
                    float hourfloat = Float.parseFloat(hourD);
                    String minusD = ps3itext3.getText().substring(3, 5);
                    float minufloat = Float.parseFloat(minusD) / 60;
                    minufloat = (float) (Math.round(minufloat * 100.0) / 100.0);
                    float sum = hourfloat + minufloat;
                    Ps3iNumberTextField3.setText(Float.toString(sum));

                }
            }
        });
        ResrtTimer3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
                CreateNewUserAlert.setTitle("Confirmation dialog");
                CreateNewUserAlert.setContentText("Are you sure to reset time ?");
                CreateNewUserAlert.setHeaderText(null);

                Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    mins3 = 0;
                    secs3 = 0;
                    millis3 = 0;
                    hourrr3 = 0;
                    timeline3.pause();
                    ps3itext3.setText("00:00:00");
                    if (!sos34) {
                        sos34 = true;
                        imgView3.setImage(play3);
                        StartTimer3.setGraphic(imgView3);
                    }
                }
            }
        });
        ///////////////////////////////////
        ///////////////////////////////////
        /////////////////////////////////// end of ps3iv
        //
        //
        //
        //
        //
        //
        //
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        //////////////////////////// start for ps3v
        Ps3iPriceTextField4.setEditable(false);
        ps3iBaqy4.setEditable(false);
        ps3iMatlob4.setEditable(false);
        ps3iTextarea4.setEditable(false);
        Ps3iDrinkPriceTextField4.setEditable(false);
        //////////////////////////////
        //////////////////////////////

        /////////////////////////////////////////
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for timeline Ps3v
        timeline4 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                change4(ps3itext4);
            }
        }));
        timeline4.setCycleCount(Timeline.INDEFINITE);
        timeline4.setAutoReverse(false);
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for images for ps3v
        Image pause4 = new Image("rsz_pause_50px.png");
        Image play4 = new Image("rsz_play_50px.png");
        Image reset4 = new Image("rsz_restart_50px.png");
        ImageView imgView4 = new ImageView(play4);
        StartTimer4.setGraphic(imgView4);
        ImageView imgViewreset4 = new ImageView(reset4);
        ResrtTimer4.setGraphic(imgViewreset4);
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        /////////////////////////////////////////////// Actions for ps3v
        StartTimer4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (sos35) {
                    if (!(Ps3vStartTime.equals("null"))) {
                        timeline4.play();
                        sos35 = false;
                        // StartTimer.setText("Stop");
                        // StartTimer.setStyle("-fx-graphic:Replay_48px.png");
                        imgView4.setImage(pause4);
                        StartTimer4.setGraphic(imgView4);
                        ttab5.setStyle("-fx-text-base-color: red;");
                    } else {
                        alert.showErrorMessage("Attention", "Please Select type of order");
                    }
                } else {
                    timeline4.pause();
                    sos35 = true;
                    // StartTimer.setText("");
                    imgView4.setImage(play4);
                    StartTimer4.setGraphic(imgView4);
                    String hourD = ps3itext4.getText().substring(0, 2);
                    float hourfloat = Float.parseFloat(hourD);
                    String minusD = ps3itext4.getText().substring(3, 5);
                    float minufloat = Float.parseFloat(minusD) / 60;
                    minufloat = (float) (Math.round(minufloat * 100.0) / 100.0);
                    float sum = hourfloat + minufloat;
                    Ps3iNumberTextField4.setText(Float.toString(sum));

                }
            }
        });
        ResrtTimer4.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
                CreateNewUserAlert.setTitle("Confirmation dialog");
                CreateNewUserAlert.setContentText("Are you sure to reset time ?");
                CreateNewUserAlert.setHeaderText(null);

                Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    mins4 = 0;
                    secs4 = 0;
                    millis4 = 0;
                    hourrr4 = 0;
                    timeline4.pause();
                    ps3itext4.setText("00:00:00");
                    if (!sos35) {
                        sos35 = true;
                        imgView4.setImage(play4);
                        StartTimer4.setGraphic(imgView4);
                    }
                }
            }
        });
        ///////////////////////////////////
        ///////////////////////////////////
        /////////////////////////////////// end of ps3v
        //
        //
        //
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        //////////////////////////// start for ps4i
        Ps3iPriceTextField5.setEditable(false);
        ps3iBaqy5.setEditable(false);
        ps3iMatlob5.setEditable(false);
        ps3iTextarea5.setEditable(false);
        Ps3iDrinkPriceTextField5.setEditable(false);
        //////////////////////////////
        //////////////////////////////

        /////////////////////////////////////////
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for timeline ps4i
        timeline5 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                change5(ps3itext5);
            }
        }));
        timeline5.setCycleCount(Timeline.INDEFINITE);
        timeline5.setAutoReverse(false);
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for images for ps4i
        Image pause5 = new Image("rsz_pause_50px.png");
        Image play5 = new Image("rsz_play_50px.png");
        Image reset5 = new Image("rsz_restart_50px.png");
        ImageView imgView5 = new ImageView(play5);
        StartTimer5.setGraphic(imgView5);
        ImageView imgViewreset5 = new ImageView(reset5);
        ResrtTimer5.setGraphic(imgViewreset5);
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        /////////////////////////////////////////////// Actions for ps3v
        StartTimer5.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (sos41) {
                    if (!(Ps4iStartTime.equals("null"))) {
                        timeline5.play();
                        sos41 = false;
                        // StartTimer.setText("Stop");
                        // StartTimer.setStyle("-fx-graphic:Replay_48px.png");
                        imgView5.setImage(pause5);
                        StartTimer5.setGraphic(imgView5);
                        ttab6.setStyle("-fx-text-base-color: red;");
                    } else {
                        alert.showErrorMessage("Attention", "Please Select type of order");
                    }
                } else {
                    timeline5.pause();
                    sos41 = true;
                    // StartTimer.setText("");
                    imgView5.setImage(play5);
                    StartTimer5.setGraphic(imgView5);
                    String hourD = ps3itext5.getText().substring(0, 2);
                    float hourfloat = Float.parseFloat(hourD);
                    String minusD = ps3itext5.getText().substring(3, 5);
                    float minufloat = Float.parseFloat(minusD) / 60;
                    minufloat = (float) (Math.round(minufloat * 100.0) / 100.0);
                    float sum = hourfloat + minufloat;
                    Ps3iNumberTextField5.setText(Float.toString(sum));

                }
            }
        });
        ResrtTimer5.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
                CreateNewUserAlert.setTitle("Confirmation dialog");
                CreateNewUserAlert.setContentText("Are you sure to reset time ?");
                CreateNewUserAlert.setHeaderText(null);

                Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    mins5 = 0;
                    secs5 = 0;
                    millis5 = 0;
                    hourrr5 = 0;
                    timeline5.pause();
                    ps3itext5.setText("00:00:00");
                    if (!sos41) {
                        sos41 = true;
                        imgView5.setImage(play5);
                        StartTimer5.setGraphic(imgView5);
                    }
                }
            }
        });
        ///////////////////////////////////
        ///////////////////////////////////
        /////////////////////////////////// end of ps4i
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        ////////////////////////////
        //////////////////////////// start for ps4ii
        Ps3iPriceTextField6.setEditable(false);
        ps3iBaqy6.setEditable(false);
        ps3iMatlob6.setEditable(false);
        ps3iTextarea6.setEditable(false);
        Ps3iDrinkPriceTextField6.setEditable(false);
        //////////////////////////////
        //////////////////////////////

        /////////////////////////////////////////
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for timeline ps4i
        timeline6 = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                change6(ps3itext6);
            }
        }));
        timeline6.setCycleCount(Timeline.INDEFINITE);
        timeline6.setAutoReverse(false);
        /////////////////////////////////////////
        /////////////////////////////////////////
        ///////////////////////////////////////// this for images for ps4i
        Image pause6 = new Image("rsz_pause_50px.png");
        Image play6 = new Image("rsz_play_50px.png");
        Image reset6 = new Image("rsz_restart_50px.png");
        ImageView imgView6 = new ImageView(play6);
        StartTimer6.setGraphic(imgView6);
        ImageView imgViewreset6 = new ImageView(reset6);
        ResrtTimer6.setGraphic(imgViewreset6);
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        /////////////////////////////////////////////// Actions for ps3v
        StartTimer6.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (sos42) {
                    if (!(Ps4iiStartTime.equals("null"))) {
                        timeline6.play();
                        sos42 = false;
                        // StartTimer.setText("Stop");
                        // StartTimer.setStyle("-fx-graphic:Replay_48px.png");
                        imgView6.setImage(pause6);
                        StartTimer6.setGraphic(imgView6);
                        ttab7.setStyle("-fx-text-base-color: red;");
                    } else {
                        alert.showErrorMessage("Attention", "Please Select type of order");
                    }
                } else {
                    timeline6.pause();
                    sos42 = true;
                    // StartTimer.setText("");
                    imgView6.setImage(play6);
                    StartTimer6.setGraphic(imgView6);
                    String hourD = ps3itext6.getText().substring(0, 2);
                    float hourfloat = Float.parseFloat(hourD);
                    String minusD = ps3itext6.getText().substring(3, 5);
                    float minufloat = Float.parseFloat(minusD) / 60;
                    minufloat = (float) (Math.round(minufloat * 100.0) / 100.0);
                    float sum = hourfloat + minufloat;
                    Ps3iNumberTextField6.setText(Float.toString(sum));

                }
            }
        });

        ResrtTimer6.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Alert CreateNewUserAlert = new Alert(Alert.AlertType.CONFIRMATION);
                CreateNewUserAlert.setTitle("Confirmation dialog");
                CreateNewUserAlert.setContentText("Are you sure to reset time ?");
                CreateNewUserAlert.setHeaderText(null);

                Optional<ButtonType> action = CreateNewUserAlert.showAndWait();
                if (action.get() == ButtonType.OK) {
                    mins6 = 0;
                    secs6 = 0;
                    millis6 = 0;
                    hourrr6 = 0;
                    timeline6.pause();
                    ps3itext6.setText("00:00:00");
                    if (!sos42) {
                        sos42 = true;
                        imgView6.setImage(play6);
                        StartTimer6.setGraphic(imgView6);
                    }
                }
            }
        });
        ///////////////////////////////////
        ///////////////////////////////////
        /////////////////////////////////// end of ps4i
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //
        //

        //
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////
        // TextFields.bindAutocomplete 
        //    TextFields.bindAutoCompletion(PreviousCashierName, UsersValuexs);
        ///////////////////////////////
        ///////////////////////////////
        ///////////////////////////////
        Ps3iNumberTextField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iNumberTextField.setText(newValue.replaceAll("[\\D]", "."));
            }
        });

        Ps3iDrinkNumberTextField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iDrinkNumberTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        ///////////////////////////////
        ///////////////////////////////
        ///////////////////////////////
        Ps3iNumberTextField1.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iNumberTextField1.setText(newValue.replaceAll("[\\D]", "."));
            }
        });

        Ps3iDrinkNumberTextField1.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iDrinkNumberTextField1.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        ///////////////////////////////
        ///////////////////////////////
        ///////////////////////////////
        Ps3iNumberTextField2.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iNumberTextField2.setText(newValue.replaceAll("[\\D]", "."));
            }
        });

        Ps3iDrinkNumberTextField2.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iDrinkNumberTextField2.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        ///////////////////////////////
        ///////////////////////////////
        ///////////////////////////////
        Ps3iNumberTextField3.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iNumberTextField3.setText(newValue.replaceAll("[\\D]", "."));
            }
        });

        Ps3iDrinkNumberTextField3.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iDrinkNumberTextField3.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        ///////////////////////////////
        ///////////////////////////////
        ///////////////////////////////
        Ps3iNumberTextField4.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iNumberTextField4.setText(newValue.replaceAll("[\\D]", "."));
            }
        });

        Ps3iDrinkNumberTextField4.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iDrinkNumberTextField4.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        ///////////////////////////////
        ///////////////////////////////
        ///////////////////////////////
        Ps3iNumberTextField5.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iNumberTextField5.setText(newValue.replaceAll("[\\D]", "."));
            }
        });

        Ps3iDrinkNumberTextField5.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iDrinkNumberTextField5.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        ///////////////////////////////
        ///////////////////////////////
        ///////////////////////////////
        Ps3iNumberTextField6.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iNumberTextField6.setText(newValue.replaceAll("[\\D]", "."));
            }
        });

        Ps3iDrinkNumberTextField6.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                Ps3iDrinkNumberTextField6.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        ////////////////////////////////////////////////////
        ////////////////////////////////////////////////////
        ////////////////////////////////////////////////////
        AnchorPanePassword.setOpacity(0);

        ps3iTextarea.setWrapText(false);

        ps3iTextarea.getText().replaceAll(" ", System.getProperty("."));
        // ps3iTextarea1.setText().replaceAll(" ", System.getProperty("line.separator"));
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/additionalpackage/add.fxml"));
            anchoooooor.getChildren().setAll(root);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            AnchorPane root = FXMLLoader.load(getClass().getResource("/aditionalpackage2/add.fxml"));
            anchoooooor1.getChildren().setAll(root);

        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } // this end of main's class

} // this for end of class
