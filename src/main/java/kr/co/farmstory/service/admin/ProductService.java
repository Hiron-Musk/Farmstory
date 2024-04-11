package kr.co.farmstory.service.admin;

import kr.co.farmstory.dto.ProductDTO;
import kr.co.farmstory.entity.Product;
import kr.co.farmstory.repository.admin.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    public Product save(ProductDTO productDTO) {

        List<MultipartFile> imgList = List.of(
                productDTO.getImage2(),
                productDTO.getImage3());
        //사진 업로드 시스템 경로 설정
        //new FILE()  --> import java.io.File;
        String savePath = new File(imagesUploadPath).getAbsolutePath();

        // 썸네일 저장
        MultipartFile thumbImg = productDTO.getImage1();

        if (thumbImg != null) {

            // thumbNail 사진의 원래 이름 앞에 넣는 랜덤 식별자 생성
            UUID uuid = UUID.randomUUID();

            //multiPartFile 원래 이름 가져오기
            String oriName = thumbImg.getOriginalFilename();

            // "s_" + uuid + _ + 사진의 원래 이름 = db에 저장되는 thumbNail 이름
            String thumbImageName = "s_" + uuid + "_" + thumbImg.getOriginalFilename();

            // 임의의 파일 객체 생성
            File thumbFile = new File(savePath, thumbImageName);

            try {
                Thumbnails.of(thumbImg.getInputStream())
                        .size(90, 90)
                        .toFile(thumbFile);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            log.info("save...6");

        }

        // 상세이미지 저장
        for (MultipartFile img : imgList) {
            log.info("save...7");
            // 사진의 원래 이름 앞에 넣는 랜덤 식별자 생성
            UUID uuid = UUID.randomUUID();

            // uuid + _ + 사진의 원래 이름 = db에 저장될 이름
            String saveImageName = uuid + "_" + img.getOriginalFilename();

            //사진을 생성할 것인데 경로는 path, 이름은 saveImageName
            File saveFile = new File(savePath, saveImageName);

            // product 엔티티 필드에 saveImageName 저장
            //saveImageNames.add(saveImageName);
            //사진 저장
            try {
                img.transferTo(saveFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        //product.setImage1(saveImageNames.get(0));
        //product.setImage2(saveImageNames.get(1));
        //product.setImage3(saveImageNames.get(2));

        // 썸네일 사진은 db에 저장되는 image1 필드 앞에 + "s_"
        /*
        String thumbnailName = "s_" + saveImageNames.get(0);
        File thumbNailInfo = new File(savePath, thumbnailName);


        // *** Thumbnailator 라이브러리 추가 ***
        try {

            BufferedImage thumbNailImage = Thumbnailator.createThumbnail(getImage, 60, 60);
            ImageIO.write(thumbNailImage, "jpeg",thumbNailInfo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */
        return null;
    }

    public List<Product> prodFindAll() {
        return repository.findAll();
    }
}
