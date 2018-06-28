package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class PhieuNhapSach implements Serializable {
    private String IDPhieuNhapSach;
    private String IDNhanVien;
    private String NgayNhap;
    private int TongSoLuong;
    private double TongDongia;

    public PhieuNhapSach(){

    }
    public PhieuNhapSach(String IDPhieuNhapSach,String IDNhanVien,String NgayNhap,int TongSoLuong,double TongDongia){
        this.setIDPhieuNhapSach(IDPhieuNhapSach);
        this.setIDNhanVien(IDNhanVien);
        this.setNgayNhap(NgayNhap);
        this.setTongSoLuong(TongSoLuong);
        this.setTongDongia(TongDongia);
    }

    public String getIDPhieuNhapSach() {
        return IDPhieuNhapSach;
    }

    public void setIDPhieuNhapSach(String IDPhieuNhapSach) {
        this.IDPhieuNhapSach = IDPhieuNhapSach;
    }

    public String getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(String IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        NgayNhap = ngayNhap;
    }

    public int getTongSoLuong() {
        return TongSoLuong;
    }

    public void setTongSoLuong(int tongSoLuong) {
        TongSoLuong = tongSoLuong;
    }

    public double getTongDongia() {
        return TongDongia;
    }

    public void setTongDongia(double tongDongia) {
        TongDongia = tongDongia;
    }
}
