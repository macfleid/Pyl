package com.mcfly.pyl.webservices;

import java.util.HashMap;

import org.json.JSONObject;


public interface IWsClient {

	public String callWs(String url, String[] params);
}
