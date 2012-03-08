package com.jonathanhester.gtvhub.shared;

import java.util.List;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;

@ServiceName(value = "com.jonathanhester.gtvhub.server.GtvhubService", locator = "com.jonathanhester.gtvhub.server.GtvhubServiceLocator")
public interface GtvhubRequest extends RequestContext {

	Request<UserDeviceProxy> createUserDevice(String deviceCode, String tvName);

	Request<UserDeviceProxy> readUserDevice(Long id);

	Request<UserDeviceProxy> updateUserDevice(UserDeviceProxy userdevice);

	Request<Void> deleteUserDevice(UserDeviceProxy userdevice);

	Request<List<UserDeviceProxy>> queryUserDevices();

}
