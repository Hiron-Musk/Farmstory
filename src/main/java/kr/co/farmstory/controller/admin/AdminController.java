package kr.co.farmstory.controller.admin;

import kr.co.farmstory.entity.Product;
import kr.co.farmstory.service.admin.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductService service;

    @GetMapping("/product/list")
    public String list(Model model) {
        List<Product> products = service.prodFindAll();
        for (Product product : products) {
            log.info("product={}", product);
        }
        model.addAttribute("products", products);
        return "/admin/product/list";
    }

    @GetMapping(value = {"/index", "/"})
    public String index() {
        return "/admin/index";
    }

    @GetMapping("/product/register")
    public String registerFrom() {
        return "/admin/product/register";
    }

    /**
     * @param product product 엔티티를 받음
     * @param image   templates/admin/product/register.html에서 <input type="file" name="image">
     *                개별로 전송하는 MultipartFile을 넘길때는 name="" 을 같게해서 넘긴다.
     */
    @PostMapping("/product/register")
    public String register(@ModelAttribute Product product, MultipartFile[] image) {
        service.save(product, image);
        return "redirect:/admin/product/list";
    }
}
