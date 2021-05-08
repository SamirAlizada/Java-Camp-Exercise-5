package Buisness.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import Buisness.abstracts.UserService;
import Core.abstracts.GoogleLoginService;
import DataAccess.abstracts.UserDao;
import Entities.concretes.User;

public class UserManager implements UserService{
	
	UserDao userDao; 
	GoogleLoginService googleLoginService;
	
	private ArrayList<String> emailList = new ArrayList<String>();
	private ArrayList<String> passwordList = new ArrayList<String>();

	public static boolean isEmailValid(String email) {
		final Pattern EMAIL_REGEX = Pattern.compile(
				"[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
				Pattern.CASE_INSENSITIVE);
		return EMAIL_REGEX.matcher(email).matches();
	}
	
	public static boolean isEmailValidOnClick() {
		return true;
	}
	
	public UserManager(UserDao userDao, GoogleLoginService googleLoginService) {
		this.userDao = userDao;
		this.googleLoginService = googleLoginService;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void register(String email, String password, User user) {
		if(isEmailValid(email) != true) {
			System.out.println("Email address is not valid. Please enter a valid e-mail address. ");
			return;
		}
		else if(user.getEmail().equals(emailList.contains(email))) {
			System.out.println("You have entered a registered e-mail address. Please enter a valid e-mail address. ");
			return;
		}
		else if (user.getFirstName().length() < 2) {
			System.out.println("The name must have at least 2 characters. ");
			return;
		}
		else if (user.getLastName().length() < 2) {
			System.out.println("The surname must have at least 2 characters. ");
			return;
		}
		else {
			System.out.println("Registration was successful.");
			emailList.add(email);
			passwordList.add(password);
			userDao.add(user);
		}
		
	}

	@Override
	public void LogIn(String email, String password) {
		if (isEmailValidOnClick()) {
			System.out.println("Please verify your e-mail before logging in. ");
		}
		if (isEmailValid(email) && passwordList.contains(password)) {
			System.out.println("Login successful. ");
			return;
		}
		else if (!passwordList.contains(password) || !isEmailValid(email)) {
			System.out.println("Login failed. Please check your login information. ");
		}
		
	}

	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public void googleRegister(User user) {
		googleLoginService.googleAccountLogInService(user.getEmail());
		return;
	}

}
