package com.example.nhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhac.Activity.DanhsachbaihatActivity;
import com.example.nhac.Model.Album;
import com.example.nhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Albumadapter extends RecyclerView.Adapter<Albumadapter.ViewHolder> {
    Context context;
    ArrayList<Album> mangalbum;


    public Albumadapter(Context context, ArrayList<Album> Mangalbum) {
        this.context = context;
        this.mangalbum = Mangalbum;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_album, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Album album = mangalbum.get(position);
        viewHolder.txttencasialbum.setText(album.getTenCaSiAlbum());
        viewHolder.txttenalbum.setText(album.getTenAlbum());
        Picasso.with(context).load(album.getHinhAlbum()).into(viewHolder.imghinhalbum);
    }

    @Override
    public int getItemCount() {
        return mangalbum.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imghinhalbum;
        TextView txttenalbum, txttencasialbum;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imghinhalbum = itemView.findViewById(R.id.imageviewalbum);
            txttenalbum = itemView.findViewById(R.id.textviewtenalbum);
            txttencasialbum = itemView.findViewById(R.id.textviewtencasialbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("album", mangalbum.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
