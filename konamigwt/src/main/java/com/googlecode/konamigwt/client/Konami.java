/*
 * Copyright 2010 Nicolas FRANCOIS
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.konamigwt.client;

import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Event.NativePreviewEvent;
import com.google.gwt.user.client.Event.NativePreviewHandler;

/**
 * Konami code monitor.
 * 
 * @author Nicolas François
 *
 */
public class Konami {

	/**
	 * The konami code sequence in ascii.
	 */
	private final static String KONAMICODE_SEQUENCE = "38384040373937396665";
	
	private final KonamiHandler konamiHandler;
	private String lastInputs = "";
	
	
	/**
	 * Constructor with the konami handler.
	 * @param konamiHandler
	 */
	public Konami(KonamiHandler konamiHandler){
		this.konamiHandler = konamiHandler;
	}

	/**
	 * Start the konami code execution monitoring. 
	 */
	public void start(){
		final NativePreviewHandler nph = new NativePreviewHandler() {

			@Override
			public void onPreviewNativeEvent(NativePreviewEvent event) {
				if(event.getTypeInt() == Event.ONKEYDOWN){
					lastInputs+= event.getNativeEvent().getKeyCode();
					if(lastInputs.length()>KONAMICODE_SEQUENCE.length()){
						lastInputs = lastInputs.substring(lastInputs.length()-KONAMICODE_SEQUENCE.length());
					}
					if(KONAMICODE_SEQUENCE.equals(lastInputs)){
						lastInputs = "";
						konamiHandler.onKonamiCodePerformed();
					}
				}
			}
		};
		Event.addNativePreviewHandler(nph);
	}		
}

