package id.tokoonderdil.study.springmvc.services.role;

import id.tokoonderdil.study.springmvc.domain.DomainObject;
import id.tokoonderdil.study.springmvc.domain.security.Role;
import id.tokoonderdil.study.springmvc.services.AbstractMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class RoleServiceImpl extends AbstractMapService implements RoleService {

    @Override
    public List<DomainObject> listAll() {
        return null;
    }

    @Override
    public Role getById(Integer objectId) {
        return null;
    }

    @Override
    public Role saveOrUpdate(Role domainObject) {
        return null;
    }

    @Override
    public void delete(Integer objectId) {

    }

    @Override
    protected void loadDomainObject() {

    }
}
