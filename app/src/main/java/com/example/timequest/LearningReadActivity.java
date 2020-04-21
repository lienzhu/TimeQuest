package com.example.timequest;

import androidx.annotation.NonNull;
import androidx.annotation.XmlRes;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.timequest.ui.question.QuestionPage;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class LearningReadActivity extends AppCompatActivity {

    public static final String ARG_ITEM_ID = "LEARNING";
    private static final String TAG = "LearningReadActivity";

    private ImageView eraBanner;
    private TextView learningText;
    private Button takeTrial;
    private VideoView videoView;
    private MediaController mediaController;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning_read);


        String learningContent = getIntent().getStringExtra("LEARNING");
               Log.d(TAG, "on getIntent success:" + learningContent);

        learningText = findViewById(R.id.learningText);
        videoView = findViewById(R.id.videoView);
        Button takeTrial = findViewById(R.id.takeTrial);

        final String wikiUrl =
                //"https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=Legionary"
               "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=" + learningContent
                //+ PlanetActivity.name +"%20(planet)"
                ;

        Context context = getApplicationContext();
        final RequestQueue requestQueue = Volley.newRequestQueue(context);



        //grabs string and cleans it removing bracketed text and any newline characters
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String string = (response.substring(response.lastIndexOf("extract")+10,response.length()-5));
                //string = string.replace("\\n", "\n\n");
                string = string.replace("\n", "\n\n");
                string = string.replaceAll("\\(.*?\\)", "");
                learningText.setText(string);
                System.out.println(string);

                requestQueue.stop();
            }
        };

        //best practice error hadling
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse (VolleyError error) {
                System.out.println(error.toString());
            }
        };
        StringRequest stringRequest = new StringRequest(Request.Method.GET, wikiUrl, responseListener, errorListener);
        requestQueue.add(stringRequest);

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "BIqWKPA83V0";
                youTubePlayer.cueVideo(videoId, 0f);

            }

        });


        takeTrial.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), QuestionPage.class);
            intent.putExtra("LEARNING", learningContent);
            Log.d(TAG, "on putExtra Intent success:" + learningContent);
            startActivity(intent);
        });

    }

}

/** VIDEO PLAYING FROM YOUTUBE DOES NOT WORK WELL USING VIDEO VIEW
 //Video Player
 String videoURL ="https://m.www.youtube.com/watch?v=BIqWKPA83V0";
 //videoView.setVideoURI(Uri.parse(videoURL));
 videoView.setVideoPath(videoURL);
 mediaController = new MediaController(this);
 mediaController.setAnchorView(videoView);
 videoView.setMediaController(mediaController);

 //videoView.start();
 //videoView.setOnPreparedListener(mediaPlayer -> videoView.start());

 videoView.setOnTouchListener(
 (v, event) -> {
 videoView.start();
 videoView.requestFocus();
 return false;
 }
 );

 **/