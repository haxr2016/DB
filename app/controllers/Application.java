package controllers;


import models.Product;
import play.db.jpa.Transactional;
import play.mvc.*;

import play.twirl.api.Html;
import views.html.*;

import java.util.List;


public class Application extends Controller {

 /*   @Transactional
    public Result getcnames() {
        List<Product> product = ProductController.colname(sessionFactoryBean);
        return ok(String.valueOf(product));
    } */



    @Transactional
    public Result getProduct() {
        List<Product> product = ProductController.getAllProductsFromRepo();
        return ok(play.libs.Json.toJson(product));

    }

    @Transactional


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

