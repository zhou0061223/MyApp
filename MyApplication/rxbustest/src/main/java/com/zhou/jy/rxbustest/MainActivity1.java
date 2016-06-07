package com.zhou.jy.rxbustest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity1 extends AppCompatActivity {
    @Bind(R.id.btn_main_test1)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        ButterKnife.bind(this);

        Observable<String>  observable=RxBus.getInstance().register("aaaaaa");
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> {
                    Log.i("aaaaaaaaa",s);
                    Log.i("a","a");
                });

        btn.setOnClickListener(v->{
            Log.i("aaaaaaaa","test");
            RxBus.getInstance().post("hehehehhehe");
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.getInstance().unregister("aaaaaa");
    }
}
