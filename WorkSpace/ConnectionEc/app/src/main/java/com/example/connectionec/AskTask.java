package com.example.connectionec;

import android.content.Context;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;

import com.google.gson.Gson;

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

//AsyncTask
//1.extends <-
public class AskTask extends AsyncTask<String , String , InputStream> {
    HttpClient httpClient;// 접속을 위한 객체
    HttpPost httpPost; //Post요청을 하기 위한 객체
    MultipartEntityBuilder builder;
    // Web => Web (File빼고는 MultiPart처리가 필요없음)
    //  http => http 프로토콜 같음.( req , res )
    // Android,Iot,기기(여러가지) => Web(WAS) 요청 Multipart 처리가 필요함.
    //  http => http 프로토콜의 바디 부분에 데이터를 써서 나눠서 보내는 형태
    final String HTTPIP = "http://192.168.0.27";//ipconfig ( cmd 에서 확인 )
    final String SVRPATH = "/mid/";
    String mapping;
    private String postUrl ;
    ArrayList<ParamDTO> params = new ArrayList<>();
    public AskTask(String mapping) {
        this.mapping = mapping;
    }

    public void addParam(String key , String value){
        params.add(new ParamDTO(key , value));
    }

 //   MainActivity activity;
 //   ArrayList<String> params;
//    String paramdata ;
//
//    public AskTask(String mapping, String paramdata) {
//        this.mapping = mapping;
//        this.paramdata = paramdata;
//    }
//
//    public AskTask(String mapping, ArrayList<String> params , int a) {
//        this.mapping = mapping;
//        this.params = params;
//    }
//
//    public AskTask(String mapping, MainActivity activity) {
//        this.mapping = mapping;
//        this.activity = activity;
//    }



    @Override
    protected InputStream doInBackground(String... strings) {
        postUrl = HTTPIP + SVRPATH + mapping ;//url에 넣고 enter key쳤을때 (요청,주소)
        builder = MultipartEntityBuilder.create();//빌더 초기화식.(가져다가쓰면됨)
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);//인터넷 켜놓고 엔터치는 형식
        //↑위에 부분까지는 고정 된 부분
        // 나중에 파라메터를 추가하는 부분 (나중에 추가할것)
        // MultiPart ( 여러부분으로 나누어진 ) 에서 데이터를 보낼땐 String
        // => json [] 리스트 , { } 오브젝트
        // params [0] : 검색조건 String search = "닉네임"
        // params [1] : LoginDTO { key : value }
        for(int i=0 ; i<params.size() ; i++){
                builder.addTextBody( params.get(i).getKey()  ,  params.get(i).getValue()
                , ContentType.create("Multipart/related" , "UTF-8") );
        }

                //        builder.addTextBody( "size"  , params.size()+""
//                , ContentType.create("Multipart/related" , "UTF-8") );
//        for(int i = 0 ; i<params.size(); i ++){
//            builder.addTextBody( "param" + i , params.get(i)
//                    , ContentType.create("Multipart/related" , "UTF-8") );
//        }
//            builder.addTextBody( "key" , "value"
//            , ContentType.create("Multipart/related" , "UTF-8") );

        // 파라메터를 입력받는부분을 확장성있게 코딩을하면 계속해서 사용가능함.

        //↓고정 된 부분 ( 고정 된 부분은 절대 외우거나 깊게 공부할필요가 없음
        // 대충의 흐름을 이해하는게 중요함 )
        httpClient = AndroidHttpClient.newInstance("Android");//<=요청한 플랫폼(Android고정)
        httpPost = new HttpPost(postUrl);
        httpPost.setEntity(builder.build());
        InputStream in = null ;
        try {

             in = httpClient.execute(httpPost).getEntity().getContent();//실제 enter key <-
            //Gson gson = new Gson();
            //MemberDTO dto = gson.fromJson(new InputStreamReader(in), MemberDTO.class);
            //String aaa = "";
            //rtnData = rtnString(in); <= 초기 Servlet(미들웨어)만들고 테스트용.
           //activity.setText(aa);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return in;
    }//do

    public String rtnString(InputStream in) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder strbrd = new StringBuilder();
        String line = null;
        while( (line = reader.readLine()) != null ){
            strbrd.append( line);

        }

        return strbrd.toString();
    }



}
