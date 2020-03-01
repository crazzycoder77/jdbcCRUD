package com.dao;

import java.util.List;
import com.model.Package;
public class PackageDaoImplTest {
	public static void main(String[] args) {
		PackageDaoImpl pkg = new PackageDaoImpl();
		System.out.println("File Reading...");
		List<Package> list = pkg.readPackages("package.txt");
		System.out.println("File Read...");
		System.out.println("Inserting Data...");
		pkg.insertPackage(list);
		System.out.println("Inserting Done");
	}
}
