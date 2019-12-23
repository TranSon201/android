package com.example.nhac.Service;

public class APIService {
    private static String base_url = "https://appnhacmp3.000webhostapp.com/Server/";

    public static Dataservice getService(){{
        return APIRetrofitClient.getClienr(base_url).create(Dataservice.class);
    }
    }
}
