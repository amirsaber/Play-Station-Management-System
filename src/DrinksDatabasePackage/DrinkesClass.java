/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DrinksDatabasePackage;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Amir
 */
public class DrinkesClass {

    private StringProperty NameProperty = new SimpleStringProperty();
    private FloatProperty PriceProperty = new SimpleFloatProperty();
    private IntegerProperty QuantityProperty = new SimpleIntegerProperty();
    private IntegerProperty CountProperty = new SimpleIntegerProperty();

    public DrinkesClass(String name, float price, int quantity, int count) {

        this.NameProperty = new SimpleStringProperty(name);
        this.PriceProperty = new SimpleFloatProperty(price);
        this.QuantityProperty = new SimpleIntegerProperty(quantity);
        this.CountProperty = new SimpleIntegerProperty(count);

    }
///////////////////////////
    public String GetName() {

        return NameProperty.get();
    }

    public void SetName(String name) {

        this.NameProperty.set(name);
    }

    public String getNameProperty() {
        return NameProperty.get();
    }
    ///////////////////////////
    public float GetPrice() {

        return PriceProperty.get();
    }

    public void SetPrice(int price) {

        this.PriceProperty.set(price);
    }

    public float getPriceProperty() {
        return PriceProperty.get();
    }
    ///////////////////////////
    public int GetQuantity() {

        return QuantityProperty.get();
    }

    public void SetQuantity(int quantity) {

        this.QuantityProperty.set(quantity);
    }

    public int getQuantityProperty() {
        return QuantityProperty.get();
    }
    ///////////////////////////
    public int GetCount() {

        return CountProperty.get();
    }

    public void SetCount(int count) {

        this.CountProperty.set(count);
    }

    public int getCountProperty() {
        return CountProperty.get();
    }

    


}
