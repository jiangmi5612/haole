package service;

import java.util.List;

import commons.PageInfo;

import domain.Block;

public interface IBlockService {
	public void addBlock(Block block);
	
	public void deleteBlock(Block block);
	
	public void deleteBlockById(int id);
	
	public void updateBlock(Block block);
	
	public Block getBlockById(int id);
	
	public PageInfo getBlockByBlockTypeWithPage(String blockType, int itemsPerPage, int pageNo);
	
	public PageInfo getAllBlockWithPage(int pageSize,int page);
	
	public List<String> getBlockType();
}
