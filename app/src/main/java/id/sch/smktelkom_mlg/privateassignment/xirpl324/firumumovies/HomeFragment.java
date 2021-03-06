package id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.adapter.MyAdapter;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.model.Results;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.model.ResultsRespons;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.service.GsonGetRequest;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.service.VolleySingleton;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    ArrayList<Results> mList = new ArrayList<>();
    MyAdapter myAdapter;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        myAdapter = new MyAdapter(this, mList, getContext());
        rv.setAdapter(myAdapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        downloadDataSources();

        return rootView;
    }

    private void downloadDataSources() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=577e733b8e412c4d995ab7f3cc4a1002&language=en-US&page=1";

        GsonGetRequest<ResultsRespons> myRequest = new GsonGetRequest<ResultsRespons>
                (url, ResultsRespons.class, null, new Response.Listener<ResultsRespons>() {
                    @Override
                    public void onResponse(ResultsRespons response) {
                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(response)));
                        fillColor(response.results);
                        mList.addAll(response.results);
                        myAdapter.notifyDataSetChanged();
                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("FLOW", "onErrorRespose: ", error);
                    }
                });
        VolleySingleton.getInstance(this).addToRequestQueue(myRequest);
    }

    private void fillColor(List<Results> results) {
        for (int i = 0; i < results.size(); i++)
            results.get(i).color = ColorUtil.getRandomColor();
    }


}