/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TOBApackages;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;
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
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        md.update(password.getBytes());
        byte[] mdArray = md.digest();
        StringBuilder sb = new StringBuilder(mdArray.length * 2);
        for (byte b : mdArray) {
            int v = b & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }
    
    public static String getSalt(){
        Random r = new SecureRandom();
        byte[] saltBytes = new byte[32];
        r.nextBytes(saltBytes);
        return Base64.getEncoder().encodeToString(saltBytes);
        
    }
    public static String hashAndSaltPassword(String password) throws NoSuchAlgorithmException {
        String salt = getSalt();
        return hashPassword(password + salt);
    }
}
