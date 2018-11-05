package id.tokoonderdil.study.springmvc.controller;

import id.tokoonderdil.study.springmvc.domain.Product;
import id.tokoonderdil.study.springmvc.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/product")
@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping({"/list", "/"})
    public String listProduct(Model model) {
        model.addAttribute("products", productService.listAll());
        return "product/list";
    }

    @RequestMapping("/show/{productId}")
    public String getProduct(@PathVariable Integer productId, Model model) {
        model.addAttribute("product", productService.getById(productId));
        return "product/show";
    }

    @RequestMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/productform";
    }

    @RequestMapping("/edit/{productId}")
    public String edit(@PathVariable Integer productId, Model model) {
        model.addAttribute("product", productService.getById(productId));
        return "product/productform";
    }

    @RequestMapping("/delete/{productId}")
    public String delete(@PathVariable Integer productId) {
        productService.delete(productId);
        return "redirect:/product/list";
    }

    @RequestMapping(value = "/action", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product) {
        Product savedProduct = productService.saveOrUpdate(product);
        return "redirect:/product/show/" + savedProduct.getObjectId();
    }

}
