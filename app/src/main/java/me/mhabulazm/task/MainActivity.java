package me.mhabulazm.task;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import me.mhabulazm.task.common.BaseActivity;
import me.mhabulazm.task.view.MostViewedItemsFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.container, new MostViewedItemsFragment(), "MostViewedItem");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }

}
