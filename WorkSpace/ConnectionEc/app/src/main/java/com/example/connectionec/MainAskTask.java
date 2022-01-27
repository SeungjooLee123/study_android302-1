package com.example.connectionec;

import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainAskTask extends AsyncTask<String , String , InputStream> {
    HttpClient httpClient;
    HttpPost httpPost;
    MultipartEntityBuilder builder;
    final String HTTPIP = "http://192.168.0.27";
    final String SVRPATH = "/mid/";
    String mapping;
    private String postUrl ;
    ArrayList<ParamDTO> params = new ArrayList<>();
    public MainAskTask(String mapping) {
        this.mapping = mapping;
    }

    public void addParam(String key , String value){
        params.add(new ParamDTO(key , value));
    }

    @Override
    protected InputStream doInBackground(String... strings) {
        postUrl = HTTPIP + SVRPATH + mapping ;
        builder = MultipartEntityBuilder.create();
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        for(int i=0 ; i<params.size() ; i++){
                builder.addTextBody( params.get(i).getKey()  ,  params.get(i).getValue()
                , ContentType.create("Multipart/related" , "UTF-8") );
        }

        httpClient = AndroidHttpClient.newInstance("Android");//<=요청한 플랫폼(Android고정)
        httpPost = new HttpPost(postUrl);
        httpPost.setEntity(builder.build());
        InputStream in = null ;
        try {
             in = httpClient.execute(httpPost).getEntity().getContent();//실제 enter key <-
        } catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }
}
