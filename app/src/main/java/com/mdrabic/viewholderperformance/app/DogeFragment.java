package com.mdrabic.viewholderperformance.app;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class DogeFragment extends ListFragment {;

    public static DogeFragment newInstance() {
        return new DogeFragment();
    }

    public DogeFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new DogeAdapter(getActivity(), R.layout.doge_list_row_item, R.id.list_item_text_one, DogeContent.ITEMS));
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_doge_list, container, false);
    }
}
