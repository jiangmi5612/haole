package dao.imp;

import java.util.List;

import org.hibernate.Query;
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
		this.sessionFactory.getCurrentSession().save(category);
	}

	public void deleteCategory(Category category) {
		this.sessionFactory.getCurrentSession().delete(category);
	}

	public void updateCategory(Category category) {
		this.sessionFactory.getCurrentSession().update(category);
		
	}

	public Category getCategoryById(int id) {
		return (Category)this.sessionFactory.getCurrentSession().get(Category.class, id);
	}

	/**
	 * 严格意义上讲，Category的Name并不唯一，此处返回取得的第一个值
	 */
	public Category getCategoryByName(String catName) {
		String hsql = "FROM Category WHERE catName='"+catName+"'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hsql);
		return (Category)query.list().get(0);
	}

	public List<Category> getAllCategorie() {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Category");
		return query.list();
	}
	
}
