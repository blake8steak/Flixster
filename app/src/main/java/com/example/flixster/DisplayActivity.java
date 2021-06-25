package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.flixster.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcels;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import okhttp3.Headers;

public class DisplayActivity extends YouTubeBaseActivity {
    public String videoApiUrl;

    TextView movieTitle;
    TextView movieDesc;
    TextView ratingNum;
    RatingBar movieStars;
    Movie movie;
    ArrayList<String> videoResults;
    String videoId;

    public List<String> keysFromJsonArray(JSONArray videoJSONArr) throws JSONException {
        List<String> videos = new ArrayList<>();
        for(int i=0; i<videoJSONArr.length(); i++) {
            Log.d("MOVIEAPI", "Got here, adding "+videoJSONArr.getJSONObject(i).getString("key"));
            videos.add(videoJSONArr.getJSONObject(i).getString("key"));
            videos.size();
        }
        return videos;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        movieTitle = findViewById(R.id.movieTitle);
        movieDesc = findViewById(R.id.movieDesc);
        ratingNum = findViewById(R.id.ratingNum);
        movieStars = findViewById(R.id.movieStars);

        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Movie data for '%s'", movie.getTitle()));

        //getSupportActionBar().setTitle(movie.getTitle());
        movieTitle.setText(movie.getTitle());
        movieDesc.setText(movie.getOverview());
        ratingNum.setText(movie.getVoteAvg()+" / 10");
        movieStars.setRating(movie.getVoteAvg());

        //get correct movie preview
        final String TAG = "MOVIEAPI";
        videoResults = new ArrayList();
        videoId = "";
        videoApiUrl = "https://api.themoviedb.org/3/movie/"+movie.getMovieId()+"/videos?api_key="+MainActivity.apiKey+"&language=en-US";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(videoApiUrl, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {
                Log.d(TAG, "onSuccess");
                JSONObject jsonObject = json.jsonObject;
                try {
                    JSONArray results = jsonObject.getJSONArray("results");
                    Log.i(TAG, "Results: " + results.toString());
                    videoResults.addAll((ArrayList<String>) keysFromJsonArray(results));
                    videoId = videoResults.get(0);
                    Log.i(TAG, "VideoKey: " + videoId);
                    // resolve the player view from the layout
                    YouTubePlayerView playerView = (YouTubePlayerView) findViewById(R.id.player);

                    // initialize with API key stored in secrets.xml
                    playerView.initialize(getString(R.string.youtube_api_key), new YouTubePlayer.OnInitializedListener() {
                        @Override
                        public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                            YouTubePlayer youTubePlayer, boolean b) {
                            // do any work here to cue video, play video, etc.
                            youTubePlayer.cueVideo(videoId);
                        }

                        @Override
                        public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                            YouTubeInitializationResult youTubeInitializationResult) {
                            // log the error
                            Log.e("MovieTrailerActivity", "Error initializing YouTube player");
                        }
                    });
                } catch (JSONException e) {
                    Log.e(TAG, "Hit json exception");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG, "onFailure");
            }
        });
    }
}