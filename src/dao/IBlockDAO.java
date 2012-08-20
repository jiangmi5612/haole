package dao;

import java.util.List;

import domain.Block;

public interface IBlockDAO {
	public void addBlock(Block block);
	
	public void deleteBlock(Block block);
	
	public void updateBlock(Block block);
	
	public Block getBlockById(String id);
	
	public List<Block> getAllBlock();
}
