package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class SachTheoTheLoai implements Serializable {
    private String TenTheLoai;
    private String MaTheLoai;
    private ArrayList<Sach> listSach;

    public SachTheoTheLoai( ){
    }
    public SachTheoTheLoai(String TenTheLoai,String MaTheLoai){
        this.setTenTheLoai(TenTheLoai);
        this.setMaTheLoai(MaTheLoai);
    }


    public String getTenTheLoai() {
        return TenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        TenTheLoai = tenTheLoai;
    }

    public String getMaTheLoai() {
        return MaTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        MaTheLoai = maTheLoai;
    }

    public ArrayList<Sach> getListSach() {
        return listSach;
    }

    public void setListSach(ArrayList<Sach> listSach) {
        this.listSach = listSach;
    }
}

