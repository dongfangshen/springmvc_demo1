package com.jameshu.annotation.service;



import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.jameshu.entity.Sys_Annotation;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestAnoService {
	private static Logger logger = Logger.getLogger(TestAnoService.class);
	@Resource
	private IAnoService anoService = null;
	@Test
	public void test1() {
		//Sys_Annotation user = anoService.selectByPrimaryKey(1);
		// System.out.println(user.getUserName());
		// logger.info("值："+user.getUserName());
		List<Sys_Annotation> user=anoService.selectAll();
		logger.info(JSON.toJSONString(user));
	}
}
