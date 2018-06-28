package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class NhaXuatBan implements Serializable {
    private String IDNhaXuatBan;
    private String TenNhaXuatBan;

    public NhaXuatBan(){

    }
    public NhaXuatBan(String IDNhaXuatBan,String TenNhaXuatBan){
        this.setIDNhaXuatBan(IDNhaXuatBan);
        this.setTenNhaXuatBan(TenNhaXuatBan);
    }

    public String getIDNhaXuatBan() {
        return IDNhaXuatBan;
    }

    public void setIDNhaXuatBan(String IDNhaXuatBan) {
        this.IDNhaXuatBan = IDNhaXuatBan;
    }

    public String getTenNhaXuatBan() {
        return TenNhaXuatBan;
    }

    public void setTenNhaXuatBan(String tenNhaXuatBan) {
        TenNhaXuatBan = tenNhaXuatBan;
    }
}