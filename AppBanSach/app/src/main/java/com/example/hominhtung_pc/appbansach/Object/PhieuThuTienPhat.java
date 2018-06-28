package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class PhieuThuTienPhat implements Serializable {
    private String IDPhieuThuTienPhat;
    private String IDDocGia;
    private String NgayThang;
    private double TienThu;

    public PhieuThuTienPhat(){

    }
    public PhieuThuTienPhat(String IDPhieuThuTienPhat,String IDDocGia,String NgayThang,double TienThu){
        this.setIDPhieuThuTienPhat(IDPhieuThuTienPhat);
        this.setIDDocGia(IDDocGia);
        this.setNgayThang(NgayThang);
        this.setTienThu(TienThu);
    }

    public String getIDPhieuThuTienPhat() {
        return IDPhieuThuTienPhat;
    }

    public void setIDPhieuThuTienPhat(String IDPhieuThuTienPhat) {
        this.IDPhieuThuTienPhat = IDPhieuThuTienPhat;
    }

    public String getIDDocGia() {
        return IDDocGia;
    }

    public void setIDDocGia(String IDDocGia) {
        this.IDDocGia = IDDocGia;
    }

    public String getNgayThang() {
        return NgayThang;
    }

    public void setNgayThang(String ngayThang) {
        NgayThang = ngayThang;
    }

    public double getTienThu() {
        return TienThu;
    }

    public void setTienThu(double tienThu) {
        TienThu = tienThu;
    }
}
