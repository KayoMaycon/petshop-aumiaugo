/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.TelaCadastroProduto;
import view.TelaListagemProduto;
import service.ServiceProduto;
import view.TelaPrincipal;

/**
 *
 * @author kayom
 */
public class ControleProduto implements ActionListener, KeyListener{
   private final TelaCadastroProduto telaCadastroProduto;
    private final TelaListagemProduto telaListagemProduto;
    private final ServiceProduto serviceProduto;

    public ControleProduto(TelaPrincipal telaPrincipal) {

        // instancia as telas
        this.telaCadastroProduto = new TelaCadastroProduto(telaPrincipal, true);
        this.telaListagemProduto = new TelaListagemProduto(telaPrincipal, true);
        //instancia a classe regra de negocio
        this.serviceProduto = new ServiceProduto(telaListagemProduto, telaCadastroProduto);
        // adiciona os eventos
        addListernersTelaListagem();
        addListernersTelaCadastro();
        //solicita a listagem
        this.serviceProduto.listar();
        // exibe a tela de listagem
        this.telaListagemProduto.setVisible(true);   
        //this.telaCadastroProduto.setVisible(true);
    }
   
   
    public void actionPerformed(ActionEvent ae) {
       
        // Eventos da tela de listagem
        if(ae.getSource().equals(this.telaListagemProduto.getjButtonNovo())){
            this.serviceProduto.novo();
        }
       
        if(ae.getSource().equals(this.telaListagemProduto.getjButtonPesquisar())){
            this.serviceProduto.pesquisar();
        }
       
        if(ae.getSource().equals(this.telaListagemProduto.getjButtonExcluir())){
            this.serviceProduto.excluir();
        }
       
       
        if(ae.getSource().equals(this.telaListagemProduto.getjButtonEditar())){
            this.serviceProduto.editar();
        }

       
        // Eventos da tela de cadastro
        if(ae.getSource().equals(this.telaCadastroProduto.getjButtonFechar())){
            this.serviceProduto.fechar();
        }
       
        if(ae.getSource().equals(this.telaCadastroProduto.getjButtonLimpar())){
            this.serviceProduto.limpar();
        }
       
        if(ae.getSource().equals(this.telaCadastroProduto.getjButtonSalvar())){
            this.serviceProduto.salvar();
        }
       
       
    }

    // eventos da tela de listagem
    private void addListernersTelaListagem() {
        this.telaListagemProduto.getjButtonEditar().addActionListener((ActionListener) this);
        this.telaListagemProduto.getjButtonNovo().addActionListener((ActionListener) this);
        this.telaListagemProduto.getjButtonExcluir().addActionListener((ActionListener) this);
        this.telaListagemProduto.getjButtonPesquisar().addActionListener((ActionListener) this);
       
        this.telaListagemProduto.getjTextFieldPesquisa().addKeyListener((KeyListener) this);
    }

    // eventos da tela de cadastro
    private void addListernersTelaCadastro() {
        this.telaCadastroProduto.getjButtonFechar().addActionListener((ActionListener) this); //estava sem o ActionListener antes do this
        this.telaCadastroProduto.getjButtonLimpar().addActionListener((ActionListener) this);
        this.telaCadastroProduto.getjButtonSalvar().addActionListener((ActionListener) this);    
    }

    public void keyTyped(KeyEvent ke) {
    }

    public void keyPressed(KeyEvent ke) {
    }

    public void keyReleased(KeyEvent ke) {
       
        if(ke.getSource().equals(telaListagemProduto.getjTextFieldPesquisa())){
            this.serviceProduto.pesquisar();
        }
       
    }
}
