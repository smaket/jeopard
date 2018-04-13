package com.altm.jeopard.presenter;

import android.util.Log;

import com.altm.jeopard.application.AltmApplication;
import com.altm.jeopard.presenter.api.IHttpConnection;
import com.altm.jeopard.presenter.api.IResponseCallback;
import com.altm.jeopard.view.api.IRegisterView;
import com.android.volley.Request;

import java.util.HashMap;

public class AJPresenterImpl implements IAJPresenter,IResponseCallback {
    private static final String TAG =AJPresenterImpl.class.getName();
    private IRegisterView mView;
    public AJPresenterImpl (IRegisterView aView) {
        this.mView = aView;
    }
    @Override
    public void getCategories(IResponseCallback responseCallback) {
        Log.d(TAG,"getCategories()");
        NetworkController gatewayController = NetworkController.getInstance(AltmApplication.getAppContext() , responseCallback);
        HashMap<String, String> params = new HashMap<>();
        gatewayController.processNetworkRequest(IHttpConnection.IResponseObserver.RequestTypeEnum.GET_CATEGORIES,params, Request.Priority.IMMEDIATE);
    }

    @Override
    public void getRandom(IResponseCallback responseCallback) {
        Log.d(TAG,"getRandom()");
        NetworkController gatewayController = NetworkController.getInstance(AltmApplication.getAppContext() , responseCallback);
        HashMap<String, String> params = new HashMap<>();
        gatewayController.processNetworkRequest(IHttpConnection.IResponseObserver.RequestTypeEnum.GET_RANDOM,params, Request.Priority.IMMEDIATE);
    }

    @Override
    public void getCategory(IResponseCallback responseCallback) {

        Log.d(TAG,"getCategory()");
        NetworkController gatewayController = NetworkController.getInstance(AltmApplication.getAppContext() , responseCallback);
        HashMap<String, String> params = new HashMap<>();
        gatewayController.processNetworkRequest(IHttpConnection.IResponseObserver.RequestTypeEnum.GET_CATEGORY,params, Request.Priority.IMMEDIATE);
    }

    @Override
    public void getClues(IResponseCallback responseCallback) {
        Log.d(TAG,"getClues()");
        NetworkController gatewayController = NetworkController.getInstance(AltmApplication.getAppContext() , responseCallback);
        HashMap<String, String> params = new HashMap<>();
        gatewayController.processNetworkRequest(IHttpConnection.IResponseObserver.RequestTypeEnum.GET_CLUES,params, Request.Priority.IMMEDIATE);
    }

    @Override
    public void responseReceived(int status, String body, IHttpConnection.IResponseObserver.RequestTypeEnum aRespType, Object requestParams) {
        Log.d(TAG, " status "+status + " body =="+body);
    }
}
