package lookieBM.taxitogether.dto;

import lombok.Builder;
import lombok.Getter;
import lookieBM.taxitogether.domain.Notice;
import java.time.LocalDateTime;

@Getter
public class NoticeDto {

    private Long noticeId;
    private Long userId;
    private String noticeTitle;
    private String noticeContent;
    private LocalDateTime createNoticeDate;
    private LocalDateTime updateNoticeDate;
    private String noticeImage;

    public Notice toEntity(){
        Notice notice = Notice.builder()
                .noticeId(noticeId)
                .userId(userId)
                .noticeTitle(noticeTitle)
                .noticeContent(noticeContent)
                .noticeImage(noticeImage)
                .build();
        return notice;
    }

    @Builder
    public NoticeDto(Long noticeId, Long userId, String noticeTitle, String noticeContent,
                     String noticeImage, LocalDateTime createNoticeDate, LocalDateTime updateNoticeDate){
        this.noticeId = noticeId;
        this.userId = userId;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeImage = noticeImage;
        this.createNoticeDate = createNoticeDate;
        this.updateNoticeDate = updateNoticeDate;

    }
}
