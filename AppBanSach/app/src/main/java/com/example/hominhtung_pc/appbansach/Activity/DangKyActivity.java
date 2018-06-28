package com.example.hominhtung_pc.appbansach.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.example.hominhtung_pc.appbansach.R;

import java.util.HashMap;
import java.util.Map;

import static com.example.hominhtung_pc.appbansach.Activity.DangNhapActivity.URL;
import static com.example.hominhtung_pc.appbansach.Activity.MainActivity.docNoiDung_Tu_URL;

public class DangKyActivity extends AppCompatActivity {

    static int FLAG_DANGKY = 0;
    private TextView btnDangKy;

    private TextView txtTenDocGia;
    private TextView txtEmail;
    private TextView txtSoDienThoai;
    private TextView txtMatKhau;

    ProgressDialog progressDialog;

    private String urlDangKy = URL+"/api/DocGias/PostDocGia";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        ImageButton btn_QuayLai = (ImageButton) findViewById(R.id.btnQuayLai);
        btn_QuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        txtTenDocGia = (TextView) findViewById(R.id.txt_TenDocGia_dk);
        txtEmail = (TextView) findViewById(R.id.txt_Email_dk);
        txtSoDienThoai = (TextView) findViewById(R.id.txt_Sdt_dk);
        txtMatKhau = (TextView) findViewById(R.id.txt_MatKhau_dk);

        btnDangKy = (TextView) findViewById(R.id.btn_DangKy_dk);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtTenDocGia.getText().toString().equals("")){
                    txtTenDocGia.setError("Bạn chưa nhập tên!");
                    txtTenDocGia.requestFocus();
                } else if(txtTenDocGia.getText().toString().length()>50){
                    txtTenDocGia.setError("Tên không vượt quá 50 kí tự!");
                    txtTenDocGia.requestFocus();
                } else  if(txtEmail.getText().toString().equals("")){
                    txtEmail.setError("Bạn chưa nhập email!");
                    txtEmail.requestFocus();
                } else if(txtEmail.getText().toString().length()>50) {
                    txtEmail.setError("Email không vượt quá 50 kí tự!");
                    txtEmail.requestFocus();
                } else  if(txtSoDienThoai.getText().toString().equals("")){
                    txtSoDienThoai.setError("Bạn chưa nhập sđt!");
                    txtSoDienThoai.requestFocus();
                } else if(txtSoDienThoai.getText().toString().length()>11 || txtSoDienThoai.getText().toString().length()<9){
                    txtSoDienThoai.setError("Sđt phải từ 9 -> 11 kí tự!");
                    txtSoDienThoai.requestFocus();
                } else  if(txtMatKhau.getText().toString().equals("")){
                    txtMatKhau.setError("Bạn chưa nhập mật khẩu!");
                    txtMatKhau.requestFocus();
                } else if(txtMatKhau.getText().toString().length()>100 || txtMatKhau.getText().toString().length()<4){
                    txtMatKhau.setError("Mật khẩu phải > 4 kí tự");
                    txtMatKhau.requestFocus();
                }
                else {
                    progressDialog = new ProgressDialog(DangKyActivity.this);
                    progressDialog = ProgressDialog.show(DangKyActivity.this, "",
                            "Đang kết nối...", true);
                    new docKiemTra().execute(URL+"/api/DocGia/getKetQuaDangKy/"+txtSoDienThoai.getText().toString()+"/"+txtEmail.getText().toString());
                }
            }
        });
    }

    public class docKiemTra extends AsyncTask<String, Integer, String> {
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

            if(s.contains("Email đã tồn tại!")){
                txtEmail.setError("Email đã tồn tại!");
                txtEmail.requestFocus();
            }else if(s.contains("Số điện thoại đã tồn tại!")){
                txtSoDienThoai.setError("Số điện thoại đã tồn tại!");
                txtSoDienThoai.requestFocus();
            }
            else{
                requestQueue = Volley.newRequestQueue(getApplicationContext());


                    StringRequest request = new StringRequest(Request.Method.POST, urlDangKy, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            FLAG_DANGKY = 1;

                            Intent intent = new Intent(DangKyActivity.this,DangNhapActivity.class);
                            intent.putExtra("SoDienThoai",txtSoDienThoai.getText().toString());
                            intent.putExtra("MatKhau",txtMatKhau.getText().toString());
                            Toast.makeText(getApplication(),"Thêm thành công!",Toast.LENGTH_LONG).show();
                            startActivity(intent);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(getApplication(),"Thêm hất bại, kiểm tra lại kết nội mạng!",Toast.LENGTH_LONG).show();
                        }

                    }) {

                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> parameters  = new HashMap<String, String>();
                            parameters.put("IDDocGia","a");
                            parameters.put("SoDienThoai",txtSoDienThoai.getText().toString());
                            parameters.put("MatKhau",txtMatKhau.getText().toString());
                            parameters.put("TenDocGia",txtTenDocGia.getText().toString());
                            parameters.put("Email",txtEmail.getText().toString());
                            return parameters;
                        }
                    };

                    requestQueue.add(request);

            }

        }
    }
}
