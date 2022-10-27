package lookieBM.taxitogether.api;

import lombok.RequiredArgsConstructor;
import lookieBM.taxitogether.dto.NoticeDto;
import lookieBM.taxitogether.dto.NoticeUpdateDto;
import lookieBM.taxitogether.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoticeApiController {

    @Autowired
    private NoticeService noticeService;

    /*
    // 전체 조회
    @GetMapping("/api/notice")
    public List<NoticeDto> noticeList() throws Exception{
        return noticeService.getNoticeList();
    }
    */

    // 게시글 단독 조회
    @GetMapping("/api/notice/post/{id}")
    public NoticeDto findById(@PathVariable Long id) {
        return noticeService.findById(id);
    }

    // 게시글 등록
    @PostMapping("/api/notice/post")
    public Long postNotice(@RequestBody NoticeDto notice) throws Exception{
        return noticeService.saveNotice(notice);
    }

    // 게시글 수정
    @PatchMapping("/api/notice/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoticeUpdateDto noticeUpdateDto){
        return noticeService.update(id, noticeUpdateDto);
    }

    // 게시글 삭제
    @DeleteMapping("/api/notice/{id}")
    public Long delete(@PathVariable Long id){
        return noticeService.delete(id);
    }
}
