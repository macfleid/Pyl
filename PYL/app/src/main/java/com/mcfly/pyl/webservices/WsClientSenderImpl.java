package com.mcfly.pyl.webservices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class WsClientSenderImpl extends AsyncTask<String, Integer, String> implements IWsClientSender {

	private static final String TAG = WsClientSenderImpl.class.getName();
	protected Context context;
	private IWsResult listener;
	
	public WsClientSenderImpl(Context c, IWsResult listener) {
		this.context = c;
		this.listener = listener;
	}
	
	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		listener.onPostExecute(result);
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		super.onProgressUpdate(values);
	}
	
	
	@Override
	protected String doInBackground(String... params) {
		if(params.length<2) {
            Log.e(TAG, "Error on WsClientSenderImpl, not enough params");
			return null;
		}
		return sendData(params[0], params[1]);
	}
	
	@Override
	public String sendData(String url, String jsonData) {
        Log.d(TAG, "... call callWs sendData()");
        Log.d(TAG, "...url:"+url);
        Log.d(TAG, "...JsonData:"+jsonData);
		
		HttpParams httpParams = new BasicHttpParams();
		int timeOutConnection = 120000;
		StringBuilder stringBuilder = new StringBuilder();
		int timeOutSocket = 120000;
		HttpConnectionParams.setConnectionTimeout(httpParams, timeOutConnection);
		HttpConnectionParams.setSoTimeout(httpParams, timeOutSocket);
		HttpClient client = new DefaultHttpClient(httpParams);
		
		HttpPost httpPost = null;
		HttpEntity entity = null;
		try {
			entity = new StringEntity(jsonData,"UTF-8");
			httpPost = new HttpPost(url);
			httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
			httpPost.setEntity(entity);
			
			HttpResponse response = client.execute(httpPost);
			StatusLine statusLine = response.getStatusLine();
            Log.d(TAG, "   ...request status:"+statusLine);
			int statusCode = statusLine.getStatusCode();
			//			if (statusCode == 200) {
			HttpEntity entity_ = response.getEntity();
			InputStream is = entity_.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line);
			}
			is.close();
            Log.d(TAG, "Result  :"+stringBuilder.toString());
			if(statusCode!=200) {
				listener.signalError();
			}
		} catch (UnsupportedEncodingException e) {
            Log.e(TAG, "Exception occured when callWs sendData", e);
            Log.e(TAG, "Trace: "+ e.getMessage());
			listener.signalError(); 
		} catch (ClientProtocolException e) {
            Log.e(TAG, "Exception occured when callWs sendData", e);
            Log.e(TAG, "Trace: "+ e.getMessage());
			listener.signalError(); 
		} catch (IOException e) {
            Log.e(TAG, "Exception occured when callWs sendData", e);
            Log.e(TAG, "Trace: "+ e.getMessage());
			listener.signalError(); 
		} 
		return stringBuilder.toString();
	}

}
