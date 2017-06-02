package com.junhee.android.myfragment;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ListFragment listFrag;
    DetailFragment detailFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createFrag();
        addList();

    }
    public void createFrag(){
        // 하위 버전 호환성을 위해 (support. v4 - API ver 4 이상부터 지원해줌)
        // support라는 단어가 붙은 클래스들은 버전 호환성을 위해 만들어짐
        listFrag = new ListFragment();
        detailFrag = new DetailFragment();
        listFrag.setActivity(this);
        detailFrag.setActivity(this);

    }


    public void addList(){

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, listFrag);
        transaction.addToBackStack(null);
        transaction.commit();


    }

    public void addDetail(){
        // transaction을 사용하면 스택구조로 움직일 수 있음
        // transaction을 통해 fragment
        // transaction에 커밋해줘야함
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.container, detailFrag);
        // 트랜젝션 처리 전체를 stack에 담아 놓았다가 안드로이드이ㅡ 백 버튼으로 뒤로가기를 할 수 있음

        transaction.addToBackStack(null);
        transaction.commit();

    }
    public void backToList(){
        // 뒤로가기
        super.onBackPressed();
    }



}
