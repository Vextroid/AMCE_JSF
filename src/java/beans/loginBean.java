package beans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import beans.CustomerBeanRemote;
import beans.EmployeeBeanRemote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.sql.DataSource;

/**
 *
 * @author Vextroid
 */
@Named(value = "loginBean")
@RequestScoped
public class loginBean {
    @Resource(mappedName = "jms/messageQue")
    private Queue messageQue;
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;
    

    /**
     * Creates a new instance of loginBean
     */
     @Resource(lookup = "jdbc/acmeDBDatasource")
    private DataSource dataSource;
    private Connection connection;
    
//    @PostConstruct
//    public void initialize(){
//        try{
//            connection = dataSource.getConnection();
//        }catch (SQLException sqle)
//        {
//            sqle.printStackTrace();
//        }
//    }
//    
//    /**
//     *
//     */
//    @PreDestroy
//     public void close()
//    {
//        try{
//            connection.close();
//        }catch (SQLException sqle)
//        {
//            sqle.printStackTrace();
//        }
//        
//    }
    
    
    
    private static CustomerBeanRemote customerBean;
    private static EmployeeBeanRemote employeeBean;
        private String firstName;
        private int customerID;
        private int id = 0;
        private String extra;
        private String isOk;
        private String fName ="w";
        final String nextPage = "confirmation.xhtml";

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public loginBean() {
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }
    
    public String getNext()
    {
        return nextPage;
    }
       
    
    public String validLogin()
    {
        //id = this.getCustomerID();
         id = 10;
         try{
          //Customer c = null;
          
          PreparedStatement sqlStatement = connection.prepareStatement("SELECT * FROM DBUSR.CUSTOMER WHERE C_ID =" + id);
           
          ResultSet result = sqlStatement.executeQuery();
 
          //result.next();

          fName = result.getString("FIRST_NAME");
          
          //int cusID = result.getInt("C_ID");

          //return fName;

      }catch (SQLException sqlException)
      {
          System.out.println("Could not find customer.");
          sqlException.printStackTrace();
          return sqlException.toString();
    }
             
      
        System.out.println(fName);
        int cid = this.getCustomerID();
        firstName = this.getFirstName();
        if(fName.equals(firstName))
        {
         isOk ="true";
         return isOk;
         //return "conformation.xhtml";
        }
        else
        {
         isOk = "false";    
         return isOk;
         //return "index.xhtml";
        }

    }

    private void sendJMSMessageToMessageQue(String messageData) {
        context.createProducer().send(messageQue, messageData);
    }
    
    
}
