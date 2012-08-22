package domain;

public class Option {
	
	private int id;
	
	private String key;
	
	private String value;

	/**
	 * 
	 */
	public Option() {
		super();
	}

	/**
	 * @param key
	 * @param value
	 */
	public Option(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	protected void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
