package com.core.controller;

import com.core.config.RedisService;
import com.core.service.user.UserService;
import com.github.pagehelper.PageHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by WJ on 2018/5/3
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@Autowired
	RedisService redisService;

	@ResponseBody
	@GetMapping("/all")
	public Object findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
		// 日志记录
		logger.info("这是一条测试的日志");
		// 开始分页
		PageHelper.startPage(pageNum, pageSize);
		// 存redis测试
		redisService.setStr("test", "这是测试数据");
		return userService.findAllUser(pageNum, pageSize);
	}

	@ResponseBody
	@GetMapping("/add")
	public void add() {
		//事务测试
		userService.add();
	}
}
