package com.le.www.retrofit_test_by_me_2;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.retrofit.ChunkingConverter;
import com.example.retrofit.Crawler;
import com.example.retrofit.DeserializeErrorBody;
import com.example.retrofit.ErrorHandlingAdapter;
import com.example.retrofit.JsonQueryParameters;
import com.example.retrofit.MyService;
import com.example.retrofit.SimpleMockService;
import com.example.retrofit.SimpleService;
import com.example.retrofit.SimpleService2;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (addPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
    }


    public void storeApi(View v) {
        startActivity(new Intent(getApplicationContext(), StoreActivity.class));
    }

    /**
     * 同步请求
     * @param v
     */
    public void syncRequest(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SimpleService.syncRequest();
//                    SimpleService2.syncRequestString();
//                    MyService.test();
//                    MyService.doGetSync();
//                    MyService.testByQueryMap();
//                    MyService.doPost();
//                    MyService.testPostFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void async(View v) {
        try {
            SimpleService.asyncRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void mockService(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    SimpleMockService.main();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void JsonQueryParameters(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    JsonQueryParameters.main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void errorHandlingAdapter(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ErrorHandlingAdapter.main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void deserializeErrorBody(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DeserializeErrorBody.main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void crawler(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Crawler.main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void chunkingConverter(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ChunkingConverter.main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public void annotatedConverters(View v) {

    }

    private boolean addPermission(Context context, String permission) {
        if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }
}
