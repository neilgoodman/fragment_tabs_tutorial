package net.neilgoodman.android.fragmenttabstutorial.activity;

import net.neilgoodman.android.fragmenttabstutorial.R;
import net.neilgoodman.android.fragmenttabstutorial.fragment.TabFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class FragmentTabActivity extends FragmentActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Notice how there is not very much code in the Activity. All the business logic for
        // rendering tab content and even the logic for switching between tabs has been pushed
        // into the Fragments. This is one example of how to organize your Activities with Fragments.
        // This benefit of this approach is that the Activity can be reorganized using layouts
        // for different devices and screen resolutions.
        setContentView(R.layout.activity_fragment_tab);
        
        // Grab the instance of TabFragment that was included with the layout and have it
        // launch the initial tab.
        FragmentManager fm = getSupportFragmentManager();
        TabFragment tabFragment = (TabFragment) fm.findFragmentById(R.id.fragment_tab);
        tabFragment.gotoListView();
    }

}
