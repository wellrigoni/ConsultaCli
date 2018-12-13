/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Cliente;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author wellington.rigoni
 */
public class ClienteController {

    connectionBD connection;   
    LocalDate hoje = LocalDate.now();   
    
    
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
    
    
    public List<Cliente> consultaClientesSemCompra(int dias, int rca){
        
        connection = new connectionBD();
        List<Cliente> clientes = new ArrayList<>(); 
        
        
        try {
            Connection con = connection.conectaBD();
                        
            String sql = "select codcli, cliente,telcob,cgcent\n" +
"from pcclient \n" +
"where dtbloq is NULL and bloqueiodefinitivo = 'N' and CODUSUR1 = "+rca+" and dtexclusao is null and codcli not in \n" +
"(select unique(codcli) from pcpedc where posicao <> 'C'  AND data BETWEEN  TO_DATE('"+hoje+"', 'yyyy/mm/dd') -"+dias+" AND TO_DATE('"+hoje+"', 'yyyy/mm/dd'))" ;
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                    Cliente cli = new Cliente();
                    cli.codCli = rs.getInt(1);
                    cli.cliente = rs.getString(2);
                    cli.telefone = rs.getString(3);
                    cli.cnpj = rs.getString(4);
                    System.out.println(cli.toString());
                    clientes.add(cli);
            }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("error" + e);
        }
        return clientes;
    }
    
    
}
