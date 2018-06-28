package com.example.hominhtung_pc.appbansach.Activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hominhtung_pc.appbansach.Adapter.SachAdapter;
import com.example.hominhtung_pc.appbansach.Object.Sach;
import com.example.hominhtung_pc.appbansach.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.hominhtung_pc.appbansach.Activity.DangNhapActivity.URL;
import static com.example.hominhtung_pc.appbansach.Activity.MainActivity.docNoiDung_Tu_URL;

public class LoaiSachActivity extends AppCompatActivity {

    private TextView txtTenTheLoai;

    //recyclerView
    private RecyclerView rcvListSach;
    private ArrayList<Sach> listSach = new ArrayList<>();
    private SachAdapter sachAdapter;

    String IDTheLoai;
    String TenTheLoai;

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loai_sach);

        ImageButton btn_QuayLai = (ImageButton) findViewById(R.id.btnQuayLai);
        btn_QuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle extraItem = getIntent().getExtras();

        txtTenTheLoai = (TextView) findViewById(R.id.txt_TenTheLoai_tl);
        TenTheLoai = extraItem.getString("TenTheLoai");
        txtTenTheLoai.setText(TenTheLoai);

        IDTheLoai = extraItem.getString("IDTheLoai");

        //khởi tạo RecycleView
        rcvListSach = (RecyclerView) findViewById(R.id.rcv_Sach_tl);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvListSach.setLayoutManager(layoutManager);

        sachAdapter = new SachAdapter(LoaiSachActivity.this,listSach);
        rcvListSach.setAdapter(sachAdapter);

        //Xử lí thread
        progressDialog = new ProgressDialog(this);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog = ProgressDialog.show(LoaiSachActivity.this, "",
                        "Đang kết nối...", true);
                new docSach().execute(URL+"/api/Sach/GetSachTheLoai/"+IDTheLoai);
            }
        });
    }

    public class docSach extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }
            try {
                JSONArray arrDM = new JSONArray(s);
                for(int i=0;i<arrDM.length();i++){
                    JSONObject jsonSach = arrDM.getJSONObject(i);
                    Sach sach = new Sach();
                    sach.setTenSach(jsonSach.getString("TenSach"));
                    sach.setHinhAnh(jsonSach.getString("HinhAnh"));
                    sach.setTriGia(Double.parseDouble(jsonSach.getString("TriGia")));
                    sach.setIDSach(jsonSach.getString("IDSach"));
                    sach.setIDTacGia(jsonSach.getString("IDTacGia"));
                    listSach.add(sach);
                }
                sachAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

}
