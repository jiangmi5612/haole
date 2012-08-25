package action;

import java.util.List;

import service.ICategoryService;
import service.IProductService;
import service.IProductmetaService;

import com.opensymphony.xwork2.ActionSupport;

import domain.Category;
import domain.Product;
import domain.Productmeta;

public class ProductAction extends ActionSupport {
	
	//每页多少行记录
	private int itemsPerPage = 10;
	
	/**
	 * 按照请求渲染产品类别列表
	 * @return
	 */
	public String renderCatList() {
		listCategory = categoryService.getAllCategorie();
		return SUCCESS;
	}
	
	public String addProduct() {
		//判断是新增还是编辑
		if(productId > 0){
			productService.updateProduct(productId, productName, productDescription, marketPrice, productPrice, productFeature, productInfo, categoryId, browseTimes, img);
			return INPUT;
		}
		else {
			Category category = categoryService.getCategoryById(categoryId);
			if(category != null && category.getId().length() > 0){
				//如果成功查询到该类别
				productService.addProduct(productName, productDescription, marketPrice, productPrice, productFeature, productInfo, category, browseTimes,img);
				this.productId = 0;
				this.productName = null;
				this.productDescription = null;
				this.categoryId = null;
				this.marketPrice = 0;
				this.productPrice = 0;
				this.productFeature = null;
				this.productInfo = null;
				this.browseTimes = 0;
				this.img = null;
			}
			return INPUT;
		}
	}
	
	public String listProduct() {
		//TODO:优化为只输出选定的列
		//产品完整介绍会很大，无谓地占用了空间，降低了效率
		if(pageNo < 1) pageNo = 1;
		listProduct = productService.getProductWithPage(itemsPerPage, pageNo);
		return "list";
	}
	
	public String delProduct(){
		if(productId > 0){
			productService.deleteProduct(productId);
		}
		return "relist";
	}
	
	public String edtProduct() {
		Product product = productService.getProductById(productId);
		if(product.getId() > 0){
			this.productId = product.getId();
			this.productName = product.getProductName();
			this.productDescription = product.getProductDescription();
			this.categoryId = product.getCategory().getId();
			this.marketPrice = product.getMarketPrice();
			this.productPrice = product.getProductPrice();
			this.productFeature = product.getProductFeature();
			this.productInfo = product.getProductInfo();
			this.browseTimes = product.getBrowseTimes();
			this.img = product.getImg();
			return INPUT;
		}
		else {
			return "list";
		}
	}
	
	private IProductService productService;

	/**
	 * @param productService the productService to set
	 */
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	
	private ICategoryService categoryService;
	
	/**
	 * @param categoryService the categoryService to set
	 */
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	private IProductmetaService productmetaService;
	

	/**
	 * @param productmetaService the productmetaService to set
	 */
	public void setProductmetaService(IProductmetaService productmetaService) {
		this.productmetaService = productmetaService;
	}

	//接收产品类别id
	private String categoryId;
	
	//接收产品名称
	private String productName;
	
	//映射产品简述
	private String productDescription;
	
	//映射产品市场价格
	private float marketPrice;
	
	//映射产品价格
	private float productPrice;
	
	//映射产品特性
	private String productFeature;
	
	//映射产品介绍
	private String productInfo;
	
	//映射浏览次数
	private Integer browseTimes;
	
	//映射产品id
	private int productId;
	
	//映射产品图片路径
	private String img;
	
	//映射产品类别列表
	private List<Category> listCategory;
	
	//映射页码
	private int pageNo;
	
	//映射产品列表
	private List<Product> listProduct;

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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
	 * @return the marketPrice
	 */
	public float getMarketPrice() {
		return marketPrice;
	}

	/**
	 * @param marketPrice the marketPrice to set
	 */
	public void setMarketPrice(float marketPrice) {
		this.marketPrice = marketPrice;
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
	 * @return the productFeature
	 */
	public String getProductFeature() {
		return productFeature;
	}

	/**
	 * @param productFeature the productFeature to set
	 */
	public void setProductFeature(String productFeature) {
		this.productFeature = productFeature;
	}

	/**
	 * @return the productInfo
	 */
	public String getProductInfo() {
		return productInfo;
	}

	/**
	 * @param productInfo the productInfo to set
	 */
	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	/**
	 * @return the browseTimes
	 */
	public Integer getBrowseTimes() {
		return browseTimes;
	}

	/**
	 * @param browseTimes the browseTimes to set
	 */
	public void setBrowseTimes(Integer browseTimes) {
		this.browseTimes = browseTimes;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return the pageNo
	 */
	public int getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo the pageNo to set
	 */
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the listCategory
	 */
	public List<Category> getListCategory() {
		return listCategory;
	}

	/**
	 * @return the listProduct
	 */
	public List<Product> getListProduct() {
		return listProduct;
	}
	
	
}
