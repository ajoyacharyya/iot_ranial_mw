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
package com.ranial.api.cloud;

import com.ranial.api.KuraException;
import com.ranial.api.message.KuraPayload;

public interface CloudPayloadProtoBufEncoder {
	/**
	 * Encodes a {@link com.ranial.api.message.KuraPayload} to a Google Protocol Buffers encoded, optionally gzipped, binary payload.
	 * 
	 * @param kuraPayload
	 * @param gzipped
	 * @return
	 * @throws KuraException
	 */
	byte[] getBytes(KuraPayload kuraPayload, boolean gzipped) throws KuraException;
}
