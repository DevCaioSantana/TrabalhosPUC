package com.puc.poo.GYNAlimentos;

import java.util.ArrayList;
import java.util.List;

public class CalculosDoFuncionario {
    private ListaFuncionarios listaFuncionarios;

    // Construtor que recebe a instância de ListaFuncionarios
    public CalculosDoFuncionario(ListaFuncionarios listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
    }

    public Float Gratificacao(String matricula) {
        List<Funcionario> funcionariosList = listaFuncionarios.getFuncionariosList();
        for (Funcionario f : funcionariosList) {
            if (f.getMatricula().equalsIgnoreCase(matricula)) {
                if (f.getItensProduzidos() <= 1000.00f) return 500.00f;
                if (f.getItensProduzidos() <= 2000.00f) return 1250.00f;
                return 2250.00f;
            }
        }

        return null;
    }

    public Float SalarioBruto(String matricula) {
        List<Funcionario> funcionariosList = listaFuncionarios.getFuncionariosList();
        for (Funcionario f : funcionariosList) {
            if (f.getMatricula().equalsIgnoreCase(matricula)) {
                Float gratificacao = Gratificacao(matricula);
                if (gratificacao != null) return f.getSalarioBase() + gratificacao;

            }
        }
        return null;
    }

    public Float INSS(String matricula) {
        List<Funcionario> funcionariosList = listaFuncionarios.getFuncionariosList();
        for (Funcionario f : funcionariosList) {
            if (f.getMatricula().equalsIgnoreCase(matricula)) {
                Float inss = SalarioBruto(matricula);
                if (inss <= 1412.00f) return inss * 0.075f;
                if (inss <= 2666.68) return inss * 0.09f;
                if (inss <= 4000.03) return inss * 0.12f;
                return inss * 0.14f;
            }
        }
        return null;
    }

    public Float IRPF(String matricula) {
        List<Funcionario> funcionariosList = listaFuncionarios.getFuncionariosList();
        for (Funcionario f : funcionariosList) {
            if (f.getMatricula().equalsIgnoreCase(matricula)) {
                Float irpf = SalarioBruto(matricula);
                if (irpf <= 2259.20f) return 0f;
                if (irpf <= 2826.65f) return irpf * 0.075f;
                if (irpf <= 3751.05f) return irpf * 0.15f;
                if (irpf <= 4664.68f) return irpf * 0.225f;
                return irpf * 0.275f;
            }
        }
        return null;
    }


    public Float DescontoFilhos(String matricula) {
        List<Funcionario> funcionariosList = listaFuncionarios.getFuncionariosList();
        for (Funcionario f : funcionariosList) {
            if (f.getMatricula().equalsIgnoreCase(matricula)) {

                if(f.getDependentes() != 0 && SalarioBruto(matricula) > 2259.20f){
                    float descontoFilhos = 123.00f;
                    return descontoFilhos * f.getDependentes();
                }

            }
        }
        return 0f;
    }
    public Float SalarioLiquido(String matricula){
        List<Funcionario> funcionariosList = listaFuncionarios.getFuncionariosList();
        for (Funcionario f : funcionariosList) {
            if (f.getMatricula().equalsIgnoreCase(matricula)) return SalarioBruto(matricula) + DescontoFilhos(matricula) - IRPF(matricula) - INSS(matricula);

        }
        return null;
    }
    }






