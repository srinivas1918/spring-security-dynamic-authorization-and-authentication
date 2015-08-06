package com.exp.dynamicroles.dao;

import java.awt.datatransfer.Transferable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.exp.dynamicroles.model.RoleAction;
import com.exp.dynamicroles.model.UrlRolesBean;
import com.exp.dynamicroles.model.User;

@Repository
public class AppDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public User getUser(String username){
	Query query=sessionFactory.getCurrentSession().createQuery("from User u where u.username=:username");
	query.setString("username", username);
	List<User> users=query.list();
	if (users.size()>0) {
		return users.get(0);
		
	}
		return null;
	}
	
	public List<UrlRolesBean> getUrlRoles(){
		Query query=sessionFactory.getCurrentSession().createSQLQuery("SELECT a.`NAME` AS url ,r.`ROLE_NAME` AS role FROM role r JOIN role_action ra ON r.`ROLE_ID`=ra.`ROLE_ID` JOIN ACTION a ON a.`ID`=ra.`ACTION_ID`");
		query.setResultTransformer(Transformers.aliasToBean(UrlRolesBean.class));
		return query.list();
	}
}
