package id.tokoonderdil.study.springmvc.services.user;

import id.tokoonderdil.study.springmvc.domain.DomainObject;
import id.tokoonderdil.study.springmvc.domain.User;
import id.tokoonderdil.study.springmvc.services.AbstractMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class UserServiceImpl extends AbstractMapService implements UserService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public User getById(Integer objectId) {
        return (User) super.getById(objectId);
    }

    @Override
    public User saveOrUpdate(User domainObject) {
        return (User) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer objectId) {
        super.delete(objectId);
    }

    @Override
    protected void loadDomainObject() {
    }
}
