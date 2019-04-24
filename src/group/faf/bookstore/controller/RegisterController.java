package group.faf.bookstore.controller;

import group.faf.bookstore.model.customer.Customer;
import group.faf.bookstore.model.customer.CustomerDAO;
import group.faf.bookstore.model.customer.CustomerDAOImpl;
import group.faf.bookstore.model.customer.person.Account;
import group.faf.bookstore.model.customer.person.FullName;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterController" ,urlPatterns = "/register")
public class RegisterController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String first_name = request.getParameter("firstName");
        String last_name = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("add");
        String contact = request.getParameter("contact");
        if(first_name.isEmpty() || last_name.isEmpty() || username.isEmpty() ||
                password.isEmpty() || address.isEmpty() || contact.isEmpty())
        {
            RequestDispatcher req = request.getRequestDispatcher("register.jsp");
            req.include(request, response);
        }
        else{

            Customer customer = new Customer.CustomerBuilder(username,password,first_name,last_name)
                    .address(address)
                    .phone(contact)
                    .build();
            CustomerDAO customerDAO = new CustomerDAOImpl();
            customerDAO.addCustomer(customer);
            RequestDispatcher req = request.getRequestDispatcher("register_success.jsp");
            req.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.println("hello get");
    }
}
