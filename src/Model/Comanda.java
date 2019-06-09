package Model;

import java.math.BigDecimal;

public class Comanda {
    private Cliente cliente;
    private Pedido pedido;
    private StatusPagamento statusPagamento;

    public Comanda(Cliente cliente) {
        this.cliente = cliente;
        this.statusPagamento = StatusPagamento.NAO_PAGO;
    }

    public Comanda(){
        this.statusPagamento = StatusPagamento.NAO_PAGO;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido getPedido() {
        return cliente.getPedido();
    }

    public float getTotalPedido(){
        return this.cliente.getPedido().getTotal();
    }


    public StatusPagamento getStatusPagamento() {
        return this.statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }



    @Override
    public String toString() {
        return "- Comanda - " +
                "\nCliente:\n" + cliente + "\nTotal do pedido: " + cliente.getPedido().getTotal() + "\nStatus Pagamento: " + getStatusPagamento();

    }

    public static void main(String[] args) {

    }

}