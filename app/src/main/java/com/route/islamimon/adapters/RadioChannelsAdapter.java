package com.route.islamimon.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.route.islamimon.R;
import com.route.islamimon.model.RadiosItem;

import java.util.List;

/**
 * Created by Abdulrahman Gaballah on 10/14/2019.
 * jaballah.9999@gmail.com
 */
public class RadioChannelsAdapter extends RecyclerView.Adapter<RadioChannelsAdapter.ViewHolder> {
    List<RadiosItem> channels;

    public RadioChannelsAdapter(List<RadiosItem> channels) {
        this.channels = channels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_radio_channel,parent,false);
        return new ViewHolder(view);
    }

    public void changeData(List<RadiosItem> radiosItems){
        this.channels = radiosItems;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final RadiosItem item = channels.get(position);
        holder.name.setText(item.getName());
        if(onPlayClickListener!=null)
            holder.play.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPlayClickListener.onItemClick(position,item);
                }
            });
        if(onStopClickListener!=null)
            holder.stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onStopClickListener.onItemClick(position,item);
                }
            });

    }
    OnItemClickListener onPlayClickListener;
    OnItemClickListener onStopClickListener;

    public void setOnPlayClickListener(OnItemClickListener onPlayClickListener) {
        this.onPlayClickListener = onPlayClickListener;
    }

    public void setOnStopClickListener(OnItemClickListener onStopClickListener) {
        this.onStopClickListener = onStopClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(int pos,RadiosItem item);
    }

    @Override
    public int getItemCount() {
        return channels == null? 0:channels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView play,stop;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.name);
            play= itemView.findViewById(R.id.play);
            stop= itemView.findViewById(R.id.stop);
        }
    }
}
