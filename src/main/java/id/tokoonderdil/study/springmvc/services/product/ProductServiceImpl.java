package id.tokoonderdil.study.springmvc.services.product;

import id.tokoonderdil.study.springmvc.domain.DomainObject;
import id.tokoonderdil.study.springmvc.domain.Product;
import id.tokoonderdil.study.springmvc.services.AbstractMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
@Profile("map")
public class ProductServiceImpl extends AbstractMapService implements ProductService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Product getById(Integer objectId) {
        return (Product) super.getById(objectId);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        return (Product) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer objectId) {
        super.delete(objectId);
    }

    @Override
    protected void loadDomainObject() {
//        domainMap = new HashMap<>();
//
//        Product product1 = new Product();
//        product1.setObjectId(1);
//        product1.setDescription("Product 1");
//        product1.setPrice(new BigDecimal("500000"));
//        product1.setImageUrl("http://example.com/product1");
//
//        Product product2 = new Product();
//        product2.setObjectId(2);
//        product2.setDescription("Product 2");
//        product2.setPrice(new BigDecimal("100000"));
//        product2.setImageUrl("http://example.com/product2");
//
//        Product product3 = new Product();
//        product3.setObjectId(3);
//        product3.setDescription("Product 3");
//        product3.setPrice(new BigDecimal("10000"));
//        product3.setImageUrl("http://example.com/product3");
//
//        Product product4 = new Product();
//        product4.setObjectId(4);
//        product4.setDescription("Product 4");
//        product4.setPrice(new BigDecimal("1000000"));
//        product4.setImageUrl("http://example.com/product4");
//
//        Product product5 = new Product();
//        product5.setObjectId(5);
//        product5.setDescription("Product 5");
//        product5.setPrice(new BigDecimal("200000"));
//        product5.setImageUrl("http://example.com/product5");
//
//        domainMap.put(1, product1);
//        domainMap.put(2, product2);
//        domainMap.put(3, product3);
//        domainMap.put(4, product4);
//        domainMap.put(5, product5);
    }

}
