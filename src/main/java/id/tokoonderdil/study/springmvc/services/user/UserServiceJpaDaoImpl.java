package id.tokoonderdil.study.springmvc.services.user;

import id.tokoonderdil.study.springmvc.domain.Customer;
import id.tokoonderdil.study.springmvc.domain.User;
import id.tokoonderdil.study.springmvc.services.AbstractJpaDaoService;
import id.tokoonderdil.study.springmvc.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class UserServiceJpaDaoImpl extends AbstractJpaDaoService implements UserService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<?> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getById(Integer objectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(User.class, objectId);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        if (domainObject.getPassword() != null) {
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }

        User savedUser = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();

        return savedUser;
    }

    @Override
    public void delete(Integer objectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Customer customer = entityManager.find(Customer.class, objectId);
        entityManager.remove(customer.getUser());
        entityManager.remove(customer);
        entityManager.getTransaction().commit();
    }
}
