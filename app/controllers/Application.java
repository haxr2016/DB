package controllers;


import org.h2.engine.User;
import play.db.jpa.Transactional;
import play.mvc.*;

import play.twirl.api.Html;
import views.html.*;

import java.sql.Connection;
import java.text.Normalizer;


public class Application extends Controller {

    public Result login() {
        return ok(login.render());
    }


    @Transactional(readOnly = true)
    public Result index() {

        return ok(index.render("testing",new models.User(),new Html("")));
    }


    @Transactional
    public Result home() {
        ProductController.allProducts();

        return ok(home.render());
    }

    public Result prodDetails() {
        return ok(proddetails.render());
    }


}

