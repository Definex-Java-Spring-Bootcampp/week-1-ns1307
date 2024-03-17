package com.patika.kredinbizdenservice;

import com.patika.kredinbizdenservice.enums.CategoryType;
import com.patika.kredinbizdenservice.enums.LoanType;
import com.patika.kredinbizdenservice.model.*;
import com.patika.kredinbizdenservice.product.Customer;
import com.patika.kredinbizdenservice.product.Order;
import com.patika.kredinbizdenservice.product.OrderItem;
import com.patika.kredinbizdenservice.product.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;

@SpringBootApplication
public class KredinbizdenserviceApplication {


	public static void main(String[] args) {
		SpringApplication.run(KredinbizdenserviceApplication.class, args);


		Bank bank=new Bank("Akbank");
		LoanFactory.getLoan(LoanType.ARAC_KREDISI,bank);//Answer of Question 3 in HW,Factory Design Pattern is used in creation of this object.


		SingleHandler singletonObj = SingleHandler.getInstance();//Answer of Question 3 in HW, Singleton Object is created.


		//Answer of Question 4.1 in HW,Trying to add new user with an email that already exists
		//singletonObj.addNewUser(new User("Cem","Dırman", LocalDate.parse("1990-10-10"),"cemdrman@gmail.com","123123","5554443322",true));


		//Answer 4.2, password of users are encrypted in creation of objects.Check User class for more.


		//Answer of Question 4.3 in HW,Print the user who created new applications the most
		//singletonObj.printMostApplicantUser();

		//Answer of Question 4.4 in HW,Prints the highest application with its user
		//singletonObj.printHighestApplication();

		//Answer of Question 4.5 in HW,Prints the applications in the last month (last 30 days)
		//singletonObj.printApplicationsLastMont();


		//Answer of Question 4.6, Prints credit card offers by the campaign counts in descending order.
		//singletonObj.printCreditCardsDescending();


		//Answer of Question 4.7, Prints the applications of users by their email.
		//singletonObj.printApplicationsByEmail("cemdrman@gmail.com");


		//Answers of question 5 below

		//Creating products
		Product freezer=new Product("Buzdolabı", CategoryType.ELECTRONIC,21000,15);
		Product jacket=new Product("Jacket", CategoryType.CLOTHES,800,25);
		Product pants=new Product("Pantolon", CategoryType.CLOTHES,550,25);
		Product perfume=new Product("Parfüm", CategoryType.COSMETICS,999,15);
		Product ladder=new Product("Merdiven", CategoryType.HOUSE,1275,15);
		Product rice=new Product("Pirinç 1 KG", CategoryType.FOOD,150,50);

		//Creating orders
		List<Order> orderList1=new ArrayList<Order>();
		Order order1=new Order();
		order1.addProduct(ladder);
		order1.addProduct(rice,5);
		order1.addProduct(pants);
		orderList1.add(order1);

		Order order2=new Order();
		order2.addProduct(freezer);
		orderList1.add(order2);

		List<Order> orderList2=new ArrayList<Order>();
		Order order3=new Order();
		order3.addProduct(perfume);
		order3.addProduct(jacket);
		orderList2.add(order3);

		List<Order> orderList3=new ArrayList<Order>();
		Order order4=new Order();
		order4.addProduct(ladder);
		order4.addProduct(jacket);
		orderList3.add(order4);


		List<Order> orderList4=new ArrayList<Order>();
		Order order5=new Order();
		order5.addProduct(rice,4);
		order5.addProduct(jacket);
		orderList4.add(order5);

		List<Order> orderList5=new ArrayList<Order>();
		Order order6=new Order();
		order6.addProduct(pants,2);
		order6.addProduct(jacket,3);
		orderList5.add(order6);


		List<Order> orderList6=new ArrayList<Order>();
		Order order7=new Order();
		order7.addProduct(rice,3);
		orderList6.add(order7);


		//Creating customers with orders

		Customer customer1= new Customer(orderList1,"Cem","Dırman", LocalDate.parse("1995-10-10"),"cemdrman@gmail.com","xXxxX","5554443322",true);
		Customer customer2= new Customer(orderList6,"Enes","Yurtcu", LocalDate.parse("1999-01-29"),"enes_yurtcu@hotmail.com","password","5554443322",true);
		Customer customer3=new Customer(orderList4,"Cem","Yılmaz", LocalDate.parse("1978-02-13"),"cemylmaz@hotmail.com","asdasew","5554443322",true);
		Customer customer4=new Customer(orderList2,"Cem","Kaya", LocalDate.parse("1952-05-15"),"cmkya@hotmail.com","sdqwesd","5554443322",true);
		Customer customer5=new Customer(orderList3,"Adil","Atak", LocalDate.parse("2002-03-21"),"adilatak@hotmail.com","sdaweqw","5554443322",true);
		Customer customer6=new Customer(orderList5,"Ahmet","Mert", LocalDate.parse("1995-11-18"),"ahmetmert@hotmail.com","sdaeqs","5554443322",true);
		Customer customer7=new Customer("Ali","Atik", LocalDate.parse("1994-12-15"),"aliatik@hotmail.com","sdaweq","5554443322",true);

		List <Customer> customerList=new ArrayList<Customer>();
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
		customerList.add(customer4);
		customerList.add(customer5);
		customerList.add(customer6);
		customerList.add(customer7);

		//Answers of Question 5 in HW, OOP model is created in package "product"
		// also, below is printed based on dummy data created in above.
		//printAllCustomersCount(customerList);
		//printAllProductsOfUser(customerList,"Cem");
		//printUsersBetweenAgesWithName(customerList,25,30,"Cem");
		//printOrdersOverPrice(customerList,1500);
	}

