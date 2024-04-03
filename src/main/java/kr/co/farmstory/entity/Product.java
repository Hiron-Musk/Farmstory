package kr.co.farmstory.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prodNo;
    private Integer cateNo;
    private String prodName;
    private Integer prodStock;
    private Integer prodPrice;
    private Integer prodSold;
    private Integer prodDiscount;
    private Byte image1;
    private Byte image2;
    private Byte image3;
    private Integer delivery;
    private String etc;
    private Integer point;
}
