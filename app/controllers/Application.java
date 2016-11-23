package controllers;


import models.Product;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;

import play.twirl.api.Html;
import views.html.*;

import java.util.List;

import static play.data.Form.form;


public class Application extends Controller {
    public Result authenticate() {
        Form<Login> loginForm = form(Login.class).bindFromRequest();
        return ok();
    }

 /*   @Transactional
    public Result getcnames() {
        List<Product> product = ProductController.colname(sessionFactoryBean);
        return ok(String.valueOf(product));
    } */




   /* public  Result login() {
        return ok(
                login1.render(form(Login.class))
        );
    }*/

  /* public Result login() {
        return ok(login.render());
    }*/



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

