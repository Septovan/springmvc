package id.tokoonderdil.study.springmvc.controller;

import id.tokoonderdil.study.springmvc.domain.Customer;
import id.tokoonderdil.study.springmvc.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/customer")
@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping({"/list", "/"})
    public String getAllCustomer(Model model) {
        model.addAttribute("customers", customerService.listAll());
        return "customer/list";
    }

    @RequestMapping("/show/{customerId}")
    public String getCustomerById(@PathVariable Integer customerId, Model model) {
        model.addAttribute("customer", customerService.getById(customerId));
        return "customer/show";
    }

    @RequestMapping("/new")
    public String newCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customerform";
    }

    @RequestMapping("/edit/{customerId}")
    public String editCustomer(@PathVariable Integer customerId, Model model) {
        model.addAttribute("customer", customerService.getById(customerId));
        return "customer/customerform";
    }

    @RequestMapping(value = "/action", method = RequestMethod.POST)
    public String saveOrUpdate(Customer customer) {
        Customer savedCustomer = customerService.saveOrUpdate(customer);
        return "redirect:/customer/show/" + savedCustomer.getObjectId();
    }

    @RequestMapping("/delete/{customerId}")
    public String deleteCustomer(@PathVariable Integer customerId) {
        customerService.delete(customerId);
        return "redirect:/customer/list";
    }

}
