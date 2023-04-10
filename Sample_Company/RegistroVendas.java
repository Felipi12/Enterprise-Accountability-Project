package Sample_Company;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class RegistroVendas {

    private Map<Vendedor, Map<YearMonth, Integer>> vendasPorVendedor;

    public RegistroVendas() {
        this.vendasPorVendedor = new HashMap<>();
    }

    public void adicionarVendas(Vendedor vendedor, String data, int valor) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        LocalDate dataVenda = YearMonth.parse(data, formatter).atDay(1);
        YearMonth mesAnoVenda = YearMonth.from(dataVenda);

        vendasPorVendedor.putIfAbsent(vendedor, new HashMap<>());
        Map<YearMonth, Integer> vendasPorMes = vendasPorVendedor.get(vendedor);
        vendasPorMes.put(mesAnoVenda, vendasPorMes.getOrDefault(mesAnoVenda, 0) + valor);
    }

    public int getTotalVendas(Vendedor vendedor, LocalDate dataLimite) {
        int totalVendas = 0;
        Map<YearMonth, Integer> vendasPorMes = vendasPorVendedor.get(vendedor);
        if (vendasPorMes != null) {
            for (Map.Entry<YearMonth, Integer> entry : vendasPorMes.entrySet()) {
                YearMonth mesAnoVenda = entry.getKey();
                if (mesAnoVenda.atEndOfMonth().isBefore(dataLimite)) {
                    totalVendas += entry.getValue();
                }
            }
        }
        return totalVendas;
    }
}
