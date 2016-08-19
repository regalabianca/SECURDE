package modelAccess;

import java.util.ArrayList;

import models.Purchase;

public interface PurchaseDao {
	public boolean addPurchase (Purchase purchase);
	public Purchase getPurchase (int purchaseId);
	public ArrayList<Purchase> getPurchases ();
	public ArrayList<Purchase> getPurchases(int purchaseId);
	public ArrayList<Purchase> getProductPurchases (int productId);
	public void updatePurchase (Purchase purchase);
	public void deletePurchase (int purchaseId);
	
}
