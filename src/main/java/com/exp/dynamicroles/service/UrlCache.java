package com.exp.dynamicroles.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.exp.dynamicroles.model.UrlRolesBean;

@Component
public class UrlCache {
	
	HashMap<String, List<String>> urlRoles=new HashMap<String, List<String>>();

	public HashMap<String, List<String>> getUrlRoles() {
		return this.urlRoles;
	}

	public void setUrlRoles(HashMap<String, List<String>> urlRoles) {
		this.urlRoles = urlRoles;
	}
	
	public List<String> getUrlRoles(String key) {
		return urlRoles.get(key);
	}

	/**
	 * 
	 * @param roleActions
	 * Maps the Url as key and List<String> as the value.
	 */
	public void mapUrlToRole(List<UrlRolesBean> roleActions){
		String dbUrl=null;
		for (UrlRolesBean urlRolesBean : roleActions) {
			dbUrl=urlRolesBean.getUrl();
			if(this.urlRoles.containsKey(dbUrl)){
				List<String> roles=this.urlRoles.get(dbUrl);
				roles.add(urlRolesBean.getRole());
				
			}else{
				List<String> roles=new ArrayList<String>();
				roles.add(urlRolesBean.getRole());
				this.urlRoles.put(dbUrl, roles);
			}
		}
	}
		
}
