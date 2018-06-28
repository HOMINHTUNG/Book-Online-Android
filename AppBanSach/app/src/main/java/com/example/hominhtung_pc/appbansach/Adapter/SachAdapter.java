package com.example.hominhtung_pc.appbansach.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hominhtung_pc.appbansach.Activity.DetailSachActivity;
import com.example.hominhtung_pc.appbansach.Object.Sach;
import com.example.hominhtung_pc.appbansach.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by HOMINHTUNG-PC on 11/8/2017.
 */

public class SachAdapter extends RecyclerView.Adapter<SachAdapter.RecyclerViewHolder> {

    public Context context;
    private ArrayList<Sach> listSach = new ArrayList<>();

    public SachAdapter(Context context, ArrayList<Sach> listSach) {
        this.listSach = listSach;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_item_sach, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {

        holder.ten.setText(listSach.get(position).getTenSach().toString());
        holder.gia.setText("10000.0₫");

        Picasso.with(this.context).load(listSach.get(position).getHinhAnh()).into(holder.image);
        holder.image.getContext();

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlinkDetailSP(position);
            }
        });
        holder.ten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlinkDetailSP(position);
            }
        });


    }
    public void BlinkDetailSP(int i){
        Intent intent = new Intent(context,DetailSachActivity.class);
        intent.putExtra("IDSach",listSach.get(i).getIDSach());
        intent.putExtra("IDTacGia",listSach.get(i).getIDTacGia());
        context.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        return listSach.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView ten;
        TextView gia;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.img_Sach_item_gd);
            ten = (TextView) itemView.findViewById(R.id.txt_TenSach_item_gd);
            gia = (TextView) itemView.findViewById(R.id.txt_TriGia_item_gd);
        }
    }
}