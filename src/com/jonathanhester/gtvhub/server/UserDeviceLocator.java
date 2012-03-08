package com.jonathanhester.gtvhub.server;

import com.google.web.bindery.requestfactory.shared.Locator;


public class UserDeviceLocator extends Locator<UserDevice, Void> {

	@Override
	public UserDevice create(Class<? extends UserDevice> clazz) {
		return new UserDevice();
	}

	@Override
	public UserDevice find(Class<? extends UserDevice> clazz, Void id) {
		return create(clazz);
	}

	@Override
	public Class<UserDevice> getDomainType() {
		return UserDevice.class;
	}

	@Override
	public Void getId(UserDevice domainObject) {
		return null;
	}

	@Override
	public Class<Void> getIdType() {
		return Void.class;
	}

	@Override
	public Object getVersion(UserDevice domainObject) {
		return null;
	}

}
