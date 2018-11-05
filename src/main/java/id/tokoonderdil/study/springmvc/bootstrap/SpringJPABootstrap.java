package id.tokoonderdil.study.springmvc.bootstrap;

import id.tokoonderdil.study.springmvc.domain.*;
import id.tokoonderdil.study.springmvc.domain.security.Role;
import id.tokoonderdil.study.springmvc.enums.OrderStatus;
// import id.tokoonderdil.study.springmvc.services.customer.CustomerService;
import id.tokoonderdil.study.springmvc.services.product.ProductService;
import id.tokoonderdil.study.springmvc.services.role.RoleService;
import id.tokoonderdil.study.springmvc.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ProductService productService;
    private UserService userService;
    private RoleService roleService;
//    private CustomerService customerService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

//    @Autowired
//    public void setCustomerService(CustomerService customerService) {
//        this.customerService = customerService;
//    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
        loadUsersAndCustomers();
        loadCarts();
        loadOrderHistory();
        loadRoles();
        assignUsersToDefaultRole();
//        loadCustomer();
    }

    private void assignUsersToDefaultRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();

        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("CUSTOMER")) {
                users.forEach(user -> {
                    user.addRole(role);
                    userService.saveOrUpdate(user);
                });
            }
        });
    }

    private void loadRoles() {
        Role role = new Role();
        role.setRole("CUSTOMER");
        roleService.saveOrUpdate(role);
    }

    private void loadOrderHistory() {
        List<User> users = (List<User>) userService.listAll();
        List<Product> products = (List<Product>) productService.listAll();

        users.forEach(user -> {
            Order order = new Order();
            order.setCustomer(user.getCustomer());
            order.setOrderStatus(OrderStatus.SHIPPED);

            products.forEach(product -> {
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setProduct(product);
                orderDetail.setQuantity(1);
                order.addToOrderDetails(orderDetail);
            });
        });
    }

    private void loadCarts() {
        List<User> users = (List<User>) userService.listAll();
        List<Product> products = (List<Product>) productService.listAll();

        users.forEach(user -> {
            user.setCart(new Cart());
            CartDetail cartDetail = new CartDetail();
            cartDetail.setProduct(products.get(0));
            cartDetail.setQuantity(2);
            user.getCart().addCartDetail(cartDetail);
            userService.saveOrUpdate(user);
        });
    }

    public void loadUsersAndCustomers() {
        User user1 = new User();
        user1.setUsername("mweston");
        user1.setPassword("password");

        Customer customer1 = new Customer();
        customer1.setFirstName("Micheal");
        customer1.setLastName("Weston");
        customer1.setBillingAddress(new Address());
        customer1.getBillingAddress().setAddressLineOne("1 Main St");
        customer1.getBillingAddress().setCity("Miami");
        customer1.getBillingAddress().setState("Florida");
        customer1.getBillingAddress().setZipCode("33101");
        customer1.setEmail("micheal@burnnotice.com");
        customer1.setPhoneNumber("305.333.0101");
        user1.setCustomer(customer1);
        userService.saveOrUpdate(user1);

        User user2 = new User();
        user2.setUsername("fglenanne");
        user2.setPassword("password");

        Customer customer2 = new Customer();
        customer2.setFirstName("Fiona");
        customer2.setLastName("Glenanne");
        customer2.setBillingAddress(new Address());
        customer2.getBillingAddress().setAddressLineOne("1 Key Biscane Ave");
        customer2.getBillingAddress().setCity("Miami");
        customer2.getBillingAddress().setState("Florida");
        customer2.getBillingAddress().setZipCode("33101");
        customer2.setEmail("fiona@burnnotice.com");
        customer2.setPhoneNumber("305.323.0233");
        user2.setCustomer(customer2);
        userService.saveOrUpdate(user2);

        User user3 = new User();
        user3.setUsername("saxe");
        user3.setPassword("password");
        Customer customer3 = new Customer();
        customer3.setFirstName("Sam");
        customer3.setLastName("Axe");
        customer3.setBillingAddress(new Address());
        customer3.getBillingAddress().setAddressLineOne("1 Little Cuba Road");
        customer3.getBillingAddress().setCity("Miami");
        customer3.getBillingAddress().setState("Florida");
        customer3.getBillingAddress().setZipCode("33101");
        customer3.setEmail("sam@burnnotice.com");
        customer3.setPhoneNumber("305.426.9832");

        user3.setCustomer(customer3);
        userService.saveOrUpdate(user3);
    }

    public void loadProducts() {
        Product product1 = new Product();
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("500000"));
        product1.setImageUrl("http://example.com/product1");

        Product product2 = new Product();
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("100000"));
        product2.setImageUrl("http://example.com/product2");

        Product product3 = new Product();
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("10000"));
        product3.setImageUrl("http://example.com/product3");

        Product product4 = new Product();
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("1000000"));
        product4.setImageUrl("http://example.com/product4");

        Product product5 = new Product();
        product5.setDescription("Product 5");
        product5.setPrice(new BigDecimal("200000"));
        product5.setImageUrl("http://example.com/product5");

        productService.saveOrUpdate(product1);
        productService.saveOrUpdate(product2);
        productService.saveOrUpdate(product3);
        productService.saveOrUpdate(product4);
        productService.saveOrUpdate(product5);
    }

//    public void loadCustomer() {
//        Customer customer1 = new Customer();
//        customer1.setFirstName("Septovan");
//        customer1.setLastName("Saian");
//        customer1.setEmail("septovan.ovan@gmail.com");
//        customer1.setPhoneNumber("000000000");
//        customer1.setBillingAddress(new Address());
//        customer1.getBillingAddress().setAddressLineOne("Perumahan Kota Baru 86-87");
//        customer1.getBillingAddress().setAddressLineTwo("RT.003/RW.013, Blotongan, Sidorejo");
//        customer1.getBillingAddress().setCity("Salatiga");
//        customer1.getBillingAddress().setState("Indonesia");
//        customer1.getBillingAddress().setZipCode("50715");
//
//        Customer customer2 = new Customer();
//        customer2.setFirstName("Dwi");
//        customer2.setLastName("Suputra");
//        customer2.setEmail("septovan_suputra@tokoonderdil.id");
//        customer2.setPhoneNumber("111111111");
//        customer2.setBillingAddress(new Address());
//        customer2.getBillingAddress().setAddressLineOne("Mess Sinarmas, Roxy Square");
//        customer2.getBillingAddress().setAddressLineTwo("Jalan Kyai Tapa");
//        customer2.getBillingAddress().setCity("Jakarta Barat");
//        customer2.getBillingAddress().setState("Indonesia");
//        customer2.getBillingAddress().setZipCode("11440");
//
//        Customer customer3 = new Customer();
//        customer3.setFirstName("Bambang");
//        customer3.setLastName("Soedarmo");
//        customer3.setEmail("bambang_soe@gmail.com");
//        customer3.setPhoneNumber("222222222");
//        customer3.setBillingAddress(new Address());
//        customer3.getBillingAddress().setAddressLineOne("Kos kosan");
//        customer3.getBillingAddress().setAddressLineTwo("Terbaik");
//        customer3.getBillingAddress().setCity("Jakarta");
//        customer3.getBillingAddress().setState("Indonesia");
//        customer3.getBillingAddress().setZipCode("11440");
//
//        customerService.saveOrUpdate(customer1);
//        customerService.saveOrUpdate(customer2);
//        customerService.saveOrUpdate(customer3);
//    }

}
