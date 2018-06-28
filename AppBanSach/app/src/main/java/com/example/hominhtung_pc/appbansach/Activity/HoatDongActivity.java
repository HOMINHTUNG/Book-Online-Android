package com.example.hominhtung_pc.appbansach.Activity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.hominhtung_pc.appbansach.Adapter.RowSachTheoLoaiAdapter;
import com.example.hominhtung_pc.appbansach.Object.Sach;
import com.example.hominhtung_pc.appbansach.Object.SachTheoTheLoai;
import com.example.hominhtung_pc.appbansach.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.hominhtung_pc.appbansach.Activity.DangNhapActivity.SESSION_LOGIN;
import static com.example.hominhtung_pc.appbansach.Activity.DangNhapActivity.URL;
import static com.example.hominhtung_pc.appbansach.Activity.MainActivity.docNoiDung_Tu_URL;

public class HoatDongActivity extends AppCompatActivity {

     private SectionsPagerAdapter mSectionsPagerAdapter;

      private ViewPager mViewPager;


    //Content-Menu
    private static RecyclerView rcvListSach;


    private static ArrayList<SachTheoTheLoai> listTheLoaiRow1 = new ArrayList<>();
    private static ArrayList<SachTheoTheLoai> listTheLoaiRow2 = new ArrayList<>();
    private static ArrayList<SachTheoTheLoai> listTheLoaiRow3 = new ArrayList<>();

    private static ArrayList<SachTheoTheLoai> listSachDaMuon = new ArrayList<>();
    public static ArrayList<SachTheoTheLoai> listSachDatCoc = new ArrayList<>();
    private static ArrayList<SachTheoTheLoai> listSachDangMuon = new ArrayList<>();


