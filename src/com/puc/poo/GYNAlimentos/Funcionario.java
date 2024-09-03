package com.puc.poo.GYNAlimentos;

public class Funcionario {
    private String matricula;
    private String nome;
    private int dependentes;
    private float salarioBase;
    private int itensProduzidos;

    public Funcionario(String matricula, String nome, int dependentes, float salarioBase, int itensProduzidos) {
        if (matricula == null || matricula.isEmpty()) {
            throw new IllegalArgumentException("Matrícula não pode ser nula ou vazia.");
        }
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        if (dependentes < 0) {
            throw new IllegalArgumentException("Número de dependentes não pode ser negativo.");
        }
        if (salarioBase <= 0) {
            throw new IllegalArgumentException("Salário base deve ser maior que zero.");
        }
        if (itensProduzidos < 0) {
            throw new IllegalArgumentException("Número de itens produzidos não pode ser negativo.");
        }

        this.matricula = matricula;
        this.nome = nome;
        this.dependentes = dependentes;
        this.salarioBase = salarioBase;
        this.itensProduzidos = itensProduzidos;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public int getDependentes() {
        return this.dependentes;
    }

    public float getSalarioBase() {
        return this.salarioBase;
    }

    public int getItensProduzidos() {
        return this.itensProduzidos;
    }
}
