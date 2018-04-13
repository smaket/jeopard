package com.altm.jeopard.networksdk.Network;

import android.content.Context;

import com.altm.jeopard.networksdk.JobQueue.PriorityJobQueue;
import com.altm.jeopard.networksdk.Listener.ErrorResponseListener;
import com.altm.jeopard.networksdk.Listener.ResponseListener;
import com.altm.jeopard.networksdk.Network.Constants;
import com.altm.jeopard.networksdk.Network.GetRequest;
import com.android.volley.toolbox.StringRequest;

/**
 * Class NetworkHandler is ItemClickListener for the GrowingListView
 *
 * @author  Bikash Kumar Mohanty
 * @version 1.0
 * @since   2018-30-3
 */

public class NetworkHandler {

    private  static NetworkHandler instance = null;
    private Context mContext = null;

    private NetworkHandler(Context mContext)
    {
        this.mContext = mContext;
    }

    public static NetworkHandler getInstance(Context mContext) {
        if (instance == null) instance = new NetworkHandler(mContext);
        return instance;
    }

    public StringRequest getRequestObject(int TYPE, Object requestTAG, String url, ResponseListener responseListener, ErrorResponseListener errorListener, Object requestParams)
    {
        StringRequest request = null;
        switch (TYPE)
        {
            case Constants.NetworkRequestType.POST:
                request =  new PostRequest(url,responseListener,errorListener,requestTAG,requestParams);
                break;
            case Constants.NetworkRequestType.GET:
                request =  new GetRequest(url,responseListener,errorListener,requestTAG,requestParams);
                break;
            case Constants.NetworkRequestType.PUT:
                request =  new PutRequest(url,responseListener,errorListener,requestTAG,requestParams);
                break;
            /*case Constants.NetworkRequestType.DELETE:
                request =  new DeleteRequest(url,responseListener,errorListener,requestTAG,requestParams);
                break;*/

        }
        return request;
    }

   /* public BitMapRequest getImageRequest(int TYPE, Object requestTAG, String url, BitMapResponseListner responseListener, ErrorResponseListener errorListener, Object requestParams)
    {
        BitMapRequest request = null;
        switch (TYPE)
        {
            case Constants.NetworkRequestType.IMAGE:
                request =  new BitMapRequest(url,responseListener,errorListener,requestTAG,requestParams);
                break;

        }
        return request;
    }
*/

    public PriorityJobQueue getJobQueue()
    {
        return PriorityJobQueue.getInstane(mContext);
    }
}
