package com.example.hominhtung_pc.appbansach.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hominhtung_pc.appbansach.R;

import static com.example.hominhtung_pc.appbansach.Activity.DetailSachActivity.SESSION_GIOHANG;

public class ThanhToanActivity extends AppCompatActivity {

    TextView btnThanhToan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);

        Bundle extraItem = getIntent().getExtras();
        btnThanhToan = (TextView) findViewById(R.id.btn_ThanhToan_tt);
        btnThanhToan.setText("PAY "+extraItem.getString("TongTien"));
        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Thanh toán thành công!",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ThanhToanActivity.this, MainActivity.class);
                SESSION_GIOHANG.removeAll(SESSION_GIOHANG);
                startActivity(intent);
            }
        });
    }
}
