package lookieBM.taxitogether.controller;

import lookieBM.taxitogether.dto.NoticeDto;
import lookieBM.taxitogether.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class NoticeController {

    private NoticeService noticeService;

    public NoticeController(NoticeService noticeService){
        this.noticeService = noticeService;
    }

    @GetMapping("/")
    public String list(Model model){
        List<NoticeDto> noticeDtoList = noticeService.getNoticeList();
        model.addAttribute("noticeList", noticeDtoList);
        return "board/list";
    }

    @GetMapping("/post")
    public String post(){
        return "board/post";
    }

    @PostMapping("/post")
    public String write(NoticeDto noticeDto){
        noticeService.saveNotice(noticeDto);
        return "redirect:/";
    }

}
