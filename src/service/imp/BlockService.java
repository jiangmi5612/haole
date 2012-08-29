package service.imp;

import java.util.List;

import commons.PageInfo;

import dao.IBlockDAO;
import dao.imp.BlockDAO;
import domain.Block;
import service.IBlockService;

public class BlockService implements IBlockService {

	@Override
	public void addBlock(Block block) {
		blockDAO.addBlock(block);
		
	}

	@Override
	public void deleteBlock(Block block) {
		blockDAO.deleteBlock(block);
		
	}

	@Override
	public void deleteBlockById(int id) {
		blockDAO.deleteBlockById(id);
		
	}

	@Override
	public void updateBlock(Block block) {
		blockDAO.updateBlock(block);
		
	}

	@Override
	public Block getBlockById(int id) {
		return blockDAO.getBlockById(id);
		
	}

	@Override
	public PageInfo getBlockByBlockTypeWithPage(String blockType, int itemsPerPage,
			int pageNo) {
		return blockDAO.getBlockByBlockTypeWithPage(blockType, itemsPerPage, pageNo);
		
	}
	
	@Override
	public PageInfo getAllBlockWithPage(int pageSize,int page) {
		return blockDAO.getAllBlockWithPage(pageSize, page);
	}

	@Override
	public List<Block> getBlockByBlockTypeWithAmount(String blockType, int amount) {
		return blockDAO.getBlockByBlockTypeWithAmount(blockType, amount);
		
	}

	private IBlockDAO blockDAO;

	/**
	 * @param blockDAO the blockDAO to set
	 */
	public void setBlockDAO(IBlockDAO blockDAO) {
		this.blockDAO = blockDAO;
	}

	@Override
	public List<String> getBlockType() {
		return blockDAO.getBlockType();
	}
	
	
}
