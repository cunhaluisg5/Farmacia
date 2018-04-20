/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Medicamento;

/**
 *
 * @author Luís Gustavo
 */
public class MedicamentoDao {
    private List<Medicamento> lista = null;

    public MedicamentoDao() {
        lista = new ArrayList<Medicamento>();
    }
    
    public void adicionaMedicamento(Medicamento medicamento){
        lista.add(medicamento);
    }
    
    public Medicamento buscaMedicamento(String cod, String nome){
        Medicamento med = null;
        for(int i = 0; i < lista.size(); i++){
            if((cod.equals(lista.get(i).getCodigoBarra())) || (nome.equals(lista.get(i).getNome()))){
                med = lista.get(i);
            }
        }
        return med;
    }
    
    public void removeMedicamento(String cod, String nome){
        Medicamento med = buscaMedicamento(cod, nome);
        if(med != null){
            lista.remove(med);
        }
    }
    
    public void alteraMedicamento(Medicamento medicamento){
        Medicamento med = buscaMedicamento(medicamento.getCodigoBarra(), medicamento.getNome());
        if(med != null){
            int idx = lista.indexOf(med);
            lista.set(idx, medicamento);
        }
    }
    
    public List<Medicamento> todosMedicamentos(){
        return lista;
    }
}
