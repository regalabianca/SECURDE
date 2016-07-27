package modelAccess;

import models.Category;

public interface CategoryDao {
	public boolean addCategory (Category category);
	public Category getCategory (int categoryId);
	public void updateCategory (Category category);
	public void deleteCategory (int categoryId);
}
