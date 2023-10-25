package com.platzi.store.service;


import com.platzi.store.entity.Product;
import com.platzi.store.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    IProductRepository iProductRepository;


 /*   private List<ProductMapper> getMapper(List<Product> products) {
        return products.stream()
                .map(this::convertirProductAMapper)
                .collect(Collectors.toList());
    }
*/
  /*  private ProductMapper convertirProductAMapper(Product product) {

        ProductMapper productMapper = new ProductMapper();
        productMapper.setId(String.valueOf(product.getId()));
        productMapper.setDescription(String.valueOf(product.getDescription()));
        productMapper.setImage(String.valueOf(product.getImage()));
        productMapper.setTitle(String.valueOf(product.getTitle()));
        productMapper.setPrice(Integer.valueOf(product.getPrice()));



        return productMapper;
    }*/

    /*public List<ProductMapper> getProducts() {
        List<Product> products = (List<Product>) iProductRepository.findAll();
        return getMapper(products);
    }*/

    public List<Product> getProducts(){
        return (List<Product>) iProductRepository.findAll();
    }


    public Optional<Product> getProductById(Long id){
        return  iProductRepository.findById(id);
    }

    public Product save(Product product){
        return iProductRepository.save(product);
    }

    public boolean deleteProduct(Long productId) {
        try{
            iProductRepository.deleteById(productId);
            return true;
        }catch (Exception e){
            return false;
        }

    }

}
