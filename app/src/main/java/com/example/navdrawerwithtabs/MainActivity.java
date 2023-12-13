package com.example.navdrawerwithtabs;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navView;
    ViewPager pager;
    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);


        PagerAdapter adapter = new pagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabLayout.setupWithViewPager(pager, true);


        drawerLayout = findViewById(R.id.drawer);
        navView = findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (item.getItemId() == R.id.chatMenu) {

            Intent intent = new Intent(this, chatMenu.class);
            startActivity(intent);
            Toast.makeText(this, "This is Chat Activity in Nav Drawar", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.statusMenu){
            Intent intent = new Intent(this, statusMenu.class);
            startActivity(intent);
            Toast.makeText(this, "This is Status Activity in Nav Drawar", Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.callMenu) {
            Intent intent = new Intent(this, callMenu.class);
            startActivity(intent);
            Toast.makeText(this, "This is Call Activity in Nav Drawar", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}