package com.core.dao;



import java.util.HashMap;
import java.util.List;

import com.core.model.UserDomain;

public interface UserDao {


    List<UserDomain> selectUsers();

	void add(HashMap<String, String> map);
}