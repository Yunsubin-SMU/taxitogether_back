package lookieBM.taxitogether.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@NoArgsConstructor
public class NoticeUpdateDto {

    private String noticeTitle;
    private String noticeContent;

    @Builder
    public NoticeUpdateDto(String noticeTitle, String noticeContent){
        this.noticeContent=noticeContent;
        this.noticeTitle=noticeTitle;
    }
}
