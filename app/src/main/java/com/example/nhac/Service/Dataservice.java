package com.example.nhac.Service;

import com.example.nhac.Model.Album;
import com.example.nhac.Model.BaiHat;
import com.example.nhac.Model.ChuDe;
import com.example.nhac.Model.Playlist;
import com.example.nhac.Model.Quangcao;
import com.example.nhac.Model.TheLoai;
import com.example.nhac.Model.Theloaitrongngay;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("songbanner.php")
    Call<List<Quangcao>> GetDataBanner();

    @GET("playlistcurrentday.php")
    Call<List<Playlist>> GetPlaylistCurrentDay();

    @GET("chudutheloaitrongngay.php")
    Call<Theloaitrongngay> GetCategoryMusic();

    @GET("albumhot.php")
    Call<List<Album>> Getalbumhot();

    @GET("baihatduocthich.php")
    Call<List<BaiHat>> Getbaihat();


    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> GetDanhsachbaihattheoquangcao(@Field("idquangcao") String idquangcao);

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> GetDanhsachbaitheoplaylist(@Field("idPlayList") String idplaylist);

    @GET("Danhsachcacplaylist.php")
    Call<List<Playlist>> GetDanhsachcacPlaylist();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> GetDanhsachbaihattheotheloai (@Field("idtheloai") String idtheloai);

    @GET("Tatcachude.php")
    Call<List<ChuDe>> GetAllChuDe();

    @FormUrlEncoded
    @POST("theloaitheochude.php")
    Call<List<TheLoai>> GetTheloaitheochude(@Field("idchude") String idchude);

    @GET("tatcaalbum.php")
    Call<List<Album>> GetAllAlbum();

    @FormUrlEncoded
    @POST("danhsachbaihat.php")
    Call<List<BaiHat>> GetDanhsachbaihattheoalbum(@Field("idalbum") String idalbum);

    @FormUrlEncoded
    @POST("updateluotthich.php")
    Call<String> UpdateLuotThich(@Field("luotthich") String luotthich, @Field("idbaihat") String idbaihat);

    @FormUrlEncoded
    @POST("searchbaihat.php")
    Call<List<BaiHat>> GetSearchBaihat (@Field("tukhoa") String tukhoa);
}
