package org.testng;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.annotations.ITestAnnotation;

public class IAnnotationTransformerListener implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		if(testMethod.getName().equals("myTestCase")){			
			annotation.setDependsOnMethods(null);
		}
		if(testMethod.getName().equals("myTestCase")){			
			annotation.setInvocationCount(1);					
			annotation.setEnabled(false);
		}
		annotation.setRetryAnalyzer(RetryListener.class);
	}
}
