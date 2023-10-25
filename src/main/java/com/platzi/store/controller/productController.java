package com.platzi.store.controller;

import com.platzi.store.entity.Product;
import com.platzi.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class productController {


    @Autowired
    private ProductService productService;



    @GetMapping()
    private List<Product> getAll(){
        return productService.getProducts();
    }

    @GetMapping(path = "/{id}")

    public Optional<Product> getUserById(@PathVariable("id") Long longId){//pathVariable permite obtener el valor de la ruta id y pasarlo como parametro
        return this.productService.getProductById(longId);
    }


    @PostMapping
    public Product saveUser(@RequestBody Product product){ //hago un request
        return this.productService.save(product);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById (Long id){
        boolean ok = productService.deleteProduct(id);
        if(ok){
            return "producto eliminado";
        }else{
            return "No se elimino el producto";
        }
    }

}
