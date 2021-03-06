package com.mehnaz.cookbookbymehnaz;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.mehnaz.cookbookbymehnaz.Adapter.FavoriteItems2Adapter;
import com.mehnaz.cookbookbymehnaz.Adapter.FavoriteItemsAdapter;
import com.mehnaz.cookbookbymehnaz.Adapter.RecyclerViewDataAdapter;
import com.mehnaz.cookbookbymehnaz.Adapter.ShortcutlistAdapter;
import com.mehnaz.cookbookbymehnaz.Models.FruitModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopDishesActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
@BindView(R.id.recyclerview)
RecyclerView listView;
FavoriteItemsAdapter adapter;

ArrayList<FruitModel> allSampleData;
        @BindView(R.id.recyclerview2)
        RecyclerView my_recycler_view;
//        @BindView(R.id.recyclerviewParent3)
//        RecyclerView my_recycler_view2;
//        @BindView(R.id.recyclerviewParent4)
//        RecyclerView my_recycler_view3;
ArrayList<FruitModel> imageModelArrayList;


        private int[] myImageList = new int[]{R.drawable.breakfast, R.drawable.lunch,R.drawable.frychicken, R.drawable.steak,R.drawable.cheesecake,R.drawable.noodls,R.drawable.soup,R.drawable.cholabhatura,R.drawable.pizza};
        private String[] data = new String[]{"Breakfast", "Lunch", "Snacks","Dinner","Desert","Thai","Chinese","Indian","Italian"};
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_dishes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ButterKnife.bind(this);
        successResult();


        }
private void successResult()
        {
        // data to populate the RecyclerView with
        //  String[] data = {"Bousorama", "Bousorama", "Bousorama"};


        imageModelArrayList = eatFruits();
        adapter = new FavoriteItemsAdapter(this, imageModelArrayList);
        listView.setAdapter(adapter);
        listView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));





        //  createDummyData();

        allSampleData = eatFruits();
        FavoriteItems2Adapter adapter = new FavoriteItems2Adapter(this, allSampleData);
        my_recycler_view.setAdapter(adapter);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

//        allSampleData = eatFruits();
//        RecyclerViewDataAdapter adapter2 = new RecyclerViewDataAdapter(this, allSampleData);
//        my_recycler_view2.setAdapter(adapter2);
//        my_recycler_view2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//
//        allSampleData = eatFruits();
//        RecyclerViewDataAdapter adapter3 = new RecyclerViewDataAdapter(this, allSampleData);
//        my_recycler_view3.setAdapter(adapter3);
//        my_recycler_view3.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

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
                        Intent intent = new Intent(this, ShortcutItemsActivity.class);
                        this.startActivity(intent);
                }
                else if (id == R.id.nav_favorite) {
                        Intent intent = new Intent(this,FavoriteDishesActivity.class);
                        this.startActivity(intent);
                } else if (id == R.id.nav_top_dishes) {
                        Intent intent = new Intent(this,TopDishesActivity.class);
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
