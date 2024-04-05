package kr.co.farmstory.controller.admin;

import kr.co.farmstory.entity.Product;
import kr.co.farmstory.service.admin.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 데이터 product 키 다시 수정해야됨
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final ProductService service;

    @GetMapping("/product/list")
    public String list(Model model) {
        List<Product> products = service.prodFindAll();
        log.info("products={}", products);
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

    @PostMapping("/product/register")
    public String register(@ModelAttribute Product product,
                           @RequestParam MultipartFile image
                           ) {
        log.info("product={}", product.toString());
        log.info("image_getOriginalFilename={}", image.getOriginalFilename());
//        service.save(product, image1, image2, image3);
//        return null;
        return "/admin/product/register";
    }
}
