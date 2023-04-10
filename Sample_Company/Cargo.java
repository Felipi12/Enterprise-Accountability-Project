package Sample_Company;

public enum Cargo {
    SECRETARIO(7000, 1000, 0.2),
    VENDEDOR(12000, 1800, 0.3),
    GERENTE(20000, 3000, 0);

    private final double salarioBase;
    private final double beneficio;
    private final double comissao;

    Cargo(double salarioBase, double beneficio, double comissao) {
        this.salarioBase = salarioBase;
        this.beneficio = beneficio;
        this.comissao = comissao;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getBeneficio(Funcionario funcionario) {
        return beneficio + (funcionario.getAnosServico() * 1000);
    }

    public double getComissao() {
        return comissao;
    }
}