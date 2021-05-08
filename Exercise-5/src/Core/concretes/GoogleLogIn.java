package Core.concretes;

import Core.abstracts.GoogleLoginService;

public class GoogleLogIn implements GoogleLoginService{

	@Override
	public void googleAccountLogInService(String message) {
		System.out.println(message);
		
	}

}
