package dao.imp;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.IOptionDAO;
import domain.Option;

public class OptionDAO implements IOptionDAO {
	
	private SessionFactory sessionFactory;
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addOption(Option option) {
		sessionFactory.getCurrentSession().save(option);

	}

	@Override
	public void deleteOption(Option option) {
		sessionFactory.getCurrentSession().delete(option);

	}

	@Override
	public void updateOption(Option option) {
		sessionFactory.getCurrentSession().update(option);

	}

	@Override
	public Option getOptionByKey(String key) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Option WHERE key=:key");
		query.setString("key", key);
		return (Option)query.uniqueResult();
	}

	@Override
	public Option getOptionByKeyAndValue(String key, String val) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Option WHERE key=:key AND value=:val");
		query.setString("key", key);
		query.setString("val", val);
		return (Option)query.uniqueResult();
	}

}
