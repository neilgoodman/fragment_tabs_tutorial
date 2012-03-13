package net.neilgoodman.android.fragmenttabstutorial.adapter;

import net.neilgoodman.android.fragmenttabstutorial.R;
import net.neilgoodman.android.fragmenttabstutorial.model.LocationModel;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class LocationModelListAdapter extends BaseAdapter {

    private class ViewHolder {
        public TextView textView;
    }
    
    private LocationModel[] mLocations;
    private LayoutInflater  mInflater;
    
    public LocationModelListAdapter(Context context, LocationModel[] locations) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLocations = locations;
    }
    
    @Override
    public int getCount() {
        if (mLocations != null) {
            return mLocations.length;
        }
        
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (mLocations != null && position >= 0 && position < getCount()) {
            return mLocations[position];
        }
        
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (mLocations != null && position >= 0 && position < getCount()) {
            return mLocations[position].id;
        }
        
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
        View       view = convertView;
        ViewHolder viewHolder;
        
        if (view == null) {
            view = mInflater.inflate(R.layout.item_location_list, parent, false);
            
            viewHolder = new ViewHolder();
            viewHolder.textView = (TextView) view.findViewById(R.id.list_label);
            
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        
        LocationModel locationModel = mLocations[position];
        
        viewHolder.textView.setText(locationModel.address);
        
        return view;
    }

}
