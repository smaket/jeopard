package com.altm.jeopard.presenter.api;

import com.altm.jeopard.presenter.api.IHttpConnection;

/**
 * Created by Bikash on 3/30/2018.
 */

public interface IResponseCallback {
    void responseReceived(int status, String body, IHttpConnection.IResponseObserver.RequestTypeEnum aRespType, Object requestParams) ;
}
