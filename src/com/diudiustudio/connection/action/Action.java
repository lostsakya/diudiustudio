package com.diudiustudio.connection.action;

import com.diudiustudio.connection.result.Result;

interface Action {

	/**
	 * @return Action according to provided index
	 */
	String getAction(int index);

	/**
	 * @return Method according to provided action
	 */
	int getMethod(String action);

	/**
	 * @return Method according to provided action
	 */
	int getIndex(String action);

	/**
	 * @return url according to provided action
	 */
	String getUrl(String action);

	/**
	 * @return ? extends Result according to provided action
	 */
	Class<? extends Result> getResultType(String action);

}
