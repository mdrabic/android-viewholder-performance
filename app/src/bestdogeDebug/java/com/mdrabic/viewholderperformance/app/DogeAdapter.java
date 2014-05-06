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

/*
 * Adapter using ViewHolder pattern
 */
public class DogeAdapter extends ArrayAdapter<DogeContent.Doge> {

    private Drawable avatar;

    public DogeAdapter(Context context, int resource, int textViewResourceId, List<DogeContent.Doge> objects) {
        super(context, resource, textViewResourceId, objects);
        avatar = context.getResources().getDrawable(R.drawable.ic_doge_avatar);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Debug.startMethodTracing("best_doge_debug");
        View view = getViewTest(position, convertView, parent);
        Debug.stopMethodTracing();
        return view;
    }

    public View getViewTest(int position, View convertView, ViewGroup parent) {
        Holder holder;
        DogeContent.Doge doge = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.doge_list_row_item, parent, false);
            holder = new Holder();
            holder.avatar = (ImageView) convertView.findViewById(R.id.list_item_avatar);
            holder.textOne = (TextView) convertView.findViewById(R.id.list_item_text_one);
            holder.textTwo = (TextView) convertView.findViewById(R.id.list_item_text_two);
            holder.textTwoOne = (TextView) convertView.findViewById(R.id.list_item_two_text_one);
            holder.textTwoTwo = (TextView) convertView.findViewById(R.id.list_item_two_text_two);
            holder.textThreeOne = (TextView) convertView.findViewById(R.id.list_item_three_text_one);
            holder.textThreeTwo = (TextView) convertView.findViewById(R.id.list_item_three_text_two);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.avatar.setImageDrawable(avatar);
        holder.textOne.setText(doge.getTextOne() + " " + position);
        holder.textTwo.setText(doge.getTextTwo() + " " + position);
        holder.textTwoOne.setText(doge.getTextOne() + " " + position);
        holder.textTwoTwo.setText(doge.getTextTwo() + " " + position);
        holder.textThreeOne.setText(doge.getTextOne() + " " + position);
        holder.textThreeTwo.setText(doge.getTextTwo() + " " + position);

        return convertView;
    }

    private class Holder {
        ImageView avatar;
        TextView textOne;
        TextView textTwo;
        TextView textTwoOne;
        TextView textTwoTwo;
        TextView textThreeOne;
        TextView textThreeTwo;
    }
}