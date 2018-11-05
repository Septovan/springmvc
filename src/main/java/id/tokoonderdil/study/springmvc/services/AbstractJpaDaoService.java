package id.tokoonderdil.study.springmvc.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class AbstractJpaDaoService {

    protected EntityManagerFactory entityManagerFactory;

    @PersistenceUnit
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
}
