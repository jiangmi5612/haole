/**
 * 产品扩展信息类
 */
package domain;

public class Productmeta {
	
	/**
	 * 无参构造函数
	 */
	public Productmeta() {
	}
	
	/**
	 * 带参构造函数
	 * @param product
	 * @param metaKey
	 * @param metaValue
	 */
	public Productmeta(Product product, String metaKey, String metaValue) {
		this.product = product;
		this.metaKey = metaKey;
		this.metaValue = metaValue;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Productmeta [product=" + product + ", metaKey=" + metaKey
				+ ", metaValue=" + metaValue + "]";
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Productmeta other = (Productmeta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

	/**
	 * @return the metaKey
	 */
	public String getMetaKey() {
		return metaKey;
	}

	/**
	 * @param metaKey the metaKey to set
	 */
	public void setMetaKey(String metaKey) {
		this.metaKey = metaKey;
	}

	/**
	 * @return the metaValue
	 */
	public String getMetaValue() {
		return metaValue;
	}

	/**
	 * @param metaValue the metaValue to set
	 */
	public void setMetaValue(String metaValue) {
		this.metaValue = metaValue;
	}


	//扩展信息ID
	private String id;
	
	//对应产品ID
	private Product product;
	
	//扩展键
	private String metaKey;
	
	//扩展值
	private String metaValue;
}
