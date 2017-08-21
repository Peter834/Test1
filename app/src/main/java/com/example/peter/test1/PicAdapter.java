package com.example.peter.test1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.IdentityHashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Peter on 2017/8/21.
 */

public class PicAdapter extends RecyclerView.Adapter<PicAdapter.PicViewHolder> {
    final String baseUrl="http://jfsc.quan-oo.com";
    private List<PictureEntity> mPicture;
    private Context mContext;
    private LayoutInflater inflater;
    public PicAdapter(Context mContext,List<PictureEntity> mPicture){
        this.mContext=mContext;
        this.mPicture=mPicture;
        inflater=LayoutInflater.from(mContext);
    }




    @Override
    public PicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.pic,parent,false);
        return new PicViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final PicViewHolder holder, int position) {

            final String baseUrl="http://jfsc.quan-oo.com";
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Picface picface=retrofit.create(Picface.class);
            Call<Pic11> call=picface.getpic();
            call.enqueue(new Callback<Pic11>() {
                @Override
                public void onResponse(Call<Pic11> call, Response<Pic11> response) {
//               Glide.with(MainActivity.this)
//                       .load(response.body().getData().getTop_pic().get(4).getT_pic()).into(imageview);
                    Glide.with(mContext)
                            .load(baseUrl+response.body().getData().getTop_pic().get(6).getT_pic()).into(holder.imageview);
                    //Log.i(response.toString(),"ss");
                }

                @Override
                public void onFailure(Call<Pic11> call, Throwable t) {

                }
            });

    }

    @Override
    public int getItemCount() {
        return mPicture.size();
    }


    public class PicViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageview;
        public PicViewHolder(View itemView) {
            super(itemView);
            imageview= (ImageView) itemView.findViewById(R.id.imview);
        }
    }
}
