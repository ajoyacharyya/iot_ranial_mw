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
package com.ranial.api.net.route;

import com.ranial.api.net.IP6Address;

/**
 * Implementation of IPv6 route configurations
 */
public class RouteConfigIP6 extends RouteConfigIP<IP6Address> implements RouteConfig6 {

	public RouteConfigIP6(IP6Address destination, IP6Address gateway,
			IP6Address netmask, String interfaceName, int metric) {
		super(destination, gateway, netmask, interfaceName, metric);
	}

	public boolean equals(RouteConfig r) {
		// TODO Auto-generated method stub
		return false;
	}
}