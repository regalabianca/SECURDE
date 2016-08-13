package modelAccess;

import java.util.ArrayList;

import models.Address;

public interface AddressDao {
	public boolean addAddress (Address address);
	public ArrayList<Address> getAddress (int userId);
	public void updateAddress (Address address);
	public void deleteAddress (int addressId);
}