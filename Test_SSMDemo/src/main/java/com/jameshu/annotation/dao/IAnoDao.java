package com.jameshu.annotation.dao;

import java.util.HashMap;
import java.util.List; 

import com.jameshu.entity.*;;

public interface IAnoDao {
	Sys_Annotation selectByPrimaryKey(Integer id);
	
	 List<Sys_Annotation>  selectAll();
	 
	 List<Sys_Annotation>  selectAuthor();
	 
	 List<Sys_Annotation>  selectAnoByWhere(HashMap<String, Object> map);
}
