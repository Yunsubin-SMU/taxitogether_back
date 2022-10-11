package lookieBM.taxitogether.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lookieBM.taxitogether.BaseTimeEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Notice extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="notice_id")
    private Long noticeId;

    // 공지사항 작성자가 여러 명일 수가 있을지
    //@ManyToOne
    @Column(name="user_id")
    private Long userId; //FK

    @Column(name="notice_title")
    private String noticeTitle;

    @Column(name="notice_content")
    private String noticeContent;

    @CreatedDate
    private LocalDateTime createNoticeDate;

    @LastModifiedDate
    private LocalDateTime updateNoticeDate;

    // 이미지 처리
    @Column(name="noticeImage_id")
    private String noticeImage;

    @Builder
    public Notice(Long noticeId, Long userId, String noticeTitle, String noticeContent, String noticeImage){
        this.noticeId = noticeId;
        this.userId = userId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeImage = noticeImage;
    }

}
