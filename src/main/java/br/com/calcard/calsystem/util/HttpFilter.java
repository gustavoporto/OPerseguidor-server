package br.com.calcard.calsystem.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class HttpFilter implements Filter {

	RequestWrapper requestWrapper;
	ResponseWrapper responseWrapper;

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {

		requestWrapper = new RequestWrapper((HttpServletRequest) request);

		// responseWrapper = new ResponseWrapper((HttpServletResponse)
		// response);

		// readHeader();

		String token = requestWrapper.getHeader("hashToken");
		String idPeriferico = requestWrapper.getHeader("idPeriferico");

		filterChain.doFilter(requestWrapper, response);

	}

	private boolean readHeader() {

		if (requestWrapper.getHeader("calsystem") != null) {

			// String crypt = CriptografiaService.RSA.decrypt(requestWrapper
			// .getHeader("calsystem"));
			//
			// String header = CriptografiaService.Utils.base64_decode(crypt);
			//
			// System.out.println("Header: " + header);

		}

		return false;

	}

	public void destroy() {

	}

	private static class ResponseWrapper extends HttpServletResponseWrapper {

		protected ServletOutputStream out;

		public ResponseWrapper(HttpServletResponse response) {
			super(response);
			try {
				out = response.getOutputStream();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public ServletOutputStream getOutputStream() {

			return out;

		}

	}

	private static class RequestWrapper extends HttpServletRequestWrapper {

		// private byte[] rawData;
		// private HttpServletRequest request;
		// private ResettableServletInputStream servletStream;

		public RequestWrapper(HttpServletRequest request) {
			super(request);
			// this.request = request;
			// this.servletStream = new ResettableServletInputStream();
		}

		// public ServletInputStream getInputStream() throws IOException {
		//
		// if (rawData == null) {
		// rawData = IOUtils.toByteArray(this.request.getReader());
		// servletStream.stream = new ByteArrayInputStream(rawData);
		//
		// // String msgOriginal = CriptografiaService.RSA.decrypt(IOUtils
		// // .toString(this.getReader()));
		//
		// // servletStream.stream = IOUtils.toInputStream(
		// // CriptografiaService.Utils.base64_decode(msgOriginal),
		// // "UTF-8");
		//
		// }
		//
		// return servletStream;
		//
		// }
		//
		// public BufferedReader getReader() throws IOException {
		// if (rawData == null) {
		// rawData = IOUtils.toByteArray(this.request.getReader());
		// servletStream.stream = new ByteArrayInputStream(rawData);
		// }
		//
		// return new BufferedReader(new InputStreamReader(servletStream));
		// }
		//
		// private class ResettableServletInputStream extends ServletInputStream
		// {
		//
		// private InputStream stream;
		//
		// @Override
		// public int read() throws IOException {
		// return stream.read();
		// }
		// }

	}

}
