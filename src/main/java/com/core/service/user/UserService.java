package com.core.service.user;


import java.util.List;

import com.core.model.UserDomain;

/**
 * Created by WJ on 2018/5/3
 */
public interface UserService {


    List<UserDomain> findAllUser(int pageNum, int pageSize);

	void add();
}
