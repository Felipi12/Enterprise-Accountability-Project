package Sample_Company;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Vendedor> vendedores = new ArrayList<>();
        RegistroVendas registroVendas = new RegistroVendas();

        // Criação dos funcionários
        Secretario jorge = new Secretario("Jorge Carvalho", LocalDate.of(2018, Month.JANUARY, 1));
        Secretario maria = new Secretario("Maria Souza", LocalDate.of(2015, Month.DECEMBER, 1));
        Vendedor ana = new Vendedor("Ana Silva", LocalDate.of(2021, Month.DECEMBER, 1));
        Vendedor joao = new Vendedor("João Mendes", LocalDate.of(2021, Month.DECEMBER, 1));
        Gerente juliana = new Gerente("Juliana Alves", LocalDate.of(2017, Month.JULY, 1));
        Gerente bento = new Gerente("Bento Albino", LocalDate.of(2014, Month.MARCH, 1));

        // Adição dos funcionários na lista
        funcionarios.add(jorge);
        funcionarios.add(maria);
        funcionarios.add(ana);
        funcionarios.add(joao);
        funcionarios.add(juliana);
        funcionarios.add(bento);

        // Adição dos vendedores na lista
        vendedores.add(ana);
        vendedores.add(joao);

        // Adição das vendas no registro de vendas
        registroVendas.adicionarVendas(ana, "12/2021", 5200);
        registroVendas.adicionarVendas(ana, "01/2022", 4000);
        registroVendas.adicionarVendas(ana, "02/2022", 4200);
        registroVendas.adicionarVendas(ana, "03/2022", 5850);
        registroVendas.adicionarVendas(ana, "04/2022", 7000);

        registroVendas.adicionarVendas(joao, "12/2021", 3400);
        registroVendas.adicionarVendas(joao, "01/2022", 7700);
        registroVendas.adicionarVendas(joao, "02/2022", 5000);
        registroVendas.adicionarVendas(joao, "03/2022", 5900);
        registroVendas.adicionarVendas(joao, "04/2022", 6500);
        
        
        System.out.println("O valor total pago foi de "+ valorTotalPago(funcionarios, LocalDate.now()));
        
        System.out.println("O valor total pago apenas de salário foi de "+ valorSalarioPago(funcionarios, LocalDate.now()));
        
        System.out.println("O valor total pago apenas de benefício foi de "+ valorBeneficioPago(funcionariosComBeneficio( funcionarios, LocalDate.now()), LocalDate.now()));
        
        System.out.println("O funcionário de maior pagamento foi "+ encontrarFuncionarioComMaiorPagamento(funcionarios, LocalDate.now()));
        
        System.out.println("O funcionário de maior pagamento de benefícios foi "+ encontrarFuncionarioComMaiorBeneficio(funcionariosComBeneficio( funcionarios, LocalDate.now()), LocalDate.now()));
    
        System.out.println("O funcionário que mais vendeu foi "+ getMelhorVendedor(vendedores, LocalDate.now(),registroVendas));
    }
    
     // Método que retorna o valor total pago (salário e benefício) a esses funcionários no mês
        public static double valorTotalPago(List<Funcionario> funcionarios, LocalDate mesEano) {
            double totalPago = 0;
            for (Funcionario f : funcionarios) {
                if (f.getSalario(mesEano) != 0) {
                    totalPago += f.getSalario(mesEano);
                }
            }
            return totalPago;
        }
        
        // Método que recebe uma lista de funcionários, mês e ano e retorna o total pago somente em salários no mês.
        public static double valorSalarioPago(List<Funcionario> funcionarios, LocalDate mesEano) {
            double totalPago = 0;
            for (Funcionario f : funcionarios) {
                if (f.getSoSalario( mesEano ) != 0) {
                    totalPago += f.getSoSalario(mesEano);
                }
            }
            return totalPago;
        }
        
        // Método que recebe uma lista somente com os funcionários que recebem benefícios, mês e ano e retorna o total pago em benefícios no mês.
        public static double valorBeneficioPago(List<Funcionario> funcionarios, LocalDate mesEano) {
            double totalPago = 0;
            for (Funcionario f : funcionarios) {
                if (f.getSoSalario(mesEano) != f.getSalario(mesEano)) {
                    totalPago += f.getSoBeneficio(mesEano);
                }
            }
            return totalPago;
        }
        
        // Método que recebe uma lista de funcionários, mês e ano e retorna o que recebeu o valor mais alto no mês.
        public static Funcionario encontrarFuncionarioComMaiorPagamento(List<Funcionario> funcionarios, LocalDate mesEano) {
            Funcionario funcionarioComMaiorPagamento = null;
            double maiorPagamento = 0;
            for (Funcionario funcionario : funcionarios) {
                double pagamento = funcionario.getSalario(mesEano);
                if (pagamento > maiorPagamento) {
                    maiorPagamento = pagamento;
                    funcionarioComMaiorPagamento = funcionario;
                }
            }
            return funcionarioComMaiorPagamento;
        }
        
        // Método que recebe uma lista somente com os funcionários que recebem benefícios, mês e ano e retorna o nome do funcionário que recebeu o valor mais alto em benefícios no mês.
        public static Funcionario encontrarFuncionarioComMaiorBeneficio(List<Funcionario> funcionarios, LocalDate mesEano) {
                Funcionario funcionarioComMaiorBeneficio = null;
                double maiorBeneficio = 0;
                for (Funcionario funcionario : funcionarios) {
                double beneficio = funcionario.getSoBeneficio(mesEano);
                if (beneficio > maiorBeneficio) {
                    maiorBeneficio = beneficio;
                    funcionarioComMaiorBeneficio = funcionario;
                }
            }
                return funcionarioComMaiorBeneficio;
            }
        
        //Método que receba uma lista de vendedores, mês e ano e retorne o que mais vendeu no mês
        public static Vendedor getMelhorVendedor(List<Vendedor> vendedores, LocalDate mesEano, RegistroVendas registroVendas) {
            Vendedor melhorVendedor = null;
            int vendasMelhorVendedor = 0;

            for (Vendedor vendedor : vendedores) {
                int totalVendas = registroVendas.getTotalVendas(vendedor, mesEano);
                if (totalVendas > vendasMelhorVendedor) {
                    vendasMelhorVendedor = totalVendas;
                    melhorVendedor = vendedor;
                }
            }

            return melhorVendedor;
        }
        
        // Método que filtra a lista de funcionários e retorna apenas os que recebem benefícios
        public static List<Funcionario> funcionariosComBeneficio(List<Funcionario> funcionarios, LocalDate mesEano) {
            List<Funcionario> funcionariosComSalarioMaior = new ArrayList<>();

            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getSoBeneficio(mesEano) > 0) {
                    funcionariosComSalarioMaior.add(funcionario);
                }
            }

            return funcionariosComSalarioMaior;
        }
}
