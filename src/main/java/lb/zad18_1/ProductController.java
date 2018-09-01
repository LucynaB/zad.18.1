package lb.zad18_1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {
    private ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/allproducts")
    @ResponseBody
    public String allProducts() {
        List<Product> products = productRepository.getProductList();
        String info = "";
        double priceSum =ProductRepository.sumPrice(products);

        for (Product product : products) {
            info += product.toString() + "<br>";

        }
        return info+"Suma cen: "+priceSum;
    }



    @PostMapping("/add")
    public String add(@RequestParam String name, @RequestParam double price, @RequestParam String category) {
        Enum<Category> categoryEnum = Category.getByName(category);
        Product product = new Product(name, price, categoryEnum);
        productRepository.addProduct(product);

        return "redirect:/allproducts";

    }

    @GetMapping("/list")
    @ResponseBody
    public String categoryList(@RequestParam(required=false) String category ) {

        List<Product> products = ProductRepository.selectCategory(category);
        String info = "";
        double priceSum =0;

        for (Product product : products) {
            info += product.toString() + "<br>";
            priceSum+=product.getPrice();
        }
        return info+"Suma cen: "+priceSum;


       // return "redirect:/allproducts";

    }
}
