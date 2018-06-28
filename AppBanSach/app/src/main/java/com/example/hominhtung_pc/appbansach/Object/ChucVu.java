package com.example.hominhtung_pc.appbansach.Object;

import java.io.Serializable;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class ChucVu  implements Serializable {
    private String IDChucVu;
    private String TenChucVu;

    public ChucVu(){

    }
    public ChucVu(String IDChucVu,String TenChucVu){
        this.setIDChucVu(IDChucVu);
        this.setTenChucVu(TenChucVu);
    }


    public String getIDChucVu() {
        return IDChucVu;
    }

    public void setIDChucVu(String IDChucVu) {
        this.IDChucVu = IDChucVu;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        TenChucVu = tenChucVu;
    }
}
