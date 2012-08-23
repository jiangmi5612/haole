/**
 * 代码段类，用以承载网站中所有非动态内容
 */
package domain;

/**
 * @author 姜敏
 * @version 1.0.0
 *
 */
public class Block {
	
	/**
	 * 无参构造函数
	 */
	public Block() {
	}

	/**
	 * 带参构造函数
	 * @param blockName
	 * @param blockDescription
	 * @param blockHtml
	 */
	public Block(String blockType,String blockName, String blockDescription, String blockHtml) {
		super();
		this.blockName = blockName;
		this.blockDescription = blockDescription;
		this.blockHtml = blockHtml;
		this.blockType = blockType;
	}
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	protected void setId(String id) {
		this.id = id;
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

	/**
	 * @return the blockHtml
	 */
	public String getBlockHtml() {
		return blockHtml;
	}

	/**
	 * @param blockHtml the blockHtml to set
	 */
	public void setBlockHtml(String blockHtml) {
		this.blockHtml = blockHtml;
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

	/* 获取代码段基本信息
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Block [getId()=" + getId() + ", getBlockName()="
				+ getBlockName() + ", getBlockDescription()="
				+ getBlockDescription() + "]";
	}

	//代码段编号
	private String id;
	
	//代码类别，自定义字符串，用来扩展功能，如新闻列表、简单评论等
	private String blockType;
	
	//代码段名称
	private String blockName;
	
	//代码段描述
	private String blockDescription;
	
	//代码段内容（HTML代码）
	private String blockHtml;
}
