package com.example.hominhtung_pc.appbansach.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hominhtung_pc.appbansach.Object.DocGia;
import com.example.hominhtung_pc.appbansach.R;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import static com.example.hominhtung_pc.appbansach.Activity.DangKyActivity.FLAG_DANGKY;
import static com.example.hominhtung_pc.appbansach.Activity.MainActivity.docNoiDung_Tu_URL;

public class DangNhapActivity extends AppCompatActivity {

    static String URL = "http://applibschool.somee.com";
    static DocGia SESSION_LOGIN = new DocGia();

    //Field
    private EditText txtMatKhau;
    private EditText txtTaiKhoan;
    private TextView btnDangNhap;
    private TextView btnQuenMatKhau;
    private TextView btnDangKy;

    private TextView mTvInfo;
    private LoginButton mBtnLoginFacebook;
    private CallbackManager mCallbackManager;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap_new);

        mCallbackManager = CallbackManager.Factory.create();
        mTvInfo = (TextView) findViewById(R.id.tv_info);
        mBtnLoginFacebook = (LoginButton) findViewById(R.id.btn_login_facebook);

        mBtnLoginFacebook.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                mTvInfo.setText("User ID: " + loginResult.getAccessToken().getUserId() + "\n" +
                        "Auth Token: " + loginResult.getAccessToken().getToken());
            }

            @Override
            public void onCancel() {
                Toast.makeText(getApplicationContext(),"Huỷ đăng nhập Facebook!",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FacebookException e) {
                Toast.makeText(getApplicationContext(),"Đăng nhập thất bại!",Toast.LENGTH_LONG).show();
            }
        });

        txtTaiKhoan = (EditText) findViewById(R.id.txt_TaiKhoan_lg);
        txtMatKhau = (EditText) findViewById(R.id.txt_MatKhau_lg);

        if (FLAG_DANGKY==1){
            Bundle extraItem = getIntent().getExtras();
            txtTaiKhoan.setText(extraItem.getString("SoDienThoai").toString());
            txtMatKhau.setText(extraItem.getString("MatKhau").toString());
        }

        btnDangNhap = (TextView) findViewById(R.id.btn_DangNhap_lg);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtTaiKhoan.getText().toString().equals("")){
                    txtTaiKhoan.setError("Tên đăng nhập không được để trống");
                } else  if(txtMatKhau.getText().toString().equals("")){
                    txtMatKhau.setError("Mật khẩu không được để trống");
                }
                else {
                    progressDialog = new ProgressDialog(DangNhapActivity.this);
                    progressDialog = ProgressDialog.show(DangNhapActivity.this, "",
                            "Đang kết nối...", true);
                    new docDangNhap().execute(URL+"/api/DocGia/getDangNhap/"+txtTaiKhoan.getText().toString()+"/"+txtMatKhau.getText().toString());
                }
            }
        });

        btnDangKy = (TextView) findViewById(R.id.btn_DangKy_lg);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapActivity.this,DangKyActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public class docDangNhap extends AsyncTask<String, Integer, String> {
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
                    if(s.equals("null\n")){
                        Toast.makeText(getApplicationContext(),"Tên đăng nhập hoặc mật khẩu không đúng",Toast.LENGTH_LONG).show();
                        txtTaiKhoan.setText("");
                        txtMatKhau.setText("");
                        txtTaiKhoan.requestFocus();
                    }
                    else{
                        JSONObject DocGia = new JSONObject(s);

                        Toast.makeText(getApplicationContext(),"Đăng nhập thành công!",Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(DangNhapActivity.this,MainActivity.class);
                        SESSION_LOGIN = new DocGia(DocGia.getString("IDDocGia"),DocGia.getString("SoDienThoai"),DocGia.getString("MatKhau"),DocGia.getString("TenDocGia"),DocGia.getString("DiaChi"),DocGia.getString("Email"),DocGia.getString("CMND"),DocGia.getString("NgayLap"),DocGia.getString("NgayHetHan"),DocGia.getString("NgaySinh"),DocGia.getInt("TinhTrang"),DocGia.getDouble("TongTienPhat"));
                        startActivity(intent);
                    }

            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(),"Lỗi kết nối mạng!",Toast.LENGTH_LONG).show();
            }

        }
    }
}
