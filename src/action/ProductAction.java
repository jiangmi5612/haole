package action;

import java.util.List;

import service.ICategoryService;
import service.IProductService;
import service.IProductmetaService;

import com.opensymphony.xwork2.ActionSupport;
import commons.PageInfo;

import domain.Category;
import domain.Product;
import domain.Productmeta;

public class ProductAction extends ActionSupport {
	
	/**
	 * 按照请求渲染产品类别列表
	 * @return
	 */
	public String renderCatList() {
		listCategory = categoryService.getAllCategorie();
		return SUCCESS;
	}
	
	/**
	 * 新增产品页
	 * @return
	 */
	public String addProduct() {
		//判断是新增还是编辑
		if(productId > 0){ //编辑模式
			Product originalProduct = productService.getProductById(productId);
			Category category = categoryService.getCategoryById(categoryId);
			
			originalProduct.setProductName(product.getProductName());
			originalProduct.setProductDescription(product.getProductDescription());
			originalProduct.setMarketPrice(product.getMarketPrice());
			originalProduct.setProductPrice(product.getProductPrice());
			originalProduct.setProductFeature(product.getProductFeature());
			originalProduct.setProductInfo(product.getProductInfo());
			
			originalProduct.setCategory(category);
			originalProduct.setBrowseTimes(product.getBrowseTimes());
			originalProduct.setImg(product.getImg());
			
			productService.updateProduct(originalProduct);
			return INPUT;
		}
		else {
			Category category = categoryService.getCategoryById(categoryId);
			if(category != null && category.getId() > 0){
				//如果成功查询到对应类别，则新增该产品
				product.setCategory(category);
				productService.addProduct(product);
			}
			return INPUT;
		}
	}
	
	/**
	 * 列出产品页
	 * @return
	 */
	public String listProduct() {
		pageInfo = productService.getProductWithPage(10, pageNo);
		pageInfo.setListPage("listProduct?pageNo=");
		return "list";
	}
	
	/**
	 * 删除产品
	 * @return
	 */
	public String delProduct(){
		if(productId > 0){
			productService.deleteProductById(productId);
		}
		//TODO:如果网站规模较大，查询列表的消耗较高的话，此处可以改进为通过Ajax删除
		//本系统不在后台中引入Ajax
		return "relist";
	}
	
	/**
	 * 编辑产品
	 * @return
	 */
	public String edtProduct() {
		product = productService.getProductById(productId);
		if(product.getId() > 0){
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

	//映射产品
	private Product product;
	
	//接收产品类别id
	private int categoryId;
	
	//映射产品id
	private int productId;
	
	//映射产品类别列表
	private List<Category> listCategory;
	
	//映射页码
	private int pageNo;
	
	//映射分页信息类
	private PageInfo pageInfo;

	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	 * @return the pageInfo
	 */
	public PageInfo getPageInfo() {
		return pageInfo;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}
