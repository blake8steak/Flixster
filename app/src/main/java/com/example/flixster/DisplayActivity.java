package com.example.flixster;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.flixster.models.Movie;

import org.parceler.Parcels;

public class DisplayActivity extends AppCompatActivity {
    TextView movieTitle;
    TextView movieDesc;
    TextView ratingNum;
    RatingBar movieStars;

    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        movieTitle = findViewById(R.id.movieTitle);
        movieDesc = findViewById(R.id.movieDesc);
        ratingNum = findViewById(R.id.ratingNum);
        movieStars = findViewById(R.id.movieStars);

        getSupportActionBar().setTitle("Movie");

        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Movie data for '%s'", movie.getTitle()));
    }
}