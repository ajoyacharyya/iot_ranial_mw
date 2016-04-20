/*******************************************************************************
 * Copyright (c) 2011, 2016 Eurotech and/or its affiliates
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech
 *******************************************************************************/
package com.ranial.api.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * This class represents an Internet Protocol (IP) address.
 */
public abstract class IPAddress 
{
	private   byte[] address;
	protected java.net.InetAddress javaNetAddress;
	
	IPAddress(byte[] address,
				java.net.InetAddress jnAddress) 
	{
		this.address = address;
		this.javaNetAddress = jnAddress;
	}
	
	/**
	 * Returns an InetAddress object given the raw IP address. 
	 * The argument is in network byte order: the highest order byte of the address is in getAddress()[0].
	 * This method doesn't block, i.e. no reverse name service lookup is performed.
	 * <br/>
	 * IPv4 address byte array must be 4 bytes long and IPv6 byte array must be 16 bytes long
	 * @param addr - the raw IP address in network byte order
	 * @return an InetAddress object created from the raw IP address.
	 */
	public static IPAddress getByAddress(byte[] addr)
		throws UnknownHostException
	{
		IPAddress result = null;
		java.net.InetAddress jnetAddr = null;
		if(addr.length==16) {
	    	StringBuffer sb = new StringBuffer();
	    	for(int i=0; i<16; i=i+2) {
	       		sb.append(Integer.toHexString(0xFF & addr[i]));
	       		sb.append(Integer.toHexString(0xFF & addr[i+1]));
	       		if(i!=14) {
	       			sb.append(":");
	       		}
	       	}
	    	jnetAddr = java.net.InetAddress.getByName(sb.toString());
		} else {
			jnetAddr = java.net.InetAddress.getByAddress(addr);
		}
		if (jnetAddr instanceof java.net.Inet4Address) {
			result = new IP4Address(addr, jnetAddr);
		}
		else if (jnetAddr instanceof java.net.Inet6Address) {
			result = new IP6Address(addr, jnetAddr);
		}
		return result;
	}
	
	//TODO - only works on IPv4 now
	public static IPAddress getByAddress(int addr) throws UnknownHostException {

		StringBuffer sb = new StringBuffer();
		for (int shift = 24; shift > 0; shift -= 8) {
			// process 3 bytes, from high order byte down
			sb.append(Integer.toString((addr >>> shift) & 0xff));
			sb.append('.');
		}
		sb.append(Integer.toString(addr & 0xff));

		InetAddress jnetAddr = InetAddress.getByName(sb.toString());
		return getByAddress(jnetAddr.getAddress());
	}
	
	/**
	 * Parse a literal representation of an IP address and returns the 
	 * corresponding IPAddress class.
	 * 
	 * @param hostAddress
	 * @return
	 */
	public static IPAddress parseHostAddress(String hostAddress)
		throws UnknownHostException
	{
		InetAddress jnetAddr = InetAddress.getByName(hostAddress);
		return getByAddress(jnetAddr.getAddress()); 
	}
	
	/**
	 * Returns the raw IP address of this InetAddress object. 
	 * The result is in network byte order: the highest order byte of the address is in getAddress()[0].
	 * @return the raw IP address of this object.
	 */
	public byte[] getAddress() {
		return address;
	}

	/**
	 * Returns the IP address string in textual presentation.
	 * @return the raw IP address in a string format.
	 */
	public String getHostAddress() {
		return javaNetAddress.getHostAddress();
	}

	/**
	 * Utility routine to check if the InetAddress in a wildcard address.
	 * @return a boolean indicating if the Inetaddress is a wildcard address.
	 */
	public boolean isAnyLocalAddress() {
		return javaNetAddress.isAnyLocalAddress();
	}

	/**
	 * Utility routine to check if the InetAddress is an link local address.
	 * @return a boolean indicating if the InetAddress is a link local address; or false if address is not a link local unicast address.
	 */
	public boolean isLinkLocalAddress() {
		return javaNetAddress.isLinkLocalAddress();
	}

	/**
	 * Utility routine to check if the InetAddress is a loopback address.
	 * @return a boolean indicating if the InetAddress is a loopback address; or false otherwise.
	 */
	public boolean isLoopbackAddress() {
		return javaNetAddress.isLoopbackAddress();
	}

	/**
	 * Utility routine to check if the multicast address has global scope.
	 * @return a boolean indicating if the address has is a multicast address of global scope, false if it is not of global scope or it is not a multicast address
	 */
	public boolean isMCGlobal() {
		return javaNetAddress.isMCGlobal();
	}

	/**
	 * Utility routine to check if the multicast address has link scope.
	 * @return a boolean indicating if the address has is a multicast address of link-local scope, false if it is not of link-local scope or it is not a multicast address
	 */
	public boolean isMCLinkLocal() {
		return javaNetAddress.isMCLinkLocal();
	}

	/**
	 * Utility routine to check if the multicast address has node scope.
	 * @return a boolean indicating if the address has is a multicast address of node-local scope, false if it is not of node-local scope or it is not a multicast address
	 */
	public boolean isMCNodeLocal() {
		return javaNetAddress.isMCNodeLocal();
	}

	/**
	 * Utility routine to check if the multicast address has organization scope.
	 * @return a boolean indicating if the address has is a multicast address of organization-local scope, false if it is not of organization-local scope or it is not a multicast address
	 */
	public boolean isMCOrgLocal() {
		return javaNetAddress.isMCOrgLocal();
	}

	/**
	 * Utility routine to check if the multicast address has site scope.
	 * @return a boolean indicating if the address has is a multicast address of site-local scope, false if it is not of site-local scope or it is not a multicast address
	 */
	public boolean isMCSiteLocal() {
		return javaNetAddress.isMCSiteLocal();
	}

	/**
	 * Utility routine to check if the InetAddress is an IP multicast address.
	 * @return
	 */
	public boolean isMulticastAddress() {
		return javaNetAddress.isMulticastAddress();
	}

	/**
	 * Utility routine to check if the InetAddress is a site local address.}
	 * @return a boolean indicating if the InetAddress is a site local address; or false if address is not a site local unicast address.
	 */
	public boolean isSiteLocalAddress() {
		return javaNetAddress.isSiteLocalAddress();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(address);
		result = prime * result
				+ ((javaNetAddress == null) ? 0 : javaNetAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IPAddress other = (IPAddress) obj;
		if (!Arrays.equals(address, other.address))
			return false;
		if (javaNetAddress == null) {
			if (other.javaNetAddress != null)
				return false;
		} else if (!javaNetAddress.equals(other.javaNetAddress))
			return false;
		return true;
	}	
}
