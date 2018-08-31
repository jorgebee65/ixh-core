package com.ixh.model.builder;

public class Builders {
	
	public static AdvertiseBuilder advBuilder;
	public static CategoryBuilder catBuilder;
	public static CuponBuilder cuponBuilder;
	public static UserBuilder userBuilder;
	
	static {
		catBuilder = new CategoryBuilder();
		advBuilder = new AdvertiseBuilder();
		cuponBuilder = new CuponBuilder();
		userBuilder = new UserBuilder();
	}
}
