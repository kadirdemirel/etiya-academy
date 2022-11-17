public class ProductManager {

    static {
        System.out.println("Static yapıcı blok çalıştı");
    }

    public void add(Product product) {

        if (ProductValidator.isValid(product)) {
            System.out.println("Eklendi");
        } else {
            System.out.println("Ürün bilgileri geçersizdir");
        }

    }

    public static class BaskaBirClass {
        public static void sil() {

        }
    }
}
