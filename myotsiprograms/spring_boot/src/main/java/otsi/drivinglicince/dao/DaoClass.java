package otsi.drivinglicince.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Repository;

import com.couchbase.client.java.view.ViewQuery;

import otsi.drivinglicince.bean.BeanClass;
import otsi.drivinglicince.controller.ControllerClass;

@Repository
public class DaoClass {
	
	private static final String DESIGN_DOC = "person";
	 @Autowired
	    private CouchbaseTemplate template;
	 public List getData()
	 {
		
		 return template.findByView(ViewQuery.from(DESIGN_DOC, "all"), BeanClass.class);
		 
	 }

}
