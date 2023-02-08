/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreateNewUserPackage;

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
public class CreateNewUserClass {
    public  static  int CreateNewUserStagCount;
    
   public void CreateNewUserStageMethod() throws IOException {
        Parent CreateNewUserRoot = FXMLLoader.load(getClass().getResource("CreateNewUserFXML.fxml"));

        Scene CreateNewUserScene = new Scene(CreateNewUserRoot);
        Stage CreateNewUserStage = new Stage();

        CreateNewUserStage.setScene(CreateNewUserScene);
        CreateNewUserStage.setMaximized(false);
        CreateNewUserStage.setFullScreen(false);
        CreateNewUserStage.setMaxWidth(570);
        CreateNewUserStage.setMaxHeight(340);
        CreateNewUserStage.setMinWidth(570);
        CreateNewUserStage.setMinHeight(340);
        CreateNewUserStage.setResizable(false);

        CreateNewUserStage.setTitle("create new user");

        CreateNewUserStage.getIcons().add(new Image("user_group_new.png"));

        if (CreateNewUserStagCount == 0) {
            CreateNewUserStage.show();
            CreateNewUserStagCount++;
        }
    }  

    public  void setCreateNewUserStagCount(int CreateNewUserStagCount) {
        CreateNewUserClass.CreateNewUserStagCount = CreateNewUserStagCount;
    }
}
