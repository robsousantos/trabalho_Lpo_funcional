/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Robson
 */
public class Mercado {
     private static Connection conexao = null;
     private static PreparedStatement criaOferta;
     private static PreparedStatement criaProposta;
     private static PreparedStatement listaOfertas;
     private static PreparedStatement listaPropostas;
     private static PreparedStatement efetuarLogin;
     
    
     
     
    
    public Mercado() throws Exception {
        conexao = Conexao.getConexao();
        
        criaOferta = conexao.prepareStatement("INSERT INTO OFERTA (TITULO, DESCRICAO,OFERTANTE,GRUPO) VALUES ( ?, ?, ? ,?)");
        criaProposta = conexao.prepareStatement("INSERT INTO PROPOSTA (OFERTANTE, DESEJO,OFERTA) VALUES ( ?, ?, ?)");
        listaOfertas = conexao.prepareStatement("SELECT * FROM OFERTA");
        listaPropostas = conexao.prepareStatement("SELECT * FROM PROPOSTA");
        efetuarLogin = conexao.prepareStatement("SELECT * FROM USUARIO WHERE NOME = ?");
    }
    
    public void criaOferta(Oferta oferta) throws Exception{
    criaOferta.setString(1, oferta.getTitulo());
    criaOferta.setString(2, oferta.getDescricao());
    criaOferta.setString(3, oferta.getOfertante());
    criaOferta.setString(4, oferta.getGrupo());
    
    criaOferta.executeUpdate();
    
    }
    
  public void criaProposta(Proposta proposta)throws Exception{
      criaProposta.setString(1, proposta.getOfertante());
      criaProposta.setString(2, proposta.getDesejo());
      criaProposta.setString(3, proposta.getOferta());
      
      criaProposta.executeUpdate();
  
  }
  
  public ResultSet listarOfertas()throws Exception{
  
  
  ResultSet consultaOferta = listaOfertas.executeQuery();
  
  return consultaOferta ;
  }
  
    public ResultSet listarProposta()throws Exception{
  
  
  ResultSet consultaProposta = listaPropostas.executeQuery();
  
  return consultaProposta ;
  }
    
  public ResultSet login (Usuario usuario)throws Exception{
  
  efetuarLogin.setString(1, usuario.getNome());    
  ResultSet login = efetuarLogin.executeQuery();
  
      return login;
  }
  
    
    
}
