package tech.nikant.springjavaconfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(SpringConfig.class);
		ctx.refresh();
		Service service = ctx.getBean(Service.class);
		System.out.println(service.hashCode());
	
		
		Service service2 = ctx.getBean(Service.class);
		System.out.println(service2.hashCode());
		
		service.save();
		ctx.close();
	}

}
