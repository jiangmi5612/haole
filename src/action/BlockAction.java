package action;

import java.util.List;

import service.IBlockService;

import com.opensymphony.xwork2.ActionSupport;
import commons.PageInfo;

import domain.Block;

public class BlockAction extends ActionSupport {
	
	public String renderBlockTypeList() {
			listBlockType = blockService.getBlockType();
			if(block != null && block.getId() > 0){
				blockId = block.getId();
			}
		return INPUT;
	}
	
	public String edtBlock() {
		if(blockId > 0){
			//如果已经有id，则表示为编辑模式
			Block originalBlock = blockService.getBlockById(blockId);
			originalBlock.setBlockType(block.getBlockType());
			originalBlock.setBlockName(block.getBlockName());
			originalBlock.setBlockDescription(block.getBlockDescription());
			originalBlock.setBlockHtml(block.getBlockHtml());
			blockService.updateBlock(originalBlock);
		}
		else if(block != null && block.getBlockName().length() > 0){
			//要求功能块名称必填
			blockService.addBlock(block);
		}
		return INPUT;
	}
	
	public String listBlock() {
		pageInfo = blockService.getBlockByBlockTypeWithPage("新闻", 5, 1);
		listBlock = (List<Block>)pageInfo.getList();
		return "list";
	}
	private IBlockService blockService;

	/**
	 * @param blockService the blockService to set
	 */
	public void setBlockService(IBlockService blockService) {
		this.blockService = blockService;
	}
	
	//映射功能块ID
	private int blockId;
	
	//映射功能块
	private Block block;
	
	//映射功能块类别列表
	private List<String> listBlockType;
	
	//映射功能块列表
	private List<Block> listBlock;
	
	//映射分页信息
	private PageInfo pageInfo;

	/**
	 * @return the blockId
	 */
	public int getBlockId() {
		return blockId;
	}

	/**
	 * @param blockId the blockId to set
	 */
	public void setBlockId(int blockId) {
		this.blockId = blockId;
	}

	/**
	 * @return the block
	 */
	public Block getBlock() {
		return block;
	}

	/**
	 * @param block the block to set
	 */
	public void setBlock(Block block) {
		this.block = block;
	}

	/**
	 * @return the listBlockType
	 */
	public List<String> getListBlockType() {
		return listBlockType;
	}

	/**
	 * @return the listBlock
	 */
	public List<Block> getListBlock() {
		return listBlock;
	}

	/**
	 * @return the pageInfo
	 */
	public PageInfo getPageInfo() {
		return pageInfo;
	}
	
	
}
