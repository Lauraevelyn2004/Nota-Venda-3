package view;

import model.Sale;
import model.SalePresenter;

public class Main {
    public static void main(String[] args) {
        try {
            Sale sale = new Sale();
            
            // Adicionando itens (com verificação de estoque)
            sale.addItem("pn", 5);
            sale.addItem("fm", 2);
            sale.addItem("ms", 10);
            
            // Definindo forma de pagamento
            sale.cretePayment("dc");

            // Exibindo a nota de venda
            SalePresenter presenter = new ConsoleSalePresenter();
            presenter.show(sale);
            
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao adicionar item: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Erro no pagamento: " + e.getMessage());
        }
    }
}
