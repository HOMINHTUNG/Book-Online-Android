package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class DocGia implements Serializable {
    private String IDDocGia;
    private String SoDienThoai;
    private String MatKhau;
    private String TenDocGia;
    private String DiaChi;
    private String Email;
    private String CMND;
    private String NgayLap;
    private String NgayHetHan;
    private String NgaySinh;
    private int TinhTrang;
    private double TongTienPhat;

    public DocGia(){

    }
    public DocGia(String IDDocGia,String SoDienThoai,String MatKhau,String TenDocGia,String DiaChi,String Email,String CMND,String NgayLap,String NgayHetHan,String NgaySinh,int TinhTrang,double TongTienPhat){
        this.setIDDocGia(IDDocGia);
        this.setSoDienThoai(SoDienThoai);
        this.setMatKhau(MatKhau);
        this.setTenDocGia(TenDocGia);
        this.setDiaChi(DiaChi);
        this.setEmail(Email);
        this.setCMND(CMND);
        this.setNgayLap(NgayLap);
        this.setNgayHetHan(NgayHetHan);
        this.setNgaySinh(NgaySinh);
        this.setTinhTrang(TinhTrang);
        this.setTongTienPhat(TongTienPhat);
    }

    public String getIDDocGia() {
        return IDDocGia;
    }

    public void setIDDocGia(String IDDocGia) {
        this.IDDocGia = IDDocGia;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getTenDocGia() {
        return TenDocGia;
    }

    public void setTenDocGia(String tenDocGia) {
        TenDocGia = tenDocGia;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String ngayLap) {
        NgayLap = ngayLap;
    }

    public String getNgayHetHan() {
        return NgayHetHan;
    }

    public void setNgayHetHan(String ngayHetHan) {
        NgayHetHan = ngayHetHan;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        TinhTrang = tinhTrang;
    }

    public double getTongTienPhat() {
        return TongTienPhat;
    }

    public void setTongTienPhat(double tongTienPhat) {
        TongTienPhat = tongTienPhat;
    }
}
