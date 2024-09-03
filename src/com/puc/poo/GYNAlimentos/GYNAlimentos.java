package com.puc.poo.GYNAlimentos;

public class GYNAlimentos {

    public static void main(String[] args) {
        try {
            ListaFuncionarios listaFuncionarios = new ListaFuncionarios();
            listaFuncionarios.AdicionarFuncionarios("F001", "Joao Silva", 2, 2500.0F, 150);
            listaFuncionarios.AdicionarFuncionarios("F002", "Maria Oliveira", 1, 3200.0F, 1500);
            listaFuncionarios.AdicionarFuncionarios("F003", "Carlos Pereira", 3, 2800.0F, 2400);

            ImpressaoDeFuncionarios impressaoDeFuncionarios = new ImpressaoDeFuncionarios(listaFuncionarios);
            impressaoDeFuncionarios.exibirDadosFuncionario("F003");

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar funcionário: " + e.getMessage());
        }

    }
}