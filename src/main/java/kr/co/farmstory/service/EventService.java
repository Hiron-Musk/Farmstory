package kr.co.farmstory.service;

import kr.co.farmstory.entity.Article;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    // 실제로는 데이터베이스에서 이벤트 정보를 가져오는 메서드입니다.
    public List<Article> getAllEvents() {
        // 여기서는 임의의 이벤트 데이터를 생성하여 반환합니다.
        List<Article> events = new ArrayList<>();
        events.add(Article.builder()
                .no(1)
                .writer("글쓴이1")
                .parent(0)
                .comment(0)
                .cate("카테고리1")
                .title("제목1")
                .content("내용1")
                .file(0)
                .hit(100)
                .regip("127.0.0.1")
                .rdate(LocalDateTime.parse("2024-04-01T00:00:00"))
                .build());
        return events;
    }
}