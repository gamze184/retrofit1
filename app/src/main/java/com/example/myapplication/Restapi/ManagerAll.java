package com.example.myapplication.Restapi;

import android.content.SyncContext;

import com.example.myapplication.Models.Bilgiler;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    private static ManagerAll ourInstance=new ManagerAll();
    public static synchronized ManagerAll getInstance(){

        return ourInstance;
    }

public Call<List<Bilgiler>> getBilgiler(){

      Call<List<Bilgiler>> call=getRestApiClient().bilgiGetir();
      return call;

}
}
