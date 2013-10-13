/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
//import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Vextroid
 */
@Named(value = "testBed")
@RequestScoped
public class TestBed {

    /**
     * Creates a new instance of TestBed
     */
    
    private String one;
    final String world = "Hello World";
    
    public TestBed() {
    }
    
    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }
    
    public String getworld()
    {
        return world;
    }
}
