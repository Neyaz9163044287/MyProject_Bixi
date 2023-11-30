package com.bixi.GenericUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;

public class IAnnoTrans implements org.testng.internal.annotations.IAnnotationTransformer 
{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod,
			Class<?> occurringClazz) 
	{
		annotation.setRetryAnalyzer(com.bixi.GenericUtils.RetryImpclass.class);
	}

	
	
}
