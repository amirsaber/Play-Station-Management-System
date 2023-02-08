/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrdersPackage;

/**
 *
 * @author Amir
 */
public class OrdersEditClass {
    String number , cashier ,price , details , starttime , endtime;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public OrdersEditClass(String number, String cashier, String price, String details, String starttime, String endtime) {
        this.number = number;
        this.cashier = cashier;
        this.price = price;
        this.details = details;
        this.starttime = starttime;
        this.endtime = endtime;
    }
}
