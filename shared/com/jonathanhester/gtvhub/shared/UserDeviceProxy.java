package com.jonathanhester.gtvhub.shared;

import com.google.web.bindery.requestfactory.shared.ProxyForName;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyForName(value = "com.jonathanhester.gtvhub.server.UserDevice", locator = "com.jonathanhester.gtvhub.server.UserDeviceLocator")
public interface UserDeviceProxy extends ValueProxy {

	String getUserId();

	void setUserId(String userId);

	String getDeviceId();

	void setDeviceId(String deviceId);

	String getTvName();

	void setTvName(String tvName);

}
