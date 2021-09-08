package com.dubbo.protocol.http;

import com.dubbo.framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author pansw
 */
public class HttpClient {


	public String send(String hostName, int port, Invocation invocation) {
		try {
			URL url = new URL("http", hostName, port, "/");

			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setDoOutput(true);

			OutputStream outputStream = httpURLConnection.getOutputStream();

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(invocation);
			objectOutputStream.flush();
			objectOutputStream.close();

			InputStream inputStream = httpURLConnection.getInputStream();

			String result	=IOUtils.toString(inputStream);

			return result;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
