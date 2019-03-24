package com.example.atd;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.atd.TabsDown.FragmentTabsDown_Add;
import com.example.atd.TabsDown.FragmentTabsDown_Discover;
import com.example.atd.TabsDown.FragmentTabsDown_Maps;
import com.example.atd.TabsDown.FragmentTabsDown_Profile;
import com.example.atd.TabsDown.FragmentTabsDown_Saved;

public class MainActivity extends AppCompatActivity
{
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;

    FragmentTabsDown_Add fragmentTabsDown_add;
    FragmentTabsDown_Discover fragmentTabsDown_discover;
    FragmentTabsDown_Maps fragmentTabsDown_maps;
    FragmentTabsDown_Profile fragmentTabsDown_profile;
    FragmentTabsDown_Saved fragmentTabsDown_saved;

    @Override
    public void onBackPressed()
    {
        moveTaskToBack(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        frameLayout = (FrameLayout) findViewById(R.id.framelayout_bottom);

        fragmentTabsDown_add = new FragmentTabsDown_Add();
        fragmentTabsDown_discover = new FragmentTabsDown_Discover();
        fragmentTabsDown_maps = new FragmentTabsDown_Maps();
        fragmentTabsDown_profile = new FragmentTabsDown_Profile();
        fragmentTabsDown_saved = new FragmentTabsDown_Saved();

        setFragment(fragmentTabsDown_discover);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {

                switch (item.getItemId())
                {
                    case R.id.tab_bottom_discover:
                        setFragment(fragmentTabsDown_discover);
                        return true;

                    case R.id.tab_bottom_maps:
                        setFragment(fragmentTabsDown_maps);
                        return true;

                    case R.id.tab_bottom_add:
                        setFragment(fragmentTabsDown_add);
                        return true;

                    case R.id.tab_bottom_save:
                        setFragment(fragmentTabsDown_saved);
                        return true;

                    case R.id.tab_bottom_profile:
                        setFragment(fragmentTabsDown_profile);
                    return true;

                    default:
                        return false;
                }
            }
        });
    }

    public void setFragment(Fragment fragment)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.framelayout_bottom, fragment);
        fragmentTransaction.commit();
    }
}
