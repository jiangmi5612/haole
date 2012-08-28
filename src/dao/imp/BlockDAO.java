package dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import dao.IBlockDAO;
import domain.Block;

public class BlockDAO implements IBlockDAO {

	@Override
	public void addBlock(Block block) {
		this.sessionFactory.getCurrentSession().save(block);
		
	}

	@Override
	public void deleteBlock(Block block) {
		this.sessionFactory.getCurrentSession().delete(block);
		
	}

	@Override
	public void updateBlock(Block block) {
		this.sessionFactory.getCurrentSession().update(block);
		
	}

	@Override
	public Block getBlockById(int id) {
		return (Block)this.sessionFactory.getCurrentSession().get(Block.class, id);
	}

	@Override
	public void deleteBlockById(int id) {
		String hql = "DELETE Block WHERE id=:id";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@Override
	public List<Block> getBlockByBlockTypeWithPage(String blockType,
			int itemsPerPage, int pageNo) {
		String hql = "FROM Block WHERE blockType=:blockType ORDER BY id DESC";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("blockType", blockType);
		query.setFirstResult((pageNo - 1) * itemsPerPage);
		query.setMaxResults(itemsPerPage);
		return (List<Block>)query.list();
	}

	@Override
	public List<Block> getBlockByBlockTypeWithAmount(String blockType,
			int amount) {
		String hql = "FROM Block WHERE blockType=:blockType ORDER BY id DESC";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("blockType", blockType);
		query.setMaxResults(amount);
		return (List<Block>)query.list();
	}
	
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<String> getBlockType() {
		String hql = "SELECT DISTINCT b.blockType FROM Block b";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		return (List<String>)query.list();
	}
	
	
}
