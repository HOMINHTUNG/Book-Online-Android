package com.example.hominhtung_pc.appbansach.Activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.hominhtung_pc.appbansach.Adapter.GioHangAdapter;
import com.example.hominhtung_pc.appbansach.Object.CTMuonTra;
import com.example.hominhtung_pc.appbansach.Object.GioHang;
import com.example.hominhtung_pc.appbansach.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.example.hominhtung_pc.appbansach.Activity.DangNhapActivity.SESSION_LOGIN;
import static com.example.hominhtung_pc.appbansach.Activity.DangNhapActivity.URL;
import static com.example.hominhtung_pc.appbansach.Activity.DetailSachActivity.SESSION_GIOHANG;

public class GioHangActivity extends AppCompatActivity {

    private TextView btnThanhToan;
    private TextView txtThongBao;

    private RecyclerView rcvListSach;
    private ArrayList<GioHang> listSach = new ArrayList<>();
    public static GioHangAdapter gioHangAdapter;
    ProgressDialog progressDialog;

    private ArrayList<CTMuonTra> listCTMuon = new ArrayList<>();
    Dialog dialog;

    private String urlDatSach = URL+"/api/CTMuonTra/PostCTMuonTra";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang);

        ImageButton btn_QuayLai = (ImageButton) findViewById(R.id.btnQuayLai);
        btn_QuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnThanhToan = (TextView) findViewById(R.id.btn_ThanhToan_gh);


        txtThongBao = (TextView) findViewById(R.id.txt_ThongBao_gd);
        if(SESSION_GIOHANG.size()==0) {
            txtThongBao.setText("Quẹo lựa sách đi :)!!!!");
        }
        else{
            btnThanhToan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(SESSION_GIOHANG.size()==0) {
                        txtThongBao.setText("Quẹo lựa sách đi :)!!!!");
                    }
                    else {
                        //Chuyển đổi list chi tiết mượn
                        double tongTien =0;
                        int SLSach =0;
                        for (int i=0;i<SESSION_GIOHANG.size();i++){
                            tongTien+=SESSION_GIOHANG.get(i).tongTien();
                            SLSach+=SESSION_GIOHANG.get(i).getSoLuongThue();
                        }

                        //Alert dialog
                        final AlertDialog.Builder builder = new AlertDialog.Builder(GioHangActivity.this);

                        LayoutInflater inflater = getLayoutInflater();
                        View dialogView = inflater.inflate(R.layout.layout_dialog_thongbao, null);
                        builder.setView(dialogView);

                        builder.setTitle("Thanh toán");

                        TextView TenDocGia = (TextView) dialogView.findViewById(R.id.txt_TenDocGia_dialog);
                        TextView TongTien = (TextView) dialogView.findViewById(R.id.txt_TongTien_dialog);
                        TextView SoLuong = (TextView) dialogView.findViewById(R.id.txt_SLSach_dialog);

                        TenDocGia.setText(SESSION_LOGIN.getTenDocGia());
                        TongTien.setText(String.valueOf(tongTien)+"₫");
                        SoLuong.setText(String.valueOf(SLSach)+" Sách");

                        builder.setCancelable(true);

                        final double finalTongTien = tongTien;
                        builder.setPositiveButton(
                                "Thanh toán ngay",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        //        dialog.cancel();
                                        Intent intent = new Intent(GioHangActivity.this, ThanhToanActivity.class);
                                        intent.putExtra("TongTien", String.valueOf(finalTongTien)+"₫");
                                        startActivity(intent);
                                    }
                                });


                        builder.setNegativeButton(
                                "Đặt sách",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                        for (int i = 0;i<SESSION_GIOHANG.size();i++){
                                            requestQueue = Volley.newRequestQueue(getApplicationContext());
                                            final String IDSach=SESSION_GIOHANG.get(i).getIDSach();
                                            final String IDDocGia=SESSION_GIOHANG.get(i).getIDDocGia();

                                            StringRequest request = new StringRequest(Request.Method.POST, urlDatSach, new Response.Listener<String>() {
                                                @Override
                                                public void onResponse(String response) {

                                                }
                                            }, new Response.ErrorListener() {
                                                @Override
                                                public void onErrorResponse(VolleyError error) {

                                                }

                                            }) {

                                                @Override
                                                protected Map<String, String> getParams() throws AuthFailureError {
                                                    Map<String,String> parameters  = new HashMap<String, String>();
                                                    parameters.put("STT", "a");
                                                    parameters.put("IDSach",IDSach);
                                                    parameters.put("IDDocGia",IDDocGia);
                                                    parameters.put("NgayMuon","2017-11-22T13:25:43.707");
                                                    parameters.put("NgayTraQuyDinh","2017-11-22T13:25:43.707");
                                                    parameters.put("NgayTraThucTe","2017-11-22T13:25:43.707");
                                                    parameters.put("NgayQuaHan","2");
                                                    parameters.put("TinhTrangMuon","0");
                                                    parameters.put("SoLuongThue","1");
                                                    parameters.put("TriGia","1");
                                                    parameters.put("TienCoc","1");
                                                    parameters.put("TienThue","1");
                                                    parameters.put("TienPhat","1");
                                                    parameters.put("TongTien","1");
                                                    return parameters;
                                                }
                                            };

                                            requestQueue.add(request);
                                        }

                                        Intent intent = new Intent(GioHangActivity.this, MainActivity.class);
                                        SESSION_GIOHANG.removeAll(SESSION_GIOHANG);
                                        startActivity(intent);
                                        Toast.makeText(getApplicationContext(),"Đặt sách thành công, hãy kiểm tra hoạt động!",Toast.LENGTH_LONG).show();

                                    }
                                });

                        AlertDialog alert = builder.create();
                        alert.show();
                    }

                }
            });

        }




        rcvListSach = (RecyclerView) findViewById(R.id.rcv_CTMuon_gh);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvListSach.setLayoutManager(layoutManager);

        gioHangAdapter = new GioHangAdapter(GioHangActivity.this,SESSION_GIOHANG);
        rcvListSach.setAdapter(gioHangAdapter);
    }
}
