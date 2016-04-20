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
package com.ranial.api.linux.udev;

import com.ranial.api.usb.UsbDevice;

public interface LinuxUdevListener {

	/**
	 * Callback for notifications of new UsbDevice ATTACH events
	 *
	 * @param device	The UsbDevice that was just attached
	 */
	void attached(UsbDevice device);

	/**
	 * Callback for notifications of new UsbDevice DETACH events
	 *
	 * @param device	The UsbDevice that was just detached
	 */
	void detached(UsbDevice device);
}

