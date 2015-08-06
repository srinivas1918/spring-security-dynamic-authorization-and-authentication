package com.exp.dynamicroles.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
/**
 * 
 * @author Srinivas Nalla
 * 
 *
 */
@Component
public class DbFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean{
	private static final Logger logger = LoggerFactory.getLogger(DbFilterInvocationSecurityMetadataSource.class);
	
	@Autowired
	private AppService appService;
	
	@Autowired
	private UrlCache urlCache;
	
	private HashMap<String, List<String>> urlRoles;
	
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		FilterInvocation fi=(FilterInvocation)object;
		String url=fi.getRequestUrl();
		logger.debug("Request Url====>"+url);
				
		List<String> roles_=urlRoles.get(url);
		logger.debug("Url Associated Roles :"+roles_);
		if(roles_==null){
			return null;
		}
		logger.debug("------------------");
		String[] stockArr = new String[roles_.size()];
		stockArr = roles_.toArray(stockArr);
		
	    return SecurityConfig.createList(stockArr);
	}

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}

	public void afterPropertiesSet() throws Exception {
		
		appService.getUrlRoles();
		this.urlRoles=urlCache.getUrlRoles();
		logger.debug("Url Roles object :"+urlRoles);
	}

}
