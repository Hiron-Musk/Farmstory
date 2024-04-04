package kr.co.farmstory.dto;

import lombok.*;

/**
 * 24/4/2수정
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private int prodNo;
    private int cateNo;
    private String prodName;
    private int prodStock;
    private int prodPrice;
    private int prodSold;
    private int prodDiscount;
    private String image1;
    private String image2;
    private String image3;
    private int delivery;
    private String etc;
    private int point;

}
