package com.unicom.pay.lt.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.unicom.pay.lt.util.ConfigurationManager;
import com.unicom.pay.lt.util.HttpClientUtil;

/**
 * Filename:WoBFService.java Description: 沃百富接口查询服务
 * 
 * @author litong
 * @date 2017年5月22日 下午2:26:28
 */
public class WoBFService {

	// 变量定义
	private static WoBFService instance = null;
	private String url = "";
	private String merchantName = "";

	/**
	 * 构建类
	 */
	private WoBFService() {
		url = ConfigurationManager.getProperty("woBF.tokenUrl");
		merchantName = ConfigurationManager.getProperty("woBF.merchantName");
	}

	/**
	 * 单例模式
	 * 
	 * @return
	 */
	public static WoBFService getInstance() {
		if (instance == null) {
			synchronized (WoBFService.class) {
				if (instance == null) {
					instance = new WoBFService();
				}
			}
		}
		return instance;
	}

	/**
	 * 获取初始化的StringEntity
	 * 
	 * @param jsonObj
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static StringEntity getStringEntity(JSONObject jsonObj) {
		StringEntity entity = null;
		try {
			// 设置编码UTF-8和数据格式为json数据
			/*entity = new StringEntity(jsonObj.toJSONString());
			entity.setContentEncoding("UTF‐8");
			entity.setContentType("application/json");*/
			entity = new StringEntity(JSON.toJSONString(jsonObj),"application/json","utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	/**
	 * 获取token
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String getToken() throws IOException {
		HttpPost post = new HttpPost(this.url);
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("merchantName", merchantName);
		System.out.println("请求消息体是:");
		System.out.println(jsonObj);

		post.setEntity(getStringEntity(jsonObj));
		post.setHeader("merchantName", merchantName);

		String res = "无返回结果";
		res = HttpClientUtil.post(post, this.url);
		System.out.println("请求结果如下:");
		System.out.println(res);
		return res;
	}

	public String getData(String token, String url, JSONObject jsonObj) throws IOException {
		HttpPost post = new HttpPost(url);
		System.out.println("请求消息体是:");
		System.out.println(jsonObj);

		post.setEntity(getStringEntity(jsonObj));
		post.setHeader("merchantName", merchantName);
		post.setHeader("token", token);

		String res = "无返回结果";
		res = HttpClientUtil.post(post, url);
		System.out.println("请求结果如下:");
		System.out.println(res);
		return res;
	}
}
