/*package controllers;

import models.User;
import play.mvc.Http;

public class StaffAuthenticator extends MyAuthenticator {

	@Override
	public String getUsername(Http.Context ctx) {
		
		User user = UserController.getCurrentUser();
		
		if (user == null || user.getUser_type_id() != 2) {
			return null;
		}
		
		return ctx.session().get("username");
		
	}
	
}*/
