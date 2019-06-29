package android.example.cs496;

import android.example.cs496.ui.main.SectionsPagerAdapter;
import android.example.cs496.ui.main.TabFragment1;
import android.example.cs496.ui.main.TabFragment2;
import android.example.cs496.ui.main.TabFragment3;
import android.example.cs496.ui.main.fragment1.dummyData;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;

import static android.example.cs496.ui.main.fragment1.dummyData.setInitialData;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager viewPager;
    SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Initializing the TabLayout;
        tabs = findViewById(R.id.tabs);
        try {
            new dummyData();
            setInitialData();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Initializing ViewPager
        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.setupWithViewPager(viewPager);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    public void setupViewPager(ViewPager mViewPager) {
        sectionsPagerAdapter.addFragment(new TabFragment1(), "Phone");
        sectionsPagerAdapter.addFragment(new TabFragment2(), "Photos");
        sectionsPagerAdapter.addFragment(new TabFragment3(), "Weather");
        mViewPager.setAdapter(sectionsPagerAdapter);
    }
}