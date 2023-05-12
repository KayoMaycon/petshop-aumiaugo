/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.TelaLogin;
import view.TelaPrincipal;
import view.TelaCadastroProduto;

/**
 *
 * @author kayom
 */
public class ControlePrincipal implements ActionListener{
    private TelaPrincipal telaPrincipal;
    private TelaLogin telaLogin;
    private TelaCadastroProduto telaCadastroProduto;

    public ControlePrincipal() {
        telaPrincipal = new TelaPrincipal();
        telaPrincipal.getjMenuItemPessoa().addActionListener(this);
        telaPrincipal.getjMenuItemProduto().addActionListener(this);
        telaPrincipal.getjMenuItemSistema().addActionListener(this);
        telaPrincipal.getjMenuItemEmpresa().addActionListener(this);
        telaPrincipal.getjButtonSair().addActionListener(this);
        telaPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource().equals(telaPrincipal.getjMenuItemPessoa())){
            ControlePessoa controlePessoa = new ControlePessoa(telaLogin);
            
        } else if(ae.getSource().equals(telaPrincipal.getjMenuItemProduto())){
            ControleProduto controleProduto = new ControleProduto(telaPrincipal);
            
    
        }
        
        else if(ae.getSource().equals(telaPrincipal.getjMenuItemSistema())){
            JOptionPane.showMessageDialog(telaPrincipal, "Sistema elaborado com o intuito de permitir que o PetShop Aumiaugo consiga realizar o controle de atividades referentes aos serviços prestados.", 
                    "Sobre o Sistema", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(ae.getSource().equals(telaPrincipal.getjMenuItemEmpresa())){
            JOptionPane.showMessageDialog(telaPrincipal, "Aumiaugo Corporation© - Fundadores: Larissa Miranda, Kayo Maycon, Uenderson Carvalho e Ana Esttefane", 
                    "Sobre a Empresa", JOptionPane.INFORMATION_MESSAGE);
        } else if (ae.getSource().equals(telaPrincipal.getjButtonSair())){
            telaPrincipal.setVisible(false);
        }
    }
}
