/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DevicesDatabasePackage;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Amir
 */
public class DevicesClass {
   
    private StringProperty NameProperty = new SimpleStringProperty();
    private StringProperty Name1Property = new SimpleStringProperty();
    private FloatProperty PriceProperty = new SimpleFloatProperty();
    private FloatProperty QuantityProperty = new SimpleFloatProperty();
    private FloatProperty CountProperty = new SimpleFloatProperty();
    private FloatProperty MatchProperty = new SimpleFloatProperty();

    public DevicesClass(String name,String name1, float price, float quantity, float count , float n) {

        this.NameProperty = new SimpleStringProperty(name);
        this.Name1Property = new SimpleStringProperty(name1);
        this.PriceProperty = new SimpleFloatProperty(price);
        this.QuantityProperty = new SimpleFloatProperty(quantity);
        this.CountProperty = new SimpleFloatProperty(count);
        this.MatchProperty = new SimpleFloatProperty(n);

    }

    public void setName1Property(StringProperty Name1Property) {
        this.Name1Property = Name1Property;
    }

    public String getName1Property() {
        return Name1Property.get();
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

    public void SetPrice(float price) {

        this.PriceProperty.set(price);
    }

    public float getPriceProperty() {
        return PriceProperty.get();
    }
    ///////////////////////////
    public float GetQuantity() {

        return QuantityProperty.get();
    }

    public void SetQuantity(float quantity) {

        this.QuantityProperty.set(quantity);
    }

    public float getQuantityProperty() {
        return QuantityProperty.get();
    }
    ///////////////////////////
    public float GetCount() {

        return CountProperty.get();
    }

    public void SetCount(float count) {

        this.CountProperty.set(count);
    }

    public float getCountProperty() {
        return CountProperty.get();
    }
    ///////////////////////////
    public float GetMatch() {

        return MatchProperty.get();
    }

    public void SetMatch(float count) {

        this.MatchProperty.set(count);
    }

    public float getMatchProperty() {
        return MatchProperty.get();
    }
 
}
