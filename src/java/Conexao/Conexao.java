/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Robson
 */
public class Conexao {
        
     private static Connection conexao=null;
   public static Connection getConexao() throws SQLException, ClassNotFoundException{
         if (conexao == null){
        Class.forName("org.apache.derby.jdbc.ClientDriver");
         
        System.out.println("Driver carregado com sucesso!");
            
            //criando conexão .
            conexao = java.sql.DriverManager.getConnection("jdbc:derby://localhost:1527/trabalho", "trabalholpo", "trabalholpo");
            System.out.println("Banco de dados conectado com sucesso.");
         }
   return conexao;
   }

    
}
