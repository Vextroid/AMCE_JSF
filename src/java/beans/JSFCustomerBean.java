package beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//import DAO.CustomerDAO;
//import RDB.RDBCustomerDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.sql.DataSource;


/**
 *
 * @author Vextroid
 */
@Named(value = "customerBean")
@RequestScoped
public class JSFCustomerBean {
    

    /**
     * Creates a new instance of JSFCustomerBean
     */
    
    @Resource(lookup = "jdbc/acmeDBDatasource")
    private DataSource dataSource;
    private Connection connection;
    
    
        @PostConstruct
    public void initialize(){
        try{
            connection = dataSource.getConnection();
        }catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
    }
    
    /**
     *
     */
    @PreDestroy
     public void close()
    {
        try{
            connection.close();
        }catch (SQLException sqle)
        {
            sqle.printStackTrace();
        }
        
    }
    
private int cID;
private String firstName;
private String lastName;
private Date dob;
private String address;
private List allCust;
    
    public JSFCustomerBean() {
       
        
        
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List getAllCust() {
        return allCust;
    }

    public void setAllCust(List allCust) {
        this.allCust = allCust;
    }
    
    /////////////////////////////////////////////////
    
    
  //@Override
//    public String readCustomer (int id)    {
//            String s;
//            
//        try{
//            CustomerDAO dao = new RDBCustomerDAO(connection);
//          //Employee employee = new Employee(id);
//            //dao.createEmployee(employee);
//            //dao.readEmployee(id);
//            s = dao.readCustomer(id);
//           //s = dao.toString();
//            return s;
//            //return "TESTTTTTTTTTTTTTTTTTT";
//            
//        }catch(Exception e)
//        {
//            System.out.println("Invalid Employee.");
//            e.printStackTrace();
//            return e.toString();
//        }
//    
//    }
    
}
