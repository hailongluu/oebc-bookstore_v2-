package group.faf.bookstore.model.customer;

import group.faf.bookstore.model.customer.person.Account;
import group.faf.bookstore.model.customer.person.Address;
import group.faf.bookstore.model.customer.person.FullName;
import group.faf.bookstore.model.customer.person.Person;

public class Customer extends Person {
	private int id;
	private int age;
	private String phone;

	public Customer(Account account, FullName fullName, Address address, int id, int age, String phone) {
		super(account, fullName, address);
		this.id = id;
		this.age = age;
		this.phone = phone;
	}

	public Customer(Account account, FullName fullName, Address address, int id) {
		super(account, fullName, address);
		this.id = id;
	}

	public int getId() {
		return id;
	}



	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", fullName=" + fullName +
				", address=" + address +
				'}';
	}
	public static class CustomerBuilder{
		private final String username;
		private final String pass;
		private final String firstName;
		private final String lastName;
		private int age;
		private String address;
		private String phone;

		public CustomerBuilder(String username, String pass, String firstName, String lastName) {
			this.username = username;
			this.pass = pass;
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public CustomerBuilder age(int age){
			this.age = age;
			return this;
		}
		public  CustomerBuilder address(String add){
			this.address = add;
			return this;
		}
		public CustomerBuilder phone(String phone){
			this.phone = phone;
			return this;
		}
		public Customer build(){
			FullName fullName = new FullName(this.firstName,"", this.lastName);
			Account account = new Account(this.username, this.pass);
			Address address = new Address(this.address);
			Customer customer = new Customer(account,fullName,address,123,this.age,this.phone);
			return customer;
		}
	}
}