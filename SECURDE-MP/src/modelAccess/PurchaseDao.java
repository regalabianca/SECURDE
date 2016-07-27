package modelAccess;

import models.Purchase;

public interface PurchaseDao {
	public boolean addPurchase (Purchase purchase);
	public Purchase getPurchase (int purchaseId);
	public void updatePurchase (Purchase purchase);
	public void deletePurchase (int purchaseId);
}
