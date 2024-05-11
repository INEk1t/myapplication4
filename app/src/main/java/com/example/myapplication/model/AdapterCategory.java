package com.example.myapplication.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class AdapterCategory extends RecyclerView.Adapter<AdapterCategory.CategoryViewHolder> {

    Context context;
    List<Locale.Category> categories;

    public AdapterCategory(Context context, List<Locale.Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public static final class CategoryViewHolder extends RecyclerView.ViewHolder {

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
