package com.dao;

import java.util.List;
import java.util.regex.Pattern;

import com.model.Package;

public interface PackageDao {
	public  default boolean isvalidPackageId(String id) throws InvalidPackageIdException {
		boolean flag= Pattern.compile("^.{3}/.{3}$").matcher(id).matches();
		if(!flag)
			throw new InvalidPackageIdException(id+" Is Invalid Package Id");
		return flag;
	}
	public default float calculateCost(Package obj) {
		float packageCost = 0.0f;
		int noOfDays = obj.getNoOdDays();
		float discount=0;
		if(noOfDays<=5)
			discount = 0;
		else if(noOfDays<=8)
			discount = 0.03f;
		else if(noOfDays<=10)
			discount = 0.05f;
		else
			discount = 0.07f;
		packageCost = (obj.getBasicFare()*obj.getNoOdDays())*(1-discount)*1.12f;
		return packageCost;
	}

	public List<Package> readPackages(String fileName);
	public void insertPackage(Package obj);
	public void insertPackage(List<Package> packages);
}
