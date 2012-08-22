package dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import dao.ICategoryDAO;
import domain.Category;

public class CategoryDAO implements ICategoryDAO {

	private SessionFactory sessionFactory;
	
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CategoryDAO(){}
	
	public void addCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(category);
		session.flush();
	}

	public void deleteCategory(Category category) {
		//this.getHibernateTemplate().delete(category);
		
	}

	public void updateCategory(Category category) {
		//this.getHibernateTemplate().update(category);
		
	}

	public Category getCategoryById(String id) {
		//return (Category)this.getHibernateTemplate().get(Category.class, id);
		return null;
	}

	/**
	 * 严格意义上讲，Category的Name并不唯一，此处返回取得的第一个值
	 */
	public Category getCategoryByName(String catName) {
		//String hsql = "FROM Category WHERE catName='"+catName+"'";
		//return (Category)this.getHibernateTemplate().find(hsql).get(0);
		return null;
	}

	public List<Category> getAllCategorie() {
		//String hsql = "FROM Category";
		//return (List<Category>)this.getHibernateTemplate().find(hsql);
		return null;
	}
	
}
