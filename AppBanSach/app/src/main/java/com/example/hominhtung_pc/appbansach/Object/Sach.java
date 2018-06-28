package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class Sach implements Serializable {
    private String IDSach;
    private String IDTheLoai;
    private String IDTacGia;
    private String IDNhaXuatBan;
    private String TenSach;
    private String HinhAnh;
    private int NamXuatBan;
    private int SoLuong;
    private int SoLuongTon;
    private double TriGia;
    private int TinhTrang;
    private String MoTa;

    public Sach(){

    }
    public Sach(String IDSach,String IDTheLoai,String IDTacGia,String IDNhaXuatBan,String TenSach,String HinhAnh,int NamXuatBan,int SoLuong,int SoLuongTon,double TriGia,int TinhTrang,String MoTa){
        this.IDSach =IDSach;
        this.IDTheLoai =IDTheLoai;
        this.IDTacGia =IDTacGia;
        this.IDNhaXuatBan =IDNhaXuatBan;
        this.TenSach =TenSach;
        this.HinhAnh =HinhAnh;
        this.NamXuatBan =NamXuatBan;
        this.SoLuong =SoLuong;
        this.SoLuongTon =SoLuongTon;
        this.TriGia =TriGia;
        this.TinhTrang =TinhTrang;
        this.MoTa =MoTa;
    }
    public String getIDSach() {
        return IDSach;
    }

    public void setIDSach(String IDSach) {
        this.IDSach = IDSach;
    }

    public String getIDTheLoai() {
        return IDTheLoai;
    }

    public void setIDTheLoai(String IDTheLoai) {
        this.IDTheLoai = IDTheLoai;
    }

    public String getIDTacGia() {
        return IDTacGia;
    }

    public void setIDTacGia(String IDTacGia) {
        this.IDTacGia = IDTacGia;
    }

    public String getIDNhaXuatBan() {
        return IDNhaXuatBan;
    }

    public void setIDNhaXuatBan(String IDNhaXuatBan) {
        this.IDNhaXuatBan = IDNhaXuatBan;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        HinhAnh = hinhAnh;
    }

    public int getNamXuatBan() {
        return NamXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        NamXuatBan = namXuatBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        SoLuongTon = soLuongTon;
    }

    public double getTriGia() {
        return TriGia;
    }

    public void setTriGia(double triGia) {
        TriGia = triGia;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }
}
