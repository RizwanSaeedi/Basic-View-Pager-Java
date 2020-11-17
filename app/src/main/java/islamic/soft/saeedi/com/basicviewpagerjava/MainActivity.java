package islamic.soft.saeedi.com.basicviewpagerjava;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity
{
    private ViewPager mPager;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = findViewById(R.id.pager);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(adapter);

        tabLayout = findViewById(R.id.tabLayout);

        tabLayout.setupWithViewPager(mPager);
    }

    private class PagerAdapter extends FragmentStatePagerAdapter
    {

        public PagerAdapter(@NonNull FragmentManager fm)
        {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position)
        {
            return BlankFragment.newInstance(position);
        }

        @Override
        public int getCount()
        {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position)
        {
            return String.valueOf(position + 1);
        }
    }
}