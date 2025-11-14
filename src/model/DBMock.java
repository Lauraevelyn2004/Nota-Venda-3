package model;

import java.util.HashMap;
import java.util.Map;

public class DBMock {
    private final static Map<String, String[]> products = new HashMap<>();
    private final static Map<String, Payment> payments = new HashMap<>();
    private final static Map<String, Stock> stocks = new HashMap<>();

    static {
        // Produtos: [nome, preço]
        products.put("pn", new String[]{"Pileco Nobre", "30"});
        products.put("fm", new String[]{"Feijão", "25"});
        products.put("ms", new String[]{"Macarrão Santa Amália", "8"});

        // Formas de pagamento
        payments.put("cc", new CreditCard(5));
        payments.put("dc", new DebitCard(0));
        payments.put("pc", new Cash(5.0));

        // Estoques: [código, quantidade]
        stocks.put("pn", new Stock("pn", 50));
        stocks.put("fm", new Stock("fm", 100));
        stocks.put("ms", new Stock("ms", 200));
    }

    public static String[] selectProduct(String code) {
        return products.get(code);
    }

    public static Payment selectPayment(String code) {
        return payments.get(code);
    }

    public static Stock selectStock(String code) {
        return stocks.get(code);
    }

    public static boolean hasStock(String code, int qtde) {
        Stock stock = stocks.get(code);
        return stock != null && stock.hasStock(qtde);
    }

    public static void decreaseStock(String code, int qtde) {
        Stock stock = stocks.get(code);
        if (stock != null) {
            stock.decreaseStock(qtde);
        }
    }
}
