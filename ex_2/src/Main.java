public class Main {
    public static void main(String[] args) {
        ProductHashTable table = new ProductHashTable(10);

        Product product1 = new Product("Milk", 1.99, 20);
        Product product2 = new Product("Bread", 2.49, 15);

        // Вставка продуктов
        table.put("1234567890", product1);
        table.put("0987654321", product2);

        // Поиск продукта
        System.out.println("Product found: " + table.get("1234567890"));

        // Удаление продукта
        table.remove("1234567890");
        System.out.println("Product found after removal: " + table.get("1234567890"));
    }
}