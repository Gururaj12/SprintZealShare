package com.sprintzeal.sprint.sprintzeal.Tabs;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sprintzeal.sprint.sprintzeal.Tabs.CancelTab;
import com.sprintzeal.sprint.sprintzeal.Tabs.DevicesTab;


public class Pager extends FragmentStatePagerAdapter {
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                CancelTab tab1 = new CancelTab();
                return tab1;
            case 1:
                DevicesTab tab2 = new DevicesTab();
                return tab2;
            case 2:
                DevicesTab tab3 = new DevicesTab();
               // PriceTab tab3 = new PriceTab();
                return tab3;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
