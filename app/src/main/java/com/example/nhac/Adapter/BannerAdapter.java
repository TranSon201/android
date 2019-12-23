package com.example.nhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhac.Activity.DanhsachbaihatActivity;
import com.example.nhac.Model.Quangcao;
import com.example.nhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {

    Context context;
    ArrayList<Quangcao> arrayListbanner;

    public BannerAdapter(Context context, ArrayList<Quangcao> arrayListbanner) {
        this.context = context;
        this.arrayListbanner = arrayListbanner;
    }

    @Override
    public int getCount() {
        return arrayListbanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner, null);

        ImageView imgbackgoundbanner = view.findViewById(R.id.imageviewbackgroudbanner);
        ImageView imgsongbanner = view.findViewById(R.id.imageviewbanner);
        TextView txttitlesongbaihat = view.findViewById(R.id.textviewbannertitlebaihat);
        TextView txtnoidung = view.findViewById(R.id.textviewnoidung);

        Picasso.with(context).load(arrayListbanner.get(position).getHinhBaiHat()).into(imgsongbanner);
        Picasso.with(context).load(arrayListbanner.get(position).getHinhanh()).into(imgbackgoundbanner);
        txttitlesongbaihat.setText(arrayListbanner.get(position).getTenBaiHat());
        txtnoidung.setText(arrayListbanner.get(position).getNoidung());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Da click vao pase", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                intent.putExtra("banner", arrayListbanner.get(position));
                context.startActivity(intent);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

}
