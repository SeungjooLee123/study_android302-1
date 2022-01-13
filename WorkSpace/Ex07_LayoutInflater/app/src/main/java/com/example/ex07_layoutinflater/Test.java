package com.example.ex07_layoutinflater;

import android.content.Context;
import android.view.LayoutInflater;

public class Test {
    public void onCreate(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //일반 클래스와 Activity또는 디자인단의 기능을 상속받은 클래스의 차이는
        //Os에서 제공하는 기능을 사용할수있는지 없는지의 차이가 가장 크다.
    }
}
