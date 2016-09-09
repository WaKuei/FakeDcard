package com.wakuei.fakedcard.CustomAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wakuei.fakedcard.Fragment.Fragment1;
import com.wakuei.fakedcard.Fragment.Fragment2;


/**
 * Created by user on 2016/8/8/008.
 */
public class CustomAdapter extends FragmentPagerAdapter {
    private String fragments[] = {"熱門文章", "最新文章"};

    public CustomAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            default:
                return null;
        }
    }

    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments[position];
    }
}
