package DataAccess.concretes;

import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

public class HibernateDao implements UserDao{

	@Override
	public void add(User user) {
		System.out.println("Adding with Hibernate : " + user.getFirstName() + user.getLastName());
		
	}

	@Override
	public void update(User user) {
		
	}

	@Override
	public void delete(User user) {
		
	}

	@Override
	public User get(String email) {
		return null;
	}

	
}
