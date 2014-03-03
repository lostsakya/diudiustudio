package com.diudiustudio.connection.request;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

/**
 * Use one listener to handle response.
 * 
 * @author diudiustudio
 * @param <T>
 */
public interface ActionListener<T> extends Listener<T>, ErrorListener {

	@Override
	public void onErrorResponse(VolleyError error);

	@Override
	public void onResponse(T response);

}
