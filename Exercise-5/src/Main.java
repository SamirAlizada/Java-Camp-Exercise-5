import Buisness.abstracts.UserService;
import Buisness.concretes.UserManager;
import Core.concretes.GoogleLogIn;
import DataAccess.concretes.HibernateDao;
import Entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
		UserService userService = new UserManager(new HibernateDao(), new GoogleLogIn());
		User user1 = new User(1, "Samir ", "Alizada", "samir.deneme@gmail.com", "123456789");
		
		userService.register("samir.deneme@gmail.com", "123456789", user1);
		
		userService.LogIn("samir.deneme@gmail.com", "123456789");
		
		userService.googleRegister(user1);

	}

}
