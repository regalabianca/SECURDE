package modelAccess;

import models.Address;

public interface AddressDao {
	public boolean addAddress (Address address);
	public Address getBillingAddress (int addressId);
	public Address getShippingAddress (int addressId);
	public void updateAddress (Address address);
	public void deleteAddress (int addressId);
}