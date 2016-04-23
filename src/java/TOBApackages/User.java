package TOBApackages;


import java.io.Serializable;
import javax.servlet.annotation.WebServlet;


/**
 *
 * @author megmcd
 */

@WebServlet(urlPatterns={"/user"})
public class User implements Serializable {
    
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String city;
    private String zipCode;
    private String email;
    private String username;
    private String password;
    private String newPassword;
    
    public User() {
        firstName ="";
        lastName = "";
        phoneNumber ="";
        address = "";
        city = "";
        zipCode = "";
        email = "";
        username = "";
        password = "";
    }
    
    public User(String firstName, String lastName, String phoneNumber, String address, String city, String zipCode, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city = city;
    }
    public String getZipCode(){
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNewPassword() {
        return newPassword;
    }
    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
