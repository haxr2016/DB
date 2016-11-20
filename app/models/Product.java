package models;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue
	@Column(name = "product_id")
	private int product_id;
	private String name;
	private String description;
	private double price;
	private String image;
    private int quantity;
    private float length;
    private float width;
    private float weight;
    private float status;
    private float stock_status_id;
    private int category_id;
    private int warehouse_id;

	public Product(int product_id, String name, String description, double price, String image, int quantity, float length, float width, float weight, float status, float stock_status_id, int category_id, int warehouse_id) {
        this.product_id = product_id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
        this.length = length;

        this.width = width;
        this.weight = weight;
        this.status = status;
        this.stock_status_id = stock_status_id;
        this.category_id = category_id;
        this.warehouse_id = warehouse_id;
    }

    public Product() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getStatus() {
        return status;
    }

    public void setStatus(float status) {
        this.status = status;
    }

    public float getStock_status_id() {
        return stock_status_id;
    }

    public void setStock_status_id(float stock_status_id) {
        this.stock_status_id = stock_status_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", quantity=" + quantity +
                ", length=" + length +
                ", width=" + width +
                ", weight=" + weight +
                ", status=" + status +
                ", stock_status_id=" + stock_status_id +
                ", category_id=" + category_id +
                ", warehouse_id=" + warehouse_id +
                '}';
    }

    @Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other instanceof Product) {
			Product otherProduct = (Product)other;
			return otherProduct.product_id == this.product_id;
		}	
		return false;
	}


}
