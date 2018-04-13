package com.altm.jeopard.presenter;

import android.content.Context;
import android.util.Log;

import com.altm.jeopard.application.AppConstants;
import com.altm.jeopard.networksdk.JobQueue.PriorityJobQueue;
import com.altm.jeopard.networksdk.Listener.ErrorResponseListener;
import com.altm.jeopard.networksdk.Listener.ResponseListener;
import com.altm.jeopard.networksdk.Network.Constants;
import com.altm.jeopard.networksdk.Network.GetRequest;
import com.altm.jeopard.networksdk.Network.NetworkHandler;
import com.altm.jeopard.networksdk.Network.PostRequest;
import com.altm.jeopard.presenter.api.IHttpConnection;
import com.altm.jeopard.presenter.api.IResponseCallback;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Bikash on 3/30/2018.
 */

public class NetworkController implements ResponseListener.Listener,ErrorResponseListener.ErrorListener{
    private static NetworkController instance = null;
    private IResponseCallback presenter;
    private Context mContext;
    /**
     * Network handler instance for network calls defined on Network sdk module.
     */
    private NetworkHandler networkHandler;
    private PriorityJobQueue priorityJobQueue;
    private IHttpConnection.IResponseObserver.RequestTypeEnum mResponseType;
    private String TAG = NetworkController.class.getName();

    private NetworkController(Context aCxt , IResponseCallback presenter) {
        this.mContext = aCxt;
        this.presenter = presenter;
        this.networkHandler = NetworkHandler.getInstance(mContext);
        this.priorityJobQueue = networkHandler.getJobQueue();
        Log.d(TAG, "Inside GatewayController ()");
    }
    public static NetworkController getInstance(Context mContext , IResponseCallback presenter) {
        if (instance == null) instance = new NetworkController(mContext , presenter);
        return instance;
    }

    //Methods to process the network request

