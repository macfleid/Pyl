package com.mcfly.pyl.webservices;

public interface IWsResult {
	
	public void onPostExecute(String result);
	
	public void signalError();
	
}
