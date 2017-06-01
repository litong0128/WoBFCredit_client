package com.unicom.pay.lt.client.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.unicom.pay.lt.client.WoBFService;

public class TestWoBFService {

	private WoBFService wbfs;

	@Before
	public void init() {
		wbfs = WoBFService.getInstance();
	}
	
	@Test
	public void getToken() {
		try {
			wbfs.getToken();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void getData() {
		String url = "http://123.57.87.204:50002/api/unicom/userrealscore";
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("mobile", "18513737842");
		try {
			wbfs.getData("dbd9b8df56369cce4ef9ec4f85ecc93d", url,jsonObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
