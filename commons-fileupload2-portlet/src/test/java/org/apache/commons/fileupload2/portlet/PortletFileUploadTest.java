/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.fileupload2.portlet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload2.AbstractFileUploadTest;
import org.apache.commons.fileupload2.Constants;
import org.apache.commons.fileupload2.FileItem;
import org.apache.commons.fileupload2.FileUpload;
import org.apache.commons.fileupload2.FileUploadException;
import org.apache.commons.fileupload2.disk.DiskFileItemFactory;
import org.apache.commons.fileupload2.javax.MockHttpServletRequest;
import org.apache.commons.fileupload2.javax.ServletRequestContext;
import org.junit.jupiter.api.Test;

/**
 * Test for {@link PortletFileUpload}.
 *
 * @see AbstractFileUploadTest
 * @since 1.4
 */
public class PortletFileUploadTest extends AbstractFileUploadTest {

    public PortletFileUploadTest() {
        super(new PortletFileUpload(new DiskFileItemFactory()));
    }

    @Test
    public void parseParameterMap() throws Exception {
        // @formatter:off
        final String text = "-----1234\r\n" +
                      "Content-Disposition: form-data; name=\"file\"; filename=\"foo.tab\"\r\n" +
                      "Content-Type: text/whatever\r\n" +
                      "\r\n" +
                      "This is the content of the file\n" +
                      "\r\n" +
                      "-----1234\r\n" +
                      "Content-Disposition: form-data; name=\"field\"\r\n" +
                      "\r\n" +
                      "fieldValue\r\n" +
                      "-----1234\r\n" +
                      "Content-Disposition: form-data; name=\"multi\"\r\n" +
                      "\r\n" +
                      "value1\r\n" +
                      "-----1234\r\n" +
                      "Content-Disposition: form-data; name=\"multi\"\r\n" +
                      "\r\n" +
                      "value2\r\n" +
                      "-----1234--\r\n";
        // @formatter:on
        final byte[] bytes = text.getBytes(StandardCharsets.US_ASCII);
        final ActionRequest request = new MockPortletActionRequest(bytes, Constants.CONTENT_TYPE);

        final Map<String, List<FileItem>> mappedParameters = ((PortletFileUpload) upload).parseParameterMap(request);
        assertTrue(mappedParameters.containsKey("file"));
        assertEquals(1, mappedParameters.get("file").size());

        assertTrue(mappedParameters.containsKey("field"));
        assertEquals(1, mappedParameters.get("field").size());

        assertTrue(mappedParameters.containsKey("multi"));
        assertEquals(0, mappedParameters.get("multi").size());
    }

    @Override
    public List<FileItem> parseUpload(final FileUpload upload, final byte[] bytes, final String contentType) throws FileUploadException {
        final HttpServletRequest request = new MockHttpServletRequest(bytes, contentType);
        return upload.parseRequest(new ServletRequestContext(request));
    }

}
