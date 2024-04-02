package kr.co.farmstory.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {
    private int orderId;
    private String uid;
    private String resName;
    private String resHp;
    private String resZip;
    private String resAddr1;
    private String resAddr2;
    private String resPay;
    private String resEtc;

}
