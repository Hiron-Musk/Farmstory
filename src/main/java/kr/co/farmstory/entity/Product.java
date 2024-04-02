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
@Table(name = "file")
public class Product {

    @Id @GeneratedValue
    @Column(name = "prod_id")
    private int id;
    private String name;
    private int cate;
    private int discount;
    private int count;
    private int point;
    private int fee;
}
