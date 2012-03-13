package net.neilgoodman.android.fragmenttabstutorial.fragment;

import net.neilgoodman.android.fragmenttabstutorial.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class TabFragment extends Fragment {

    private static final int LIST_STATE = 0x1;
    private static final int GRID_STATE = 0x2;
    
    private int mTabState;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        
        // Grab out tab buttons from the layout and attach event handlers. The code just uses standard
        // buttons for the tab widgets. These are bad tab widgets, design something better, this is just
        // to keep the code simple.
        Button listViewTab = (Button) view.findViewById(R.id.list_view_tab);
        Button gridViewTab = (Button) view.findViewById(R.id.grid_view_tab);
        
        listViewTab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch the tab content to display the list view.
                gotoListView();
            }
        });
        
        gridViewTab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Switch the tab content to display the grid view.
                gotoGridView();
            }
        });
        
        return view;
    }
    
    public void gotoListView() {
        // mTabState keeps track of which tab is currently displaying its contents.
        // Perform a check to make sure the list tab content isn't already displaying.
        
        if (mTabState != LIST_STATE) {
            // Update the mTabState 
            mTabState = LIST_STATE;
            
            // Fragments have access to their parent Activity's FragmentManager. You can
            // obtain the FragmentManager like this.
            FragmentManager fm = getFragmentManager();
            
            if (fm != null) {
                // Perform the FragmentTransaction to load in the list tab content.
                // Using FragmentTransaction#replace will destroy any Fragments
                // currently inside R.id.fragment_content and add the new Fragment
                // in its place.
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_content, new LocationListFragment());
                ft.commit();
            }
        }
    }
    
    public void gotoGridView() {
        // See gotoListView(). This method does the same thing except it loads
        // the grid tab.
        
        if (mTabState != GRID_STATE) {
            mTabState = GRID_STATE;
            
            FragmentManager fm = getFragmentManager();
            
            if (fm != null) {
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_content, new LocationGridFragment());
                ft.commit();
            }
        }
    }

}
