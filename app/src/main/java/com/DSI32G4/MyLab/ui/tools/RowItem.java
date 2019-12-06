package com.DSI32G4.MyLab.ui.tools;

public class RowItem {

    private String title;
    private int pin;
    private String local;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public RowItem(String title, int pin, String local){
        this.title=title;
        this.pin=pin;
        this.local=local;


    }
}
