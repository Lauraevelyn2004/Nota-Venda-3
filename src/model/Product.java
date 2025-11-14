package model;

public class Product {
    private String description;
    private double price;
    private String code;

    public Product(String code) {
        String[] productData = DBMock.selectProduct(code);
        if (productData == null) {
            throw new IllegalArgumentException("Código inválido: " + code);
        }
        this.code = code;
        this.description = productData[0]; // Aqui pega a descrição correta (String)
        this.price = Double.parseDouble(productData[1]); // Converte preço para double
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasStock(int qtde) {
        return DBMock.hasStock(this.code, qtde);
    }
}
