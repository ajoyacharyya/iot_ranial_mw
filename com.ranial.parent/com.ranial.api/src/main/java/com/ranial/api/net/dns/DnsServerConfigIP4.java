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
package com.ranial.api.net.dns;

import java.util.Set;

import com.ranial.api.net.IP4Address;
import com.ranial.api.net.NetworkPair;

/**
 * DNS server configurations for IPv4 networks
 * 
 * @author eurotech
 *
 */
public class DnsServerConfigIP4 extends DnsServerConfigIP<IP4Address> implements DnsServerConfig4 {

	public DnsServerConfigIP4(Set<IP4Address> forwarders, Set<NetworkPair<IP4Address>> allowedNetworks) {
		super(forwarders, allowedNetworks);
	}

	
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
}
