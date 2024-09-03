package com.puc.poo.GYNAlimentos;


import com.puc.poo.GYNAlimentos.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class ListaFuncionarios {
    private List<Funcionario> funcionariosList;

    public ListaFuncionarios() {
        this.funcionariosList = new ArrayList<>();
    }


    public void AdicionarFuncionarios(String matricula, String nome, int dependentes, float salarioBase, int itensProduzidos) {
        this.funcionariosList.add(new Funcionario(matricula, nome, dependentes, salarioBase, itensProduzidos));
    }

    public List<Funcionario> getFuncionariosList() {
        return funcionariosList;
    }
}