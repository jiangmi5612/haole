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
	
	public List<Block> getBlockByBlockTypeWithAmount(String blockType, int amount);
	
	public List<String> getBlockType();
}
