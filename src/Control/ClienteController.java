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
public class ClienteController {

    connectionBD connection;   
    
    public ClienteController() {
    }  
    
    
    
    public Cliente consultaCli(int codcli){
        Cliente cli = new Cliente();
        connection = new connectionBD();
        
        try {
            Connection con = connection.conectaBD();
                        
            String sql = "select codcli, cliente,telcob,cgcent from pcclient where codcli =" +codcli;
            
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
    } 
    
    
}
