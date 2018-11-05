package id.tokoonderdil.study.springmvc.domain;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class AbstractDomainClass implements DomainObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Version
    private Integer version;

    private Date createdDate;
    private Date updatedDate;

    @Override
    public Integer getObjectId() {
        return this.id;
    }

    @Override
    public void setObjectId(Integer objectId) {
        this.id = objectId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    @PreUpdate
    @PrePersist
    public void updateTimeStamps() {
        updatedDate = new Date();
        if (createdDate == null) createdDate = new Date();
    }

}
