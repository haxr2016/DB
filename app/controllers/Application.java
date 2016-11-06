package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index() {

        return ok(index.render("Yo application is ready."));
    }

    public  static Result list() {
        return ok(index.render("your list nt implemented yet"));
    }

    public static Result update() {
        return ok(index.render("ur update is not implemented yet"));
    }
}
