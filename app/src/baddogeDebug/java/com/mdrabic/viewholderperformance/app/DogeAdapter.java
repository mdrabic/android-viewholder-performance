package com.mdrabic.viewholderperformance.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Debug;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * An Adapter#getView() method implemented in the worst way possible. No view recycling.
 * Always inflating the layout. Debug Tracing is enabled for the getView method.
 */
public class DogeAdapter extends ArrayAdapter<DogeContent.Doge> {

    private Drawable avatar;

    public DogeAdapter(Context context, int resource, int textViewResourceId, List<DogeContent.Doge> objects) {
        super(context, resource, textViewResourceId, objects);
        avatar = context.getResources().getDrawable(R.drawable.ic_doge_avatar);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Debug.startMethodTracing("bad_doge_debug");
        View view = getViewTest(position, convertView, parent);
        Debug.stopMethodTracing();
        return view;
    }

    private View getViewTest(int position, View convertView, ViewGroup parent) {
        DogeContent.Doge doge = getItem(position);
        LayoutInflater inflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.doge_list_row_item, parent, false);

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

