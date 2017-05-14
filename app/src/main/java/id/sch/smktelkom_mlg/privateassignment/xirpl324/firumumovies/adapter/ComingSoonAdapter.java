package id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.ComingSoon;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.model.Results;

/**
 * Created by Nadia Putri on 5/15/2017.
 */

public class ComingSoonAdapter extends RecyclerView.Adapter<ComingSoonAdapter.MyViewHolder> {
    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;
    ArrayList<Results> mlist;
    ComingSoon comingSoon;
    Context context;
    private int lastposition = -1;

    public ComingSoonAdapter(ComingSoon comingSoon, ArrayList<Results> mlist, Context context) {
        this.mlist = mlist;
        this.comingSoon = comingSoon;
        this.context = context;
    }

    @Override
    public ComingSoonAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ComingSoonAdapter.MyViewHolder holder, int position) {
        Results results = mlist.get(position);
        holder.tvName.setText(results.title);
        holder.tvDesc.setText(results.overview);
        image = url + results.backdrop_path;
        Glide.with(context).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (mlist != null)
            return mlist.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvDesc;
        ImageView imageView;

        public MyViewHolder(View v) {
            super(v);

            tvName = (TextView) v.findViewById(R.id.textViewJudul);
            tvDesc = (TextView) v.findViewById(R.id.textViewDeskripsi);
            imageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }
}
