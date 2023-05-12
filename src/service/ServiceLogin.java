/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import controller.ControlePrincipal;
import javax.swing.JOptionPane;
import model.Pessoa;
import model.PessoaDAO;
import view.TelaLogin;

/**
 *
 * @author kayom
 */
public class ServiceLogin {
    private final TelaLogin telaLogin;
    private final PessoaDAO pessoaDAO;
    
    public ServiceLogin(TelaLogin tela) {
        this.telaLogin = tela;
        this.pessoaDAO = new PessoaDAO();
    }
    
    public void login() { //validação de acesso
        Pessoa pessoaLogin = pessoaDAO.acesso(
                telaLogin.getjTextFieldUsuario().getText(), 
                telaLogin.getjPasswordFieldSenha().getText());
        if(pessoaLogin.getId() > 0){
            telaLogin.dispose();
            ControlePrincipal controlePrincipal = new ControlePrincipal();
        } else{
            JOptionPane.showMessageDialog(telaLogin, "Acesso Negado", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
