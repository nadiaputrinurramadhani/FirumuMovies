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

import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.HomeFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.model.Now;

/**
 * Created by Nadia Putri on 5/13/2017.
 */

public class NowAdapter extends RecyclerView.Adapter<NowAdapter.ViewHolder> {
    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;
    ArrayList<Now> mList;
    HomeFragment homeFragment;
    Context context;
    private int lastposition = -1;


    public NowAdapter(HomeFragment homeFragment, ArrayList<Now> mList) {
        this.mList = mList;
        this.homeFragment = homeFragment;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Now now = mList.get(position);
        holder.tvJudul.setText(now.judul);
        holder.tvDeskripsi.setText(now.deskripsi);
        image = url + now.backdrop_path;
        Glide.with(context).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        if (mList != null)
            return mList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View v) {
            super(v);
            ivFoto = (ImageView) v.findViewById(R.id.imageView);
            tvJudul = (TextView) v.findViewById(R.id.textViewJudul);
            tvDeskripsi = (TextView) v.findViewById(R.id.textViewDeskripsi);
        }
    }
}
