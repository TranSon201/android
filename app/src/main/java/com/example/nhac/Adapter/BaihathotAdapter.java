package com.example.nhac.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nhac.Activity.PlayNhacActivity;
import com.example.nhac.Model.BaiHat;
import com.example.nhac.R;
import com.example.nhac.Service.APIService;
import com.example.nhac.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaihathotAdapter extends RecyclerView.Adapter<BaihathotAdapter.ViewHolder> {

    Context context;
    ArrayList<BaiHat> baiHatArrayList;

    public BaihathotAdapter(Context context, ArrayList<BaiHat> baiHatArrayList) {
        this.context = context;
        this.baiHatArrayList = baiHatArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_bat_hat_hot, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BaiHat baiHat = baiHatArrayList.get(i);
        viewHolder.txtcasi.setText(baiHat.getCasi());
        viewHolder.txtten.setText(baiHat.getTenbaihat());
        Picasso.with(context).load(baiHat.getHinhbaihat()).into(viewHolder.imghinh);
    }

    @Override
    public int getItemCount() {
        return baiHatArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtten, txtcasi;
        ImageView imghinh, imgluotthich, imgdownload;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.textviewtenbathathot);
            txtcasi = itemView.findViewById(R.id.textviewcasibaihathot);
            imghinh = itemView.findViewById(R.id.imageviewbaihathot);
            imgluotthich = itemView.findViewById(R.id.imageviewluotthich);
            imgdownload = itemView.findViewById(R.id.imageviewdownload);
            imgdownload.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        System.out.println(baiHatArrayList.get(0).getLinhbaihat());
                        new FileService().execute(baiHatArrayList.get(0).getLinhbaihat());

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlayNhacActivity.class);
                    intent.putExtra("cakhuc", baiHatArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgluotthich.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.UpdateLuotThich("1", baiHatArrayList.get(getPosition()).getIdbaihat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                            if (ketqua.equals("Success")) {
                                Toast.makeText(context, "Đã thích", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Lỗi!!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imgluotthich.setEnabled(false);
                }
            });
        }

        public class FileService extends AsyncTask<String, String, Void> {
            private Void download(String url)  {
                try {
                    String[] splt = url.split("/");
                    String filename = splt[splt.length - 1];
                    BufferedInputStream in = new BufferedInputStream(new URL(url).openStream());
                    FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory().toString() + "/" + filename);
                    byte dataBuffer[] = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                        fileOutputStream.write(dataBuffer, 0, bytesRead);
                    }
                } catch (IOException e) {

                }
                return null;
            }

            @Override
            protected Void doInBackground(String... strings) {
                return this.download(strings[0]);
            }

            @Override
            protected void onPostExecute(Void result) {
                System.out.println("Downloaded ");
            }
        }
    }

}
