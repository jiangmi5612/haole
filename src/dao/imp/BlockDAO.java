package dao.imp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IBlockDAO;
import domain.Block;

public class BlockDAO extends HibernateDaoSupport implements IBlockDAO {

	@Override
	public void addBlock(Block block) {
		this.getHibernateTemplate().save(block);
		
	}

	@Override
	public void deleteBlock(Block block) {
		this.getHibernateTemplate().delete(block);
		
	}

	@Override
	public void updateBlock(Block block) {
		this.getHibernateTemplate().update(block);
		
	}

	@Override
	public Block getBlockById(String id) {
		return (Block)this.getHibernateTemplate().get(Block.class, id);
	}

	@Override
	public List<Block> getAllBlock() {
		String hsql="FROM Block";
		return (List<Block>)this.getHibernateTemplate().find(hsql);
	}

}
