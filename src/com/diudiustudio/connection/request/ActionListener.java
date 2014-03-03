package com.diudiustudio.connection.request;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;

/**
 * 负责联网后返回错误及返回数据的处理
 * 
 * @author Hongjian.Liu 10:35:55 AM Nov 21, 2013
 * @param <T>
 */
public interface ActionListener<T> extends Listener<T>, ErrorListener {

	@Override
	public void onErrorResponse(VolleyError error);

	@Override
	public void onResponse(T response);

}
