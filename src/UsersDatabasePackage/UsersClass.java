/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UsersDatabasePackage;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Amir
 */
public class UsersClass {

    private StringProperty UserNameProperty = new SimpleStringProperty();
    private StringProperty PasswordProperty = new SimpleStringProperty();
    private StringProperty DetailsProperty = new SimpleStringProperty();
    private FloatProperty AmountProperty = new SimpleFloatProperty();

    public UsersClass(String username, String password, float amount, String details) {

        this.UserNameProperty = new SimpleStringProperty(username);
        this.PasswordProperty = new SimpleStringProperty(password);
        this.AmountProperty = new SimpleFloatProperty(amount);
        this.DetailsProperty = new SimpleStringProperty(details);

    }

    ///////////////////////////
    public float GetAmount() {

        return AmountProperty.get();
    }

    public void SetAmount(float amount) {

        this.AmountProperty.set(amount);
    }

    public float getAmountProperty() {
        return AmountProperty.get();
    }

    ///////////////////////////

    public String GetUserName() {

        return UserNameProperty.get();
    }

    public void SetUserName(String username) {

        this.UserNameProperty.set(username);
    }

    public String getUserNameProperty() {
        return UserNameProperty.get();
    }

    ///////////////////////////

    public String GetPassword() {

        return PasswordProperty.get();
    }

    public void SetPassword(String password) {

        this.PasswordProperty.set(password);
    }

    public String getPasswordProperty() {
        return PasswordProperty.get();
    }

    ///////////////////////////

    public String GetDetails() {

        return DetailsProperty.get();
    }

    public void SetDetails(String details) {

        this.DetailsProperty.set(details);
    }

    public String getDetailsProperty() {
        return DetailsProperty.get();
    }

}
