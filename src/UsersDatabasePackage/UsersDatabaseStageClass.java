/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsersDatabasePackage;

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
public class UsersDatabaseStageClass {

    public static int AdminStageCount = 0;

    public static void setAdminStageCount(int AdminStageCount) {
        UsersDatabaseStageClass.AdminStageCount = AdminStageCount;
    }

    Stage UsersDatabaseStage = new Stage();

    public void UsersDatabaseStageMethod() throws IOException {
        Parent AdminPasswordRoot = FXMLLoader.load(getClass().getResource("UsersDatabaseFXML.fxml"));

        Scene AdminPasswordScene = new Scene(AdminPasswordRoot);
        UsersDatabaseStage.setScene(AdminPasswordScene);
        UsersDatabaseStage.setMaximized(false);
        UsersDatabaseStage.setFullScreen(false);
        UsersDatabaseStage.setResizable(false);
        UsersDatabaseStage.setTitle("Users");
        UsersDatabaseStage.getIcons().add(new Image("User-Database-512.png"));
        if (AdminStageCount == 0) {
            UsersDatabaseStage.show();
            AdminStageCount++;
        }
    }

}
