/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author wellington.rigoni
 */
public class connectionBD {
    
    
    public Connection conectaBD(){
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            

        }
        
        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.0.244:1521:WINTST", "wilso", "teste");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
            
        }

        return connection;
    }
       /*public Cliente consultaCli(){
  
        Cliente cli = new Cliente();
         
        try {
            Connection con = connection.conectaBD();
                        
            String sql = "select codcli, cliente,telcob,cgcent from pcclient where codcli = 100 ";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                    cli.codCli = rs.getInt(1);
                    cli.cliente = rs.getString(2);
                    cli.telefone = rs.getString(3);
                    cli.cnpj = rs.getString(4);               
            }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("error" + e);
        }
        return cli;
    } */
}
