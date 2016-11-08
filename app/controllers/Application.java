package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {

        return ok(index.render("Your application is ready."));
    }

    public Result list() {
        return ok(index.render("your list nt implemented yet"));
    }

    public Result update() {
        return ok(index.render("ur update is not implemented yet"));
    }
}
