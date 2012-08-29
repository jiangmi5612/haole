package domain;

public class BlockRow {

	/**
	 * @param id
	 * @param blockType
	 * @param blockName
	 * @param blockDescription
	 */
	public BlockRow(Integer id, String blockType, String blockName,
			String blockDescription) {
		this.id = id;
		this.blockType = blockType;
		this.blockName = blockName;
		this.blockDescription = blockDescription;
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the blockType
	 */
	public String getBlockType() {
		return blockType;
	}
	/**
	 * @param blockType the blockType to set
	 */
	public void setBlockType(String blockType) {
		this.blockType = blockType;
	}
	/**
	 * @return the blockName
	 */
	public String getBlockName() {
		return blockName;
	}
	/**
	 * @param blockName the blockName to set
	 */
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	/**
	 * @return the blockDescription
	 */
	public String getBlockDescription() {
		return blockDescription;
	}
	/**
	 * @param blockDescription the blockDescription to set
	 */
	public void setBlockDescription(String blockDescription) {
		this.blockDescription = blockDescription;
	}
	
	private Integer id;
	private String blockType;
	private String blockName;
	private String blockDescription;
	
}
