package com.hui.pattern;

public class SingletonA {
	private static final SingletonA instance = new SingletonA();
	
	private SingletonA()
	{
		
	}
	
	public static SingletonA getInstance()
	{
		return instance;
	}
}
