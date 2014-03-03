package com.diudiustudio.connection.action;

import java.lang.reflect.Field;

import com.diudiustudio.connection.annotation.DConfig;
import com.diudiustudio.connection.result.Result;
import com.diudiustudio.exception.DException;

public class DAction implements Action {

	@Override
	public String getAction(int index) {
		String action = "";
		Field[] fields = getClass().getFields();
		for (Field field : fields) {
			DConfig annotation = field.getAnnotation(DConfig.class);
			if (annotation != null && annotation.index() == index) {
				try {
					action = (String) field.get(null);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
		}
		return action;
	}

	@Override
	public String getUrl(String action) {
		String url = null;
		DConfig annotation = getAnnotation(action);
		if (annotation != null) {
			url = annotation.url();
		} else {
			try {
				throw new DException("url cannot be null, please configure in DConfig first!");
			} catch (DException e) {
				e.printStackTrace();
			}
		}
		return url;
	}

	@Override
	public int getIndex(String action) {
		int index = -1;
		DConfig annotation = getAnnotation(action);
		if (annotation != null) {
			index = annotation.index();
		} else {
			try {
				throw new DException("index cannot be null, please configure in DConfig first!");
			} catch (DException e) {
				e.printStackTrace();
			}
		}
		return index;
	}

	@Override
	public int getMethod(String action) {
		int method = -1;
		DConfig annotation = getAnnotation(action);
		if (annotation != null) {
			method = annotation.index();
		} else {
			try {
				throw new DException("method cannot be null, please configure in DConfig first!");
			} catch (DException e) {
				e.printStackTrace();
			}
		}
		return method;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<? extends Result> getResultType(String action) {
		Class<? extends Result> clazz = null;
		DConfig annotation = getAnnotation(action);
		if (annotation != null) {
			clazz = annotation.clazz();
		} else {
			try {
				throw new DException("clazz cannot be null,please configure in DConfig first!");
			} catch (DException e) {
				e.printStackTrace();
			}
		}
		return clazz;
	}

	private DConfig getAnnotation(String action) {
		Field[] fields = getClass().getFields();
		for (Field field : fields) {
			try {
				if (action.equals(field.get(field.getName()))) {
					DConfig annotation = field.getAnnotation(DConfig.class);
					return annotation;
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
