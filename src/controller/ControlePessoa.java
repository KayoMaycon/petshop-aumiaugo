/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import service.ServicePessoa;
import view.TelaCadastroPessoa;
import view.TelaLogin;
import view.TelaPrincipal;

/**
 *
 * @author kayom
 */
public class ControlePessoa implements ActionListener, KeyListener{
private TelaCadastroPessoa telaPessoa;
    private ServicePessoa servicePessoa;
    
    public ControlePessoa(TelaLogin telaLogin){
        telaPessoa = new TelaCadastroPessoa(null, true);
        servicePessoa = new ServicePessoa(telaPessoa);
        // adiciona listeners para a tela de cadastro
        telaPessoa.getjButtonLimpar().addActionListener(this);
        telaPessoa.getjButtonVoltar().addActionListener(this);
        telaPessoa.getjButtonSalvar().addActionListener(this);
        telaPessoa.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        // evento do botão limpar
        if(evento.getSource().equals(telaPessoa.getjButtonLimpar())){
            servicePessoa.limpar();
        }
        // evento do botão voltar
        if(evento.getSource().equals(telaPessoa.getjButtonVoltar())){
            servicePessoa.voltar();
        }
        // evento do botão cadastrar
        else if(evento.getSource().equals(telaPessoa.getjButtonSalvar())){
            servicePessoa.salvar();


        }

        
    }

    

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
