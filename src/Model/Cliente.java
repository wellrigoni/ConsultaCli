/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author wellington.rigoni
 */
public class Cliente {
    public int codCli;
    public String cliente;
    public String cnpj;
    public String telefone;

    public Cliente() {
    
    }
    public Cliente(int codCli, String cliente, String cnpj, String telefone) {
        this.codCli = codCli;
        this.cliente = cliente;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Código: "+ codCli +"\nCliente: "+ cliente+ "\nCNPJ: "+cnpj +"\nTelefone:"+telefone; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
