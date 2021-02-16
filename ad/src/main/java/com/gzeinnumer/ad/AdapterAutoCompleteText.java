package com.gzeinnumer.ad;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AdapterAutoCompleteText<T> extends ArrayAdapter<T> {

    int style = -1;
    private List<T> list = new ArrayList<>();
    private Context context;

    public AdapterAutoCompleteText(@NonNull Context context) {
        this(context, new ArrayList<>());
        this.context = context;
    }

    public AdapterAutoCompleteText(@NonNull Context context, @NonNull List<T> objects) {
        super(context, 0, objects);
        this.list = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.item_auto_textview, parent, false);

        T data = list.get(position);

        TextView name = listItem.findViewById(R.id.tv);
        if (style != -1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                name.setTextAppearance(style);
            }
        }
        name.setText(data.toString());

        return listItem;
    }


    public void setList(ArrayList<T> data) {
        this.list = data;
        notifyDataSetChanged();
    }

    public void setItemStyle(int style) {
        this.style = style;
    }
}
