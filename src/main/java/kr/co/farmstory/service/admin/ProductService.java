package kr.co.farmstory.service.admin;

import kr.co.farmstory.entity.Product;
import kr.co.farmstory.repository.admin.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;

    @Value("${images.upload.path}")
    private String imagesUploadPath;

    public Product save(Product product, MultipartFile[] image) {

        //saveImageName을 product entity에 넣기 위한 리스트
        List<String> saveImageNames = new ArrayList<>();

        //사진 업로드 시스템 경로 설정
        //new FILE()  --> import java.io.File;
        String savePath = new File(imagesUploadPath).getAbsolutePath();

        for (MultipartFile img : image) {

            // 사진의 원래 이름 앞에 넣는 랜덤 식별자 생성
            UUID uuid = UUID.randomUUID();

            // uuid + _ + 사진의 원래 이름 = db에 저장될 이름
            String saveImageName = uuid + "_" + img.getOriginalFilename();

            //사진을 생성할 것인데 경로는 path, 이름은 saveImageName
            File saveFile = new File(savePath, saveImageName);

            //사진 저장
            try {
                img.transferTo(saveFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // product 엔티티필드에 saveImageName 저장
            saveImageNames.add(saveImageName);
        }
        product.setImage1(saveImageNames.get(0));
        product.setImage2(saveImageNames.get(1));
        product.setImage3(saveImageNames.get(2));

        return repository.save(product);
    }

    public List<Product> prodFindAll() {
        return repository.findAll();
    }
}
