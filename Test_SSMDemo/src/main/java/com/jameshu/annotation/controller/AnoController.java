package com.jameshu.annotation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.taglibs.standard.lang.jstl.AndOperator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jameshu.annotation.service.*;
import com.jameshu.annotation.service.TestAnoService;
import com.jameshu.entity.Sys_Annotation;

import junit.framework.Test;

@Controller
@RequestMapping("/ano")
public class AnoController {
	private static Logger logger = Logger.getLogger(AnoController.class);
	@Resource
	private IAnoService anoService;
	@Resource
	private IParamService paramService;

	// 查看所有方法
	@RequestMapping("/hello/anoList")
	public String anoList(ModelMap modelMap) throws JsonProcessingException {
		List<Sys_Annotation> list = anoService.selectAll();

		Map<String, Object> authors = anoService.selectAuthor();
		Map<String, Object> clients = paramService.selectByName("ClientType");
		//初始化加载 默认查询全部
		StringBuilder sb = new StringBuilder();
		String str=JSON.toJSONString(list);
		sb.append("{\"anoL\":");
		sb.append(str);
		sb.append("}");
		modelMap.addAttribute("anoList", sb.toString());
		modelMap.addAttribute("authorList", authors);
		modelMap.addAttribute("clientList", clients);
		logger.info(sb.toString());
		return "anoList";
	}
	
	// 根据条件查询方法
	@ResponseBody
	@RequestMapping("/test")
	public  Map<String, Object> testAjax(){
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("msg", "success");
		return  map;
	}

	// 根据条件查询方法
	@ResponseBody
	@RequestMapping("/hello/anoListByWhere")
	public  Map<String, Object> anoListByWhere(String author, Integer clientType, String methodOrDes) {
		logger.info(JSON.toJSONString(author));
		logger.info(JSON.toJSONString(clientType));
		logger.info(JSON.toJSONString(methodOrDes));

		Map<String, Object> authors = anoService.selectAuthor();
		Map<String, Object> clients = paramService.selectByName("ClientType");
		HashMap<String, Object> map=new HashMap<String, Object>();
		if (!author.equals("-1")) {
			map.put("author", author);
		}
		if (clientType!=-1) {
			map.put("clienttype", clientType);
		}
		if (methodOrDes!="") {
			map.put("methodOrDes", methodOrDes);
		}
		List<Sys_Annotation> list=anoService.selectAnoByWhere(map);
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("anoList", list);
		return resultMap;
	}

	// 查看方法详情 @PathVariable("id")
	@RequestMapping(value = "showAno/{id}", method = RequestMethod.GET)
	public String showAno(@PathVariable("id") Integer id, ModelMap modelMap) throws Exception {
		try {
			Map<String, Object> maps = anoService.selectByPrimaryKey(id);
			Map<String, Object> ano = (Map<String, Object>) maps.get("mapAno");
			List<Map<String, Object>> listInput = (List<Map<String, Object>>) maps.get("listInput");
			List<Map<String, Object>> listOutput = (List<Map<String, Object>>) maps.get("listOutput");
			modelMap.addAttribute("ano", ano);
			modelMap.addAttribute("listInput", listInput);
			modelMap.addAttribute("listOutput", listOutput);
			// logger.info(JSON.toJSONString(listOutput));
		} catch (Exception ex) {

		}
		return "showAno";
	}
}
