package com.example.hominhtung_pc.appbansach.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hominhtung_pc.appbansach.R;

import static com.example.hominhtung_pc.appbansach.Activity.DangNhapActivity.SESSION_LOGIN;

public class CaNhanActivity extends AppCompatActivity {


    private Button btnSuaThongTin;
    private Button btnDoiMatKhau;

    private TextView txtTenDocGia;
    private TextView txtSoDienThoai;
    private TextView txtEmail;
    private TextView txtNgaySinh;
    private TextView txtNgayLap;
    private TextView txtNgayHetHan;
    private TextView txtTongTienPhat;
    private TextView txtTinhTrang;
    private TextView txtDiaChi;

    private ImageView imgHinhAnh;
    String HinhAnh="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ca_nhan);

        ImageButton btn_QuayLai = (ImageButton) findViewById(R.id.btnQuayLai);
        btn_QuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txtTenDocGia = (TextView) findViewById(R.id.txt_TenDocGia_cn);
        txtTenDocGia.setText(SESSION_LOGIN.getTenDocGia());

        txtSoDienThoai = (TextView) findViewById(R.id.txt_SoDienThoai_cn);
        txtSoDienThoai.setText(SESSION_LOGIN.getSoDienThoai());

        txtEmail = (TextView) findViewById(R.id.txt_Email_cn);
        txtEmail.setText(SESSION_LOGIN.getEmail());

        txtNgaySinh = (TextView) findViewById(R.id.txt_NgaySinh_cn);
        txtNgaySinh.setText(SESSION_LOGIN.getNgaySinh());

        txtNgayLap = (TextView) findViewById(R.id.txt_NgayLap_cn);
        txtNgayLap.setText(SESSION_LOGIN.getNgayLap());

        txtNgayHetHan = (TextView) findViewById(R.id.txt_NgayHetHan_cn);
        txtNgayHetHan.setText(SESSION_LOGIN.getNgayHetHan());

        txtTongTienPhat = (TextView) findViewById(R.id.txt_TongTienPhat_cn);
        txtTongTienPhat.setText(String.valueOf(SESSION_LOGIN.getTongTienPhat()));

        txtTinhTrang = (TextView) findViewById(R.id.txt_TinhTrang_cn);
        txtTinhTrang.setText(String.valueOf(SESSION_LOGIN.getTinhTrang()));

        txtDiaChi = (TextView) findViewById(R.id.txt_DiaChi_cn);
        txtDiaChi.setText(SESSION_LOGIN.getDiaChi());

    }
}
