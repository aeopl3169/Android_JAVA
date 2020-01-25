package com.shiva.fetchingdatafrommysqlphp;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingletonClass {
    private static VolleySingletonClass volleySingletonClass;
    private RequestQueue requestQueue;

    private VolleySingletonClass(Context context) {
        this.requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleySingletonClass getInstanceMethod(Context context){
        if(volleySingletonClass == null){
            volleySingletonClass = new VolleySingletonClass(context);
        }
        return volleySingletonClass;
    }

    public RequestQueue getRequestQueueMethod(){
        return requestQueue;
    }
}
