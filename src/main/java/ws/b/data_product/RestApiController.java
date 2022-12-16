/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.b.data_product;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Habib Santoso
 */
public class RestApiController {
    private static Map<String, Product> productRepo = new HashMap<>();
    static{
        Product buku = new Product();
        buku.setId("1");
        buku.setName("Buku");
        buku.setNumber(5);
        buku.setPrice(5000);
        buku.setTbuy();
        productRepo.put(buku.getId(), buku);
    }
    
    @RequestMapping(value="/product2")
    public ResponseEntity<Object> getProduct(){
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/product2", method = RequestMethod.POST)
        public ResponseEntity<Object> createProduct(@RequestBody Product product){
            product.setTbuy();
            productRepo.put(product.getId(), product);
            return new ResponseEntity<>("product is created successfully", HttpStatus.CREATED);
        }
        
    @RequestMapping(value = "//product2/{Id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduc(@PathVariable("Id") String Id, @RequestBody Product product){
        productRepo.remove(Id);
        product.setId(Id);
        product.setTbuy();
        productRepo.put(Id, product);
        return new ResponseEntity<>("Product is updated successfully", HttpStatus.OK);
    }
    
    @RequestMapping(value = "/product2/{Id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("Id") String Id){
        productRepo.remove(Id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }
}
