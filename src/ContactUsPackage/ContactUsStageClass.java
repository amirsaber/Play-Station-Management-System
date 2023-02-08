/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ContactUsPackage;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Amir
 */
public class ContactUsStageClass {
    
    Stage ContactUsStage = new Stage();
    
    public void DrinksDatabaseStageMethod() throws IOException {
        Parent ContactUsRoot = FXMLLoader.load(getClass().getResource("ContactUsFXML.fxml"));
        
        Scene ContactUsScene = new Scene(ContactUsRoot);
        ContactUsStage.setScene(ContactUsScene);
        ContactUsStage.setMaximized(false);
        ContactUsStage.setFullScreen(false);
        ContactUsStage.setResizable(false);
        ContactUsStage.setTitle("Contact Us");
        
        ContactUsStage.getIcons().add(new Image("contact.png"));
        ContactUsStage.setMinWidth(800);
        ContactUsStage.setMinHeight(600);
        ContactUsStage.show();
        
    }
}
