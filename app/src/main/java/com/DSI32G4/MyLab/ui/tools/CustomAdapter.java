package com.DSI32G4.MyLab.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.DSI32G4.MyLab.R;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItems;

    CustomAdapter(Context context, List<RowItem> rowItems){
        this.context=context;
        this.rowItems=rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    private class ViewHolder{
        ImageView pin;
        TextView titre;
        TextView desc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = inflater.inflate(R.layout.activity_list_item_centre,null);
            holder = new ViewHolder();

            holder.titre = (TextView) convertView.findViewById(R.id.item_title);
            holder.pin = (ImageView) convertView.findViewById(R.id.item_image);
            holder.desc = (TextView) convertView.findViewById(R.id.item_detail);

            RowItem row_pos = rowItems.get(position);




            //holder.pin.setImageResource(row_pos.getPin());
            holder.titre.setText(row_pos.getTitle());
            holder.desc.setText(row_pos.getLocal());

            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }
}
