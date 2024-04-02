package kr.co.farmstory.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDTO {
    private int prodId;
    private String prodName;
    private int prodCate;
    private int prodPrice;
    private int prodDiscount;
    private int prodCount;
    private int prodPoint;
    private int prodDeliverFee;

}
