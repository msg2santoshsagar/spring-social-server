package com.sagar.springsocialserver.util;


public class CustomLogWriter {

	private String TAG;

	private CustomLogWriter(){
		// private constructor
	};

	public String getTAG() {
		return TAG;
	}

	public CustomLogWriter setTAG(String tAG) {
		TAG = tAG;
		return this;
	}



	public static CustomLogWriter getLogger(Class<?> cls){
		return new CustomLogWriter().setTAG(cls.getName());
	}

	
	public void debug(String ...strings){
		
		System.out.print(DateUtil.getCurrentDateInIst());
		
		printSeperator();
		System.out.print("debug");
		printSeperator();
		System.out.print(this.TAG);
		printSeperator();
		for(String str : strings){
			System.out.print(str);
			printSpace();
		}
		System.out.println();
	}

	public void error(String ...strings){
		System.out.print(DateUtil.getCurrentDateInIst());printErrSeperator();
		System.err.print("error");
		printErrSeperator();
		System.err.print(this.TAG);
		printErrSeperator();
		for(String str : strings){
			System.err.print(str);
			printErrSpace();
		}
		System.err.println();
	}

	private void printSpace(){
		System.out.print(" ");
	}

	private void printErrSpace(){
		System.err.print(" ");
	}

	private void printSeperator(){
		System.out.print(" :: ");
	}

	private void printErrSeperator(){
		System.err.print(" :: ");
	}


}
