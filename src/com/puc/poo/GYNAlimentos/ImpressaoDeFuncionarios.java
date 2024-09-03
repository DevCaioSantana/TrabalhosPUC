package com.puc.poo.GYNAlimentos;

import javax.swing.*;
import java.util.List;

public class ImpressaoDeFuncionarios {
    private ListaFuncionarios listaFuncionarios;
    private CalculosDoFuncionario calculosDoFuncionario;

    public ImpressaoDeFuncionarios(ListaFuncionarios listaFuncionarios) {
        this.listaFuncionarios = listaFuncionarios;
        this.calculosDoFuncionario = new CalculosDoFuncionario(listaFuncionarios);
    }

    public void exibirDadosFuncionario(String matricula) {
        List<Funcionario> funcionariosList = listaFuncionarios.getFuncionariosList();

        for (Funcionario func : funcionariosList) {
            if (func.getMatricula().equals(matricula)) {

                float gratificacao = calculosDoFuncionario.Gratificacao(matricula);
                float salarioBruto = calculosDoFuncionario.SalarioBruto(matricula);
                float descontoINSS = calculosDoFuncionario.INSS(matricula);
                float descontoIRPF = calculosDoFuncionario.IRPF(matricula);
                float descontoFilhos = calculosDoFuncionario.DescontoFilhos(matricula);
                float salarioLiquido = calculosDoFuncionario.SalarioLiquido(matricula);


                String mensagem = String.format(
                        "Matrícula do funcionário: %s\n" +
                                "Nome do funcionário: %s\n" +
                                "Número de dependentes: %d\n" +
                                "Salário base: %.2f\n" +
                                "Valor da gratificação: %.2f\n" +
                                "Salário bruto: %.2f\n" +
                                "Valor do desconto do INSS: %.2f\n" +
                                "Valor do desconto do IRPF: %.2f\n" +
                                "Valor do desconto dos filhos: %.2f\n" +
                                "Salário Líquido: %.2f",
                        func.getMatricula(), func.getNome(), func.getDependentes(),
                        func.getSalarioBase(), gratificacao, salarioBruto, descontoINSS,
                        descontoIRPF, descontoFilhos, salarioLiquido
                );


                JOptionPane.showMessageDialog(null, mensagem, "Contracheque do Funcionário "+func.getNome(), JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Funcionário com matrícula " + matricula + " não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    public void exibirFuncionarios() {
        List<Funcionario> funcionariosList = listaFuncionarios.getFuncionariosList();
        System.err.println("Seus funcionarios sao : ");
        for (Funcionario f : funcionariosList) {
            System.out.println(" Matricula: " + f.getMatricula() + "| Nome: " + f.getNome() + "| Dependentes: " + f.getDependentes() + "| SalarioBase : " + f.getSalarioBase() + "| Itens Produzidos :" + f.getItensProduzidos());
        }
    }
}
