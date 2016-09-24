package com.jameshu.annotation.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.jameshu.annotation.dao.IAnoDao;
import com.jameshu.annotation.service.IAnoService;
import com.jameshu.entity.Sys_Annotation;

@Service("anoService")
public class AnoService implements IAnoService {
	@Resource
	private IAnoDao anoDao;
	
	@Override
	public Map<String, Object> selectByPrimaryKey(Integer id) {

		// TODO Auto-generated method stub
		Map<String, Object> maps = new HashMap<String, Object>();
		try {

			Sys_Annotation ano = this.anoDao.selectByPrimaryKey(id);

			// 得到一个对象
			
			  Map<String, Object> mapAno = new HashMap<String, Object>();
			  mapAno.put("id", ano.getId()); 
			  mapAno.put("clienttype",ano.getClienttype()); 
			  mapAno.put("author", ano.getAuthor());
			  mapAno.put("method", ano.getMethod());
			  mapAno.put("module",ano.getModule());
			  mapAno.put("service", ano.getService());
			  mapAno.put("descre", ano.getDescre());
			  maps.put("mapAno",mapAno);
			 
		/*	Sys_Annotation newAno = new Sys_Annotation();
			newAno.setId(ano.getId());
			newAno.setClienttype(ano.getClienttype());
			newAno.setAuthor(ano.getAuthor());
			newAno.setMethod(ano.getMethod());
			newAno.setModule(ano.getModule());
			newAno.setService(ano.getService());
			newAno.setDescre(ano.getDescre());
			maps.put("ano", newAno);*/

			// 得到input 以,分隔 每个对象又以:分隔 英文名 类型 中文名
			List<Map<String, Object>> listInput = new ArrayList<Map<String, Object>>();
			String inputString = ano.getInput();
			String[] inputOutArray = inputString.split("\",");
			for (int i = 0; i < inputOutArray.length; i++) {
				String[] inputInnerArray = inputOutArray[i].replaceAll("\"", " ").split(":");
				Map<String, Object> mapInput = new HashMap<String, Object>();
				mapInput.put("enName", inputInnerArray[0].toString());
				mapInput.put("type", inputInnerArray[1].toString());
				mapInput.put("cnName", inputInnerArray[2].toString());
				listInput.add(mapInput);
			}
			maps.put("listInput", listInput);

			// 得到output 以,分隔 每个对象又以:分隔 英文名 类型 中文名
			List<Map<String, Object>> listOutput = new ArrayList<Map<String, Object>>();
			String outputString = ano.getOutput();
			String[] outputOutArray = outputString.split("\",");
			for (int i = 0; i < outputOutArray.length; i++) {
				String[] outputInnerArray = outputOutArray[i].replaceAll("\"", " ").split(":");
				Map<String, Object> mapOutput = new HashMap<String, Object>();
				mapOutput.put("enName", outputInnerArray[0].toString());
				mapOutput.put("type", outputInnerArray[1].toString());
				mapOutput.put("cnName", outputInnerArray[2].toString());
				listOutput.add(mapOutput);
			}
			maps.put("listOutput", listOutput);
		} catch (Exception e) {
			 Logger.getLogger(AnoService.class).info(e.getMessage());
			 throw e;
			// TODO: handle exception
		}
		return maps;
	}

	@Override
	public List<Sys_Annotation> selectAnoByWhere(HashMap<String, Object> map)
	{
		return anoDao.selectAnoByWhere(map);
	}
	@Override
	public List<Sys_Annotation> selectAll() {
		return anoDao.selectAll();
	}
	
	
	@Override
	public Map<String, Object> selectAuthor()
	{
		List<Sys_Annotation> list=anoDao.selectAuthor();
		Map<String, Object> map=new HashMap<String, Object> ();
		for (int i = 0; i < list.size(); i++) {
			Sys_Annotation annotation=list.get(i);
			map.put(Integer.toString(i),annotation.getAuthor());
		}
		return map;
	}
}
