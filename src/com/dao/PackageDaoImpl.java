package com.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.model.Package;
import com.util.ConnectionHandler;

public class PackageDaoImpl implements PackageDao{

	@Override
	public List<Package> readPackages(String fileName) {
		List<Package> list = new ArrayList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = "";
			while((line=br.readLine())!=null) {
				StringTokenizer tokenString = new StringTokenizer(line, ",");
				String packageId = tokenString.nextToken();
				try {
					isvalidPackageId(packageId);
				} catch (InvalidPackageIdException e) {
					continue;
				}
				String sourcePlace = tokenString.nextToken();
				String destinationPlace = tokenString.nextToken();
				float basicFare = Float.parseFloat(tokenString.nextToken());
				int noOfDays = Integer.parseInt(tokenString.nextToken());
				Package pkg = new Package(packageId, sourcePlace, destinationPlace, basicFare, noOfDays);
				pkg.setPackageCost(calculateCost(pkg));
				list.add(pkg);
			}
			br.close();
			return list;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertPackage(Package obj) {
		try {
			Connection conn = ConnectionHandler.getConnection();
			String sql = "INSERT INTO package VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement smt = conn.prepareStatement(sql);
			smt.setString(1, obj.getPackageId());
			smt.setString(2, obj.getSourcePlace());
			smt.setString(3, obj.getDestinationPlace());
			smt.setFloat(4, obj.getBasicFare());
			smt.setInt(5, obj.getNoOdDays());
			smt.setFloat(6, obj.getPackageCost());
			smt.executeUpdate();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void insertPackage(List<Package> packages) {
		packages.forEach(e -> insertPackage(e));
	}
}
