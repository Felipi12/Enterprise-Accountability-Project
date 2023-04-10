/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample_Company;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;


public abstract class Funcionario {
    private String nome;
    private Cargo cargo;
    private LocalDate periodoContratacao;

    public Funcionario(String nome, Cargo cargo, LocalDate periodoContratacao) {
        this.nome = nome;
        this.cargo = cargo;
        this.periodoContratacao = periodoContratacao;
    }

    public abstract double getSalario(LocalDate mesEano );
    public abstract double getSoSalario(LocalDate mesEano );
    public abstract double getSoBeneficio(LocalDate mesEano);

    public String getNome() {
        return nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public LocalDate getPeriodoContratacao() {
        return periodoContratacao;
    }
    
    public int getAnosServico() {
        return (int) ChronoUnit.YEARS.between(periodoContratacao, LocalDate.now());
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + ", Cargo: " + cargo + ", Período de Contratação: " + periodoContratacao;
    }
}

