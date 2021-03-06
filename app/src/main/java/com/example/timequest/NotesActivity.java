package com.example.timequest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.timequest.Adapters.NotesAdapter;
import com.example.timequest.Entities.Era;

import java.util.List;

public class NotesActivity extends AppCompatActivity {


    public static final String EXTRA_MESSAGE = "TOPIC";
    private boolean mTwoPane;
    public static AppDatabase db;
    private RecyclerView notesList;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        notesList = findViewById(R.id.rvListNotes);
        notesList.setHasFixedSize(true);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient));
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(R.layout.abs_layout);




        mLayoutManager = new LinearLayoutManager(this);
        notesList.setLayoutManager(mLayoutManager);
        NotesAdapter.RecyclerViewClickListener listener = new NotesAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                launchDetailActivity(position);

            }
        };
        mAdapter = new NotesAdapter(Era.addEraData(), listener);
        notesList.setAdapter(mAdapter);

/**
        NotesAdapter mNotesAdapter = new NotesAdapter(Era.addEraData(), listener);


        notes = db.notesDAO().getNotes();


        db = AppDatabase.getInstance(getApplicationContext());
 **/
    }

    private void launchDetailActivity(int position){
        Intent intent = new Intent(this, NotesDetail.class);
        intent.putExtra(EXTRA_MESSAGE, position);
        startActivity(intent);
    }

}