    public void processNetworkRequest(IHttpConnection.IResponseObserver.RequestTypeEnum mResponseType, Object requestParams, Request.Priority priority) {
        this.mResponseType = mResponseType;
        switch (mResponseType) {
            case POST_CONTENT:
                Log.v(TAG, "LOGIN_AUTH_SERVICE processNetworkRequest()-->");
                postRequest(requestParams, mResponseType, priority);
                break;
            case GET_CATEGORIES:
                Log.v(TAG, "Passtime processNetworkRequest()-->");
                getCategories(requestParams, mResponseType, priority);
                break;
            case GET_CATEGORY:
                Log.v(TAG, "Passtime processNetworkRequest()-->");
                getCategory(requestParams, mResponseType, priority);
                break;
            case GET_CLUES:
                Log.v(TAG, "Passtime processNetworkRequest()-->");
                getClues(requestParams, mResponseType, priority);
                break;
            case GET_RANDOM:
                Log.v(TAG, "Passtime processNetworkRequest()-->");
                getRandom(requestParams, mResponseType, priority);
                break;

        }
    }
    private void getClues(Object requestParams, IHttpConnection.IResponseObserver.RequestTypeEnum mResponseType, Request.Priority priority) {
        HashMap<String, String> params = (HashMap<String, String>) requestParams;
        Log.v(TAG, "getWeatherContent() Request-->");

        Log.d(TAG, "Request is about to get the Contents  = ");
        //Hard coded URL , It can be put on config file
        String lUrl = AppConstants.CLUES_URI;


        GetRequest getSanboxdata = (GetRequest) networkHandler.getRequestObject(Constants.NetworkRequestType.GET, mResponseType, lUrl, new ResponseListener(this), new ErrorResponseListener(this), requestParams);
        Log.d(TAG, "List Data Request() ->  Url=" + lUrl);
        getSanboxdata.setPriority(priority);
        getSanboxdata.setRetryPolicy(new DefaultRetryPolicy(AppConstants.SOCKET_TIMEOUT_TIME, AppConstants.RE_TRY_COUNT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        priorityJobQueue.addToRequestQueue(getSanboxdata, AppConstants.TAG_CONTENT_RESPONSE_TYPE);
    }

    private void getCategories(Object requestParams, IHttpConnection.IResponseObserver.RequestTypeEnum mResponseType, Request.Priority priority) {
        HashMap<String, String> params = (HashMap<String, String>) requestParams;
        Log.v(TAG, "getWeatherContent() Request-->");

        Log.d(TAG, "Request is about to get the Contents  = ");
        //Hard coded URL , It can be put on config file
        String lUrl = AppConstants.CATEGORIES_URI;


        GetRequest getSanboxdata = (GetRequest) networkHandler.getRequestObject(Constants.NetworkRequestType.GET, mResponseType, lUrl, new ResponseListener(this), new ErrorResponseListener(this), requestParams);
        Log.d(TAG, "List Data Request() ->  Url=" + lUrl);
        getSanboxdata.setPriority(priority);
        getSanboxdata.setRetryPolicy(new DefaultRetryPolicy(AppConstants.SOCKET_TIMEOUT_TIME, AppConstants.RE_TRY_COUNT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        priorityJobQueue.addToRequestQueue(getSanboxdata, AppConstants.TAG_CONTENT_RESPONSE_TYPE);
    }
    private void getCategory(Object requestParams, IHttpConnection.IResponseObserver.RequestTypeEnum mResponseType, Request.Priority priority) {
        HashMap<String, String> params = (HashMap<String, String>) requestParams;
        Log.v(TAG, "getWeatherContent() Request-->");

        Log.d(TAG, "Request is about to get the Contents  = ");
        //Hard coded URL , It can be put on config file
        String lUrl = AppConstants.CATEGORY_URI;


        GetRequest getSanboxdata = (GetRequest) networkHandler.getRequestObject(Constants.NetworkRequestType.GET, mResponseType, lUrl, new ResponseListener(this), new ErrorResponseListener(this), requestParams);
        Log.d(TAG, "List Data Request() ->  Url=" + lUrl);
        getSanboxdata.setPriority(priority);
        getSanboxdata.setRetryPolicy(new DefaultRetryPolicy(AppConstants.SOCKET_TIMEOUT_TIME, AppConstants.RE_TRY_COUNT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        priorityJobQueue.addToRequestQueue(getSanboxdata, AppConstants.TAG_CONTENT_RESPONSE_TYPE);
    }
    private void getRandom(Object requestParams, IHttpConnection.IResponseObserver.RequestTypeEnum mResponseType, Request.Priority priority) {
        HashMap<String, String> params = (HashMap<String, String>) requestParams;
        Log.v(TAG, "getWeatherContent() Request-->");

        Log.d(TAG, "Request is about to get the Contents  = ");
        //Hard coded URL , It can be put on config file
        String lUrl = AppConstants.RANDOM_URI;


        GetRequest getSanboxdata = (GetRequest) networkHandler.getRequestObject(Constants.NetworkRequestType.GET, mResponseType, lUrl, new ResponseListener(this), new ErrorResponseListener(this), requestParams);
        Log.d(TAG, "List Data Request() ->  Url=" + lUrl);
        getSanboxdata.setPriority(priority);
        getSanboxdata.setRetryPolicy(new DefaultRetryPolicy(AppConstants.SOCKET_TIMEOUT_TIME, AppConstants.RE_TRY_COUNT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        priorityJobQueue.addToRequestQueue(getSanboxdata, AppConstants.TAG_CONTENT_RESPONSE_TYPE);
    }
    /**
     * Post Method added for Demonstration
     * @param requestParams
     * @param mResponseType
     * @param priority
     */
    private void postRequest(Object requestParams, IHttpConnection.IResponseObserver.RequestTypeEnum mResponseType, Request.Priority priority) {
        Log.v(TAG, "postRequestpostRequest()-->");
        if (requestParams instanceof HashMap) {
            Log.v(TAG, "postRequest postRequest()-->requestParams check");
            HashMap<String, String> params = (HashMap<String, String>) requestParams;
            //TODO write the logic to make network call
            JSONObject luserRegistrationdata = new JSONObject();

            String lUrl = "http://lyrics.wikia.com/api.php?func=getSong&artist=Tom+Waits&song=new+coat+of+paint&fmt=json";
            // String lUrl = "https://user-auth-service-uat.cfapps.scus-10.test.cf.fedex.com/v1/user/auth";
            int requestType = Constants.NetworkRequestType.POST;
            PostRequest authRequest = (PostRequest) networkHandler.getRequestObject(requestType, mResponseType, lUrl, new ResponseListener(this), new ErrorResponseListener(this), requestParams);
            authRequest.addHeader("Content-Type", "application/json");
            authRequest.addHeader("X-locale", "en_US"); // As per working param
            authRequest.addHeader("X-version", "1");
            authRequest.setRequestBody(luserRegistrationdata.toString());
            authRequest.setEncodingType("utf-8");
            authRequest.setPriority(priority);
            authRequest.setRetryPolicy(new DefaultRetryPolicy(AppConstants.SOCKET_TIMEOUT_TIME, AppConstants.RE_TRY_COUNT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
            priorityJobQueue.addToRequestQueue(authRequest, AppConstants.TAG_POST_RESPONSE_TYPE);
        }
    }


    @Override
    public void onResponse(String response) {

    }

    @Override
    public void onResponseHeaders(Map<String, String> headers, Object requestTAG) {

    }

    @Override
    public void onResponseObject(NetworkResponse response, Response<String> responseObject, Object requestTAG, Object requestParams) {

        Log.v(TAG, "onResponseObject()-->pre");
        IHttpConnection.IResponseObserver.RequestTypeEnum mResponseTypeFromRequest = (IHttpConnection.IResponseObserver.RequestTypeEnum) requestTAG;
        //Reset if response received
        presenter.responseReceived(response.statusCode, responseObject.result, mResponseTypeFromRequest, requestParams);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onErrorResponse(VolleyError error, Object requestTag) {

    }

    @Override
    public void onErrorResponse(VolleyError error, NetworkResponse response, Object requestTAG, Object requestParams) {
        IHttpConnection.IResponseObserver.RequestTypeEnum mResponseTypeFromRequest = (IHttpConnection.IResponseObserver.RequestTypeEnum) requestTAG;
        try {

            if (response == null || (response != null && (Integer) response.statusCode == null)) {
                presenter.responseReceived(-1, null, mResponseTypeFromRequest, requestParams);
            } else {
                presenter.responseReceived(response.statusCode, null, mResponseTypeFromRequest, requestParams);
            }
        } catch (Exception ex) {
            presenter.responseReceived(-1, null, mResponseTypeFromRequest, requestParams);
            ex.printStackTrace();
            Log.e(TAG, "error==" + ex.toString());
        }
    }
}
