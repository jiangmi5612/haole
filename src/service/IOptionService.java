package service;

import domain.Option;

public interface IOptionService {
	
	public void addOption(Option option);
	
	public void deleteOption(Option option);
	
	public void updateOption(Option option);
	
	public Option getOptionByKey(String key);
	
	public Option getOptionByKeyAndValue(String key,String value);
}
