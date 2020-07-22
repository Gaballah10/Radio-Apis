package com.route.islamimon.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.route.islamimon.R;

/**
 * Created by Abdulrahman Gaballah on 10/14/2019.
 * jaballah.9999@gmail.com
 */
public class SurasRecyclerAdapter
        extends RecyclerView.Adapter<SurasRecyclerAdapter.ViewHolder> {

    String [] items;

    public SurasRecyclerAdapter(String[] items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_sura,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final String name =items[position];
        holder.title.setText(name);
        if(onItemClickListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position,name);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if(items==null)return 0;
        return items.length;
    }

    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos,String name);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}
