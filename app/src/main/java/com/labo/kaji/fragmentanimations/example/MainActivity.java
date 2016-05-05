package com.labo.kaji.fragmentanimations.example;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.layout_main, ExampleFragment.newInstance(ExampleFragment.NODIR));
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        ExampleFragment f = (ExampleFragment)getSupportFragmentManager().findFragmentById(R.id.layout_main);
        switch (id) {
            case R.id.style_move:
                f.setAnimationStyle(ExampleFragment.AnimationStyle.MOVE);
                return true;
            case R.id.style_cube:
                f.setAnimationStyle(ExampleFragment.AnimationStyle.CUBE);
                return true;
            case R.id.style_flip:
                f.setAnimationStyle(ExampleFragment.AnimationStyle.FLIP);
                return true;
            case R.id.style_pushpull:
                f.setAnimationStyle(ExampleFragment.AnimationStyle.PUSHPULL);
                return true;
            case R.id.style_sides:
                f.setAnimationStyle(ExampleFragment.AnimationStyle.SIDES);
                return true;
            case R.id.style_cubemove:
                f.setAnimationStyle(ExampleFragment.AnimationStyle.CUBEMOVE);
                return true;
            case R.id.style_movecube:
                f.setAnimationStyle(ExampleFragment.AnimationStyle.MOVECUBE);
                return true;
            case R.id.style_pushmove:
                f.setAnimationStyle(ExampleFragment.AnimationStyle.PUSHMOVE);
                return true;
            case R.id.style_movepull:
                f.setAnimationStyle(ExampleFragment.AnimationStyle.MOVEPULL);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
