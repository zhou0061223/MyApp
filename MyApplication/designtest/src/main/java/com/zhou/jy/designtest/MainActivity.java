package com.zhou.jy.designtest;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.btn_main_snackbar)
     Button btn_snackbar;
    @Bind(R.id.btn_main_tabLayout)
    Button btn_tabLayout;
    @Bind(R.id.btn_main_navigationView)
    Button btn_navigationView;

    @Bind(R.id.TT_et)
    TextInputLayout textInputLayout;

    @Bind(R.id.nv_main_navigation)
    NavigationView nvMainNavigation;

    @Bind(R.id.TL_main_tab)
    TabLayout tb;
    @Bind(R.id.VP_mian_view)
    ViewPager vp_view;

    private FragmentAdapter adapter;
    private List<Fragment>  fragmentList;
    private List<View> views;


    @OnClick({R.id.btn_main_snackbar,R.id.btn_main_tabLayout,R.id.btn_main_navigationView})
    void Onclick(View view){
          switch (view.getId()){
              case R.id.btn_main_snackbar :
                  Snackbar.make(view,"test..snackbar",Snackbar.LENGTH_LONG)
                          .setAction("action", new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {
                                  Toast.makeText(MainActivity.this,"test..toast",Toast.LENGTH_LONG).show();
                              }
                          }).show();


                      textInputLayout.setError("errororoor");
                      textInputLayout.setErrorEnabled(true);
                  break;


          }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        setTheme( R.style.AppThemeDay);
        ButterKnife.bind(this);

        View headerView = nvMainNavigation.inflateHeaderView(R.layout.nav_header_main);
        nvMainNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){

                    case R.id.nav_change :
                        Toast.makeText(MainActivity.this,"change",Toast.LENGTH_LONG).show();
                       // Snackbar.make(new View(context),"change",Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.nav_login:
                        Toast.makeText(MainActivity.this,"login",Toast.LENGTH_LONG).show();
                       // Snackbar.make(new View(context),"login",Snackbar.LENGTH_LONG).show();
                        break;
                    case R.id.nav_manage:
                        Toast.makeText(MainActivity.this,"manage",Toast.LENGTH_LONG).show();
                      //  Snackbar.make(new View(context),"manage",Snackbar.LENGTH_LONG).show();
                        break;

                }
                return true;
            }
        });

        tb.setTabTextColors(Color.WHITE, Color.GRAY);
        fragmentList=new ArrayList<>();
        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());
        List<String> str=new ArrayList<>();
         Log.i("aaaaaaaaa",fragmentList.size()+"");
        str.add("第一个");
        str.add("第二个");
        str.add("第三个");
       // tb.setTabMode(TabLayout.MODE_SCROLLABLE);
        vp_view.setAdapter(new FragmentAdapter(getSupportFragmentManager(),fragmentList,str));

        tb.setupWithViewPager(vp_view);
        tb.setTabMode(TabLayout.MODE_FIXED);


    }
}
