package me.mhabulazm.task;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import me.mhabulazm.task.common.BaseActivity;
import me.mhabulazm.task.view.MostViewedItemsFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment(new MostViewedItemsFragment(), false);
    }

    public void addFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        String tag = fragment.getClass().getSimpleName();
        fragmentTransaction.replace(R.id.container, fragment, tag);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        if (addToBackStack) fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }

}
