package org.apache.commons.fileupload;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 *
 *
 *
 *
 *
 */
class MyHttpServletRequest implements HttpServletRequest
{

	private byte[] m_requestData;
	private String m_strContentType;
	private Map m_headers = new java.util.HashMap();

	public MyHttpServletRequest(
			final byte[] requestData,
			final String strContentType)
	{
		m_requestData = requestData;
		m_strContentType = strContentType;
		m_headers.put(FileUploadBase.CONTENT_TYPE, strContentType);
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getAuthType()
	 */
	public String getAuthType()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getCookies()
	 */
	public Cookie[] getCookies()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getDateHeader(String)
	 */
	public long getDateHeader(String arg0)
	{
		return 0;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getHeader(String)
	 */
	public String getHeader(String headerName)
	{
		return (String) m_headers.get(headerName);
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getHeaders(String)
	 */
	public Enumeration getHeaders(String arg0)
	{
		// todo - implement
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getHeaderNames()
	 */
	public Enumeration getHeaderNames()
	{
		// todo - implement
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getIntHeader(String)
	 */
	public int getIntHeader(String arg0)
	{
		return 0;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getMethod()
	 */
	public String getMethod()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getPathInfo()
	 */
	public String getPathInfo()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getPathTranslated()
	 */
	public String getPathTranslated()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getContextPath()
	 */
	public String getContextPath()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getQueryString()
	 */
	public String getQueryString()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getRemoteUser()
	 */
	public String getRemoteUser()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#isUserInRole(String)
	 */
	public boolean isUserInRole(String arg0)
	{
		return false;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getUserPrincipal()
	 */
	public Principal getUserPrincipal()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getRequestedSessionId()
	 */
	public String getRequestedSessionId()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getRequestURI()
	 */
	public String getRequestURI()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getRequestURL()
	 */
	public StringBuffer getRequestURL()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getServletPath()
	 */
	public String getServletPath()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getSession(boolean)
	 */
	public HttpSession getSession(boolean arg0)
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#getSession()
	 */
	public HttpSession getSession()
	{
		return null;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdValid()
	 */
	public boolean isRequestedSessionIdValid()
	{
		return false;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromCookie()
	 */
	public boolean isRequestedSessionIdFromCookie()
	{
		return false;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromURL()
	 */
	public boolean isRequestedSessionIdFromURL()
	{
		return false;
	}

	/**
	 * @see javax.servlet.http.HttpServletRequest#isRequestedSessionIdFromUrl()
	 * @deprecated
	 */
	public boolean isRequestedSessionIdFromUrl()
	{
		return false;
	}

	/**
	 * @see javax.servlet.ServletRequest#getAttribute(String)
	 */
	public Object getAttribute(String arg0)
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getAttributeNames()
	 */
	public Enumeration getAttributeNames()
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getCharacterEncoding()
	 */
	public String getCharacterEncoding()
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#setCharacterEncoding(String)
	 */
	public void setCharacterEncoding(String arg0)
		throws UnsupportedEncodingException
	{
	}

	/**
	 * @see javax.servlet.ServletRequest#getContentLength()
	 */
	public int getContentLength()
	{
		int iLength = 0;

		if (null == m_requestData)
		{
			iLength = -1;
		}
		else
		{
			iLength = m_requestData.length;
		}
		return iLength;
	}

	/**
	 * @see javax.servlet.ServletRequest#getContentType()
	 */
	public String getContentType()
	{
		return m_strContentType;
	}

	/**
	 * @see javax.servlet.ServletRequest#getInputStream()
	 */
	public ServletInputStream getInputStream() throws IOException
	{
		ServletInputStream sis = new MyServletInputStream(m_requestData);
		return sis;
	}

	/**
	 * @see javax.servlet.ServletRequest#getParameter(String)
	 */
	public String getParameter(String arg0)
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getParameterNames()
	 */
	public Enumeration getParameterNames()
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getParameterValues(String)
	 */
	public String[] getParameterValues(String arg0)
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getParameterMap()
	 */
	public Map getParameterMap()
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getProtocol()
	 */
	public String getProtocol()
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getScheme()
	 */
	public String getScheme()
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getServerName()
	 */
	public String getServerName()
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getServerPort()
	 */
	public int getServerPort()
	{
		return 0;
	}

	/**
	 * @see javax.servlet.ServletRequest#getReader()
	 */
	public BufferedReader getReader() throws IOException
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getRemoteAddr()
	 */
	public String getRemoteAddr()
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getRemoteHost()
	 */
	public String getRemoteHost()
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#setAttribute(String, Object)
	 */
	public void setAttribute(String arg0, Object arg1)
	{
	}

	/**
	 * @see javax.servlet.ServletRequest#removeAttribute(String)
	 */
	public void removeAttribute(String arg0)
	{
	}

	/**
	 * @see javax.servlet.ServletRequest#getLocale()
	 */
	public Locale getLocale()
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getLocales()
	 */
	public Enumeration getLocales()
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#isSecure()
	 */
	public boolean isSecure()
	{
		return false;
	}

	/**
	 * @see javax.servlet.ServletRequest#getRequestDispatcher(String)
	 */
	public RequestDispatcher getRequestDispatcher(String arg0)
	{
		return null;
	}

	/**
	 * @see javax.servlet.ServletRequest#getRealPath(String)
	 * @deprecated
	 */
	public String getRealPath(String arg0)
	{
		return null;
	}

	/**
	 *
	 *
	 *
	 *
	 */
	private static class MyServletInputStream
		extends javax.servlet.ServletInputStream
	{
		private ByteArrayInputStream m_bais;

		public MyServletInputStream(byte[] data)
		{
			m_bais = new ByteArrayInputStream(data);
		}

		public int read()
		{
			return m_bais.read();
		}
	}
}
