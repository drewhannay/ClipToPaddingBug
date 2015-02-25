package com.drewhannay.cliptopaddingdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // if you use LinearLayoutManager, everything works correctly
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));

        recyclerView.setAdapter(adapter);
    }

    private final RecyclerView.Adapter<DemoViewHolder> adapter = new RecyclerView.Adapter<DemoViewHolder>() {
        @Override
        public DemoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new DemoViewHolder(LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false));
        }

        @Override
        public void onBindViewHolder(DemoViewHolder holder, int position) {
            holder.title.setText("Item #" + position);
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    };

    private static class DemoViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public DemoViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView;
        }
    }
}
