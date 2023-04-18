package com.kbstar.frame;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggerAdvice {
	
	@Before("execution(* com.kbstar.service.*Service.*(..))")    // ****Service에 모든 함수 전에 실행
	public void beforeLog(JoinPoint jp){
		Object [] arg = jp.getArgs();
		Signature si = jp.getSignature();

		Date d = new Date();
		System.out.println(d.toString()+
				" Before Log:"+si.getName());
	}
	@After("execution(* com.kbstar.service.*Service.*(..))")
	public void afterLog(JoinPoint jp){
		Signature si = jp.getSignature();
		System.out.println("-----------After Log:"+si.getName());
	}
//	@After("execution(* com.dao.UserDao.get(..))")
//	public void aftergetLog(JoinPoint jp){
//		Signature si = jp.getSignature();
//		System.out.println("-----------After dao GET Log:"+si.getName());
//	}
//	@AfterReturning(pointcut="execution(* com.service.UserService.get(..))",
//			        returning="returnVal")
//	public void afterReturnLog(JoinPoint jp,Object returnVal){
//		Signature si = jp.getSignature();
//		System.out.println("----afterReturn send Mail:"+si.getName()+":"+returnVal);
//	}
//	@AfterThrowing(pointcut="execution(* com.service.UserService.get(..))",
//	               throwing="exObj")
//	public void afterEx(JoinPoint jp, Exception exObj){
//		Signature si = jp.getSignature();
//		System.out.println("---- afterEx Log:"+si.getName());
//		System.out.println(jp.getArgs()[0]);
//		System.out.println("---- Alert Admin:"+exObj.getMessage());
//	}
	@Around("execution(* com.*.*.*Service.*(..))")
	public Object around(ProceedingJoinPoint process){
		Object result = null;
		Signature si = process.getSignature();
		String className = process.getTarget().toString();
		long start = System.currentTimeMillis();
		System.out.println("***Before:"+si.getName()+" "+className);
		try {
			result = process.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(
				si.getName()+"시간:"+(end-start)+"ms");
		System.out.println("***After:"+si.getName()+" "+className);
		return result;
	}
}













