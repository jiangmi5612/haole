/**
 * 产品类别类
 */
package domain;

import java.util.Set;

/**
 * @author 姜敏
 * @version 1.0.0
 */
public class Category {
	
	/**
	 * 无参构造函数
	 */
	public Category() {
	}
	
	/**
	 * 带参数的构造函数
	 * @param catName
	 * @param catDescription
	 * @param products
	 */
	public Category(String catName, String catDescription, Set<Product> products) {
		super();
		this.catName = catName;
		this.catDescription = catDescription;
		this.products = products;
	}

	//类别ID
	private int id;
	
	//类别名称
	private String catName;
	
	//类别描述
	private String catDescription;
	
	//属于该类别的产品
	private Set<Product> products;

	//获取类别ID
	public int getId() {
		return id;
	}

	//设置类别ID，改为protected，由Hibernate负责自动设置
	protected void setId(int id) {
		this.id = id;
	}

	//获取类别名称
	public String getCatName() {
		return catName;
	}

	//设置类别名称
	public void setCatName(String catName) {
		this.catName = catName;
	}

	//获取类别描述
	public String getCatDescription() {
		return catDescription;
	}

	//设置类别描述
	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}

	//获取属于该类别的产品
	public Set<Product> getProducts() {
		return products;
	}

	//设置属于该类别的产品
	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	/*
	 * 重载toString方法
	 */
	@Override
	public String toString() {
		return "Category [getId()=" + getId() + ", getCatName()="
				+ getCatName() + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}


	
}
