package com.example.hominhtung_pc.appbansach.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.example.hominhtung_pc.appbansach.Adapter.RowSachTheoLoaiAdapter;
import com.example.hominhtung_pc.appbansach.Object.Sach;
import com.example.hominhtung_pc.appbansach.Object.SachTheoTheLoai;
import com.example.hominhtung_pc.appbansach.Object.Suggestion;
import com.example.hominhtung_pc.appbansach.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.hominhtung_pc.appbansach.Activity.DangNhapActivity.SESSION_LOGIN;
import static com.example.hominhtung_pc.appbansach.Activity.DangNhapActivity.URL;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //Slide cover trang chủ
    private ImageSwitcher imageSwitcher;
    int imgCover[] = {R.drawable.cover_stevejobs, R.drawable.cover_billgate, R.drawable.cover_jackma, R.drawable.cover_robert};
    int count = imgCover.length;
    int currentIndex = -1;

    //Navigation Header
    private TextView txtTenDocGia;
    private TextView txtSoDienThoai;

    //Floating Search View
    private FloatingSearchView textSearch;
    static public ArrayList<Sach> listSachSearch = new ArrayList<>();
    private List<Suggestion> mSuggestions =new ArrayList<>();


    //Content-Menu
    private RecyclerView rcvListSach;
    private ArrayList<SachTheoTheLoai> listTheLoai = new ArrayList<>();
    private ArrayList<SachTheoTheLoai> listTheLoaiRow = new ArrayList<>();
    private ArrayList<Sach> listSach = new ArrayList<>();
    private ArrayList<Sach> listSachInitSearch = new ArrayList<>();
    private RowSachTheoLoaiAdapter rowSachTheoLoaiAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //Khởi tạo Navigation Header
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        txtTenDocGia = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txt_TenDocGia_nav);
        txtTenDocGia.setText(SESSION_LOGIN.getTenDocGia());

        txtSoDienThoai = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txt_SoDienThoai_nav);
        txtSoDienThoai.setText(SESSION_LOGIN.getSoDienThoai());



        //Cover slide show
        // get The references of Button and ImageSwitcher
        imageSwitcher = (ImageSwitcher) findViewById(R.id.coverImageSwitcher);
        // Set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub

                // Create a new ImageView and set it's properties
                ImageView imageView = new ImageView(getApplicationContext());
                // set Scale type of ImageView to Fit Center
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                return imageView;
            }
        });

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);

        // set the animation type to ImageSwitcher
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

        Timer t = new Timer();
        //Set the schedule function and rate
        t.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                //Called each time when 1000 milliseconds (1 second) (the period parameter)
                currentIndex++;
                // If index reaches maximum reset it
                if(currentIndex==count)
                    currentIndex=0;
                runOnUiThread(new Runnable() {

                    public void run() {
                        imageSwitcher.setImageResource(imgCover[currentIndex]);

                    }
                });
            }

        },0,6000);


        //khởi tạo Floating Search View
        textSearch = (FloatingSearchView)findViewById(R.id.floating_search_view);
        textSearch.setOnQueryChangeListener(new FloatingSearchView.OnQueryChangeListener() {
            @Override
            public void onSearchTextChanged(String oldQuery, String newQuery) {
                if (!oldQuery.equals("") && newQuery.equals("")) {
                    textSearch.clearSuggestions();
                } else {
                    textSearch.showProgress();
                    textSearch.swapSuggestions(getSuggestion(newQuery));
                    textSearch.hideProgress();
                }
            }
        });
        textSearch.setOnFocusChangeListener(new FloatingSearchView.OnFocusChangeListener() {
            @Override
            public void onFocus() {
                textSearch.showProgress();
                textSearch.swapSuggestions(getSuggestion(textSearch.getQuery()));
                textSearch.hideProgress();
            }

            @Override
            public void onFocusCleared() {

            }
        });
        textSearch.setOnSearchListener(new FloatingSearchView.OnSearchListener() {
            @Override
            public void onSuggestionClicked(SearchSuggestion searchSuggestion) {
                Suggestion suggestion= (Suggestion) searchSuggestion;
                Toast.makeText(getApplicationContext(),"Ban muốn tìm: "+suggestion.getBody(),Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onSearchAction(String currentQuery) {
                listSachSearch.removeAll(listSachSearch);
                for(int i=0;i<listSachInitSearch.size();i++){
                    if(listSachInitSearch.get(i).getTenSach().toLowerCase().toString().contains(currentQuery.toLowerCase().toString())){
                        listSachSearch.add(listSachInitSearch.get(i));
                    }
                }
                Intent intent = new Intent(MainActivity.this,TimKiemActivity.class);
                startActivity(intent);
            }
        });

        //khởi tạo RecycleView
        rcvListSach = (RecyclerView) findViewById(R.id.rcvSach_main);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rcvListSach.setLayoutManager(layoutManager);

        rowSachTheoLoaiAdapter = new RowSachTheoLoaiAdapter(MainActivity.this,listTheLoaiRow);
        rcvListSach.setAdapter(rowSachTheoLoaiAdapter);

        //Xử lí thread
        progressDialog = new ProgressDialog(this);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressDialog = ProgressDialog.show(MainActivity.this, "",
                        "Đang kết nối...", true);
                new docTheLoai().execute(URL+"/api/TheLoai/GetTheLoais");
                new docSach().execute(URL+"/api/Sach/GetSaches");
            }
        });

    }

    public void CheckHienThi(ArrayList<SachTheoTheLoai>  listTheLoai, ArrayList<SachTheoTheLoai>  listTheLoaiRow ){
        for(int i=0;i<listTheLoai.size();i++) {
            if (listTheLoai.get(i).getListSach().size() != 0) {
                listTheLoaiRow.add(listTheLoai.get(i));
            }
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if(id == R.id.action_image){

            Intent intent = new Intent(getApplicationContext(),GioHangActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navCaNhan) {
            Intent intent = new Intent(this,CaNhanActivity.class);
            startActivity(intent);
        } else if (id == R.id.navHoatDong) {
            Intent intent = new Intent(this, HoatDongActivity.class);
            startActivity(intent);
        }else if (id == R.id.navDangXuat) {
            Intent intent = new Intent(this,DangNhapActivity.class);
            startActivity(intent);
        } else if (id == R.id.navThoat) {
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startActivity(startMain);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public static String docNoiDung_Tu_URL(String theUrl){
        StringBuilder content = new StringBuilder();
        try    {

            URL url = new URL(theUrl);

            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            while ((line = bufferedReader.readLine()) != null){
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)    {
            e.printStackTrace();
        }
        return content.toString();
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
                    SachTheoTheLoai sachTheoTheLoai = new SachTheoTheLoai();
                    sachTheoTheLoai.setMaTheLoai(TheLoai.getString("IDTheLoai").toString());
                    sachTheoTheLoai.setTenTheLoai(TheLoai.getString("TenTheLoai").toString());
                    listSach= new ArrayList<>();
                    sachTheoTheLoai.setListSach(listSach);
                    listTheLoai.add(sachTheoTheLoai);
                }
                rowSachTheoLoaiAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
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
                for(int i=0;i<listTheLoai.size();i++){
                    for(int j=0;j<arrDM.length();j++){
                        JSONObject Sach = arrDM.getJSONObject(j);
                        if(Sach.getString("IDTheLoai").equals(listTheLoai.get(i).getMaTheLoai())){
                            Sach sach = new Sach();
                            sach.setTenSach(Sach.getString("TenSach"));
                            sach.setHinhAnh(Sach.getString("HinhAnh"));
                            sach.setTriGia(Double.parseDouble(Sach.getString("TriGia")));
                            sach.setIDSach(Sach.getString("IDSach"));
                            sach.setIDTacGia(Sach.getString("IDTacGia"));
                            listSachInitSearch.add(sach);
                            listTheLoai.get(i).getListSach().add(sach);
                        }
                    }
                }
                CheckHienThi(listTheLoai,listTheLoaiRow);
                rowSachTheoLoaiAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private List<Suggestion> getSuggestion(String query){
        List<Suggestion> suggestions=new ArrayList<>();
        for(Suggestion suggestion:mSuggestions){
            if(suggestion.getBody().toLowerCase().contains(query.toLowerCase())){
                suggestions.add(suggestion);
            }
        }
        return suggestions;
    }
}
