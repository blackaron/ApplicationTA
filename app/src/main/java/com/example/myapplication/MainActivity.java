package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Adapter_BottomBat.BottomAdapter;
import com.example.myapplication.Model.BottomBar.BottomItem;

public class MainActivity extends AppCompatActivity implements BottomAdapter.BottomItemClickInterface {
    private BottomBar bottomBar;

    private final int HOME = 0;
    private final int SEARCH = 1;
    private final int UPLOIAD = 2;
    private final int LIKES = 3;
    private final int PROFILE= 4;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomBar = new BottomBar(findViewById(R.id.BottomBar), MainActivity.this, MainActivity.this);
        initBottomItems();

    }

    private void initBottomItems(){
        BottomItem home     = new BottomItem(HOME, R.drawable.home, R.drawable.homefill, false);
        BottomItem search   = new BottomItem(SEARCH, R.drawable.search, R.drawable.searchfill, false);
        BottomItem upload   = new BottomItem(UPLOIAD,R.drawable.upload, R.drawable.upload,false);
        BottomItem likes    = new BottomItem(LIKES, R.drawable.likes, R.drawable.likesfill, true);
        BottomItem profile = new BottomItem(PROFILE, R.drawable.profile, R.drawable.profilefill, false);

        bottomBar.addBottomItem(home);
        bottomBar.addBottomItem(search);
        bottomBar.addBottomItem(upload);
        bottomBar.addBottomItem(likes);
        bottomBar.addBottomItem(profile);
    }


    @Override
    public void itemSelect(int itemId) {
        switch (itemId){
            case HOME:
                break;
            case SEARCH:
                break;
            case UPLOIAD:
            Toast.makeText(MainActivity.this, "upload a photo", Toast.LENGTH_LONG).show();
            break;
            case LIKES:
                break;
            case PROFILE:
                break;
        }
    }
}
