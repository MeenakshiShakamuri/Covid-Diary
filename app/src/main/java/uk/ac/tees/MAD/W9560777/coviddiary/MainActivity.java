package uk.ac.tees.MAD.W9560777.coviddiary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    TabLayout layout_tab;
    String key_API = "183af7cffe5a40d1a5c499398a760edb";
    TabItem s_Home, s_Health, s_Science, s_Technology, s_Entertainment, s_Sports;
    PagerAdapter adapterPager;
    Toolbar s_Toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s_Toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(s_Toolbar);

        ViewPager viewPager = findViewById(R.id.fragment_container);
        layout_tab = findViewById(R.id.include);
        s_Entertainment = findViewById(R.id.entertainment);
        s_Science = findViewById(R.id.science);
        s_Sports = findViewById(R.id.sports);
        s_Health = findViewById(R.id.health);
        s_Technology = findViewById(R.id.technology);
        s_Home = findViewById(R.id.home);

        adapterPager = new Adapter_Pager(getSupportFragmentManager(),6);
        viewPager.setAdapter(adapterPager);


        layout_tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2
                        || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5 ){

                    adapterPager.notifyDataSetChanged();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(layout_tab));


    }
}