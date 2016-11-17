package controllers;



import org.h2.engine.User;
import play.*;
import play.data.Form;
import play.db.DB;
import play.mvc.*;

import views.html.*;

import java.sql.Connection;
import java.text.Normalizer;






public class Application extends Controller {
    Connection connection = DB.getConnection();

    public Result login() {
        return ok(login.render());
    }

   /* public Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        if (loginForm.hasErrors()) {
            return badRequest(login.render(loginForm));
        } else {
            session().clear();
            session("email", loginForm.get().email);
            return redirect(
                    routes.Application.index()
            );
        }
    }*/

    /*public String validate() {
        if (User.authenticate(email, password) == null) {
            return "Invalid user or password";
        }
        return null;
    }*/



    public Result index() {

        return ok(index.render("Your application is ready."));
    }

    public Result list() {
        return ok(index.render("your list nt implemented yet"));

    }

    public Result update() {
        return ok(index.render("ur update is not implemented yet again"));
    }



}

