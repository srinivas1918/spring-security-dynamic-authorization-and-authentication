package com.exp.dynamicroles.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exp.dynamicroles.dao.AppDAO;
import com.exp.dynamicroles.model.RoleAction;
import com.exp.dynamicroles.model.UrlRolesBean;
import com.exp.dynamicroles.model.User;

@Service
public class AppService {
	private static final Logger logger = LoggerFactory.getLogger(AppService.class);
	
	@Autowired
	private UrlCache urlCache;
	
	@Autowired
	private AppDAO appDAO;
	
	@Transactional(readOnly=true)
	public User getUser(String username){
	return appDAO.getUser(username);	
	}
	
	@Transactional(readOnly=true)
	public void getUrlRoles(){
	List<UrlRolesBean> roleActions=appDAO.getUrlRoles();
	for (UrlRolesBean urlRolesBean : roleActions) {
		logger.debug("Role Name "+urlRolesBean.getRole());
		logger.debug("Action Name "+urlRolesBean.getUrl());
	}
	urlCache.mapUrlToRole(roleActions);
	return ;
	}
}
