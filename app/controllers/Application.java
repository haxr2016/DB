package controllers;



import play.*;
import play.db.DB;
import play.mvc.*;

import views.html.*;

import java.sql.Connection;

public class Application extends Controller {
    Connection connection = DB.getConnection();

    public Result index() {

        return ok(index.render("Yo application is ready."));
    }

    public Result list() {
        return ok(index.render("your list nt implemented yet"));


    }

    public Result update() {
        return ok(index.render("ur update is not implemented yet"));
    }



}

