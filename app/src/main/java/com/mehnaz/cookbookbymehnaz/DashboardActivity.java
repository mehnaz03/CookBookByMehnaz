package com.mehnaz.cookbookbymehnaz;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.mehnaz.cookbookbymehnaz.Adapter.DashboardAdapter;
import com.mehnaz.cookbookbymehnaz.Models.FruitModel;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    @BindView(R.id.recyclerview)
    RecyclerView listView;
    private DashboardAdapter adapter;
//    ArrayList<SubjectList> subjectList;
ArrayList<FruitModel> imageModelArrayList;
    private int[] myImageList = new int[]{R.drawable.noodls, R.drawable.pasta,R.drawable.meatball, R.drawable.cheesecake,R.drawable.steak,R.drawable.soup,R.drawable.soup,R.drawable.steak,R.drawable.steak};
    private String[] data = new String[]{"Breakfast", "Lunch", "Snacks","Dinner","Desert","Thai","Chinese","Indian","Italian"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        successResult();
    }

    private void successResult()
    {
        // data to populate the RecyclerView with
        //  String[] data = {"Bousorama", "Bousorama", "Bousorama"};

//        String[] data = {"Breakfast", "Lunch", "Snacks","Dinner","Thai","Chinese","Indian","Italian"};
//        String[] subtext ={"0","0.00%","Show results","EDIT Profile","0","0.00%","Show results","EDIT Profile"};

        int numberOfRows = 2;
        imageModelArrayList = eatFruits();
        listView.setLayoutManager(new GridLayoutManager(this, numberOfRows));
        adapter = new DashboardAdapter(this,imageModelArrayList);
        listView.setAdapter(adapter);




    }
    private ArrayList<FruitModel> eatFruits(){

        ArrayList<FruitModel> list = new ArrayList<>();

        for(int i = 0; i < 9; i++){
            FruitModel fruitModel = new FruitModel();
            fruitModel.setName(data[i]);
            fruitModel.setImage_drawable(myImageList[i]);
            list.add(fruitModel);
        }

        return list;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_category) {
           Intent intent = new Intent(this,DashboardActivity.class);
           this.startActivity(intent);
        } else if (id == R.id.nav_shortcuts) {
            Intent intent = new Intent(this,ShortcutItemsActivity.class);
            this.startActivity(intent);
        }
        else if (id == R.id.nav_favorite) {
            Intent intent = new Intent(this,FavoriteDishesActivity.class);
            this.startActivity(intent);
        } else if (id == R.id.nav_top_dishes) {
            Intent intent = new Intent(this,FavoriteDishesActivity.class);
            this.startActivity(intent);
        } else if (id == R.id.nav_tips_tricks) {
//            Intent intent = new Intent(this,LoginActivity.class);
//            this.startActivity(intent);
        }
     else if (id == R.id.nav_settings) {

    }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
