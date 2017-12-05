package com.example.martyna.powiadomienia;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Martyna on 2017-11-25.
 */

public class ListAdapter extends CursorAdapter {
    public ListAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView notifTextView = (TextView) view.findViewById(R.id.notif);
        TextView msgTextView = (TextView) view.findViewById(R.id.msg);

        String notif = "";
        String msg = "";

        notifTextView.setText(notif);
        msgTextView.setText(msg);
    }
}
