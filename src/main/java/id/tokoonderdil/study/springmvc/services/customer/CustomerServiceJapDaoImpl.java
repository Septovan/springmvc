package id.tokoonderdil.study.springmvc.services.customer;

import id.tokoonderdil.study.springmvc.domain.Customer;
import id.tokoonderdil.study.springmvc.domain.User;
import id.tokoonderdil.study.springmvc.services.AbstractJpaDaoService;
import id.tokoonderdil.study.springmvc.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Profile("jpadao")
public class CustomerServiceJapDaoImpl extends AbstractJpaDaoService implements CustomerService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<Customer> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Customer", Customer.class).getResultList();
    }

    @Override
    public Customer getById(Integer objectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Customer.class, objectId);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        if (domainObject.getUser() != null && domainObject.getUser().getPassword() != null) {
            domainObject.getUser().setEncryptedPassword(
                    encryptionService.encryptString(domainObject.getUser().getPassword())
            );
        }
        Customer savedCustomer = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();

        return savedCustomer;
    }

    @Override
    public void delete(Integer objectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, objectId);
        entityManager.remove(user.getCustomer());
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }
}
