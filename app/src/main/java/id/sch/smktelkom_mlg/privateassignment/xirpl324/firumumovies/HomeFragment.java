package id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.adapter.NowAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.model.Now;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    ArrayList<Now> mList = new ArrayList<>();
    NowAdapter mAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        mAdapter = new NowAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);
        return view;
    }
}
