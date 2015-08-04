/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.money2013.win.hb.net.utils;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.Base64;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author aisaev
 */
public class RestClient extends OkHttpClient {
    private static final String BASE_URL="https://money2013.net";
    private static final MediaType TEXT_HTML = MediaType.parse("text/html; charset=utf-8");    
    public static final String ACCEPT_CHARSET_HEADER = "Accept-Charset";
    public static final String ACCEPT_ENCODING_HEADER = "Accept-Encoding";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String LOCATION_HEADER = "Location";

    public static final String UTF8_CHARSET = "UTF-8";
   
    public static RestClient getInstance() {
        System.setProperty("jsse.enableSNIExtension", "false");
        RestClient client=new RestClient();
        client.setHostnameVerifier(new HostnameVerifier() {

            @Override
            public boolean verify(String hostname, SSLSession ssls) {
                //System.out.println("Approving certificate for " + hostname);
                return true;
            }
        });
        
        try {
            TrustManager[] trustAllCerts = new TrustManager[] {
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
            };

            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            client.setSslSocketFactory(sc.getSocketFactory());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return client;
    }
    
    public String sendSyncData(String userName,String password,String data) throws IOException {
        RequestBody requestBody=RequestBody.create(TEXT_HTML, data);
        Request request=new Request.Builder()
                            .url(BASE_URL+"/api/v1/sync.json")
                            .addHeader(AUTHORIZATION_HEADER, createAuthenticationHeader(userName, password))
                            .post(requestBody)
                            .build();
        
        Response response=this.newCall(request).execute();
        
        return response.body().string();
    }
    
    private String createAuthenticationHeader(String userName,String password) {
        StringBuilder sb = new StringBuilder();
        sb.append(userName).append(":").append(password);
         
        return "Basic " + (Base64.getEncoder()
                                    .withoutPadding()
                                    .encodeToString(sb.toString().getBytes()));
    }
    
}
