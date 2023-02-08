/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package additionalpackage;

import java.io.IOException;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Amir
 */
public class AdditionalClass {

    public static int AdminStageCount = 0;

    Stage UsersDatabaseStage = new Stage();

    public void UsersDatabaseStageMethod() throws IOException {
        Parent AdminPasswordRoot = FXMLLoader.load(getClass().getResource("add.fxml"));

        Scene AdminPasswordScene = new Scene(AdminPasswordRoot);

        // AdminPasswordStage.initStyle(StageStyle.TRANSPARENT);
        UsersDatabaseStage.setScene(AdminPasswordScene);
        UsersDatabaseStage.setMaximized(true);
        UsersDatabaseStage.setFullScreen(false);
        //  UsersDatabaseStage.setMaxWidth(449);
        //  UsersDatabaseStage.setMaxHeight(310);
        /*   JFrame frame = new JFrame();*/
        //  frame.setUndecorated(true);
        //   frame.setBackground(new java.awt.Color(0, 0, 0, 0));
        /*    final JFXPanel fxPanel = new JFXPanel();
        frame.add(fxPanel);
        frame.setSize(1366, 768);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        fxPanel.setScene(AdminPasswordScene);
        frame.setResizable(false);
        frame.setAlwaysOnTop(true);
        frame.setFocusableWindowState(false); // <- Here is the secret
        frame.setTitle("Additional Devices");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setVisible(true);*/
        UsersDatabaseStage.setMinWidth(1366);
        UsersDatabaseStage.setMinHeight(768);
        UsersDatabaseStage.setX(0);
        UsersDatabaseStage.setY(0);
        UsersDatabaseStage.setMaximized(true);
        UsersDatabaseStage.setTitle("Additional Devices");

        UsersDatabaseStage.getIcons().add(new Image("addsssssssssssss.png"));
      //  UsersDatabaseStage.setFocused(false);
    //   UsersDatabaseStage.setFullScreen(true);

        UsersDatabaseStage.show();
      //  UsersDatabaseStage.setIconified(true);
       // UsersDatabaseStage.setm
     //   Alert a = new Alert(Alert.AlertType.INFORMATION);
     //   a.setContentText("new devices");
    //    a.setHeaderText(null);
    //    a.showAndWait();
        
        
        
        

    }

    public void closestage() {

        UsersDatabaseStage.close();

    }
    public void MinimizeStage() {

     //   this.UsersDatabaseStage.setIconified(true);

    
    
    }

}
