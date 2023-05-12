/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;
import model.ProdutoDAO;
import view.TelaCadastroProduto;
import view.TelaListagemProduto;
import view.TelaPrincipal;

/**
 *
 * @author kayom
 */
public class ServiceProduto {
    private TelaListagemProduto telaListagemProduto;
    private TelaCadastroProduto telaCadastroProduto;
    private ProdutoDAO produtoDAO;
    private boolean novo;
    private int id;

    public ServiceProduto(TelaListagemProduto telaListagemProduto, TelaCadastroProduto telaCadastroProduto) {
        this.telaListagemProduto = telaListagemProduto;
        this.telaCadastroProduto = telaCadastroProduto;
        this.produtoDAO = new ProdutoDAO();
        this.id = 0;
    }

    public void listar() {
        listaDados(produtoDAO.listar());
    }
   
    private void listaDados(ArrayList<Produto> listaProdutos) {    
        telaListagemProduto.limpaTabela();
        for(int i=0;i<listaProdutos.size();i++){
            telaListagemProduto.adicionaItem
                           (listaProdutos.get(i).getId(),
                           listaProdutos.get(i).getDescricao(),
                           listaProdutos.get(i).getPreco());
        }      
     
    }

    public void pesquisar() {
        listaDados(produtoDAO.pesquisar(telaListagemProduto.getjTextFieldPesquisa().getText()));
    }
   
    public void excluir(){
        int item = telaListagemProduto.getjTableListaProdutos().getSelectedRow();
        if(item >= 0){
            if(JOptionPane.showConfirmDialog(telaListagemProduto, "Deseja realmente excluir?", "Confirmação de exclusão",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0){
                Produto produto = new Produto();
                produto.setId((int)telaListagemProduto.getModel().getValueAt(item, 0));
                if(produtoDAO.excluir(produto)){
                    telaListagemProduto.getModel().removeRow(item);                
                }
            }
        } else{
            JOptionPane.showMessageDialog(telaListagemProduto, "Selecione um item");
        }
    }
   
    public void novo(){
        this.novo = true;
        telaListagemProduto.setVisible(false);
        telaCadastroProduto.limpar();
        telaCadastroProduto.setVisible(true);        
    }
   
    public void salvar(){      
   
        if(validaCampos()){
            Produto p = new Produto();
           
            p.setDescricao(this.telaCadastroProduto.getjTextFieldDescricao().getText());
            p.setPreco(Float.parseFloat(this.telaCadastroProduto.getjTextFieldPreco().getText()));
           
           
            if(this.novo){
                produtoDAO.inserir(p);
            } else{
                produtoDAO.alterar(p);
            }

            this.listar();
            telaCadastroProduto.setVisible(false);
            telaListagemProduto.setVisible(true);
               
        }else{
            JOptionPane.showMessageDialog(telaCadastroProduto, "Preencha todos os campos!","Erro",JOptionPane.ERROR_MESSAGE);
        }
    }
   
    private boolean validaCampos() {
        if(this.telaCadastroProduto.getjTextFieldDescricao().getText().equals("")){
            return false;
        }
        else if(this.telaCadastroProduto.getjTextFieldPreco().getText().equals("")){
            return false;
        }
        else{
            return true;
        }
    }

    public void fechar() {
        telaCadastroProduto.setVisible(false);
        telaListagemProduto.setVisible(true);
    }
   
    public void limpar() {
        telaCadastroProduto.limpar();
    }
   
    public void editar(){
        int item = telaListagemProduto.getjTableListaProdutos().getSelectedRow();
        if(item>=0){
            this.id = (int)telaListagemProduto.getModel().getValueAt(item, 0);
            Produto p = produtoDAO.pesquisar(this.id);
            telaCadastroProduto.limpar();
            telaCadastroProduto.getjTextFieldDescricao().setText(p.getDescricao());
            telaCadastroProduto.getjTextFieldPreco().setText(String.valueOf(p.getPreco()));
            this.novo = false;
            telaListagemProduto.setVisible(false);
            telaCadastroProduto.setVisible(true);
        } else{
            JOptionPane.showMessageDialog(telaListagemProduto, "Selecione um item");
        }
    }
    


}
