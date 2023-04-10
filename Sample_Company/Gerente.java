package Sample_Company;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;


public class Gerente extends Funcionario {

    private static final double SALARIO_BASE = 20000.0;
    private static final double BENEFICIO_POR_ANO = 3000.0;

    private Map<LocalDate, Double> vendas = new HashMap<>();

    public Gerente(String nome, LocalDate periodoContratacao) {
        super(nome, Cargo.VENDEDOR, periodoContratacao);
    }

    public void setVendas(Map<LocalDate, Double> vendas) {
        this.vendas = vendas;
    }

    @Override
    public double getSalario(LocalDate mesEano) {
        int anosContratacao = Period.between(getPeriodoContratacao(), LocalDate.now()).getYears();
        return SALARIO_BASE + (anosContratacao * BENEFICIO_POR_ANO);
    }
    
    @Override
    public double getSoSalario(LocalDate mesEano ) {
        return getSalario(mesEano);
    }
    
    @Override
    public double getSoBeneficio(LocalDate mesEano ) {
        return 0;
    }
}
