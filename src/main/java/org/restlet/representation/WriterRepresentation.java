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
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

import org.restlet.data.CharacterSet;
import org.restlet.data.MediaType;
import org.restlet.engine.io.BioUtils;

/**
 * Representation based on a BIO characters writer. This class is a good basis
 * to write your own representations, especially for the dynamic and large ones. <br>
 * <br>
 * For this you just need to create a subclass and override the abstract
 * Representation.write(Writer) method. This method will later be called back by
 * the connectors when the actual representation's content is needed.
 * 
 * @author Jerome Louvel
 */
public abstract class WriterRepresentation extends CharacterRepresentation {

    /**
     * Constructor.
     * 
     * @param mediaType
     *            The representation's mediaType.
     */
    public WriterRepresentation(MediaType mediaType) {
        super(mediaType);
    }

    /**
     * Constructor.
     * 
     * @param mediaType
     *            The representation's mediaType.
     * @param expectedSize
     *            The expected writer size in bytes.
     */
    public WriterRepresentation(MediaType mediaType, long expectedSize) {
        super(mediaType);
        setSize(expectedSize);
    }

    @Override
    public Reader getReader() throws IOException {
        return BioUtils.getReader(this);
    }

    /**
     * Calls parent's implementation.
     */
    @Override
    public void release() {
        super.release();
    }

    @Override
    public void write(OutputStream outputStream) throws IOException {
        Writer writer = null;

        if (getCharacterSet() != null) {
            writer = new OutputStreamWriter(outputStream, getCharacterSet()
                    .getName());
        } else {
            // Use the default HTTP character set
            writer = new OutputStreamWriter(outputStream,
                    CharacterSet.ISO_8859_1.getName());
        }

        write(writer);
        writer.flush();
    }

}
