/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Vextroid
 */
@Named(value = "registrationBean")
@ManagedBean
@RequestScoped
public class RegistrationBean {
        private String salutation;
        private String firstName;
        private String lastName;
        private int age;
        private String email;
    /**
     * Creates a new instance of RegistrationBean
     */
    public RegistrationBean() {
         
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
