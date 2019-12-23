package com.example.nhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nhac.Activity.DanhsachbaihatActivity;
import com.example.nhac.Model.Playlist;
import com.example.nhac.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.ViewHoler> {
    Context context;
    ArrayList<Playlist> mangplaylist;

    public PlaylistAdapter(Context context, ArrayList<Playlist> mangplaylist) {
        this.context = context;
        this.mangplaylist = mangplaylist;
    }

    @NonNull
    @Override
    public PlaylistAdapter.ViewHoler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.dong_playlist1, viewGroup,false);

        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistAdapter.ViewHoler viewHoler, int position) {
        Playlist playlist = mangplaylist.get(position);
        viewHoler.txtTenPlaylist.setText(playlist.getTen());
        Picasso.with(context).load(playlist.getHinhIcon()).into(viewHoler.imgHinhPlaylist);
    }

    @Override
    public int getItemCount() {
        return mangplaylist.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        ImageView imgHinhPlaylist;
        TextView txtTenPlaylist;
        public ViewHoler(@NonNull View itemView) {

            super(itemView);
            imgHinhPlaylist= itemView.findViewById(R.id.imageviewplaylist1);
            txtTenPlaylist = itemView.findViewById(R.id.textviewtenplaylist1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("itemplaylist", mangplaylist.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
