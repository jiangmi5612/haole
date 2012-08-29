package dao;

import java.util.List;

import commons.PageInfo;

import domain.Block;

public interface IBlockDAO {
	
	public void addBlock(Block block);
	
	public void deleteBlock(Block block);
	
	public void updateBlock(Block block);
	
	public Block getBlockById(int id);
	
	public void deleteBlockById(int id);
	
	/**
	 * 取出具有分页的功能块
	 * @param itemsPerPage
	 * @param pageNo
	 * @return
	 */
	public PageInfo getBlockByBlockTypeWithPage(String blockType,int itemsPerPage,int pageNo);
	
	public PageInfo getAllBlockWithPage(int pageSize,int page);
	
	public List<String> getBlockType();
}
