package com.diudiustudio.connection.request;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;

public class StringActionRequest extends ActionRequest<Map<String, String>> {

	private static final String ACTION = "action";
	private static final String RESPONSE = "response";
	private String action;

	public StringActionRequest(String action, Map<String, String> params, ActionListener<Map<String, String>> listener) {
		super(action, listener);
		this.action = action;
	}

	@Override
	protected Response<Map<String, String>> parseNetworkResponse(NetworkResponse response) {
		String parsed;
		try {
			parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
		} catch (UnsupportedEncodingException e) {
			parsed = new String(response.data);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put(StringActionRequest.ACTION, action);
		map.put(StringActionRequest.RESPONSE, parsed);
		return Response.success(map, HttpHeaderParser.parseCacheHeaders(response));
	}

	@Override
	protected void deliverResponse(Map<String, String> response) {

	}

}
