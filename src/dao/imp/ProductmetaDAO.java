package dao.imp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IProductmetaDAO;
import domain.Productmeta;

public class ProductmetaDAO extends HibernateDaoSupport implements IProductmetaDAO {

	@Override
	public void addProductmeta(Productmeta meta) {
		this.getHibernateTemplate().save(meta);
		
	}

	@Override
	public void deleteProductmeta(Productmeta meta) {
		this.getHibernateTemplate().delete(meta);
		
	}

	@Override
	public void updateProductmeta(Productmeta meta) {
		this.getHibernateTemplate().update(meta);
		
	}

	@Override
	public Productmeta getProductmetaByProductIdAndKey(String productId,
			String key) {
		String hsql = "FROM Productmeta WHERE product='"+ productId +"' AND metaKey='"+ key +"'";
		return (Productmeta)this.getHibernateTemplate().find(hsql).get(0);
	}

	@Override
	public List<Productmeta> getProductmetaByProductId(String productId) {
		String hsql = "FROM Productmeta WHERE product='"+ productId +"'";
		return (List<Productmeta>)this.getHibernateTemplate().find(hsql);
	}

}
