package com.route.islamimon.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.route.islamimon.Constants;
import com.route.islamimon.R;
import com.route.islamimon.adapters.VersesRecyclerAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SuraDetailsActivity extends AppCompatActivity {

    int pos;
    String name;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    VersesRecyclerAdapter adapter;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_details);
        recyclerView=findViewById(R.id.recycler_view);
        title=findViewById(R.id.name);
        pos = getIntent().getIntExtra(Constants.EXTRA_POSITION,-1);
        name = getIntent().getStringExtra(Constants.EXTRA_TITLE);
        title.setText(name);
        List<String> content = readSuraFromFile((pos+1) + ".txt");
        adapter=new VersesRecyclerAdapter(content);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

    }

    public List<String> readSuraFromFile(String fileName){

        List<String> data =new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(fileName)));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                //process line
                if(!mLine.isEmpty())
                    data.add(mLine);

            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }
        return data;
    }
}
