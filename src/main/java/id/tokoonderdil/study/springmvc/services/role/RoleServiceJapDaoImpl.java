package id.tokoonderdil.study.springmvc.services.role;

import id.tokoonderdil.study.springmvc.domain.security.Role;
import id.tokoonderdil.study.springmvc.services.AbstractJpaDaoService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Profile("jpadao")
public class RoleServiceJapDaoImpl extends AbstractJpaDaoService implements RoleService {

    @Override
    public List<?> listAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getById(Integer objectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.find(Role.class, objectId);
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Role savedRole = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();
        return savedRole;
    }

    @Override
    public void delete(Integer objectId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Role.class, objectId));
        entityManager.getTransaction().commit();
    }
}
