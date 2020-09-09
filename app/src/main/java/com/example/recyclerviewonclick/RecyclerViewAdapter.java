package com.example.recyclerviewonclick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<String> stringList;
    private RecyclerViewListener recyclerViewListener;

    public RecyclerViewAdapter(List<String> stringList, RecyclerViewListener recyclerViewListener) {
        this.stringList = stringList;
        this.recyclerViewListener = recyclerViewListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view, recyclerViewListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private LinearLayout container;
        private TextView textView;
        private RecyclerViewListener recyclerViewListener;
        private String text;

        public MyViewHolder(@NonNull View itemView, RecyclerViewListener recyclerViewListener) {
            super(itemView);
            this.recyclerViewListener = recyclerViewListener;

            container = itemView.findViewById(R.id.container);
            textView = itemView.findViewById(R.id.textView);
        }

        void bind(String text) {
            this.text = text;
            textView.setText(text);
            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            recyclerViewListener.onListItemClick(text);
        }
    }

    public interface RecyclerViewListener {
        void onListItemClick(String text);
    }
}
