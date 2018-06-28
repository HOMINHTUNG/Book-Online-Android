package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class NhanVien implements Serializable {
    private String IDNhanVien;
    private String IDChucVu;
    private String TenNhanVien;
    private int GioiTinh;
    private String DiaChi;
    private String SoDienThoai;
    private String Email;
    private String CMND;
    private String NgayVaoLam;
    private String MatKhau;


    public NhanVien(){

    }
    public NhanVien(String IDNhanVien,String IDChucVu,String TenNhanVien,int GioiTinh,String DiaChi,String SoDienThoai,String Email,String CMND,String NgayVaoLam,String MatKhau){
        this.setIDNhanVien(IDNhanVien);
        this.setIDChucVu(IDChucVu);
        this.setTenNhanVien(TenNhanVien);
        this.setGioiTinh(GioiTinh);
        this.setDiaChi(DiaChi);
        this.setSoDienThoai(SoDienThoai);
        this.setEmail(Email);
        this.setCMND(CMND);
        this.setNgayVaoLam(NgayVaoLam);
        this.setMatKhau(MatKhau);
    }

    public String getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(String IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public String getIDChucVu() {
        return IDChucVu;
    }

    public void setIDChucVu(String IDChucVu) {
        this.IDChucVu = IDChucVu;
    }

    public String getTenNhanVien() {
        return TenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        TenNhanVien = tenNhanVien;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        SoDienThoai = soDienThoai;
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

    public String getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(String ngayVaoLam) {
        NgayVaoLam = ngayVaoLam;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }
}
