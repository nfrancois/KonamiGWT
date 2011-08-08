/**
 * "THE BEER-WARE LICENSE" (Revision 42): 
 * Nicolas FRANCOIS wrote this software. As long as you retain this notice 
 * you can do whatever you want with this stuff. If we meet some day, 
 * and you think this stuff is worth it, you can buy me a beer in 
 * return.
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

