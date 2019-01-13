package com.example.piata.ezbus;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;
    private MapFragment mapFragment;
    private PocketFragment pocketFragment;
    private BuyFragment buyFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.tab1:
                    setFragment(mapFragment);
                    return true;
                case R.id.tab2:
                    setFragment(pocketFragment);
                    return true;
                case R.id.tab3:
                    setFragment(buyFragment);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainNav = findViewById(R.id.main_nav);
        mMainFrame = findViewById(R.id.main_frame);
        mapFragment = new MapFragment();
        pocketFragment = new PocketFragment();
        buyFragment = new BuyFragment();

        setFragment(mapFragment);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.main_nav);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

}
