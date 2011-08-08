/**
 * "THE BEER-WARE LICENSE" (Revision 42): 
 * Nicolas FRANCOIS wrote this software. As long as you retain this notice 
 * you can do whatever you want with this stuff. If we meet some day, 
 * and you think this stuff is worth it, you can buy me a beer in 
 * return.
 */
package com.googlecode.konamigwt.client;

/**
 * Handler for the Konami Code.
 * @author Nicolas François
 *
 */
public interface KonamiHandler {
	
	/**
	 * Call when the konami code is performed.
	 */
	void onKonamiCodePerformed();

}
