package com.jonathanhester.gtvhub.server;

import java.util.List;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.jonathanhester.gtvhub.annotation.ServiceMethod;


public class GtvhubService {

	@ServiceMethod
	public UserDevice createUserDevice(String deviceCode, String tvName) {
		DeviceInfo deviceInfo = DataStore.findDevice(deviceCode);
		UserDevice userDevice = null;
		if (deviceInfo != null) {
			userDevice = new UserDevice();
			userDevice.setDeviceId(deviceInfo.getCode());
			userDevice.setTvName(tvName);
			userDevice.setUserId(this.getUserId());
			DataStore.createUserDevice(userDevice);
		}
		return null;
	}

	@ServiceMethod
	public UserDevice readUserDevice(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@ServiceMethod
	public UserDevice updateUserDevice(UserDevice userdevice) {
		// TODO Auto-generated method stub
		return null;
	}

	@ServiceMethod
	public void deleteUserDevice(UserDevice userdevice) {
		// TODO Auto-generated method stub

	}

	@ServiceMethod
	public List<UserDevice> queryUserDevices() {
		String userId = this.getUserId();
	    
	    List<UserDevice> userDevices = DataStore.queryUserDevices(userId);
	    
	    return userDevices;
	}
	
	private String getUserId() {
		UserService userService = UserServiceFactory.getUserService();
	    User user = userService.getCurrentUser();
	    return user.getEmail();
	}

}
