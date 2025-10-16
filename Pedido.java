public class Pedido {
    private Produto produto;
    private Cliente cliente;

    public Pedido(Produto produto, Cliente cliente) {
        this.produto = produto;
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
