/**
 * Copyright 2005-2011 Noelios Technologies.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL 1.0 (the
 * "Licenses"). You can select the license that you prefer but you may not use
 * this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0.html
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1.php
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1.php
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0.php
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.noelios.com/products/restlet-engine
 * 
 * Restlet is a registered trademark of Noelios Technologies.
 */

package org.restlet.representation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

/**
 * Empty representation with no content. It is always considered available but
 * calling the {@link #getText()} method for example will return an empty
 * string. It can also have regular metadata available.
 * 
 * @author Jerome Louvel
 */
public class EmptyRepresentation extends Representation {

    /**
     * Constructor.
     */
    public EmptyRepresentation() {
        setAvailable(false);
        setTransient(true);
        setSize(0);
    }

    @Override
    public java.nio.channels.ReadableByteChannel getChannel()
            throws IOException {
        return null;
    }

    @Override
    public Reader getReader() throws IOException {
        return null;
    }

    @Override
    public InputStream getStream() throws IOException {
        return null;
    }

    @Override
    public String getText() throws IOException {
        return null;
    }

    @Override
    public void write(java.io.Writer writer) throws IOException {
        // Do nothing
    }

    @Override
    public void write(java.nio.channels.WritableByteChannel writableChannel)
            throws IOException {
        // Do nothing
    }

    @Override
    public void write(OutputStream outputStream) throws IOException {
        // Do nothing
    }
}