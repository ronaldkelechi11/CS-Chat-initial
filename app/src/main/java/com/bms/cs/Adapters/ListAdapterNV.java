package com.bms.cs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bms.cs.R;
import com.bms.cs.classes.Notes;

import java.util.ArrayList;

public class ListAdapterNV extends BaseAdapter {
    Context context;
    ArrayList<Notes> notesItem;

    public ListAdapterNV(Context context, ArrayList<Notes> notesItem) {
        this.context = context;
        this.notesItem = notesItem;
    }

    @Override
    public int getCount() {
        return notesItem.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.custom_notes_view, parent, false);

        TextView title = convertView.findViewById(R.id.NoteTxt);
        title.setText(notesItem.get(position).getTitle());


        return convertView;
    }
}
