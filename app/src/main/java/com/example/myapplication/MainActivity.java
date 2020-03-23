package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.myapplication.Models.Bilgiler;
import com.example.myapplication.Restapi.ManagerAll;
import com.example.myapplication.adapters.adapterbilgi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
List<Bilgiler> list;
ListView ListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        istek();
    }
    public void tanimla()
    {

        ListView=(ListView)findViewById(R.id.list_view);
    }


    public void istek(){
        list = new ArrayList<>();

        Call<List<Bilgiler>>bilgiList= ManagerAll.getInstance().getBilgiler();
        bilgiList.enqueue(new Callback<List<Bilgiler>>() {
            @Override
            public void onResponse(Call<List<Bilgiler>> call, Response<List<Bilgiler>> response) {
              if(response.isSuccessful())  {
                    list=response.body();
                    adapterbilgi adp=new adapterbilgi(list,getApplicationContext());
                  ListView.setAdapter(adp);

                }

            }

            @Override
            public void onFailure(Call<List<Bilgiler>> call, Throwable t) {

            }
        });

    }
}
