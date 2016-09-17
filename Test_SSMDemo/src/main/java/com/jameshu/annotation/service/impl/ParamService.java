package com.jameshu.annotation.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.jameshu.annotation.dao.*;
import com.jameshu.annotation.service.*;
import com.jameshu.entity.*;

@Service("paraService")
public class ParamService implements IParamService {

	@Resource
		private IParamDao paramDao;

	@Override
	public Map<String,Object>  selectByName(String name) {
		List<Sys_Param> list = this.paramDao.selectByName(name);
		Map<String, Object> map=new HashMap<String, Object> ();
		for (int i = 0; i < list.size(); i++) {
			Sys_Param param=list.get(i);
			map.put(Integer.toString(param.getId()),param.getAttributevalue());
		}
		return map;
	}
}