    private static RowSachTheoLoaiAdapter rowSachTheoLoaiAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoat_dong);

        ImageButton btn_QuayLai = (ImageButton) findViewById(R.id.btnQuayLai);
        btn_QuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    //    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
     //   setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        init();



        //Xử lí thread
        progressDialog = new ProgressDialog(this);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {


                progressDialog = ProgressDialog.show(HoatDongActivity.this, "",
                        "Đang kết nối...", true);

                new docTheLoai().execute(URL+"/api/TheLoai/GetTheLoais");
                new docSachDatCoc().execute(URL+"/api/CTMuonTra/GetSachDatCoc/"+SESSION_LOGIN.getIDDocGia());
                new docSachDangMuon().execute(URL+"/api/CTMuonTra/GetSachDangMuon/"+SESSION_LOGIN.getIDDocGia());
                new docSachDaMuon().execute(URL+"/api/CTMuonTra/GetSachDaMuon/"+SESSION_LOGIN.getIDDocGia());
            }
        });

    }

    private void init() {


        listTheLoaiRow1.removeAll(listTheLoaiRow1);
        listTheLoaiRow2.removeAll(listTheLoaiRow2);
        listTheLoaiRow3.removeAll(listTheLoaiRow3);

        listSachDaMuon.removeAll(listSachDaMuon);
        listSachDatCoc.removeAll(listSachDatCoc);
        listSachDangMuon.removeAll(listSachDangMuon);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View  rootView = inflater.inflate(R.layout.fragment_hoat_dong, container, false);



            //khởi tạo RecycleView

            rcvListSach = (RecyclerView) rootView.findViewById(R.id.rcv_listSach_hd);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            rcvListSach.setLayoutManager(layoutManager);

            rowSachTheoLoaiAdapter = new RowSachTheoLoaiAdapter(getContext(),listTheLoaiRow1);
            rcvListSach.setAdapter(rowSachTheoLoaiAdapter);
            rowSachTheoLoaiAdapter.notifyDataSetChanged();


            switch(getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1:
                    rowSachTheoLoaiAdapter = new RowSachTheoLoaiAdapter(getContext(),listTheLoaiRow1);
                    rcvListSach.setAdapter(rowSachTheoLoaiAdapter);
                    rowSachTheoLoaiAdapter.notifyDataSetChanged();

                    return rootView;

                case 2:
                    rowSachTheoLoaiAdapter = new RowSachTheoLoaiAdapter(getContext(),listTheLoaiRow2);
                    rcvListSach.setAdapter(rowSachTheoLoaiAdapter);
                    rowSachTheoLoaiAdapter.notifyDataSetChanged();

                    return rootView;
                case 3:
                    rowSachTheoLoaiAdapter = new RowSachTheoLoaiAdapter(getContext(),listTheLoaiRow3);
                    rcvListSach.setAdapter(rowSachTheoLoaiAdapter);
                    rowSachTheoLoaiAdapter.notifyDataSetChanged();

                    return rootView;
            }

            return rootView;
        }
    }






    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position+1);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Đang đặt";
                case 1:
                    return "Đang mượn";
                case 2:
                    return "Lịch sử";
            }
            return null;
        }
    }

    public static void CheckHienThiHoatDong(ArrayList<SachTheoTheLoai> listTheLoai, ArrayList<SachTheoTheLoai> listTheLoaiRow){
        if(listTheLoai.size() != 0){
            for(int i=0;i<listTheLoai.size();i++) {
                if (listTheLoai.get(i).getListSach().size() != 0) {
                    listTheLoaiRow.add(listTheLoai.get(i));
                }
            }
        }

    }

    //Mở cổng kết nối, dữ liệu được parse json từ host
    public class docTheLoai extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {

                JSONArray arrDM = new JSONArray(s);
                for(int i=0;i<arrDM.length();i++){
                    JSONObject TheLoai = arrDM.getJSONObject(i);
                    SachTheoTheLoai sachTheoTheLoaiDM = new SachTheoTheLoai();
                    sachTheoTheLoaiDM.setMaTheLoai(TheLoai.getString("IDTheLoai").toString());
                    sachTheoTheLoaiDM.setTenTheLoai(TheLoai.getString("TenTheLoai").toString());
                    ArrayList<Sach> listSachDM= new ArrayList<>();
                    sachTheoTheLoaiDM.setListSach(listSachDM);
                    listSachDaMuon.add(sachTheoTheLoaiDM);

                    SachTheoTheLoai sachTheoTheLoaiDC = new SachTheoTheLoai();
                    sachTheoTheLoaiDC.setMaTheLoai(TheLoai.getString("IDTheLoai").toString());
                    sachTheoTheLoaiDC.setTenTheLoai(TheLoai.getString("TenTheLoai").toString());
                    ArrayList<Sach> listSachDC= new ArrayList<>();
                    sachTheoTheLoaiDC.setListSach(listSachDC);
                    listSachDatCoc.add(sachTheoTheLoaiDC);

                    SachTheoTheLoai sachTheoTheLoai = new SachTheoTheLoai();
                    sachTheoTheLoai.setMaTheLoai(TheLoai.getString("IDTheLoai").toString());
                    sachTheoTheLoai.setTenTheLoai(TheLoai.getString("TenTheLoai").toString());
                    ArrayList<Sach> listSach= new ArrayList<>();
                    sachTheoTheLoai.setListSach(listSach);
                    listSachDangMuon.add(sachTheoTheLoai);
                }
                rowSachTheoLoaiAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }




    public  class docSachDangMuon extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray arrDM = new JSONArray(s);
                for(int i=0;i<listSachDangMuon.size();i++){
                    for(int j=0;j<arrDM.length();j++){
                        JSONObject Sach = arrDM.getJSONObject(j);
                        if(Sach.getString("IDTheLoai").equals(listSachDangMuon.get(i).getMaTheLoai())){
                            Sach sach = new Sach();
                            sach.setTenSach(Sach.getString("TenSach"));
                            sach.setHinhAnh(Sach.getString("HinhAnh"));
                            sach.setTriGia(Double.parseDouble(Sach.getString("TriGia")));
                            sach.setIDSach(Sach.getString("IDSach"));
                            sach.setIDTacGia(Sach.getString("IDTacGia"));
                            listSachDangMuon.get(i).getListSach().add(sach);
                        }
                    }
                }
                CheckHienThiHoatDong(listSachDangMuon,listTheLoaiRow2);
                rowSachTheoLoaiAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    public  class docSachDaMuon extends AsyncTask<String, Integer, String> {
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
                for(int i=0;i<listSachDaMuon.size();i++){
                    for(int j=0;j<arrDM.length();j++){
                        JSONObject Sach = arrDM.getJSONObject(j);
                        if(Sach.getString("IDTheLoai").equals(listSachDaMuon.get(i).getMaTheLoai())){
                            Sach sach = new Sach();
                            sach.setTenSach(Sach.getString("TenSach"));
                            sach.setHinhAnh(Sach.getString("HinhAnh"));
                            sach.setTriGia(Double.parseDouble(Sach.getString("TriGia")));
                            sach.setIDSach(Sach.getString("IDSach"));
                            sach.setIDTacGia(Sach.getString("IDTacGia"));
                            listSachDaMuon.get(i).getListSach().add(sach);
                        }
                    }
                }
                CheckHienThiHoatDong(listSachDaMuon,listTheLoaiRow3);
                rowSachTheoLoaiAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    public  class docSachDatCoc extends AsyncTask<String, Integer, String> {
        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray arrDM = new JSONArray(s);
                for(int i=0;i<listSachDatCoc.size();i++){
                    for(int j=0;j<arrDM.length();j++){
                        JSONObject Sach = arrDM.getJSONObject(j);
                        if(Sach.getString("IDTheLoai").equals(listSachDatCoc.get(i).getMaTheLoai())){
                            Sach sach = new Sach();
                            sach.setTenSach(Sach.getString("TenSach"));
                            sach.setHinhAnh(Sach.getString("HinhAnh"));
                            sach.setTriGia(Double.parseDouble(Sach.getString("TriGia")));
                            sach.setIDSach(Sach.getString("IDSach"));
                            sach.setIDTacGia(Sach.getString("IDTacGia"));
                            listSachDatCoc.get(i).getListSach().add(sach);
                        }
                    }
                }
                CheckHienThiHoatDong(listSachDatCoc,listTheLoaiRow1);
                rowSachTheoLoaiAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
