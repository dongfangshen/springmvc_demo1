package com.jameshu.annotation.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jameshu.entity.Sys_Annotation;

public interface IAnoService {
	Map<String, Object> selectByPrimaryKey(Integer id);

	List<Sys_Annotation> selectAll();
	
	Map<String,Object>  selectAuthor();
	
	List<Sys_Annotation>  selectAnoByWhere(HashMap<String, Object> map);
}
