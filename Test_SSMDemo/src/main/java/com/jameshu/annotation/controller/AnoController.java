package com.jameshu.annotation.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.jameshu.annotation.service.*;
import com.jameshu.annotation.service.TestAnoService;
import com.jameshu.entity.Sys_Annotation;

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
	public String anoList(ModelMap modelMap) {
		List<Sys_Annotation> list = anoService.selectAll();

		Map<String, Object> authors = anoService.selectAuthor();
		Map<String, Object> clients = paramService.selectByName("ClientType");
		modelMap.addAttribute("anoList", list);
		modelMap.addAttribute("authorList", authors);
		modelMap.addAttribute("clientList", clients);
		return "anoList";
	}

	// 根据条件查询方法
	@RequestMapping("/hello/anoListByWhere")
	public String  anoListByWhere(String author,Integer clientType,String methodOrDes, ModelMap modelMap) {
		//通过ajax请求看能不能获取这三个参数
		logger.info(JSON.toJSONString(author));
		logger.info(JSON.toJSONString(clientType));
		logger.info(JSON.toJSONString(methodOrDes));
		
		Map<String, Object> authors = anoService.selectAuthor();
		Map<String, Object> clients = paramService.selectByName("ClientType");
		
		List<Sys_Annotation> list=new ArrayList<Sys_Annotation>();
		Sys_Annotation ano=new Sys_Annotation();
		ano.setId(3);
		ano.setAuthor("王麻子");
		ano.setMethod("gettest");
		ano.setClienttype(1);
		list.add(ano);
		modelMap.addAttribute("authorList", authors);
		modelMap.addAttribute("clientList", clients);
		modelMap.addAttribute("anoList", list);
		return "anoList";
	}

	// 查看方法详情 @PathVariable("id") 
	@RequestMapping(value = "showAno/{id}", method = RequestMethod.GET)
	public String showAno(@PathVariable("id") Integer id, ModelMap modelMap) throws Exception {
		try {
			// Sys_Annotation ano=(Sys_Annotation) maps.get("ano");
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
