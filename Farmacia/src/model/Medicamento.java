/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.JOptionPane;

/**
 *
 * @author Luís Gustavo
 */
public class Medicamento {
    private String codigoBarra;
    private String nome;
    private String laboratorio;
    private String localizacao;
    private double valorUnitario;
    private String composicao;
    private int quantidadeEstoque;
    private String tipo;

    public Medicamento() {
    }

    public Medicamento(String codigoBarra, String nome, String laboratorio, String localizacao, double valorUnitario, String composicao, int quantidadeEstoque, String tipo) {
        this.codigoBarra = codigoBarra;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.localizacao = localizacao;
        this.valorUnitario = valorUnitario;
        this.composicao = composicao;
        this.quantidadeEstoque = quantidadeEstoque;
        this.tipo = tipo;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getComposicao() {
        return composicao;
    }

    public void setComposicao(String composicao) {
        this.composicao = composicao;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public boolean locar(int qt){
        boolean retorno = false;
        if(qt > quantidadeEstoque){
            JOptionPane.showMessageDialog(null, "Não existe estoque suficiente!", "Falta de Estoque", JOptionPane.WARNING_MESSAGE);
        }
        if(qt == 0){
            JOptionPane.showMessageDialog(null, "A quantidade informada não pode ser 0", "Valor Nulo", JOptionPane.WARNING_MESSAGE);
        }
        if((qt <= quantidadeEstoque) && (qt != 0)){
            quantidadeEstoque = quantidadeEstoque - qt;
            retorno =  true;
        }
        return retorno;
    }
    
    public double calcularValorTotalVenda(int qt){
        return qt * valorUnitario;
    }
    
    public boolean validaMedicamento(){
        return !codigoBarra.equals("") &&
               !nome.equals("") &&
               !laboratorio.equals("") &&
               !localizacao.equals("") &&
               valorUnitario > 0 &&
               !composicao.equals("") &&
               quantidadeEstoque > 0 &&
               !tipo.equals("");
    }
    
    @Override
    public String toString(){
        return "Código de barra: " + codigoBarra +
               "\nNome: " + nome +
               "\nLaboratório: " + laboratorio +
               "\nLocalização: " + localizacao +
               "\nValor Unitário: " + valorUnitario +
               "\nComposição: " + composicao +
               "\nQuantidade em Estoque: " + quantidadeEstoque +
               "\nTipo: " + tipo;
    }
}
