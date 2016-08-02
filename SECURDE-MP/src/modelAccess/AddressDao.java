package modelAccess;

import models.Address;

public interface AddressDao {
	public boolean addAddress (Address address);
	public Address getAddress (int addressId);
	public void updateAddress (Address address);
	public void deleteAddress (int addressId);
}