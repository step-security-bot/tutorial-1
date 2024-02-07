package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        while (product.getProductId() == null || productData.contains(product)) {
            product.setProductId(UUID.randomUUID().toString());
        }
        productData.add(product);
        return product;
    }

    public Product edit(Product product, String newName, int newQuantity) {
        int productIndex = productData.indexOf(product);
        Product edited = productData.get(productIndex);
        edited.setProductName(newName);
        edited.setProductQuantity(newQuantity);
        return edited;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }
}