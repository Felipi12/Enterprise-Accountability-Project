package Sample_Company;

import java.time.LocalDate;
import java.time.Period;

public class Secretario extends Funcionario {
    private static final double SALARIO_BASE = 7000.0;
    private static final double BENEFICIO_POR_ANO = 1000.0;
    private static final double PERCENTUAL_BENEFICIO = 0.2;

    public Secretario(String nome, LocalDate periodoContratacao) {
        super(nome, Cargo.SECRETARIO, periodoContratacao);
    }

    @Override
    public double getSalario(LocalDate mesEano ) {
        int anosContratacao = Period.between(getPeriodoContratacao(), LocalDate.now()).getYears();
        double salario = SALARIO_BASE + (anosContratacao * BENEFICIO_POR_ANO);
        return salario + (salario * PERCENTUAL_BENEFICIO);
    }
    
    @Override
    public double getSoSalario(LocalDate mesEano ) {
        int anosContratacao = Period.between(getPeriodoContratacao(), mesEano).getYears();
        return SALARIO_BASE + (anosContratacao * BENEFICIO_POR_ANO);
    }
    
    @Override
    public double getSoBeneficio(LocalDate mesEano ) {
        int anosContratacao = Period.between(getPeriodoContratacao(), mesEano).getYears();
        return (getSoSalario(mesEano) * PERCENTUAL_BENEFICIO);
    }
}