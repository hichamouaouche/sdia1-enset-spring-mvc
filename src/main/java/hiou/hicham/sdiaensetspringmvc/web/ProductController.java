package hiou.hicham.sdiaensetspringmvc.web;

import hiou.hicham.sdiaensetspringmvc.entities.Product;
import hiou.hicham.sdiaensetspringmvc.repository.ProductRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/user/index")
    public String index(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("productList", products);
        return "products";
    }

    @GetMapping("/")
    public String home() {

        return "redirect:/user/index";
    }

    @PostMapping("/admin/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }

    @GetMapping("/admin/newProduct")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new-product";
    }
/*
    @PostMapping("/saveProduct")
    public String saveProduct(@Valid Product product, BindingResult bindingResult, Model model){
         if(bindingResult.hasErrors()) return "new-product";
         productRepository.save(product);
         return "redirect:/newProduct";

    }
*/
   @PostMapping("/admin/saveProduct")

   public String saveProduct(@Valid Product product, BindingResult bindingResult) {
       if (bindingResult.hasErrors()) {
           return "new-product";
       }
       productRepository.save(product);
       return "redirect:/admin/newProduct";
   }
   @GetMapping("/notauthorized")
   public String notauthorized() {
       return "notauthorized";

   }
    @GetMapping("/login")
    public String login() {
        return "login";

    }
    @GetMapping("/logout")
    public String logout(HttpSession session)  {
       session.invalidate();
       return "login";

    }


}

