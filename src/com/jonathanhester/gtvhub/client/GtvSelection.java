package com.jonathanhester.gtvhub.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.jonathanhester.gtvhub.shared.UserDeviceProxy;

public class GtvSelection extends Composite implements HasText {

	private static GtvSelectionUiBinder uiBinder = GWT
			.create(GtvSelectionUiBinder.class);

	interface GtvSelectionUiBinder extends UiBinder<Widget, GtvSelection> {
	}
	
	private List<UserDeviceProxy> userDevices;

	public GtvSelection() {
		initWidget(uiBinder.createAndBindUi(this));
		status.setInnerText("Loading TVs");
	}

	@UiField
	Button button;
	
	@UiField
	DivElement status;

	public GtvSelection(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
		
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		Window.alert("Hello!");
	}

	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}
	
	public void setUserDevices(List<UserDeviceProxy> userDevices) {
		if (this.userDevices == null || this.userDevices.size() == 0) {
			//No TVs found for this account
			status.setInnerText("No tvs found!");
			this.userDevices = new ArrayList<UserDeviceProxy>();
		} else {
			this.userDevices = userDevices;
		}
	}
	
	public void addUserDevice(UserDeviceProxy userDevice) {
		this.userDevices.add(userDevice);
		//TODO: update display with this new device
	}
	
	public String getTvId() {
		return null;
	}

}
