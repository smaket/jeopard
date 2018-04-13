package com.altm.jeopard.presenter;

import com.altm.jeopard.presenter.api.IResponseCallback;


/**
 * Created by Bikash on 3/30/2018.
 */

public interface IAJPresenter {
    /**
     * Receive Passtime from the server by providing the location
     * @param responseCallback Response call back
     */
    void getCategories(IResponseCallback responseCallback) ;
    void getRandom(IResponseCallback responseCallback) ;
    void getCategory(IResponseCallback responseCallback) ;
    void getClues(IResponseCallback responseCallback) ;

}
