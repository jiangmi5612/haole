package dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sun.xml.internal.bind.v2.TODO;

import commons.PageInfo;

import dao.IProductDAO;
import domain.Product;
import domain.ProductRow;

public class ProductDAO implements IProductDAO {
	
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * 新增产品
	 */
	@Override
	public void addProduct(Product product) {
		this.sessionFactory.getCurrentSession().save(product);
		
	}

	/**
	 * 删除产品
	 */
	@Override
	public void deleteProduct(Product product) {
		this.sessionFactory.getCurrentSession().delete(product);
		
	}

	/**
	 * 根据id删除产品
	 */
	@Override
	public void deleteProductById(int id) {
		String hql = "DELETE Product WHERE id=:id";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger("id", id);
		query.executeUpdate();
	}
	
	/**
	 * 更新产品
	 */
	@Override
	public void updateProduct(Product product) {
		this.sessionFactory.getCurrentSession().update(product);
		
	}

	/**
	 * 根据id查询产品
	 */
	@Override
	public Product getProductById(int id) {
		return (Product)this.sessionFactory.getCurrentSession().get(Product.class, id);
	}

	/**
	 * 按照产品类别，返回分页后的产品
	 */
	@Override
	public PageInfo getProductByCatIdWithPage(int categoryId, int pageSize,
			int page) {
		//构建总记录数查询
		String hsql = "SELECT COUNT(p.id) FROM Product p WHERE category=:categoryId";
		Query countQuery = this.sessionFactory.getCurrentSession().createQuery(hsql);
		countQuery.setInteger("categoryId", categoryId);
		
		//构建返回数据查询
		hsql="FROM Product WHERE category=:categoryId ORDER BY id DESC";
		Query listQuery = this.sessionFactory.getCurrentSession().createQuery(hsql);
		listQuery.setInteger("categoryId", categoryId);
		
		//获取分页信息并返回
		return new PageInfo(countQuery, listQuery, pageSize, page);
	}
	
	/**
	 * 按照产品名称，返回分页后的产品
	 * 主要用于搜索产品
	 * TODO: 建立更高效的搜索机制，不过由于本系统假设的小企业网站通常搜索活动较少，需求并不高
	 */
	@Override
	public PageInfo getProductByProductNameWithPage(String productName,
			int pageSize, int page) {
		//构建总记录数查询
		String hsql = "SELECT COUNT(p.id) FROM Product p WHERE productName=:productName";
		Query countQuery = this.sessionFactory.getCurrentSession().createQuery(hsql);
		countQuery.setString("productName", productName);
		
		//构建返回数据查询
		hsql="SELECT new ProductRow(p.id,c.catName,p.productName,p.productDescription,p.productPrice,p.browseTimes,p.productImg) FROM Product p INNER JOIN FETCH p.category c WHERE p.productName=:productName ORDER BY id DESC";
		Query listQuery = this.sessionFactory.getCurrentSession().createQuery(hsql);
		listQuery.setString("productName", productName);
		
		//获取分页信息并返回
		return new PageInfo(countQuery, listQuery, pageSize, page);
	}
	
	/**
	 * 返回分页后的产品
	 */
	@Override
	public PageInfo getProductWithPage(int pageSize, int page) {
		//构建总记录数查询
		String hsql = "SELECT COUNT(p.id) FROM Product p";
		Query countQuery = this.sessionFactory.getCurrentSession().createQuery(hsql);
		
		//构建返回数据查询
		hsql="SELECT new ProductRow(p.id,c.catName,p.productName,p.productDescription,p.productPrice,p.browseTimes,p.img) FROM Product p INNER JOIN p.category c ORDER BY p.id DESC";
		Query listQuery = this.sessionFactory.getCurrentSession().createQuery(hsql);
		
		//获取分页信息并返回
		return new PageInfo(countQuery, listQuery, pageSize, page);
	}







}
