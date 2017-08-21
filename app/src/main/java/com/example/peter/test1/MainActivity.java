package com.example.peter.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<PictureEntity> mPicture=new ArrayList<>();
    private RecyclerView recyclerView;
    private ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ImageView imageView= (ImageView) findViewById(R.id.imagetest);
        /*Glide.with(this)
                .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
                .into(imageView);*/
        RecyclerView rview= (RecyclerView) findViewById(R.id.rview);
        initdata();
        recyclerView = (RecyclerView) findViewById(R.id.rview);
        PicAdapter adapter=new PicAdapter(this,mPicture);
        LinearLayoutManager layoutmanager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutmanager);
        recyclerView.setAdapter(adapter);
        //getPic();
    }

    private void initview() {
    }

    private void initdata() {
        for(int i=0;i<6;i++){
            PictureEntity Pic1=new PictureEntity("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png");
            mPicture.add(Pic1);
        }
    }
//    private void getPic(){
//        final String baseUrl="http://jfsc.quan-oo.com";
//        Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        Picface picface=retrofit.create(Picface.class);
//        Call<Pic11> call=picface.getpic();
//        call.enqueue(new Callback<Pic11>() {
//            @Override
//            public void onResponse(Call<Pic11> call, Response<Pic11> response) {
//                //imageview= (ImageView) findViewById(R.id.imagetest);
////               Glide.with(MainActivity.this)
////                       .load(response.body().getData().getTop_pic().get(4).getT_pic()).into(imageview);
//                Glide.with(MainActivity.this)
//                       .load(baseUrl+response.body().getData().getTop_pic().get(6).getT_pic()).into(imageview);
//               //Log.i(response.toString(),"ss");
//            }
//
//            @Override
//            public void onFailure(Call<Pic11> call, Throwable t) {
//
//            }
//        });
//    }


}
