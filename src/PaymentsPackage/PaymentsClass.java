/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaymentsPackage;


/**
 *
 * @author Amir
 */
public class PaymentsClass {
    String number , cashier , price , tablee , date , time;

   public PaymentsClass(String number, String cashier, String price, String tablee, String date, String time) {
        this.number = number;
        this.cashier = cashier;
        this.price = price;
        this.tablee = tablee;
        this.date = date;
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public String getCashier() {
        return cashier;
    }

    public String getPrice() {
        return price;
    }

    public String getTablee() {
        return tablee;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setTablee(String tablee) {
        this.tablee = tablee;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }
    
}
