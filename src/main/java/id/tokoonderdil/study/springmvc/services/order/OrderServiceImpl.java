package id.tokoonderdil.study.springmvc.services.order;

import id.tokoonderdil.study.springmvc.domain.DomainObject;
import id.tokoonderdil.study.springmvc.domain.Order;
import id.tokoonderdil.study.springmvc.services.AbstractMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class OrderServiceImpl extends AbstractMapService implements OrderService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Order getById(Integer objectId) {
        return (Order) super.getById(objectId);
    }

    @Override
    public Order saveOrUpdate(Order domainObject) {
        return (Order) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer objectId) {
        super.delete(objectId);
    }

    @Override
    protected void loadDomainObject() {
    }

}
