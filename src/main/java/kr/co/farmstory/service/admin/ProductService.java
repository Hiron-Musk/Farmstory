package kr.co.farmstory.service.admin;

import kr.co.farmstory.entity.Product;
import kr.co.farmstory.repository.admin.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public List<Product> prodFindAll() {
        return repository.findAll();


    }

}
