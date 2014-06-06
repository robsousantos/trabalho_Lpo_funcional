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
     private static PreparedStatement propostasPorUsuario;
     private static PreparedStatement efetuarLogin;
    private static PreparedStatement atualizaproposta;
    private static PreparedStatement listaNegociados;
     
    
     
     
    
    public Mercado() throws Exception {
        conexao = Conexao.getConexao();
        
        criaOferta = conexao.prepareStatement("INSERT INTO MERCADO (TITULO_OFERTA, DESCRICAO,USUARIO_OFERTA,GRUPO) VALUES ( ?, ?, ? ,?)");
        criaProposta = conexao.prepareStatement("UPDATE MERCADO SET USUARIO_PROPOSTA = ?, DESEJO =?,PROPOSTA=?, GRUPO= ? WHERE ID = ?");
        listaOfertas = conexao.prepareStatement("SELECT * FROM MERCADO WHERE GRUPO = 'Ofertas' ");
        listaPropostas = conexao.prepareStatement("SELECT * FROM MERCADO WHERE GRUPO = 'Proposta' ");
        propostasPorUsuario = conexao.prepareStatement("SELECT * FROM MERCADO WHERE GRUPO = 'Proposta' and USUARIO_OFERTA = ?");
        efetuarLogin = conexao.prepareStatement("SELECT * FROM USUARIO WHERE NOME = ?");
        atualizaproposta = conexao.prepareStatement("UPDATE MERCADO SET GRUPO=? WHERE ID=?");
        listaNegociados = conexao.prepareStatement("SELECT * FROM MERCADO WHERE GRUPO = 'Negociado' ");
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
       criaProposta.setString(4, proposta.getStatus());
       
       criaProposta.setInt(5, Integer.parseInt(proposta.getDesejo()));
       
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
    
      public ResultSet PropostasPorUsuario(String proposta)throws Exception{
  
   propostasPorUsuario.setString(1, proposta);
   propostasPorUsuario.executeQuery();
  ResultSet consultaProposta = propostasPorUsuario.executeQuery();
  
  return consultaProposta ;
  }
    
  public ResultSet login (Usuario usuario)throws Exception{
  
  efetuarLogin.setString(1, usuario.getNome());    
  ResultSet login = efetuarLogin.executeQuery();
  
      return login;
  }
  
  public void atualizaProposta(Proposta status) throws Exception{
  
     
      atualizaproposta.setString(1, status.getStatus());
       atualizaproposta.setInt(2, status.getId());
      atualizaproposta.executeUpdate();
      
      
  }
  
   public ResultSet ListaNegociados() throws Exception{
   
   ResultSet negociados = listaNegociados.executeQuery();
   
   return negociados;
   
   }
    
}
