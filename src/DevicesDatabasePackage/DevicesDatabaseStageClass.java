/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DevicesDatabasePackage;

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
public class DevicesDatabaseStageClass {

    Stage DrinksDatabaseStage = new Stage();

    public void DrinksDatabaseStageMethod() throws IOException {
        Parent DrinksRoot = FXMLLoader.load(getClass().getResource("DevicesDatabaseFXML.fxml"));

        Scene DrinksScene = new Scene(DrinksRoot);
        // AdminPasswordStage.initStyle(StageStyle.TRANSPARENT);
        DrinksDatabaseStage.setScene(DrinksScene);
        DrinksDatabaseStage.setMaximized(false);
        DrinksDatabaseStage.setFullScreen(false);
     //  UsersDatabaseStage.setMaxWidth(449);
        //  UsersDatabaseStage.setMaxHeight(310);
        //  UsersDatabaseStage.setMinWidth(449);
        //  UsersDatabaseStage.setMinHeight(310);
        DrinksDatabaseStage.setResizable(false);

        DrinksDatabaseStage.setTitle("Devices");

        DrinksDatabaseStage.getIcons().add(new Image("game-console.png"));

        DrinksDatabaseStage.show();

    }
}
