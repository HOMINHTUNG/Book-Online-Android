package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class ChiTietPhieuNhapSach implements Serializable {
    private String IDPhieuNhapSach;
    private String IDSach;
    private int SoLuong;
    private double DonGia;

    public ChiTietPhieuNhapSach(){

    }
    public ChiTietPhieuNhapSach(String IDPhieuNhapSach,String IDSach,int SoLuong,double DonGia){
        this.setIDPhieuNhapSach(IDPhieuNhapSach);
        this.setIDSach(IDSach);
        this.setSoLuong(SoLuong);
        this.setDonGia(DonGia);
    }

    public String getIDPhieuNhapSach() {
        return IDPhieuNhapSach;
    }

    public void setIDPhieuNhapSach(String IDPhieuNhapSach) {
        this.IDPhieuNhapSach = IDPhieuNhapSach;
    }

    public String getIDSach() {
        return IDSach;
    }

    public void setIDSach(String IDSach) {
        this.IDSach = IDSach;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public double getDonGia() {
        return DonGia;
    }

    public void setDonGia(double donGia) {
        DonGia = donGia;
    }
}
