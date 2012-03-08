package com.jonathanhester.gtvhub.server;

import java.util.List;
import java.util.logging.Logger;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.datanucleus.jpa.annotations.Extension;

import com.google.android.c2dm.server.PMF;

public class DataStore {
	
	private static final Logger log = Logger.getLogger(DataStore.class
			.getName());

	public static List<UserDevice> queryUserDevices(String userId) {
		if (userId == null) {
			return null;
		}

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Query query = pm.newQuery("select from "
					+ UserDevice.class.getName() + " where userId=='"
					+ userId
					+ "'");
			List<UserDevice> list = (List<UserDevice>) query.execute();
			return list;
		} catch (RuntimeException e) {
			log.severe("Error finding user: " + userId + "," + " " + e.getMessage());
			throw e;
		} finally {
			pm.close();
		}
	}
	
	public static DeviceInfo findDevice(String deviceCode) {
		if (deviceCode == null) {
			return null;
		}

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			Query query = pm.newQuery("select from "
					+ DeviceInfo.class.getName() + " where code=='"
					+ deviceCode
					+ "'");
			List<DeviceInfo> list = (List<DeviceInfo>) query.execute();
			return list.size() == 0 ? null : list.get(0);
		} catch (RuntimeException e) {
			log.severe("Error finding device with code: " + deviceCode + "," + " " + e.getMessage());
			throw e;
		} finally {
			pm.close();
		}
	}
	
	public static UserDevice createUserDevice(UserDevice userDevice) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(userDevice);
			return userDevice;
		} finally {
			pm.close();
		}
	}
}
