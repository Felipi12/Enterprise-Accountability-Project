/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sample_Company;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Vendedor extends Funcionario {
    private static final double SALARIO_BASE = 12000.0;
    private static final double BENEFICIO_POR_ANO = 1800.0;
    private static final double PERCENTUAL_BENEFICIO = 0.3;

    private double valorVendido;

    public Vendedor(String nome, LocalDate periodoContratacao) {
        super(nome, Cargo.VENDEDOR, periodoContratacao);
    }

    public void setValorVendido(double valorVendido) {
        this.valorVendido = valorVendido;
    }

    @Override
    public double getSalario(LocalDate mesEano ) {
        int anosContratacao = Period.between(getPeriodoContratacao(), mesEano).getYears();
        double salario = SALARIO_BASE + (anosContratacao * BENEFICIO_POR_ANO);
        return salario + (valorVendido * PERCENTUAL_BENEFICIO);
    }
    
    @Override
    public double getSoSalario(LocalDate mesEano) {
        int anosContratacao = Period.between(getPeriodoContratacao(), LocalDate.now()).getYears();
        return SALARIO_BASE + (anosContratacao * BENEFICIO_POR_ANO);
    }
    
    @Override
    public double getSoBeneficio(LocalDate mesEano ) {
        int anosContratacao = Period.between(getPeriodoContratacao(), mesEano).getYears();
        return (valorVendido * PERCENTUAL_BENEFICIO);
    }
}