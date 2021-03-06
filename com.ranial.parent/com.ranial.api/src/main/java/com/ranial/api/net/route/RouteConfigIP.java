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

import com.ranial.api.net.IPAddress;

/**
 * Base class for Route configurations
 *
 * @param <T>
 */
public abstract class RouteConfigIP<T extends IPAddress> implements RouteConfig {

	private T 		m_destination;
	private T 		m_gateway;
	private T 		m_netmask;
	private String 	m_interfaceName;
	private int		m_metric;
	
	public RouteConfigIP(T destination, T gateway, T netmask, String interfaceName, int metric) {
		super();
		
		m_destination = destination;
		m_gateway = gateway;
		m_netmask = netmask;
		m_interfaceName = interfaceName;
		m_metric = metric;
	}

	
	public String getDescription() {
		StringBuffer desc = new StringBuffer();
		String gw;
		if(m_gateway == null) {
			gw = "default";
		} else {
			gw = m_gateway.getHostAddress();
		}
		desc.append("Destination: " + m_destination.getHostAddress() + ", " +
				"Gateway: " + gw + ", " +
				"Netmask: " + m_netmask.getHostAddress() + ", " +
				"Interface: " + m_interfaceName + ", " +
				"Metric: " + m_metric);
		return desc.toString();
	}

	
	public T getDestination() {
		return m_destination;
	}

	public void setDestination(T destination) {
		m_destination = destination;
	}

	
	public T getGateway() {
		return m_gateway;
	}

	public void setGateway(T gateway) {
		m_gateway = gateway;
	}

	
	public T getNetmask() {
		return m_netmask;
	}

	public void setNetmask(T netmask) {
		m_netmask = netmask;
	}

	
	public String getInterfaceName() {
		return m_interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		m_interfaceName = interfaceName;
	}

	
	public int getMetric() {
		return m_metric;
	}

	public void setMetric(int metric) {
		m_metric = metric;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((m_destination == null) ? 0 : m_destination.hashCode());
		result = prime * result
				+ ((m_gateway == null) ? 0 : m_gateway.hashCode());
		result = prime * result
				+ ((m_interfaceName == null) ? 0 : m_interfaceName.hashCode());
		result = prime * result + m_metric;
		result = prime * result
				+ ((m_netmask == null) ? 0 : m_netmask.hashCode());
		return result;
	}

	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		RouteConfigIP other = (RouteConfigIP) obj;
		if (m_destination == null) {
			if (other.m_destination != null)
				return false;
		} else if (!m_destination.equals(other.m_destination))
			return false;
		if (m_gateway == null) {
			if (other.m_gateway != null)
				return false;
		} else if (!m_gateway.equals(other.m_gateway))
			return false;
		if (m_interfaceName == null) {
			if (other.m_interfaceName != null)
				return false;
		} else if (!m_interfaceName.equals(other.m_interfaceName))
			return false;
		if (m_metric != other.m_metric)
			return false;
		if (m_netmask == null) {
			if (other.m_netmask != null)
				return false;
		} else if (!m_netmask.equals(other.m_netmask))
			return false;
		return true;
	}
	
	
	public boolean isValid() {
		if(m_destination == null || m_gateway == null || m_netmask == null ||
				m_interfaceName == null) {
			return false;
		}
		
		return true;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RouteConfigIP [m_destination=");
		builder.append(m_destination);
		builder.append(", m_gateway=");
		builder.append(m_gateway);
		builder.append(", m_netmask=");
		builder.append(m_netmask);
		builder.append(", m_interfaceName=");
		builder.append(m_interfaceName);
		builder.append(", m_metric=");
		builder.append(m_metric);
		builder.append("]");
		return builder.toString();
	}
}
