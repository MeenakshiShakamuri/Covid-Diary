package uk.ac.tees.MAD.W9560777.coviddiary;

import static uk.ac.tees.MAD.W9560777.coviddiary.Interface_Api.URL_BASE;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Utilities_Api {

    private static Retrofit retrofit = null;

    public static Interface_Api getApiInterface(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Interface_Api.URL_BASE).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Interface_Api.class);
    }




}
