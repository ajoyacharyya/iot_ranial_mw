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
package com.ranial.api.net.dhcp;

import java.util.List;

import com.ranial.api.net.IP6Address;

/**
 * The configuration representing a DHCP server configuration for an IPv6 network.
 * 
 * @author eurotech
 *
 */
public class DhcpServerConfigIP6 extends DhcpServerConfigIP<IP6Address> implements DhcpServerConfig6 {

	/**
	 * The basic Constructor for a DhcpServerConfigIP6
	 * 
	 * @param interfaceName			the interface name associated with the DhcpServerConfig
	 * @param enabled      			the status of the DhcpServer as a {@link boolean }
	 * @param subnet				the subnet of the DhcpServerConfig
	 * @param routerAddress			the router IPAddress
	 * @param subnetMask			the subnet mask of the DhcpServerConfig
	 * @param defaultLeaseTime		the default lease time to issue to DHCP clients
	 * @param maximumLeaseTime		the maximum lease time to issue to DHCP clients
	 * @param prefix				the network prefix associated with the DhcpServerConfig
	 * @param rangeStart			the network starting address to issue to DHCP clients
	 * @param rangeEnd				the network ending address to issue to DHCP clients
	 * @param passDns				whether or not to pass DNS to DHCP clients
	 * @param dnsServers			the DNS servers that will get passed to DHCP clients if passDns is true
	 */
	public DhcpServerConfigIP6(String interfaceName, boolean enabled, IP6Address subnet, IP6Address routerAddress, IP6Address subnetMask, int defaultLeaseTime, int maximumLeaseTime,
			short prefix, IP6Address rangeStart, IP6Address rangeEnd, boolean passDns, List<IP6Address> dnsServers) {

		super(interfaceName, enabled, subnet, routerAddress, subnetMask, defaultLeaseTime, maximumLeaseTime,
				prefix, rangeStart, rangeEnd, passDns, dnsServers);

	}
}
