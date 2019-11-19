# SpringBoot
作为一个入门级别的工程，我们创建了一个HelloWord工程，并简单的使用了SpringBoot的注解
	spring-boot-starter-parent作用
		在pom.xml中引入spring-boot-start-parent,spring官方的解释叫什么stater poms,
		它可以提供dependency management,也就是说依赖管理，
		引入以后在申明其它dependency的时候就不需要version了，后面可以看到。
	spring-boot-starter-web作用
		springweb 核心组件
	spring-boot-maven-plugin作用
		如果我们要直接Main启动spring，那么以下plugin必须要添加，否则是无法启动的。
		如果使用maven 的spring-boot:run的话是不需要此配置的。
		（我在测试的时候，如果不配置下面的plugin也是直接在Main中运行的。）
	@RestController
		在上加上RestController 表示修饰该Controller所有的方法返回JSON格式,直接可以编写Restful接口
	@EnableAutoConfiguration
		注解:作用在于让 Spring Boot   根据应用所声明的依赖来对 Spring 框架进行自动配置
		这个注解告诉Spring Boot根据添加的jar依赖猜测你想如何配置Spring。
		由于spring-boot-starter-web添加了Tomcat和Spring MVC，
		所以auto-configuration将假定你正在开发一个web应用并相应地对Spring进行设置。
	@SpringBootApplication
		@SpringBootApplication 被 @Configuration、@EnableAutoConfiguration、@ComponentScan 注解所修饰，换言之 Springboot 提供了统一的注解来替代以上三个注解
		扫包范围：在启动类上加上@SpringBootApplication注解,当前包下或者子包下所有的类都可以扫到。

静态资源的访问
	http://localhost:8001/sa.png

# SpringBootSwagger
以一个单机工程为例，简单实现了集成Swagger生成API
	http://localhost:8002/swagger-ui.html#/
	http://localhost:8002/swagger-ui.html#/swagger-demo-controller
	
# SpringBootSQL
基于application.properties配置多环境
