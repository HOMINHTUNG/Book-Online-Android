package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class TacGia implements Serializable {
    private String IDTacGia;
    private String TenTacGia;

    public TacGia(){

    }
    public TacGia(String IDTacGia,String TenTacGia){
        this.IDTacGia=IDTacGia;
        this.TenTacGia=TenTacGia;
    }
    public String getIDTacGia() {
        return IDTacGia;
    }

    public void setIDTacGia(String IDTacGia) {
        this.IDTacGia = IDTacGia;
    }

    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        TenTacGia = tenTacGia;
    }
}