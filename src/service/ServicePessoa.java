/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.PessoaDAO;
import view.TelaCadastroPessoa;

/**
 *
 * @author kayom
 */
public class ServicePessoa {
    private TelaCadastroPessoa telaCadastroPessoa;
    private PessoaDAO pessoaDAO;
    private boolean novo;
    private int id;
    
    public ServicePessoa(TelaCadastroPessoa telaPessoa) {
        this.telaCadastroPessoa = telaPessoa;
        this.pessoaDAO = new PessoaDAO();
        this.id = 0; // atributo que guarda o id para edição dos dados
        this.novo = true; // atributo que gerencia o estado do cadastro (se novo ou se edição)
    }
    
    // limpa os campos da tela de cadastro
    public void limpar() {
        telaCadastroPessoa.getjTextFieldNome().setText("");
        telaCadastroPessoa.getjFormattedTextFieldCpf().setText("");
        telaCadastroPessoa.getjFormattedTextFieldTelefone().setText("");
        telaCadastroPessoa.getjTextFieldUsuario().setText("");
        telaCadastroPessoa.getjPasswordFieldConfSenha().setText("");
        telaCadastroPessoa.getjPasswordFieldSenha().setText("");
    }
    
    // retorna da tela de cadastro para a tela de listagem
    public void voltar() {
        telaCadastroPessoa.setVisible(false);

    }
    
    public void salvar() {    

        if(validarCampos()){

            Pessoa pessoa = new Pessoa();
            pessoa.setNome(telaCadastroPessoa.getjTextFieldNome().getText());
            pessoa.setTelefone(telaCadastroPessoa.getjFormattedTextFieldTelefone().getText());
            pessoa.setCpf(telaCadastroPessoa.getjFormattedTextFieldCpf().getText());
            pessoa.setUsuario(telaCadastroPessoa.getjTextFieldUsuario().getText());
            pessoa.setSenha(telaCadastroPessoa.getjPasswordFieldSenha().getText());
            pessoa.setSenha(telaCadastroPessoa.getjPasswordFieldConfSenha().getText());
            
            if(novo){

                if(pessoaDAO.inserir(pessoa)){
                    JOptionPane.showMessageDialog(telaCadastroPessoa, "Cadastro realizado");
                } else{
                    JOptionPane.showMessageDialog(telaCadastroPessoa, "Cadastro não realizado", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else{

                pessoa.setId(id);

                if(pessoaDAO.alterar(pessoa)){
                    JOptionPane.showMessageDialog(telaCadastroPessoa, "Alteração realizada");
                } else{
                    JOptionPane.showMessageDialog(telaCadastroPessoa, "Alteração não realizada", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            telaCadastroPessoa.setVisible(false);
            
        } else{
            JOptionPane.showMessageDialog(telaCadastroPessoa, "Preencha todos os campos!","Erro",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    private boolean validarCampos() {
        if(this.telaCadastroPessoa.getjTextFieldNome().getText().equals("")){
            System.out.println("nome");
            return false;
        }
        else if(this.telaCadastroPessoa.getjFormattedTextFieldCpf().getValue()==null){
            System.out.println("cpf");
            return false;
        }
        else if(this.telaCadastroPessoa.getjFormattedTextFieldTelefone().getValue()==null){
            System.out.println("telefone");
            return false;
        }
        else if(this.telaCadastroPessoa.getjPasswordFieldSenha().getText().equals("")){
            System.out.println("senha");
            return false;
        }
     
        else if(this.telaCadastroPessoa.getjTextFieldUsuario().getText().equals("")){
            System.out.println("usuario");
            return false;
        }
        else{
            return true;
        }
    }

    public void novo() {
        this.novo = true;
        telaCadastroPessoa.setVisible(true); 
    }


}
