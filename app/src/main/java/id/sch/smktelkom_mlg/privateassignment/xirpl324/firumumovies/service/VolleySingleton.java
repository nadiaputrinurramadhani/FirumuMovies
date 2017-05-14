package id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.ComingSoon;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.HomeFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl324.firumumovies.Popular;

/**
 * Created by hyuam on 18/04/2017.
 */

public class VolleySingleton {
    private static volatile VolleySingleton mInstance;
    private static HomeFragment mCtx;
    private static ComingSoon mCtx2;
    private static Popular mCtx3;
    private static Context mCtx4;
    private RequestQueue mRequestQueue;

    /*private VolleySingleton(Context context) {
        if (mInstance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }*/

    private VolleySingleton(HomeFragment context) {
        if (mInstance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");

        }
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    private VolleySingleton(ComingSoon context1) {
        if (mInstance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx2 = context1;
        mRequestQueue = getRequestQueue();
    }

    private VolleySingleton(Popular context2) {
        if (mInstance != null) {
            throw new RuntimeException(
                    "Use getInstance() method to get the single instance of this class");
        }
        mCtx3 = context2;
        mRequestQueue = getRequestQueue();
    }

    public static VolleySingleton getInstance(HomeFragment context) {
        if (mInstance == null) {
            synchronized (VolleySingleton.class) {
                if (mInstance == null) mInstance = new VolleySingleton(context);
            }
        }
        return mInstance;

    }

    public static VolleySingleton getInstance(ComingSoon context1) {
        if (mInstance == null) {
            synchronized (VolleySingleton.class) {
                if (mInstance == null) mInstance = new VolleySingleton(context1);
            }
        }
        return mInstance;
    }


    public static VolleySingleton getInstance(Popular context2) {
        if (mInstance == null) {
            synchronized (VolleySingleton.class) {
                if (mInstance == null) mInstance = new VolleySingleton(context2);
            }
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mCtx.getActivity());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
