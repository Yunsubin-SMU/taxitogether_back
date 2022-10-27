package lookieBM.taxitogether.service;

import lookieBM.taxitogether.domain.Notice;
import lookieBM.taxitogether.dto.NoticeDto;
import lookieBM.taxitogether.dto.NoticeUpdateDto;
import lookieBM.taxitogether.dto.PostNoticeResponseDto;
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

    /*
    @Transactional
    public List<NoticeDto> getNoticeList(Notice entity){
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
     */

    @Transactional
    public NoticeDto findById (Long id){
        Notice entity = noticeRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 존재하지 않습니다 id = " + id));
        return new NoticeDto(entity);

    }

    // 게시글 수정
    @Transactional
    public Long update(Long id, NoticeUpdateDto noticeUpdateDto){
        Notice entity = noticeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException());
        entity.update(noticeUpdateDto.getNoticeTitle(), noticeUpdateDto.getNoticeContent());

        return noticeRepository.save(entity).getNoticeId();
    }

    @Transactional
    public Long delete(Long id) {

        Notice entity = noticeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("존재하지 않는 게시물입니다"));
        noticeRepository.deleteById(id);
        return entity.getNoticeId();
    }

}
