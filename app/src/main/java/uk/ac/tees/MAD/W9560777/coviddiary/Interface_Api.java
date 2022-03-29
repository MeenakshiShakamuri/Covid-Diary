package uk.ac.tees.MAD.W9560777.coviddiary;

        import java.net.URL;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Query;

public interface Interface_Api {

    public static String URL_BASE = "https://newsapi.org/v2/";

    @GET("top-headlines")
    abstract Call<Class_Main_News> getNews(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    abstract Call<Class_Main_News> getCategorical_News(
            @Query("country") String country,
            @Query("category") String category,
            @Query("pageSize") int pagesize,
            @Query("apiKey") String apiKey
    );


}
