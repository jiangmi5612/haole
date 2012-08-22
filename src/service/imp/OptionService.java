package service.imp;

import dao.IOptionDAO;
import domain.Option;
import service.IOptionService;

//由于Option的特殊性，我们将相关逻辑推迟到Action当中，Service中只传递DAO所做的工作
public class OptionService implements IOptionService {
	
	private IOptionDAO optionDAO;
	
	/**
	 * @param optionDAO the optionDAO to set
	 */
	public void setOptionDAO(IOptionDAO optionDAO) {
		this.optionDAO = optionDAO;
	}

	@Override
	public void addOption(Option option) {
		optionDAO.addOption(option);

	}

	@Override
	public void deleteOption(Option option) {
		optionDAO.deleteOption(option);

	}

	@Override
	public void updateOption(Option option) {
		optionDAO.updateOption(option);

	}

	@Override
	public Option getOptionByKey(String key) {
		return optionDAO.getOptionByKey(key);
	}

	@Override
	public Option getOptionByKeyAndValue(String key, String value) {
		return optionDAO.getOptionByKeyAndValue(key, value);
	}
	
	

}
