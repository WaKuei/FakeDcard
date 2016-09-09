package com.wakuei.fakedcard;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.wakuei.fakedcard.CustomAdapter.CustomAdapter;
import com.wakuei.fakedcard.Fragment.Fragment1;
import com.wakuei.fakedcard.Fragment.Fragment2;


public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private String forums = "";
    private ImageButton makerButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("全部");
        drawer = (DrawerLayout)findViewById(R.id.drawerLayout);
        makerButton = (ImageButton)findViewById(R.id.Lmakerbtn);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        tabLayout = (TabLayout)findViewById(R.id.tablayout);

        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        if(navigationView != null){
            navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener(){
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    forums = null;
                    int id = item.getItemId();
                    if (id == R.id.all) {
                        forums = "all";
                        toolbar.setTitle("全部");
                    } else if (id == R.id.pokemon) {
                        forums = "pokemon";
                        toolbar.setTitle("寶可夢");
                    } else if (id == R.id.bg) {
                        forums = "bg";
                        toolbar.setTitle("男女");
                    } else if (id == R.id.girl) {
                        forums = "girl";
                        toolbar.setTitle("女孩");
                    } else if (id == R.id.makeup) {
                        forums = "makeup";
                        toolbar.setTitle("美妝");
                    } else if (id == R.id.funny) {
                        forums = "funny";
                        toolbar.setTitle("有趣");
                    } else if (id == R.id.boy) {
                        forums = "boy";
                        toolbar.setTitle("男孩");
                    } else if (id == R.id.horoscopes) {
                        forums = "horoscopes";
                        toolbar.setTitle("星座");
                    } else if (id == R.id.food) {
                        forums = "food";
                        toolbar.setTitle("美食");
                    } else if (id == R.id.mood) {
                        forums = "mood";
                        toolbar.setTitle("心情");
                    } else if (id == R.id.pet) {
                        forums = "pet";
                        toolbar.setTitle("寵物");
                    } else if (id == R.id.trending) {
                        forums = "trending";
                        toolbar.setTitle("時事");
                    } else if (id == R.id.talk) {
                        forums = "talk";
                        toolbar.setTitle("閒聊");
                    } else if (id == R.id.movie) {
                        forums = "movie";
                        toolbar.setTitle("影劇");
                    } else if (id == R.id.job) {
                        forums = "job";
                        toolbar.setTitle("工作");
                    } else if (id == R.id.travel) {
                        forums = "travel";
                        toolbar.setTitle("旅遊");
                    } else if (id == R.id.sex) {
                        forums = "sex";
                        toolbar.setTitle("西斯");
                    }else if (id == R.id.appInfo){
                        appInfo();
                    }


                    if (forums != null) {
                        viewPager.removeAllViews();
                        setupViewPager(viewPager,forums);
//                        setupViewPager(viewPager,forums);
                    }

//                    item.setChecked(true);
                    drawer.closeDrawer(GravityCompat.START);
                    return true;
                }
            });
        }

//        CustomAdapter adapter = new CustomAdapter(getSupportFragmentManager());
        if(viewPager != null){
            setupViewPager(viewPager, "all");
        }
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

        makerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makerInfo();
            }
        });

    }

    private void setupViewPager(ViewPager viewPager, String forum){
        int type;
        switch (forum){
            case "all":
                type = 0;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "pokemon":
                type = 1;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "bg":
                type = 2;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "girl":
                type = 3;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "makeup":
                type = 4;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "funny":
                type = 5;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "boy":
                type = 6;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "horoscopes":
                type = 7;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "food":
                type = 8;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "mood":
                type = 9;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "pet":
                type = 10;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "trending":
                type = 11;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "talk":
                type = 12;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "movie":
                type = 13;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "job":
                type = 14;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "travel":
                type = 15;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;
            case "sex":
                type = 16;
                Fragment1.getType(type);
                Fragment2.getType(type);
                break;

        }
        CustomAdapter adapter = new CustomAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        //tabLayout.setVisibility(View.GONE);
        tabLayout.setupWithViewPager(viewPager);
    }
    public void onBackPressed(){
        assert drawer != null;
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
    private void makerInfo(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("作者資訊")
                .setMessage("作者：WaKuei Hsu\n\n請多多指教!!!")
                .setIcon(R.drawable.maker)
                .show();
    }
    private void appInfo(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("關於app")
                .setMessage("本app為練習之用所製作!\n\n" +
                        "資料來源皆為Dcard，使用Dcard之API進行練習,因此無法將app上架!\n\n" +
                        "感謝您的使用!!!")
                .setIcon(R.drawable.ic_info_black)
                .show();
    }
}
