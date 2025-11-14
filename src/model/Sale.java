package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<SaleItem> items;
    private Payment payment;

    public Sale() {
        this.items = new ArrayList<>();
    }

    public boolean addItem(String code, int qtde) {
        // Verifica se há estoque disponível
        if (!DBMock.hasStock(code, qtde)) {
            throw new IllegalArgumentException(
                "Quantidade insuficiente em estoque para o código: " + code);
        }

        // Cria o item de venda
        SaleItem saleItem = new SaleItem(code, qtde);
        
        // Faz a baixa no estoque
        DBMock.decreaseStock(code, qtde);
        
        // Adiciona o item à lista
        return this.items.add(saleItem);
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (SaleItem saleItem : this.items) {
            totalAmount += saleItem.getTotalAmount();
        }
        return totalAmount;
    }

    public List<SaleItem> getItems() {
        return this.items;
    }

    public void cretePayment(String paymentMethod) {
        this.payment = DBMock.selectPayment(paymentMethod);
    }

    public double valueToBePaid() {
        if (this.payment == null) {
            throw new IllegalStateException("Método de pagamento não definido!");
        }
        return this.payment.valueToBePaid(getTotalAmount());
    }

    public String paymentMethod() {
        return this.payment == null ? "" : this.payment.toString();
    }
}
