/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HistoryPackage;

/**
 *
 * @author Amir
 */
public class HistoryClass {
      String process , number , price , tablee ,cashier , date , time;

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTablee() {
        return tablee;
    }

    public void setTablee(String tablee) {
        this.tablee = tablee;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public HistoryClass(String process, String number, String price, String tablee, String cashier, String date, String time) {
        this.process = process;
        this.number = number;
        this.price = price;
        this.tablee = tablee;
        this.cashier = cashier;
        this.date = date;
        this.time = time;
    }
}
