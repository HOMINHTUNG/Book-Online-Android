package com.example.hominhtung_pc.appbansach.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hominhtung_pc.appbansach.Activity.LoaiSachActivity;
import com.example.hominhtung_pc.appbansach.Object.SachTheoTheLoai;
import com.example.hominhtung_pc.appbansach.R;

import java.util.ArrayList;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class RowSachTheoLoaiAdapter extends RecyclerView.Adapter<RowSachTheoLoaiAdapter.RecyclerViewHolder> {

    public Context context;
    private ArrayList<SachTheoTheLoai> listTheLoai= new ArrayList<>();
    private SachAdapter sachAdapter;

    public RowSachTheoLoaiAdapter(Context context, ArrayList<SachTheoTheLoai> listTheLoai) {
        this.listTheLoai = listTheLoai;
        this.context = context;
    }

    @Override
    public RowSachTheoLoaiAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_item_sach_main, parent, false);
        return new RowSachTheoLoaiAdapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RowSachTheoLoaiAdapter.RecyclerViewHolder holder, final int position) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        holder.listSach.setLayoutManager(layoutManager);

        sachAdapter = new SachAdapter(context,listTheLoai.get(position).getListSach());
        holder.listSach.setAdapter(sachAdapter);


        holder.ten.setText(listTheLoai.get(position).getTenTheLoai());


        holder.ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlinkDetailSP(position);
            }
        });
        holder.xemthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlinkDetailSP(position);
            }
        });


    }
     public void BlinkDetailSP(int i){
         Intent intent = new Intent(context,LoaiSachActivity.class);
         intent.putExtra("IDTheLoai",listTheLoai.get(i).getMaTheLoai().toString());
         intent.putExtra("TenTheLoai",listTheLoai.get(i).getTenTheLoai().toString());
         context.startActivity(intent);
     }
    @Override
    public int getItemCount() {
        return listTheLoai.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView xemthem;
        TextView ten;
        RecyclerView listSach;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            xemthem = (TextView) itemView.findViewById(R.id.btn_XemThem_item);
            ten = (TextView) itemView.findViewById(R.id.txt_TenLoai_item);
            listSach = (RecyclerView) itemView.findViewById(R.id.rcvSach_item);

        }
    }
}
