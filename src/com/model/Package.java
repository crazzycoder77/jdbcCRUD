package com.model;

public class Package {
	
	private String packageId;
	private String sourcePlace;
	private String destinationPlace;
	private float basicFare;
	private int noOdDays;
	private float packageCost;
	
	public String getPackageId() {
		return packageId;
	}
	
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	
	public String getSourcePlace() {
		return sourcePlace;
	}
	
	public void setSourcePlace(String sourcePlace) {
		this.sourcePlace = sourcePlace;
	}
	
	public String getDestinationPlace() {
		return destinationPlace;
	}
	
	public void setDestinationPlace(String destinationPlace) {
		this.destinationPlace = destinationPlace;
	}
	
	public float getBasicFare() {
		return basicFare;
	}
	
	public void setBasicFare(float basicFare) {
		this.basicFare = basicFare;
	}
	
	public int getNoOdDays() {
		return noOdDays;
	}
	
	public void setNoOdDays(int noOdDays) {
		this.noOdDays = noOdDays;
	}
	
	public float getPackageCost() {
		return packageCost;
	}
	
	public void setPackageCost(float packageCost) {
		this.packageCost = packageCost;
	}
	
	@Override
	public String toString() {
		return "Package [packageId=" + packageId + ", sourcePlace=" + sourcePlace + ", destinationPlace="
				+ destinationPlace + ", basicFare=" + basicFare + ", noOdDays=" + noOdDays + ", packageCost="
				+ packageCost + "]";
	}
	
	public Package(String packageId, String sourcePlace, String destinationPlace, float basicFare, int noOdDays) {
		super();
		this.packageId = packageId;
		this.sourcePlace = sourcePlace;
		this.destinationPlace = destinationPlace;
		this.basicFare = basicFare;
		this.noOdDays = noOdDays;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((packageId == null) ? 0 : packageId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Package other = (Package) obj;
		if (packageId == null) {
			if (other.packageId != null)
				return false;
		} else if (!packageId.equals(other.packageId))
			return false;
		return true;
	}
}
