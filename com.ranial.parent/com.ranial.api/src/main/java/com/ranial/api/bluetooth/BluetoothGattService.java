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
package com.ranial.api.bluetooth;

import java.util.List;
import java.util.UUID;

public interface BluetoothGattService {

	/*
	 * Get characteristic based on UUID
	 */
	public BluetoothGattCharacteristic getCharacteristic(UUID uuid);
	
	/*
	 * Get list of characteristics of the service
	 */
	public List<BluetoothGattCharacteristic> getCharacterisitcs();
	
	/*
	 * Return the UUID of this service
	 */
	public UUID getUuid();

	public String getStartHandle();
	
	public String getEndHandle();
	
}
