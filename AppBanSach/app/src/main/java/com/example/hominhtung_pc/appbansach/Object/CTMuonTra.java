package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class CTMuonTra implements Serializable {
    private String STT;
    private String IDSach;
    private String IDDocGia;
    private String NgayMuon;
    private String NgayTraQuyDinh;
    private String NgayTraThucTe;
    private int NgayQuaHan;
    private int TinhTrangMuon;
    private int SoLuongThue;
    private double TriGia;
    private double TienCoc;
    private double TienThue;
    private double TienPhat;
    private double TongTien;

    public CTMuonTra(){

    }
    public CTMuonTra(String STT,String IDSach,String IDDocGia,String NgayMuon,String NgayTraQuyDinh,String NgayTraThucTe,int NgayQuaHan,int TinhTrangMuon,int SoLuongThue,double TriGia,double TienCoc,double TienThue,double TienPhat,double TongTien){
        this.setSTT(STT);
        this.setIDSach(IDSach);
        this.setIDDocGia(IDDocGia);
        this.setNgayMuon(NgayMuon);
        this.setNgayTraQuyDinh(NgayTraQuyDinh);
        this.setNgayTraThucTe(NgayTraThucTe);
        this.setNgayQuaHan(NgayQuaHan);
        this.setTinhTrangMuon(TinhTrangMuon);
        this.setSoLuongThue(SoLuongThue);
        this.setTriGia(TriGia);
        this.setTienCoc(TienCoc);
        this.setTienThue(TienThue);
        this.setTienPhat(TienPhat);
        this.setTongTien(TongTien);
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

    public String getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(String ngayMuon) {
        NgayMuon = ngayMuon;
    }

    public String getNgayTraQuyDinh() {
        return NgayTraQuyDinh;
    }

    public void setNgayTraQuyDinh(String ngayTraQuyDinh) {
        NgayTraQuyDinh = ngayTraQuyDinh;
    }

    public String getNgayTraThucTe() {
        return NgayTraThucTe;
    }

    public void setNgayTraThucTe(String ngayTraThucTe) {
        NgayTraThucTe = ngayTraThucTe;
    }

    public int getNgayQuaHan() {
        return NgayQuaHan;
    }

    public void setNgayQuaHan(int ngayQuaHan) {
        NgayQuaHan = ngayQuaHan;
    }

    public int getTinhTrangMuon() {
        return TinhTrangMuon;
    }

    public void setTinhTrangMuon(int tinhTrangMuon) {
        TinhTrangMuon = tinhTrangMuon;
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

    public double getTienCoc() {
        return TienCoc;
    }

    public void setTienCoc(double tienCoc) {
        TienCoc = tienCoc;
    }

    public double getTienThue() {
        return TienThue;
    }

    public void setTienThue(double tienThue) {
        TienThue = tienThue;
    }

    public double getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(double tienPhat) {
        TienPhat = tienPhat;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double tongTien) {
        TongTien = tongTien;
    }
}
