package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */
public class TheLoai implements Serializable {
    private String IDTheLoai;
    private String TenTheLoai;

    public TheLoai(){

    }
    public TheLoai(String IDTheLoai,String TenTheLoai){
        this.setIDTheLoai(IDTheLoai);
        this.setTenTheLoai(TenTheLoai);
    }

    public String getIDTheLoai() {
        return IDTheLoai;
    }

    public void setIDTheLoai(String IDTheLoai) {
        this.IDTheLoai = IDTheLoai;
    }

    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        TenTheLoai = tenTheLoai;
    }
}