package id.tokoonderdil.study.springmvc.services.customer;

import id.tokoonderdil.study.springmvc.domain.Customer;
import id.tokoonderdil.study.springmvc.domain.DomainObject;
import id.tokoonderdil.study.springmvc.services.AbstractMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Customer getById(Integer objectId) {
        return (Customer) super.getById(objectId);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer objectId) {
        super.delete(objectId);
    }

    @Override
    protected void loadDomainObject() {
//        domainMap = new HashMap<>();
//
//        Customer customer1 = new Customer();
//        customer1.setObjectId(1);
//        customer1.setFirstName("Septovan");
//        customer1.setLastName("Saian");
//        customer1.setEmail("septovan.ovan@gmail.com");
//        customer1.setPhoneNumber("000000000");
//        customer1.setAddressLineOne("Perumahan Kota Baru 86-87");
//        customer1.setAddressLineTwo("RT.003/RW.013, Blotongan, Sidorejo");
//        customer1.setCity("Salatiga");
//        customer1.setState("Indonesia");
//        customer1.setZipCode("50715");
//
//        Customer customer2 = new Customer();
//        customer2.setObjectId(2);
//        customer2.setFirstName("Dwi");
//        customer2.setLastName("Suputra");
//        customer2.setEmail("septovan_suputra@tokoonderdil.id");
//        customer2.setPhoneNumber("111111111");
//        customer2.setAddressLineOne("Mess Sinarmas, Roxy Square");
//        customer2.setAddressLineTwo("Jalan Kyai Tapa");
//        customer2.setCity("Jakarta Barat");
//        customer2.setState("Indonesia");
//        customer2.setZipCode("11440");
//
//        Customer customer3 = new Customer();
//        customer3.setObjectId(3);
//        customer3.setFirstName("Bambang");
//        customer3.setLastName("Soedarmo");
//        customer3.setEmail("bambang_soe@gmail.com");
//        customer3.setPhoneNumber("222222222");
//        customer3.setAddressLineOne("Kos kosan");
//        customer3.setAddressLineTwo("Terbaik");
//        customer3.setCity("Jakarta");
//        customer3.setState("Indonesia");
//        customer3.setZipCode("11440");
//
//        domainMap.put(1, customer1);
//        domainMap.put(2, customer2);
//        domainMap.put(3, customer3);
    }

}
