package Buisness.abstracts;

import java.util.ArrayList;
import java.util.List;

import Entities.concretes.User;

public interface UserService {
	void register(String email, String password, User user);
	void LogIn(String email, String password);
	List<User> getAll();
	ArrayList<String> emailList = new ArrayList<String>();
	void googleRegister(User user);

}
