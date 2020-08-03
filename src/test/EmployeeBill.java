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

class EmployeeBill {

	@Test
	void test() {
		RetailShop retail=new RetailShopImpl();
		List<Product> list=new ArrayList();
		Product product=new Product();
		Product product1=new Product();
		User user=new User();
		user.setUserId(1);
		user.setUserName("employee1");
		user.setUsertype(UserType.Employee);
		user.setRegistrationDate(LocalDate.now());
		product.setProductId(10);
		product.setProductName("carrot");
		product.setProductType(ProductType.Groceries);
		product.setQuantity(10);
		product.setRatePerQuantity(10);
		list.add(product);
		product1.setProductId(20);
		product1.setProductName("Lays");
		product1.setProductType(ProductType.NotGroceries);
		product1.setQuantity(10);
		product1.setRatePerQuantity(10);
		list.add(product1);
		user.setProduct(list);
		double bill=retail.calculateBill(user);
		System.out.println(bill);
		assertEquals(165, bill);
		
	}

}
