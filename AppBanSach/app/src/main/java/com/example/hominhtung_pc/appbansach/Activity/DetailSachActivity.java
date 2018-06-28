package com.example.hominhtung_pc.appbansach.Activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hominhtung_pc.appbansach.Object.GioHang;
import com.example.hominhtung_pc.appbansach.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.hominhtung_pc.appbansach.Activity.DangNhapActivity.SESSION_LOGIN;
import static com.example.hominhtung_pc.appbansach.Activity.DangNhapActivity.URL;
import static com.example.hominhtung_pc.appbansach.Activity.HoatDongActivity.listSachDatCoc;
import static com.example.hominhtung_pc.appbansach.Activity.MainActivity.docNoiDung_Tu_URL;

public class DetailSachActivity extends AppCompatActivity {


    //SESSION_GIOHANG Giở hàng
    public static ArrayList<GioHang> SESSION_GIOHANG = new ArrayList<>();

    private ImageView imgHinhAnh;
    private TextView txtTenSach;
    private TextView txtDonGia;
    private TextView txtTacGia;
    private TextView txtMoTa;
    private TextView txtSoLuongTon;
    private TextView txtSoLuongMuon;
    private TextView btnThemVaoGio;

     String IDTacGia;
     String IDSach;
     String HinhAnh;
     String TriGia;
     String TenSach;
     String TenTacGia;
     String MoTa;
     String SoLuongTon;

    public int FlagSLSachDatCoc=0;
    public boolean FlagTrungSachDatCoc=false;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_sach);

        final ImageButton btn_QuayLai = (ImageButton) findViewById(R.id.btnQuayLai);
        btn_QuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Bundle extraItem = getIntent().getExtras();

        imgHinhAnh = (ImageView) findViewById(R.id.img_HinhAnh_dtsach);

        txtTenSach = (TextView) findViewById(R.id.txt_TenSach_dtsach);
        IDSach = extraItem.getString("IDSach");

        txtTacGia = (TextView) findViewById(R.id.txt_TacGia_dtsach);
        IDTacGia = extraItem.getString("IDTacGia");

        txtDonGia = (TextView) findViewById(R.id.txt_DonGia_dtsach);

        txtMoTa = (TextView) findViewById(R.id.txt_MoTa_dtsach);

        txtSoLuongTon = (TextView) findViewById(R.id.txt_SoLuongTon_dtsach);



        txtSoLuongMuon = (TextView) findViewById(R.id.txt_SoLuongMuon_dtsach);


        txtSoLuongMuon.setText("1");


        btnThemVaoGio = (TextView)findViewById(R.id.btn_ThemVaoGio_dtsach);
        btnThemVaoGio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new docCTMuon().execute(URL+"/api/CTMuonTra/GetCTMuonTra");

                if (Integer.parseInt(txtSoLuongTon.getText().toString())==0){
                    Toast.makeText(getApplicationContext(),"Sách đã mượn hết!",Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(txtSoLuongMuon.getText().toString()) > Integer.parseInt(txtSoLuongTon.getText().toString())){
                    Toast.makeText(getApplicationContext(),"Trong kho chỉ còn "+txtSoLuongTon.getText().toString()+" Sách",Toast.LENGTH_LONG).show();
                } else if(SESSION_GIOHANG.size()>=4){
                    Toast.makeText(getApplicationContext(),"Chỉ đặt được 4 sách thuộc 4 đầu sách khác nhau!",Toast.LENGTH_LONG).show();
                }else if(kiemTraTrongGioHang()){
                    Toast.makeText(getApplicationContext(),"Sách đã có trong giỏ hàng!",Toast.LENGTH_LONG).show();
                }else if(kiemTraTrongHoatDong()){
                    Toast.makeText(getApplicationContext(),"Bạn đã đặt mượn sách này rồi, nhưng chưa đến nhận!!",Toast.LENGTH_LONG).show();
                }else {
                    GioHang gioHang =  new GioHang();
                    gioHang.setHinhAnh(HinhAnh);
                    gioHang.setTenSach(TenSach);
                    gioHang.setTriGia(Double.parseDouble(TriGia));
                    gioHang.setIDSach(IDSach);
                    gioHang.setIDDocGia(SESSION_LOGIN.getIDDocGia());
                    gioHang.setSoLuongThue(Integer.parseInt(txtSoLuongMuon.getText().toString()));
                    gioHang.setSTT("a");

                    SESSION_GIOHANG.add(gioHang);
                    Toast.makeText(getApplicationContext(),"Đã thêm vào giỏ hàng!",Toast.LENGTH_LONG).show();
                }
            }
        });

                //Xử lí thread
        progressDialog = new ProgressDialog(this);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog = ProgressDialog.show(DetailSachActivity.this, "",
                        "Đang kết nối...", true);

                new docSach().execute(URL+"/api/Sach/GetSach/"+IDSach);
                new docTacGia().execute(URL+"/api/TacGias/GetTacGia/"+IDTacGia);
            }
        });

    }
    public boolean kiemTraTrongGioHang(){
        for(int i=0 ;i<SESSION_GIOHANG.size();i++){
            if(SESSION_GIOHANG.get(i).getIDSach().equals(IDSach)){
                return true;
            }
        }
        return false;
    }
    public boolean kiemTraTrongHoatDong(){
        for(int i=0 ;i<listSachDatCoc.size();i++){
            for(int j=0 ;i<listSachDatCoc.get(i).getListSach().size();j++)
                if(listSachDatCoc.get(i).getListSach().get(j).getIDSach().equals(IDSach)){
                    return true;
            }
        }
        return false;
    }
    public class docCTMuon extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray arrSach = new JSONArray(s);
                FlagSLSachDatCoc = arrSach.length();

               /*for (int i=0;i<arrSach.length();i++){
                   JSONObject Sach = arrSach.getJSONObject(i);
                   if(Sach.getString("IDSach").equals(IDSach)){
                       FlagTrungSachDatCoc=true;
                   }
               }
               */
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    //Mở cổng kết nối, dữ liệu được parse json từ host
    public class docSach extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject Sach = new JSONObject(s);

               TenSach=Sach.getString("TenSach").toString();
                TriGia=Sach.getString("TriGia").toString();
                MoTa=Sach.getString("MoTa").toString();
                SoLuongTon=Sach.getString("SoLuongTon").toString();
                HinhAnh = Sach.getString("HinhAnh").toString();


                Picasso.with(DetailSachActivity.this).load(HinhAnh).into(imgHinhAnh);
                txtTenSach.setText(TenSach);
                txtDonGia.setText("Giá gốc: "+TriGia+"₫");
                txtMoTa.setText(MoTa);
                if (Integer.parseInt(SoLuongTon)==0){
                    btnThemVaoGio.setText("Đã hết");
                }
                txtSoLuongTon.setText(SoLuongTon);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    public class docTacGia extends AsyncTask<String, Integer, String> {
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
                JSONObject TacGia = new JSONObject(s);

                TenTacGia= TacGia.getString("TenTacGia").toString();
                txtTacGia.setText(TenTacGia);


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
