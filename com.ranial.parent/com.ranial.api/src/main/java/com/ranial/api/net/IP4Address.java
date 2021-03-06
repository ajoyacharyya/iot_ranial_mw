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

/**
 * This class represents an Internet Protocol version 4 (IPv4) address. 
 */
public class IP4Address extends IPAddress 
{
	IP4Address(byte[] addr, java.net.InetAddress jnAddress) {
		super(addr, jnAddress);
	}
	
	@Override
	public String toString() {
	    return this.getHostAddress();
	}
}
