package com.zhou.jy.designtest;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.nv_main_navigation)
    NavigationView nvMainNavigation;

    @Bind(R.id.TL_main_tab)
    TabLayout tb;
    @Bind(R.id.VP_mian_view)
    ViewPager vp_view;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.dl_main_drawer)
    DrawerLayout dlMainDrawer;


    private FragmentAdapter adapter;
    private List<Fragment>  fragmentList;
    private List<View> views;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        setTheme( R.style.AppThemeDay);
        ButterKnife.bind(this);
        toolbar.setTitle("zhou");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, dlMainDrawer, R.string.drawer_open, R.string.drawer_close);
        mDrawerToggle.syncState();
        dlMainDrawer.setDrawerListener(mDrawerToggle);

        View headerView = nvMainNavigation.inflateHeaderView(R.layout.nav_header_main);
        nvMainNavigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                dlMainDrawer.closeDrawers();
                switch (item.getItemId()){
                    case R.id.nav_change :
                        Toast.makeText(MainActivity.this,"change",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_login:
                        Toast.makeText(MainActivity.this,"login",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_manage:
                        Toast.makeText(MainActivity.this,"manage",Toast.LENGTH_LONG).show();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mian, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()){

                case R.id.nav_change :
                    Toast.makeText(MainActivity.this,"change",Toast.LENGTH_LONG).show();
                    break;
                case R.id.nav_login:
                    Toast.makeText(MainActivity.this,"login",Toast.LENGTH_LONG).show();
                    break;
                case R.id.nav_manage:
                    Toast.makeText(MainActivity.this,"manage",Toast.LENGTH_LONG).show();
                    break;
                case  android.R.id.home:
                    dlMainDrawer.openDrawer(GravityCompat.START);
                    break;

            }

        return true;
    }
}
