package com.zhou.jy.designtest;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/1.
 */
public class Fragment2 extends BaseFragment{

    @Bind(R.id.btn_main_snackbar)
     Button btn_snackbar;
    @Bind(R.id.btn_main_tabLayout)
    Button btn_tabLayout;
    @Bind(R.id.btn_main_navigationView)
    Button btn_navigationView;

    @Bind(R.id.TT_et)
    TextInputLayout textInputLayout;

        @OnClick({R.id.btn_main_snackbar,R.id.btn_main_tabLayout,R.id.btn_main_navigationView})
    void Onclick(View view){
          switch (view.getId()){
              case R.id.btn_main_snackbar :
                  Snackbar.make(view,"test..snackbar",Snackbar.LENGTH_LONG)
                          .setAction("action", new View.OnClickListener() {
                              @Override
                              public void onClick(View v) {
                                  Toast.makeText(v.getContext(),"test..toast",Toast.LENGTH_LONG).show();
                                  Log.i("aaaaaaaaa","tessssssssst");
                              }
                          }).show();


                      textInputLayout.setError("errororoor");
                      textInputLayout.setErrorEnabled(true);
                  break;
          }

    }


    @Override
    public int getContentView() {
        return R.layout.fragment2;
    }

    @Override
    public void initView(View view) {
    }

    @Override
    public void init() {

    }


}
