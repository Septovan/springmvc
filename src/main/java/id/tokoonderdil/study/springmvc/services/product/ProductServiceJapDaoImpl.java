package id.tokoonderdil.study.springmvc.services.product;


import id.tokoonderdil.study.springmvc.domain.Product;
import id.tokoonderdil.study.springmvc.services.AbstractJpaDaoService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class ProductServiceJapDaoImpl extends AbstractJpaDaoService implements ProductService {

    @Override
    public List<Product> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getById(Integer objectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Product.class, objectId);
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        // Merge = Kalau datanya ada maka akan merge, kalau tirak maka buat baru
        Product savedProduct = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();

        return savedProduct;
    }

    @Override
    public void delete(Integer objectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Product.class, objectId));
        entityManager.getTransaction().commit();
    }

}
