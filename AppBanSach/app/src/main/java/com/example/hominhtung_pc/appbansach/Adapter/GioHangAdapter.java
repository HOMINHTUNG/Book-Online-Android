package com.example.hominhtung_pc.appbansach.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hominhtung_pc.appbansach.Object.GioHang;
import com.example.hominhtung_pc.appbansach.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.hominhtung_pc.appbansach.Activity.DetailSachActivity.SESSION_GIOHANG;
import static com.example.hominhtung_pc.appbansach.Activity.GioHangActivity.gioHangAdapter;

/**
 * Created by HOMINHTUNG-PC on 11/23/2017.
 */

public class GioHangAdapter  extends RecyclerView.Adapter<GioHangAdapter.RecyclerViewHolder> {

    public Context context;
    private ArrayList<GioHang> listSach = new ArrayList<>();

    public GioHangAdapter(Context context, ArrayList<GioHang> listSach) {
        this.listSach = listSach;
        this.context = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_item_gio_hang, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {

        // tang;
        // giam;
        // xoa;

        holder.ten.setText(listSach.get(position).getTenSach().toString());
        holder.soluong.setText("1");
        holder.gia.setText("10000.0₫");

        holder.tiencoc.setText(String.valueOf(listSach.get(position).getTriGia() + listSach.get(position).getTriGia()/10)+"₫");
        holder.tongtien.setText(String.valueOf(listSach.get(position).tongTien())+"₫");


        Picasso.with(this.context).load(listSach.get(position).getHinhAnh()).into(holder.image);
        holder.image.getContext();

        holder.xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SESSION_GIOHANG.remove(position);
                gioHangAdapter.notifyDataSetChanged();
            }
        });
        /*
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
*/

    }
   /* public void BlinkDetailSP(int i){
        Intent intent = new Intent(context,DetailSachActivity.class);
        intent.putExtra("IDSach",listSach.get(i).getIDSach());
        intent.putExtra("IDTacGia",listSach.get(i).getIDTacGia());
        context.startActivity(intent);
    }
    */
    @Override
    public int getItemCount() {
        return listSach.size();
    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        ImageView xoa;
        ImageView image;
        TextView ten;
        TextView gia;
        TextView soluong;
        TextView tiencoc;
        TextView tongtien;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.img_Sach_item_gh);
            tiencoc = (TextView) itemView.findViewById(R.id.txt_TienCoc_item_gh);
            tongtien = (TextView) itemView.findViewById(R.id.txt_TongTien_item_gh);
            xoa = (ImageView) itemView.findViewById(R.id.img_Xoa_item_gh);


            ten = (TextView) itemView.findViewById(R.id.txt_TenSach_item_gh);
            gia = (TextView) itemView.findViewById(R.id.txt_TriGia_item_gh);
            soluong = (TextView) itemView.findViewById(R.id.txt_SoLuongMuon_item_gh);
        }
    }
}
