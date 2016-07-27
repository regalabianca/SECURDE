package modelAccess;

import models.Product;

public interface ProductDao {
	public boolean addProduct (Product product);
	public Product getProduct (int productId);
	public void updateProduct (Product product);
	public void deleteProduct (int productId);
}
