package com.example.demo.login.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
//###AOPのクラスなので@Aspectアノテーションをつける
@Component
//###DIコンテナにBean定義をするために@Componentアノテーション
public class LogAspect {

//	@Before("execution(* *..*.*Controller.*(..))")
//	//###＊の一つ目は「戻り値」、スペースあけて、＊の二つ目はパッケージ名
//	public void startLog(JoinPoint jp) {
//		System.out.println("メソッド開始："+ jp.getSignature());
//	}
//
//	@After("execution(* *..*.*Controller.*(..))")
//	public void endLog(JoinPoint jp) {
//		System.out.println("メソッド終了："+jp.getSignature());
//	}
//	@Around("execution(* *..*.*Controller.*(..))")
//	@Around("bean(*Controller)")
//	@Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	@Around("@within(org.springframework.stereotype.Controller)")
	public Object startLog(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("メソッド開始："+jp.getSignature());
		try {
			Object result = jp.proceed();
			System.out.println("メソッド終了：" +jp.getSignature());
			return result;

		}catch(Exception e) {
			System.out.println("メソッド以上終了："+jp.getSignature());
			e.printStackTrace();
			throw e;
		}
	}

}
