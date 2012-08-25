package dao.imp;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IProductmetaDAO;
import domain.Productmeta;

public class ProductmetaDAO implements IProductmetaDAO {
	
	private SessionFactory sessionFactory;
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addProductmeta(Productmeta meta) {
		this.sessionFactory.getCurrentSession().save(meta);
		
	}

	@Override
	public void deleteProductmeta(Productmeta meta) {
		this.sessionFactory.getCurrentSession().delete(meta);
		
	}

	@Override
	public void updateProductmeta(Productmeta meta) {
		this.sessionFactory.getCurrentSession().update(meta);
		
	}

	@Override
	public Productmeta getProductmetaByProductIdAndKey(int productId,
			String key) {
		String hsql = "FROM Productmeta WHERE product='"+ productId +"' AND metaKey='"+ key +"'";
		return (Productmeta)this.sessionFactory.getCurrentSession().createQuery(hsql).list().get(0);
	}

	@Override
	public List<Productmeta> getProductmetaByProductId(int productId) {
		String hsql = "FROM Productmeta WHERE product='"+ productId +"'";
		return (List<Productmeta>)this.sessionFactory.getCurrentSession().createQuery(hsql).list();
	}

	@Override
	public Productmeta getProductmetaById(int id) {
		return (Productmeta)this.sessionFactory.getCurrentSession().get(Productmeta.class, id);
	}

}
