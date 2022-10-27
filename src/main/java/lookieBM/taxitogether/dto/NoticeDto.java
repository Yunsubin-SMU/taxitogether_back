package lookieBM.taxitogether.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lookieBM.taxitogether.domain.Notice;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Data
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
    public NoticeDto(Notice entity){
        this.noticeId = entity.getNoticeId();
        this.userId = entity.getNoticeId();
        this.noticeTitle = entity.getNoticeTitle();
        this.noticeContent = entity.getNoticeContent();
        this.noticeImage = entity.getNoticeImage();
        this.createNoticeDate = entity.getCreateNoticeDate();
        this.updateNoticeDate = entity.getUpdateNoticeDate();

    }
}
