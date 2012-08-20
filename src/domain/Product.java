/**
 * 产品类
 */
package domain;

import java.util.Set;

/**
 * @author 姜敏
 * @version 1.0.0
 */
public class Product {
	
	/**
	 * 无参构造函数
	 */
	public Product(){}

	/**
	 * 带参构造函数
	 * @param productName
	 * @param productDescription
	 * @param marketPrice
	 * @param productPrice
	 * @param productFeature
	 * @param productInfo
	 * @param category
	 * @param browseTimes
	 */
	public Product(String productName, String productDescription,
			float marketPrice, float productPrice, String productFeature,
			String productInfo, Category category, int browseTimes, Set<Productmeta> productmetas) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.marketPrice = marketPrice;
		this.productPrice = productPrice;
		this.productFeature = productFeature;
		this.productInfo = productInfo;
		this.category = category;
		this.browseTimes = browseTimes;
		this.productmetas = productmetas;
	}
	
	//产品ID
	private String id;

	//产品名称
	private String productName;
	
	//产品简述
	private String productDescription;
	
	//产品的市场价
	private float marketPrice;
	
	//产品售价
	private float productPrice;
	
	//产品关键指标（HTML代码）
	private String productFeature;
	
	//产品完整信息（HTML代码）
	private String productInfo;
	
	//产品所属类别
	private Category category;
	
	//产品的浏览量计数
	private int browseTimes;
	
	//产品的扩展信息集合
	private Set<Productmeta> productmetas;
	
	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(float marketPrice) {
		this.marketPrice = marketPrice;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductFeature() {
		return productFeature;
	}

	public void setProductFeature(String productFeature) {
		this.productFeature = productFeature;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getBrowseTimes() {
		return browseTimes;
	}

	public void setBrowseTimes(int browseTimes) {
		this.browseTimes = browseTimes;
	}

	/**
	 * @return the productmetas
	 */
	public Set<Productmeta> getProductmetas() {
		return productmetas;
	}

	/**
	 * @param productmetas the productmetas to set
	 */
	public void setProductmetas(Set<Productmeta> productmetas) {
		this.productmetas = productmetas;
	}

	@Override
	public String toString() {
		return "Product [getId()=" + getId() + ", getProductName()="
				+ getProductName() + "]";
	}


}
