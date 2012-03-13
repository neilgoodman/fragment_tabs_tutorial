package net.neilgoodman.android.fragmenttabstutorial.fragment;

import net.neilgoodman.android.fragmenttabstutorial.R;
import net.neilgoodman.android.fragmenttabstutorial.adapter.LocationModelListAdapter;
import net.neilgoodman.android.fragmenttabstutorial.application.FragmentTabTutorialApplication;
import net.neilgoodman.android.fragmenttabstutorial.model.LocationModel;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LocationListFragment extends ListFragment {
    
    // ListFragment is a very useful class that provides a simple ListView inside of a Fragment.
    // This class is meant to be sub-classed and allows you to quickly build up list interfaces
    // in your app.
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        Activity activity = getActivity();
        
        if (activity != null) {
            // Create an instance of the custom adapter for the GridView. A static array of location data
            // is stored in the Application sub-class for this app. This data would normally come
            // from a database or a web service.
            ListAdapter listAdapter = new LocationModelListAdapter(activity, FragmentTabTutorialApplication.sLocations);
            setListAdapter(listAdapter);
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Activity activity = getActivity();
        
        if (activity != null) {   
            ListAdapter listAdapter = getListAdapter();
            LocationModel locationModel = (LocationModel) listAdapter.getItem(position);
            
            // Display a simple Toast to demonstrate that the click event is working. Notice that Fragments have a
            // getString() method just like an Activity, so that you can quickly access your localized Strings.
            Toast.makeText(activity, getString(R.string.toast_item_click) + locationModel.address, Toast.LENGTH_SHORT).show();
        }
    }
       
}
