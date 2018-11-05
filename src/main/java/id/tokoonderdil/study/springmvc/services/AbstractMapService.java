package id.tokoonderdil.study.springmvc.services;

import id.tokoonderdil.study.springmvc.domain.DomainObject;

import java.util.*;

public abstract class AbstractMapService {
    protected Map<Integer, DomainObject> domainMap;

    public AbstractMapService() {
        domainMap = new HashMap<>();
    }

    protected abstract void loadDomainObject();

    private Integer getNextKey() {
        return Collections.max(domainMap.keySet()) + 1;
    }

    public List<DomainObject> listAll() {
        return new ArrayList<>(domainMap.values());
    }

    public DomainObject getById(Integer objectId) {
        return domainMap.get(objectId);
    }

    public DomainObject saveOrUpdate(DomainObject domainObject) {
        if (domainObject != null) {
            if (domainObject.getObjectId() == null) domainObject.setObjectId(getNextKey());
            domainMap.put(domainObject.getObjectId(), domainObject);
            return domainObject;
        } else {
            throw new RuntimeException("Object Can't be null");
        }
    }

    public void delete(Integer objectId) {
        domainMap.remove(objectId);
    }

}
