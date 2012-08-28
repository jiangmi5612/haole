package action;

import java.util.List;

import service.IBlockService;

import com.opensymphony.xwork2.ActionSupport;

import domain.Block;

public class BlockAction extends ActionSupport {
	
	public String renderBlockTypeList() {
			listBlockType = blockService.getBlockType();
		return INPUT;
	}
	
	public String edtBlock() {
		if(block.getId() > 0){
			//如果已经有id，则表示为编辑模式
			blockService.updateBlock(block);
		}
		else if(block != null && block.getBlockName().length() > 0){
			//要求功能块名称必填
			blockService.addBlock(block);
		}
		return INPUT;
	}
	private IBlockService blockService;

	/**
	 * @param blockService the blockService to set
	 */
	public void setBlockService(IBlockService blockService) {
		this.blockService = blockService;
	}
	
//	//映射功能块ID
//	private int blockId;
	
	//映射功能块
	private Block block;
	
	//映射功能块类别列表
	private List<String> listBlockType;
	
//	//映射功能块类型
//	private String blockType;
//	
//	//映射功能块名称
//	private String blockName;
//	
//	//映射功能块描述
//	private String blockDescription;
//	
//	//映射功能块代码
//	private String blockHtml;

//	/**
//	 * @return the blockId
//	 */
//	public int getBlockId() {
//		return blockId;
//	}
//
//	/**
//	 * @param blockId the blockId to set
//	 */
//	public void setBlockId(int blockId) {
//		this.blockId = blockId;
//	}
//
//	/**
//	 * @return the blockType
//	 */
//	public String getBlockType() {
//		return blockType;
//	}
//
//	/**
//	 * @param blockType the blockType to set
//	 */
//	public void setBlockType(String blockType) {
//		this.blockType = blockType;
//	}
//
//	/**
//	 * @return the blockName
//	 */
//	public String getBlockName() {
//		return blockName;
//	}
//
//	/**
//	 * @param blockName the blockName to set
//	 */
//	public void setBlockName(String blockName) {
//		this.blockName = blockName;
//	}
//
//	/**
//	 * @return the blockDescription
//	 */
//	public String getBlockDescription() {
//		return blockDescription;
//	}
//
//	/**
//	 * @param blockDescription the blockDescription to set
//	 */
//	public void setBlockDescription(String blockDescription) {
//		this.blockDescription = blockDescription;
//	}
//
//	/**
//	 * @return the blockHtml
//	 */
//	public String getBlockHtml() {
//		return blockHtml;
//	}
//
//	/**
//	 * @param blockHtml the blockHtml to set
//	 */
//	public void setBlockHtml(String blockHtml) {
//		this.blockHtml = blockHtml;
//	}

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
	
	
}
