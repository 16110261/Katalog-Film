package com.example.msi.katalogfilm0261;

        import retrofit2.Call;
        import retrofit2.http.GET;
        import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/now_playing")
    Call<Movie> getMovieNowPlaying(@Query("api_key") String apiKey);
}
