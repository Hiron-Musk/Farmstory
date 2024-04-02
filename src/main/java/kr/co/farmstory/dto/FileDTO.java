package kr.co.farmstory.dto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDTO {
    private int fno;
    private int ano;
    private String oName;
    private String sName;
    private int download;
    private LocalDateTime regDate;
}
