package com.diudiustudio.connection.request;

import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.diudiustudio.connection.action.DAction;

public abstract class ActionRequest<T> extends Request<T> {

	public ActionRequest(String action, ActionListener<T> listener) {
		super(DAction.getInstance().getMethod(action), DAction.getInstance().getUrl(action), listener);
	}

	public ActionRequest(int method, String url, ErrorListener listener) {
		super(method, url, listener);
	}

}
