/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.jonathanhester.gtvhub.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.TextAreaElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

import com.jonathanhester.gtvhub.client.MyRequestFactory.HelloWorldRequest;
import com.jonathanhester.gtvhub.client.MyRequestFactory.MessageRequest;
import com.jonathanhester.gtvhub.shared.GtvhubRequest;
import com.jonathanhester.gtvhub.shared.MessageProxy;
import com.jonathanhester.gtvhub.shared.UserDeviceProxy;

public class GtvhubWidget extends Composite {

  private static final int STATUS_DELAY = 4000;
  private static final String STATUS_ERROR = "status error";
  private static final String STATUS_NONE = "status none";
  private static final String STATUS_SUCCESS = "status success";

  interface GtvhubUiBinder extends UiBinder<Widget, GtvhubWidget> {
  }

  private static GtvhubUiBinder uiBinder = GWT.create(GtvhubUiBinder.class);

  @UiField
  InputElement linkToPush;

  @UiField
  InputElement tvCode;

  @UiField
  InputElement tvName;
  
  @UiField
  DivElement status;

  @UiField
  Button sayHelloButton;

  @UiField
  Button sendLinkButton;
  
  @UiField
  Button addTvButton;
  
  @UiField
  GtvSelection tvSelection;
  
  @UiField
  DivElement pushLinkContainer;

  /**
   * Timer to clear the UI.
   */
  Timer timer = new Timer() {
    @Override
    public void run() {
      status.setInnerText("");
      status.setClassName(STATUS_NONE);
      linkToPush.setValue("");
    }
  };

  private void setStatus(String message, boolean error) {
    status.setInnerText(message);
    if (error) {
      status.setClassName(STATUS_ERROR);
    } else {
      if (message.length() == 0) {
        status.setClassName(STATUS_NONE);
      } else {
        status.setClassName(STATUS_SUCCESS);
      }
    }

    timer.schedule(STATUS_DELAY);
  }

  public GtvhubWidget() {
    initWidget(uiBinder.createAndBindUi(this));
    sayHelloButton.getElement().setClassName("send centerbtn");
    sendLinkButton.getElement().setClassName("send");
    addTvButton.getElement().setClassName("send");
    
    final EventBus eventBus = new SimpleEventBus();
    final MyRequestFactory requestFactory = GWT.create(MyRequestFactory.class);
    requestFactory.initialize(eventBus);
    
    GtvhubRequest gtvRequest = requestFactory.gtvhubRequest();
    gtvRequest.queryUserDevices().fire(
			new Receiver<List<UserDeviceProxy>>() {
				public void onFailure(ServerFailure error) {
				}

				@Override
				public void onSuccess(List<UserDeviceProxy> userDevices) {
					tvSelection.setUserDevices(userDevices);
				}
				
			});
    sendLinkButton.addClickHandler(new ClickHandler() {
    public void onClick(ClickEvent event) {
    	if (tvSelection.getTvId() == null) {
    		//no tv selected
    		setStatus("No TV selected", false);
    		return;
    	}
        String link = linkToPush.getValue();
        setStatus("Connecting...", false);
        sendLinkButton.setEnabled(false);

        // Send a message using RequestFactory
        MessageRequest request = requestFactory.messageRequest();
        MessageProxy messageProxy = request.create(MessageProxy.class);
        messageProxy.setRecipient(tvSelection.getTvId());
        messageProxy.setMessage(link);
        Request<String> sendRequest = request.send().using(messageProxy);
        sendRequest.fire(new Receiver<String>() {
          @Override
          public void onFailure(ServerFailure error) {
            sendLinkButton.setEnabled(true);
            setStatus(error.getMessage(), true);
          }

          @Override
          public void onSuccess(String response) {
            sendLinkButton.setEnabled(true);
            setStatus(response, response.startsWith("Failure:"));
          }
        });
      }
    });
    
    addTvButton.addClickHandler(new ClickHandler() {
    public void onClick(ClickEvent event) {
    	if (tvCode.getValue() == null || tvCode.getValue().length() == 0) {
    		//no tv selected
    		setStatus("No code input", false);
    		return;
    	}
    	String name = tvName.getValue();
    	if (name == null || name.length() == 0) {
    		name = tvCode.getValue();
    		tvName.setValue(name);
    	}
        setStatus("Connecting...", false);
        addTvButton.setEnabled(false);
        GtvhubRequest gtvRequest = requestFactory.gtvhubRequest();
        gtvRequest.createUserDevice(tvCode.getValue(), tvName.getValue()).fire(
    			new Receiver<UserDeviceProxy>() {
    				public void onFailure(ServerFailure error) {
    				}

    				@Override
    				public void onSuccess(UserDeviceProxy userDevice) {
    					if (userDevice != null) {
    						tvSelection.addUserDevice(userDevice);
    					} else {
    						//device not found
    						setStatus("Device not found...", false);
    						tvCode.setValue("");
    					}
    				}
    			});
      }
    });

    sayHelloButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        sayHelloButton.setEnabled(false);
        HelloWorldRequest helloWorldRequest = requestFactory.helloWorldRequest();
        helloWorldRequest.getMessage().fire(new Receiver<String>() {
          @Override
          public void onFailure(ServerFailure error) {
            sayHelloButton.setEnabled(true);
            setStatus(error.getMessage(), true);
          }

          @Override
          public void onSuccess(String response) {
            sayHelloButton.setEnabled(true);
            setStatus(response, response.startsWith("Failure:"));
          }
        });
      }
    });
  }
}
