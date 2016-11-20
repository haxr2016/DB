package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import models.Category;
import models.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.metadata.ClassMetadata;
import play.Logger;
import play.data.Form;
import play.data.format.Formatters;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;


import javax.persistence.TypedQuery;
import java.net.URI;
import java.security.DomainLoadStoreParameter;
import java.util.List;
import java.util.Locale;

public class ProductController extends Controller {

	@Transactional
    public static void allProducts() {
    	String category  = request().getQueryString("cat");
    	List<Product> prods = getAllProductsFromRepo(null);
    	String title = category == null ? "Products" : category;
//        Logger logger = new Logger();
        Logger.info("product list");
        for (Product p :prods) Logger.info(p.toString());
//    	return ok(products.render(title, prods, UserController.getCurrentUser()));
//
  }

	@Transactional
    public static Result product(int id) {
    	Product prod = getProductFromRepo(id);
    	if (prod == null) {
    		return notFound("product not found");
    	}
//        return ok(product.render(prod, UserController.getCurrentUser()));
//
    return null;
    }
    
	@Transactional
	public static Result rawProduct(int id) {
		Product product = JPA.em().find(Product.class, id);
		if (product == null) {
			return notFound();
		}
		ObjectNode result = Json.newObject();
		result.put("name", product.getName());
		result.put("image", product.getImage());
		result.put("id", product.getProduct_id());
		result.put("price", product.getPrice());
		
		return ok(result);
	}
	
	
	@Transactional
	@Security.Authenticated(StaffAuthenticator.class)
	public static Result newProduct() {
		
		Formatters.register(Category.class, new Formatters.SimpleFormatter<Category>(){

			@Override
			public Category parse(String id, Locale arg1)
					throws java.text.ParseException {
				return JPA.em().find(Category.class, Integer.parseInt(id));
			}

			@Override
			public String print(Category category, Locale arg1) {
				return category.getCategory_id() + "";
			}
		});		
		
		Product product = Form.form(Product.class).bindFromRequest().get();
		JPA.em().persist(product);

        return null;
//		return redirect(routes.ProductController.allProducts());
	}
	

	@Transactional
	public static List<Product> getAllProductsFromRepo() {
		return getAllProductsFromRepo(null);
	}
	
	@Transactional
    private static List<Product> getAllProductsFromRepo(String category) {
    	List<Product> allProducts = JPA.em().createQuery("SELECT a FROM Product a", Product.class).getResultList();
    	if (category == null) {
    		return allProducts;
    	} 
    	else {
    		TypedQuery<Product> query = JPA.em().createQuery("SELECT p FROM Product p JOIN p.category_id c WHERE c = :cat GROUP BY p", Product.class);
    		return query.setParameter("cat", category).getResultList();
    	}
    }


	
	@Transactional
    private static Product getProductFromRepo(int id) {
    	Product product = JPA.em().find(Product.class, id);
    	return product;
    }


    @Transactional
    public Result addProduct() {
        JsonNode json = request().body().asJson();
        Product product = Json.fromJson(json,Product.class);


        JPA.em().persist(product);
        return ok("inserted");

    }



}

