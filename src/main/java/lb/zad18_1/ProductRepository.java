package lb.zad18_1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private static List<Product> productList = new ArrayList<>();

    public ProductRepository() {
        productList.add(new Product("chleb", 3.5, Category.ART_SPOZYWCZE));
        productList.add(new Product("odkurzacz", 300, Category.ART_GOSP_DOMOWEGO));
        productList.add(new Product("buty", 199.99, Category.INNE));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public static List<Product> selectCategory(String category) {
        List<Product> list = new ArrayList<>();

        for (Product product : productList) {
            if (product.getCategory().equals(Category.getByName(category))) {
                list.add(product);
            }
        }
        return list;
    }

    public static double sumPrice(List<Product> products) {
        double sum = 0;
        for (Product product : products) {
            sum += product.getPrice();
        }
        return sum;
    }
}