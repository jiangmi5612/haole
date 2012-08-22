package dao;

import domain.Option;

public interface IOptionDAO {
	
	public void addOption(Option option);
	
	public void deleteOption(Option option);
	
	public void updateOption(Option option);
	
	public Option getOptionByKey(String key);
	
	public Option getOptionByKeyAndValue(String key,String val);
}
