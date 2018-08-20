package com.ixh.model.builder;

public class Builders {
	
	public static AdvertiseBuilder advBuilder;
	public static CategoryBuilder catbuilder;
	
	static {
		catbuilder = new CategoryBuilder();
		advBuilder = new AdvertiseBuilder();
	}
}
