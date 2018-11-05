package id.tokoonderdil.study.springmvc.services.order;

import id.tokoonderdil.study.springmvc.domain.Order;
import id.tokoonderdil.study.springmvc.services.AbstractJpaDaoService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class OrderServiceJapDaoImpl extends AbstractJpaDaoService implements OrderService {

    @Override
    public List<Order> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Order", Order.class).getResultList();
    }

    @Override
    public Order getById(Integer objectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Order.class, objectId);
    }

    @Override
    public Order saveOrUpdate(Order domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Order savedOrder = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();
        return savedOrder;
    }

    @Override
    public void delete(Integer objectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Order.class, objectId));
        entityManager.getTransaction().commit();
    }
}
