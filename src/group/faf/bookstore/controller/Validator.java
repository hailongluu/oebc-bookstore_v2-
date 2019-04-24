package group.faf.bookstore.controller;

import group.faf.bookstore.model.customer.Customer;
import group.faf.bookstore.model.customer.CustomerDAO;
import group.faf.bookstore.model.customer.CustomerDAOImpl;

public class Validator {
    public Customer getCustomer(String username, String password){
        CustomerDAO customerDAO = new CustomerDAOImpl();
        int idAccount = ((CustomerDAOImpl) customerDAO).checkAccount(username,password);
        if (idAccount!=0){
            return customerDAO.getCustomerByAccount(idAccount);
        }
        else return null;
    }
}
