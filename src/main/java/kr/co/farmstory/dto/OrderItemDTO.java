package kr.co.farmstory.dto;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemDTO {
    private int orderItemId;
    private int prodId;
    private int orderId;
}
