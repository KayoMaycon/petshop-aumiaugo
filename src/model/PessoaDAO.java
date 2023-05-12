/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author kayom
 */
public class PessoaDAO {
    public boolean inserir(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome,telefone,cpf, senha, usuario, sexo) values (?,?,?, ?, ?, ?)";
           
        try {
            PreparedStatement pst;
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getTelefone());
            pst.setString(3, pessoa.getCpf());
            pst.setString(4, pessoa.getSenha());
            pst.setString(5, pessoa.getUsuario());
            pst.setString(6, pessoa.getSexo());
            pst.execute();   
            pst.close();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        
    }


 
    public boolean excluir(int id) {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        
        PreparedStatement pst;
        
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            pst.close();                
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        
        return true;
    }
    
    public boolean alterar(Pessoa pessoa){
        
        String sql = "UPDATE pessoa SET nome = ? , cpf = ?, telefone = ?, senha = ?, usuario = ?, sexo = ? WHERE id = ?";
        
        PreparedStatement pst;
        try {
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, pessoa.getNome());
            pst.setString(2, pessoa.getCpf());
            pst.setString(3, pessoa.getTelefone());
            pst.setString(4, pessoa.getSenha());
            pst.setString(5, pessoa.getUsuario());
            pst.setString(6, pessoa.getSexo());
            pst.setInt(7, pessoa.getId());
            pst.execute();
            pst.close();        
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
                      
        
    }
    
        public Pessoa acesso(String usuario, String senha) {
        
        String sql = "SELECT * FROM pessoa WHERE usuario = ? AND senha = ?";
        Pessoa pessoa = new Pessoa();           
            
        try {
            PreparedStatement pst;
            ResultSet rs;
            pst = Conexao.getConexao().prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, senha);
            rs = pst.executeQuery();
            while(rs.next()){
                pessoa.setId(rs.getInt("id"));
                pessoa.setUsuario(rs.getString("usuario"));
                pessoa.setSenha(rs.getString("senha"));
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco de dados!");
            System.out.println(ex);
        }
        
        return pessoa;
        
    }
}
