package domain;

public class ProductRow {
	
	/**
	 * @param id
	 * @param categoryName
	 * @param productDescription
	 * @param productPrice
	 * @param browseTimes
	 * @param productImg
	 */
	public ProductRow(Integer id, String categoryName,String productName, String productDescription,
			Float productPrice, Integer browseTimes, String productImg) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.browseTimes = browseTimes;
		this.productImg = productImg;
	}
	
	private Integer id;
	private String categoryName;
	private String productName;
	private String productDescription;
	private Float productPrice;
	private Integer browseTimes;
	private String productImg;
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
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}
	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	/**
	 * @return the productPrice
	 */
	public float getProductPrice() {
		return productPrice;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * @return the browseTimes
	 */
	public int getBrowseTimes() {
		return browseTimes;
	}
	/**
	 * @param browseTimes the browseTimes to set
	 */
	public void setBrowseTimes(int browseTimes) {
		this.browseTimes = browseTimes;
	}
	/**
	 * @return the productImg
	 */
	public String getProductImg() {
		return productImg;
	}
	/**
	 * @param productImg the productImg to set
	 */
	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}
	
}
