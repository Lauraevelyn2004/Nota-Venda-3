package model;

public class Stock {
    private String productCode;
    private int quantity;

    public Stock(String productCode, int quantity) {
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean hasStock(int qtde) {
        return this.quantity >= qtde;
    }

    public void decreaseStock(int qtde) {
        if (hasStock(qtde)) {
            this.quantity -= qtde;
        } else {
            throw new IllegalArgumentException(
                "Quantidade insuficiente em estoque para o produto: " + productCode);
        }
    }

    public void increaseStock(int qtde) {
        this.quantity += qtde;
    }

    @Override
    public String toString() {
        return "Estoque: " + quantity;
    }
}
