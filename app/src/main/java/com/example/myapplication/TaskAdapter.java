package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    Context context;
    List<Task> tasks;

    public TaskAdapter(Context context, List<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemItems = LayoutInflater.from(context).inflate(R.layout.task_item, parent, false);
        return new TaskAdapter.TaskViewHolder(itemItems);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        if (position < tasks.size()) { // Проверка на валидность индекса
            Task currentTask = tasks.get(position);
        //holder.taskBg.setCardBackgroundColor(Color.parseColor(tasks.get(position).getColor()));
        int imageId = context.getResources().getIdentifier("ic_" + tasks.get(position).getImg(), "drawable", context.getPackageName());
        holder.taskImage.setImageResource(imageId);
        holder.taskTitle.setText(tasks.get(position).getTitle());
        holder.taskType.setText(tasks.get(position).getType());
        holder.taskNumber.setText(tasks.get(position).getNumber());
        }
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static final class TaskViewHolder extends RecyclerView.ViewHolder {

        //CardView taskBg;
        ImageView taskImage;
        TextView taskTitle, taskType, taskNumber;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            taskImage = itemView.findViewById(R.id.imageView2);
            taskTitle = itemView.findViewById(R.id.itemTitle);
            taskType = itemView.findViewById(R.id.typeItem);
            taskNumber = itemView.findViewById(R.id.seller_contacts);
        }
    }
}
