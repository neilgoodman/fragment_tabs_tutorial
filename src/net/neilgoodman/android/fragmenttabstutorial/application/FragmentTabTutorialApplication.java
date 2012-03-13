package net.neilgoodman.android.fragmenttabstutorial.application;

import net.neilgoodman.android.fragmenttabstutorial.R;
import net.neilgoodman.android.fragmenttabstutorial.model.LocationModel;
import android.app.Application;

public class FragmentTabTutorialApplication extends Application {
    
    // This static field acts as the app's "fake" database of location data.
    public static final LocationModel[] sLocations = { 
        new LocationModel(0, "222 W. Washington Ave.", R.drawable.thumb_222_w_washington),
        new LocationModel(1, "150 E. Gilman St", R.drawable.thumb_150_e_gilman), 
        new LocationModel(2, "114 State St", R.drawable.thumb_114_state_st),
        new LocationModel(3, "23 N. Pinckney St", R.drawable.thumb_23_n_pinckney)
    };
}
