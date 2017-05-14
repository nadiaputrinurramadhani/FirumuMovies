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

import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.Popular;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.model.Results;

/**
 * Created by Nadia Putri on 5/14/2017.
 */

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.MyViewHolder> {
    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;
    ArrayList<Results> mList;
    Popular popular;
    Context context;
    private int lastposition = -1;

    public PopularAdapter(Popular popular, ArrayList<Results> mList, Context context) {
        this.mList = mList;
        this.popular = popular;
        this.context = context;
    }

    @Override
    public PopularAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        PopularAdapter.MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(PopularAdapter.MyViewHolder holder, int position) {
        Results results = mList.get(position);
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
        if (mList != null)
            return mList.size();
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvName;
        TextView tvDesc;

        public MyViewHolder(View v) {
            super(v);
            tvName = (TextView) v.findViewById(R.id.textViewJudul);
            tvDesc = (TextView) v.findViewById(R.id.textViewDeskripsi);
            imageView = (ImageView) v.findViewById(R.id.imageView);
        }
    }
}
