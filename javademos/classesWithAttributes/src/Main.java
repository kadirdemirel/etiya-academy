public class Main {
    public static void main(String[] args) {
        Product product = new Product(1,"Laptop","Bilgisayar",5000,3);
       /* product.setName("Laptop");
        product.setId(1);
        product.setDescription("Asus Laptop");
        product.setPrice(5000);
        product.setStockAmount(3);
        */

        ProductManager productManager = new ProductManager();
        productManager.add(product);

        System.out.println(product.getDescription());
    }
}