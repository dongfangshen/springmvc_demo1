package com.jameshu.annotation.dao;

import java.util.List;
import com.jameshu.entity.Sys_Param;

public interface IParamDao {
	 List<Sys_Param>  selectByName(String name);
}