	private static void printAllCustomersCount(List <Customer> customerList){
		System.out.println("Müşteri sayısı: "+customerList.size());
	}



	private static void printAllProductsOfUser(List <Customer> customerList, String name){
		for(Customer customer : customerList){
			if(customer.getName().contains(name)){
				System.out.println("All Products bought by "+customer.getName()+" "+customer.getSurname());
				List<Order> orders= customer.getOrderList();
				for(Order order: orders){
					List<OrderItem> orderItems= order.getItems();
					for(OrderItem orderItem: orderItems){
						System.out.println("Product:"+orderItem.getProduct().getName()+", count:"+orderItem.getCount());
					}
				}
				System.out.println("--------------");
			}
		}
	}

	private static void printUsersBetweenAgesWithName(List <Customer> customerList,int minAge,int maxAge,String name){
		Period age;
		System.out.println("Customers named as "+name+" and between "+minAge+"-"+maxAge+" ages(25 and 30 are included)");
		minAge--;
		maxAge++;
		for(Customer customer : customerList){
			if(customer.getName().contains(name)){


				age = Period.between(customer.getBirthDate(), LocalDate.now());
				if(age.getYears()>minAge & age.getYears()<maxAge ){
					System.out.println("Yaş: "+age.getYears()+" "+ customer.getName()+" "+customer.getSurname());
				}
			}
		}
		System.out.println("--------------");
	}

	private static void printOrdersOverPrice(List <Customer> customerList,double price){
		System.out.println("All Orders over this price: " + price);
		System.out.println("##############");
		for(Customer customer : customerList) {
			List<Order> orders = customer.getOrderList();
			for (Order order : orders) {
				if (order.getTotalPrice() > price) {
					System.out.println("The price of this order: " + order.getTotalPrice());
					System.out.println("This order is given by: " + customer.getName() + " " + customer.getSurname());
					System.out.println("Contents of this order:");
					List<OrderItem> orderItems = order.getItems();
					for (OrderItem orderItem : orderItems) {
						System.out.println("Product:" + orderItem.getProduct().getName() + ", count:" + orderItem.getCount());
					}
					System.out.println("--------------");

				}
			}
		}
	}
}
