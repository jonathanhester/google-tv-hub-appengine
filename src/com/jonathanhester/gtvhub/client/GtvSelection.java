package com.jonathanhester.gtvhub.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dev.json.Pair;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.jonathanhester.gtvhub.shared.UserDeviceProxy;

public class GtvSelection extends Composite {

	private static final String RADIO_GROUP = "myRadioGroup";
	
	private static GtvSelectionUiBinder uiBinder = GWT
			.create(GtvSelectionUiBinder.class);

	interface GtvSelectionUiBinder extends UiBinder<Widget, GtvSelection> {
	}
	
	private List<ArrayList<Object>> userDevices = new ArrayList<ArrayList<Object>>();

	public GtvSelection() {
		initWidget(uiBinder.createAndBindUi(this));
		status.setInnerText("Loading TVs...");
	}
	
	@UiField
	DivElement status;

	@UiField
	VerticalPanel panel;
	
	public void setUserDevices(List<UserDeviceProxy> userDevices) {
		if (userDevices == null || userDevices.size() == 0) {
			//No TVs found for this account
			status.setInnerText("No tvs found!");
		} else {
			status.setInnerText("");
			Iterator<UserDeviceProxy> iterator = userDevices.iterator();
			 
			while(iterator.hasNext()) {
				addRadio(iterator.next());
			}
		}
	}

	private void addRadio(UserDeviceProxy userDevice) {
		String name = userDevice.getTvName();
	    RadioButton rb = new RadioButton(RADIO_GROUP, name);
	    panel.add(rb);
	    rb.setChecked(true);
	    ArrayList<Object> pair = new ArrayList<Object>();
	    pair.add(0, rb);
	    pair.add(1, userDevice);
	    this.userDevices.add(pair);
	}
	
	public void addUserDevice(UserDeviceProxy userDevice) {
		addRadio(userDevice);
		status.setInnerText("");
	}
	
	public String getTvId() {
		Iterator<ArrayList<Object>> iterator = userDevices.iterator();
		 
		while(iterator.hasNext()) {
			ArrayList<Object> pair = iterator.next();
			
			if (((RadioButton)pair.get(0)).isChecked())
				return ((UserDeviceProxy)pair.get(1)).getDeviceId();
		}
		return null;
	}

}
