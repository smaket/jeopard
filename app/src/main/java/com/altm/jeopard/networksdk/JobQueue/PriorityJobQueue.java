package com.altm.jeopard.networksdk.JobQueue;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;

/**
 * Class PriorityJobQueue is ItemClickListener for the GrowingListView
 *
 * @author  Bikash Kumar Mohanty
 * @version 1.0
 * @since   2018-30-3
 */

public class PriorityJobQueue {

    /**
     * @param TAG The TAG or identifier for the class.
     * @see String
     */

    private static String TAG = PriorityJobQueue.class.getName();
    /**
     * @param instance The instance of this class as it is in the singleton pattern.
     */

    private static PriorityJobQueue instance = null;

    /**
     * @param mRequestQueue The Request Queue object to process the request.
     * @see RequestQueue
     */
    private RequestQueue mRequestQueue;
    /**
     * @param mContext The context object.
     * @see Context
     */
    private Context mContext;

    /**
     * Private constructor for PriorityJobQueue
     * @param aContext The context object.
     *
     */
    private PriorityJobQueue(Context aContext)
    {
        if(aContext != null) {
            this.mContext = aContext;
//            HttpsTrustManager.allowAllSSL();
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext() , new HurlStack(null, /*HttpsTrustManager.allowAllSSL()*/ HttpsTrustManager.allowssl()));
        }
    }

    /**
     * Public static method to get the instance of PriorityJobQueue
     * @param mContext The context object.
     *
     */

    public static PriorityJobQueue getInstane(Context mContext)
    {
        if (instance == null) instance = new PriorityJobQueue(mContext);
        return instance;
    }

    /**
     * Method Implementation to add the request to the Queue along with the Tag
     * @param req Request Object
     * @param tag tag to identify or group the request. The datatype is String
     * @return void This returns nothing.
     * @see Request
     */

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    /**
     * Method Implementation to add the request to the Queue along with the Tag
     * @param req Request Object
     * @param tag tag to identify or group the request. The datatype is Object
     * @return void This returns nothing.
     * @see Request
     */

    public <T> void addToRequestQueue(Request<T> req, Object tag) {
        // set the default tag if tag is empty
         if (tag!=null)
        getRequestQueue().add(req);
    }

    /**
     * Method Implementation to add the request to the Queue without Tag
     * @param req Request Object
     * @return void This returns nothing.
     * @see Request
     */

    public <T> void addToRequestQueue(Request<T> req) {
        // set the default tag if tag is empty
        getRequestQueue().add(req);
    }

    /**
     * Method Implementation to Cancel all the pending request in the queue
     * @param tag Clicked View.
     * @return void This returns nothing.
     * @see Request
     */

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    /**
     * Method Implementation to Cancel all the pending request in the queue
     * @param tag String. Clicked View.
     * @return void This returns nothing.
     * @see Request
     */

    public void cancelPendingRequests(String tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    /**
     * Method Implementation to get the Request Job Queue
     * @return RequestQueue returns the Request Job Queue
     * @see RequestQueue
     */

    public RequestQueue getRequestQueue()
    {
        return mRequestQueue;
    }

    /*private SSLSocketFactory getSocketFactory() {

        CertificateFactory cf = null;
        try {

            cf = CertificateFactory.getInstance("X.509");
            InputStream caInput = AltmApplication.getAppContext().getResources().openRawResource(R.raw.cert);
            Certificate ca;
            try {

                ca = cf.generateCertificate(caInput);
                Log.e("CERT", "ca=" + ((X509Certificate) ca).getSubjectDN());
            } finally {
                caInput.close();
            }


            String keyStoreType = KeyStore.getDefaultType();
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);


            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
            tmf.init(keyStore);


            HostnameVerifier hostnameVerifier = new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {

                    Log.e("CipherUsed", session.getCipherSuite());
                    return hostname.compareTo("https://opendata.cityofnewyork.us")==0; //The Hostname of your server.

                }
            };


            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
            SSLContext context = null;
            context = SSLContext.getInstance("TLS");

            context.init(null, tmf.getTrustManagers(), null);
            HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());

            SSLSocketFactory sf = context.getSocketFactory();


            return sf;

        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

        return  null;
    }*/
}
