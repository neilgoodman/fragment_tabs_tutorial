package net.neilgoodman.android.fragmenttabstutorial.fragment;

import net.neilgoodman.android.fragmenttabstutorial.R;
import net.neilgoodman.android.fragmenttabstutorial.adapter.LocationModelGridAdapter;
import net.neilgoodman.android.fragmenttabstutorial.application.FragmentTabTutorialApplication;
import net.neilgoodman.android.fragmenttabstutorial.model.LocationModel;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class LocationGridFragment extends Fragment {
    
    private GridView                 mGridView;
    private LocationModelGridAdapter mGridAdapter;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location_grid, container, false);
        
        // Store a pointer to the GridView that powers this grid fragment.
        mGridView = (GridView) view.findViewById(R.id.grid_view);
        
        return view;
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Activity activity = getActivity();
        
        if (activity != null) {
            // Create an instance of the custom adapter for the GridView. A static array of location data
            // is stored in the Application sub-class for this app. This data would normally come
            // from a database or a web service.
            mGridAdapter = new LocationModelGridAdapter(activity, FragmentTabTutorialApplication.sLocations);
            
            if (mGridView != null) {
                mGridView.setAdapter(mGridAdapter);
            }
            
            // Setup our onItemClickListener to emulate the onListItemClick() method of ListFragment.
            mGridView.setOnItemClickListener(new OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    onGridItemClick((GridView) parent, view, position, id);
                }
                
            });
        }
    }
    
    public void onGridItemClick(GridView g, View v, int position, long id) {
        Activity activity = getActivity();
        
        if (activity != null) {
            LocationModel locationModel = (LocationModel) mGridAdapter.getItem(position);
            
            // Display a simple Toast to demonstrate that the click event is working. Notice that Fragments have a
            // getString() method just like an Activity, so that you can quickly access your localized Strings.
            Toast.makeText(activity, getString(R.string.toast_item_click) + locationModel.address, Toast.LENGTH_SHORT).show();
        }
    }

}
