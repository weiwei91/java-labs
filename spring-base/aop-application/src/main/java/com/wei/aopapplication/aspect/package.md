# 切点规则匹配

# execution
/**
*scope:表示方法作用域，例如：public, private, protect
*return-type:表示返回类型
*fully-qualified-class-name:表示类的完全限定名
*method-name:表示方法名
*parameters:表示参数
*/
execution(<scope> <return-type> <fully-qualified-class-name><method-name>(<parameters>))
例如：@Pointcut("execution(public * com.wei.*.controller..*Controller.*(..))")

# annotation
用于匹配所有标注了指定注解的方法，语法如下：@annotation(<annotationName>)
例如:匹配所有标注了TestTimer的方法
@Pointcut("@annotation(aopnew.annotation.TestTimer)")

# within
语法格式 within(<typeName>); typeName表示类或者接口的全限定名，支持通配符
@Pointcut("within(aopnew.service.MyTestService*)")

## 通知类型
@Before() 前置通知
@After() 最终通知
@AfterReturning 后置通知
@doAround() 环绕通知
@AfterThrowing() 异常通知







