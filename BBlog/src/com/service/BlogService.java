package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.BlogDao;

@Service
public class BlogService {

	@Resource
	private BlogDao blogDao;
}
