package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import beans.Product;
import beans.ProductType;
import beans.User;
import beans.UserType;
import service.RetailShop;
import service.RetailShopImpl;

class NormalCustomerBill {

	@Test
	void test() {
		RetailShop retail=new RetailShopImpl();
		List<Product> list=new ArrayList();
		Product product=new Product();
		Product product1=new Product();
		User user=new User();
		user.setUserId(2);
		user.setUserName("bean");
		user.setUsertype(UserType.Normal);
		LocalDate dateInstance = LocalDate.parse("2019-03-27");
		user.setRegistrationDate(dateInstance);
		product.setProductId(10);
		product.setProductName("milk");
		product.setProductType(ProductType.Groceries);
		product.setQuantity(10);
		product.setRatePerQuantity(10);
		list.add(product);
		product1.setProductId(20);
		product1.setProductName("toothpaste");
		product1.setProductType(ProductType.NotGroceries);
		product1.setQuantity(10);
		product1.setRatePerQuantity(20);
		list.add(product1);
		user.setProduct(list);
		double bill=retail.calculateBill(user);
		System.out.println(bill);
		assertEquals(285, bill);
	}

}
