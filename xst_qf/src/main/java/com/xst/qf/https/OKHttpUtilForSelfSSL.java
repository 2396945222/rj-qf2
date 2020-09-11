package com.xst.qf.https;

import okhttp3.*;
import okhttp3.Request.Builder;

import javax.net.ssl.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class OKHttpUtilForSelfSSL {

	private static final String GET = "get";
	private static final String POST = "post";
	private static final String PUT = "put";
	private static final String DELETE = "delete";
	private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


	private static final OKHttpUtilForSelfSSL okhttpUtil = new OKHttpUtilForSelfSSL();
	private static OkHttpClient client;


	@SuppressWarnings("deprecation")
	private OKHttpUtilForSelfSSL() {
		final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
			}


			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType)
					throws CertificateException {
			}


			@Override
			public X509Certificate[] getAcceptedIssuers() {
				X509Certificate[] x509Certificates = new X509Certificate[0];
				return x509Certificates;
			}
		} };


		SSLContext sslContext;
		try {
			sslContext = SSLContext.getInstance("SSL");
			sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
			client = new OkHttpClient().newBuilder().sslSocketFactory(sslContext.getSocketFactory()).hostnameVerifier(new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}

			}).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static final OKHttpUtilForSelfSSL Builder() {
		return okhttpUtil;
	}


	public Object get(String url) throws Exception {
		return get(url, null);
	}


	public Object get(String url, Map<String, String> headers) throws Exception {
		return responseBody(url, GET, null, headers);
	}


	public String getAndReturnJson(String url) throws Exception {
		return getAndReturnJson(url, new HashMap<String, String>());
	}


	public String getAndReturnJson(String url, Map<String, String> headers) throws Exception {
		Object obj = responseBody(url, GET, null, headers);
		return obj == null ? null : com.alibaba.fastjson.JSON.toJSONString(obj);
	}


	public Object post(String url, String json) throws Exception {
		return post(url, json, new HashMap<String, String>());
	}


	public Object post(String url, String json, Map<String, String> headers) throws Exception {
		return responseBody(url, POST, json, headers);
	}


	public String postAndReturnJson(String url, String json) throws Exception {
		return postAndReturnJson(url, json, new HashMap<String, String>());
	}


	public String postAndReturnJson(String url, String json, Map<String, String> headers) throws Exception {
		Object obj = responseBody(url, POST, json, headers);
		return obj == null ? null :  com.alibaba.fastjson.JSON.toJSONString(obj);
	}


	private Object responseBody(String url, String type, String json, Map<String, String> headers) throws Exception {
		Builder builder = new Builder().url(url);
		Set<Entry<String, String>> set = headers.entrySet();
		Iterator<Entry<String, String>> iter = set.iterator();
		Entry<String, String> entry = null;
		while (iter.hasNext()) {
			entry = iter.next();
			System.out.println(entry.toString());
			builder.addHeader(entry.getKey(), entry.getValue());
			System.out.println(builder);
		}
		RequestBody body = null;
		Request request = null;
		Response response = null;
		Object value = null;
		if (json != null) {
			body = RequestBody.create(JSON, json);
		}
		switch (type) {
		case GET:
			request = builder.build();
			break;
		case POST:
			request = builder.post(body).build();
			break;
		case PUT:
			request = builder.put(body).build();
			break;
		case DELETE:
			if (body == null) {
				request = builder.delete().build();
			} else {
				request = builder.delete(body).build();
			}
			break;
		default:
			break;
		}


		response = client.newCall(request).execute();
		if (response.isSuccessful()) {
			value = response.body().string();
		} else {
			throw new RuntimeException("状态码:" + response.code() + ", message:" + response.message()+",body:"+response.body().string());
		}


		return value;
	}

	/**
	 * Post请求发送JSON数据....{"name":"zhangsan","pwd":"123456"}
	 * 参数一：请求Url
	 * 参数二：请求的JSON
	 * 参数三：请求回调
	 */
	public static String postJsonParams(String url, String jsonParams) {
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonParams);

		requestBody.contentType();
		Request request = new Builder()

				.header("Content-Type","application/json")
				.url(url)
				.post(requestBody)
				.build();

		return execNewCall(request);
	}
	/**
	 * 调用okhttp的newCall方法
	 * @param request
	 * @return
	 */
	private static String execNewCall(Request request){
		Response response = null;
		try {
			OkHttpClient okHttpClient = new OkHttpClient();
			response = okHttpClient.newCall(request).execute();
			int status = response.code();
			if (response.isSuccessful()) {
				return response.body().string();
			}
		} catch (Exception e) {
			System.out.println("okhttp3 put error >> ex = {}");
		} finally {
			if (response != null) {
				response.close();
			}
		}
		return "erro";
	}


}


