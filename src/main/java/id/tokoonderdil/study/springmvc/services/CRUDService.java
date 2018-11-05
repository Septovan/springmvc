package id.tokoonderdil.study.springmvc.services;

import java.util.List;

public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer objectId);

    T saveOrUpdate(T domainObject);

    void delete(Integer objectId);
}
