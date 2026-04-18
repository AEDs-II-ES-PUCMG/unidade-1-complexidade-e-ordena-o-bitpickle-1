import java.util.Comparator;

/**
 * Critério B - Volume Total de Itens (crescente).
 * Desempate 1: Data do Pedido.
 * Desempate 2: Código Identificador do pedido.
 */
public class ComparadorCriterioB implements Comparator<Pedido> {

    @Override
    public int compare(Pedido o1, Pedido o2) {
        var volumeTotalSub = o1.getTotalItens() - o2.getTotalItens();
        if (volumeTotalSub != 0) return volumeTotalSub;

        var dateIsEqual = o1.getDataPedido().equals(o2.getDataPedido());
        if (!dateIsEqual) {
            if (o1.getDataPedido().isBefore(o2.getDataPedido())) {
                return -1;
            }
            return 1;
        }

        return o1.getIdPedido() - o2.getIdPedido();
    }
}
