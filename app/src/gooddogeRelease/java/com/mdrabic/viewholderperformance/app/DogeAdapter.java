package com.mdrabic.viewholderperformance.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Adapter reusing the convertView.
 */
public class DogeAdapter extends ArrayAdapter<DogeContent.Doge> {

    private Drawable avatar;

    public DogeAdapter(Context context, int resource, int textViewResourceId, List<DogeContent.Doge> objects) {
        super(context, resource, textViewResourceId, objects);
        avatar = context.getResources().getDrawable(R.drawable.ic_doge_avatar);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = getViewTest(position, convertView, parent);
        return view;
    }

    public View getViewTest(int position, View convertView, ViewGroup parent) {
        DogeContent.Doge doge = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.doge_list_row_item, parent, false);
        }

        ((ImageView) convertView.findViewById(R.id.list_item_avatar)).setImageDrawable(avatar);
        ((TextView) convertView.findViewById(R.id.list_item_text_one)).setText(doge.getTextOne() + " " + position);
        ((TextView) convertView.findViewById(R.id.list_item_text_two)).setText(doge.getTextTwo() + " " + position);
        ((TextView) convertView.findViewById(R.id.list_item_two_text_one)).setText(doge.getTextOne() + " " + position);
        ((TextView) convertView.findViewById(R.id.list_item_two_text_two)).setText(doge.getTextTwo() + " " + position);
        ((TextView) convertView.findViewById(R.id.list_item_three_text_one)).setText(doge.getTextOne() + " " + position);
        ((TextView) convertView.findViewById(R.id.list_item_three_text_two)).setText(doge.getTextTwo() + " " + position);

        return convertView;
    }
}

