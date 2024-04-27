package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        super(context, R.layout.task_item, tasks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Task task = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.task_item, null);
        }

        TextView idTextView = convertView.findViewById(R.id.tv_id);
        TextView idTextTextView = convertView.findViewById(R.id.tv_text);
        TextView idTextTypeView = convertView.findViewById(R.id.tv_type);

        idTextView.setText(String.valueOf(task.id));
        idTextTextView.setText(task.text);
        idTextTypeView.setText(String.valueOf(task.type));

        return convertView;
    }
}
