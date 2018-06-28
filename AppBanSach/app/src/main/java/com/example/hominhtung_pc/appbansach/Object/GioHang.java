package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;

/**
 * Created by HOMINHTUNG-PC on 11/23/2017.
 */

public class GioHang implements Serializable {
    private String STT;
    private String IDSach;
    private String IDDocGia;
    private String TenSach;
    private int SoLuongThue;
    private double TriGia;
    private String HinhAnh;


    public GioHang(){

    }
    public GioHang(String STT,String IDSach,String IDDocGia,int SoLuongThue,double TriGia, String HinhAnh, String TenSach){
        this.setSTT(STT);
        this.setIDSach(IDSach);
        this.setIDDocGia(IDDocGia);
        this.setSoLuongThue(SoLuongThue);
        this.setTriGia(TriGia);
        this.setHinhAnh(HinhAnh);
        this.setTenSach(TenSach);
    }

    public String getSTT() {
        return STT;
    }

    public void setSTT(String STT) {
        this.STT = STT;
    }

    public String getIDSach() {
        return IDSach;
    }

    public void setIDSach(String IDSach) {
        this.IDSach = IDSach;
    }

    public String getIDDocGia() {
        return IDDocGia;
    }

    public void setIDDocGia(String IDDocGia) {
        this.IDDocGia = IDDocGia;
    }

    public int getSoLuongThue() {
        return SoLuongThue;
    }

    public void setSoLuongThue(int soLuongThue) {
        SoLuongThue = soLuongThue;
    }

    public double getTriGia() {
        return TriGia;
    }

    public void setTriGia(double triGia) {
        TriGia = triGia;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public Double tongTien(){
        return  getTriGia()+getTriGia()*10/100 +10000;
    }
}
