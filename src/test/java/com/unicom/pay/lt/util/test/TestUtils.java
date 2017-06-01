package com.unicom.pay.lt.util.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.unicom.pay.lt.util.HttpClientUtil;

/**
 * Filename:TestUtils.java
 * Description: 工具测试类
 * @author litong
 * @date 2017年5月22日 上午10:34:35
 */
public class TestUtils {
	@Test
	public void testHttpUtil() throws UnsupportedEncodingException{
		
		String url = "http://123.57.87.204:50002/base/auth/token";
		HttpPost post = new HttpPost(url);
		//Map<String, Object> params = new HashMap<String, Object>();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("merchantName", "0426036984822");
		System.out.println("请求消息体是:");
		System.out.println(jsonObj);
		StringEntity entity = new StringEntity(jsonObj.toJSONString());
		entity.setContentEncoding("UTF‐8");
		entity.setContentType("application/json");
		// 设置为json数据
		post.setEntity(entity);
		post.setHeader("merchantName", "0426036984822");
		
		
		String res = "无返回结果";
		res = HttpClientUtil.post(post,url);
		//res = HttpClientUtil.post(url,params);
		
		System.out.println("请求结果如下");
		System.out.println(res);
	}
}
