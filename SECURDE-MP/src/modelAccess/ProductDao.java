package modelAccess;

import java.util.ArrayList;

import models.Product;

public interface ProductDao {
	public boolean addProduct (Product product);
	public Product getProduct (int productId);
	public ArrayList<Product> getProducts (int categoryId);
	public void updateProduct (Product product);
	public void deleteProduct (int productId);
}
