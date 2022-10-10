package lookieBM.taxitogether.service;

import lookieBM.taxitogether.domain.Notice;
import lookieBM.taxitogether.dto.NoticeDto;
import lookieBM.taxitogether.repository.NoticeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {
    private NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository){
        this.noticeRepository = noticeRepository;
    }

    @Transactional
    public Long saveNotice(NoticeDto noticeDto){
        return noticeRepository.save(noticeDto.toEntity()).getNoticeId();
    }

    @Transactional
    public List<NoticeDto> getNoticeList(){
        List<Notice> noticeList = noticeRepository.findAll();
        List<NoticeDto> noticeDtoList = new ArrayList<>();

        for(Notice notice : noticeList){
            NoticeDto noticeDto = NoticeDto.builder()
                    .noticeId(notice.getNoticeId())
                    .userId(notice.getUserId())
                    .noticeTitle(notice.getNoticeTitle())
                    .noticeContent(notice.getNoticeContent())
                    .noticeImage(notice.getNoticeImage())
                    .createNoticeDate(notice.getCreateNoticeDate())
                    .updateNoticeDate(notice.getUpdateNoticeDate())
                    .build();
            noticeDtoList.add(noticeDto);
        }
        return noticeDtoList;
    }
}
