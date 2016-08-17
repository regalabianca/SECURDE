package modelAccess;

import java.util.ArrayList;

import models.Purchase;

public interface PurchaseDao {
	public boolean addPurchase (Purchase purchase);
	public Purchase getPurchase (int purchaseId);
	public ArrayList<Purchase> getPurchases ();
	public void updatePurchase (Purchase purchase);
	public void deletePurchase (int purchaseId);
	public ArrayList<Purchase> getPurchases(int productId);
}
