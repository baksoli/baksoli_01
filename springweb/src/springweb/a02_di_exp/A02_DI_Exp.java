package springweb.a02_di_exp;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import springweb.a02_di_exp.z01_vo.Product;

public class A02_DI_Exp {
	public static void main(String[] args) {
		Resource rs = new ClassPathResource("springweb\\a02_di_exp\\a02_di.xml");
		BeanFactory bean = new XmlBeanFactory(rs);
		
		Product product = (Product)bean.getBean("product");
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getCnt());
			
	}
}
