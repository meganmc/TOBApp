/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBApackages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author megmcd
 */
@WebServlet(urlPatterns={"/newcustomer"})
public class NewCustomerServlet  extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String zipCode = request.getParameter("zipCode");
        String email = request.getParameter("email");
        String username = ("lastName" + "zipCode");
        String password = "welcome1";
        
        if(firstName == null || (lastName == (null)) || (phoneNumber == (null)) || (address == (null)) || (city == (null)) || (zipCode == (null)) || (email == (null))) { 
            out.println("Please fill out all the form fields.");
        } else {
            response.sendRedirect("/success.html");
        }
        
        User user = new User(firstName, lastName, phoneNumber, address, city, zipCode, email, username, password);
        request.setAttribute("user", user);
        
    }
    
}
