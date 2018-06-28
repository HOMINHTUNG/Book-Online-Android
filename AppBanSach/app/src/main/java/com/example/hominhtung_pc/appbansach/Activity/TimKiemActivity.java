package com.example.hominhtung_pc.appbansach.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.hominhtung_pc.appbansach.Adapter.SachAdapter;
import com.example.hominhtung_pc.appbansach.R;

import static com.example.hominhtung_pc.appbansach.Activity.MainActivity.listSachSearch;

public class TimKiemActivity extends AppCompatActivity {

    private RecyclerView rcvListSach;
    private SachAdapter sachAdapter;
    private TextView TextThongBao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search);

        ImageButton btn_QuayLai = (ImageButton) findViewById(R.id.btnQuayLai);
        btn_QuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextThongBao = (TextView) findViewById(R.id.txt_TextThongBao);

        if(listSachSearch.isEmpty()){
            TextThongBao.setText("Không tìm thấy!");
        }
        else if (listSachSearch.size()>0){
            TextThongBao.setText("");
        }

        rcvListSach = (RecyclerView) findViewById(R.id.rcv_Sach_search);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvListSach.setLayoutManager(layoutManager);
        sachAdapter = new SachAdapter(TimKiemActivity.this,listSachSearch);
        rcvListSach.setAdapter(sachAdapter);


    }
}
