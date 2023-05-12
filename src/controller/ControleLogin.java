/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import service.ServiceLogin;
import view.TelaLogin;
import view.TelaPrincipal;

/**
 *
 * @author kayom
 */
public class ControleLogin implements ActionListener, KeyListener{
    private TelaLogin telaLogin;   
    private ServiceLogin serviceLogin;
    
    public ControleLogin(){
        telaLogin = new TelaLogin(null, true);
        serviceLogin = new ServiceLogin(telaLogin);
        telaLogin.getjButtonEntrar().addActionListener(this);
        telaLogin.getjTextFieldUsuario().addKeyListener(this);
        telaLogin.getjPasswordFieldSenha().addKeyListener(this);
        telaLogin.getjButtonCadastrar().addActionListener(this);
        telaLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource().equals(telaLogin.getjButtonEntrar())){
            serviceLogin.login();
        }
        
        else if(ae.getSource().equals(telaLogin.getjButtonCadastrar())){
            ControlePessoa controlePessoa = new ControlePessoa(telaLogin);
        } 
        
    }
    

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
//        if(ke.getSource().equals(telaLogin.getjTextFieldUsuario()) ||
//                ke.getSource().equals(telaLogin.getjPasswordFieldSenha())){
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                serviceLogin.login();
            }
        //}
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        
    }

}
