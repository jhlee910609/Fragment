package com.junhee.android.myfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    Button btnDetail;
    MainActivity activity;


    public ListFragment() {
        // Required empty public constructor
    }


    @Override               // 이미 view로 만들어진 LayoutInflater
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Frangment의 메인 레이아웃을 inflate하고
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        // 내부의 위젯들을 코드로 연결해준다.
        btnDetail = (Button) view.findViewById(R.id.btnGoDetail);
        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.addDetail();

            }
        });
        return view;
    }

    public void setActivity(MainActivity activity){
        // 자신에게 activity 자체를 넘겨주는 것이 가장 리소스 자원을 아낄 수 있음
        // 객체지향에는 맞지 않는 설계
        this.activity = activity;
    }

}
