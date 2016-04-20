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
package com.ranial.api.command;

import java.io.IOException;

import com.ranial.api.KuraException;
import com.ranial.api.message.KuraRequestPayload;
import com.ranial.api.message.KuraResponsePayload;

/**
 * This interface provides methods for running system commands from the web console.
 *
 */
public interface CommandService {

	public String execute(String cmd) throws KuraException;
}
