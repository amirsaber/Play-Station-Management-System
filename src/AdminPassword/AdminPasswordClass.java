/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminPassword;

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
public class AdminPasswordClass {
    
    public static int AdminStageCount = 0;
    
    Stage AdminPasswordStage = new Stage();
    
    public void AdminPasswordStageMethod() throws IOException {
        Parent AdminPasswordRoot = FXMLLoader.load(getClass().getResource("AdminPasswordFXML.fxml"));
        
        Scene AdminPasswordScene = new Scene(AdminPasswordRoot);
        // AdminPasswordStage.initStyle(StageStyle.TRANSPARENT);
        AdminPasswordStage.setScene(AdminPasswordScene);
        AdminPasswordStage.setMaximized(false);
        AdminPasswordStage.setFullScreen(false);
        AdminPasswordStage.setMaxWidth(449);
        AdminPasswordStage.setMaxHeight(310);
        AdminPasswordStage.setMinWidth(449);
        AdminPasswordStage.setMinHeight(310);
        AdminPasswordStage.setResizable(false);
        AdminPasswordStage.setTitle("Check");
        
        AdminPasswordStage.getIcons().add(new Image("2288-200.png"));
        
        if (AdminStageCount == 0) {
            AdminPasswordStage.show();
            AdminStageCount++;
        }
    }

    public void AdminStageClose() {
        AdminPasswordStage.close();
        
    }
    
    public void setAdminStageCount(int AdminStageCount) {
        AdminPasswordClass.AdminStageCount = AdminStageCount;
    }
    
}
