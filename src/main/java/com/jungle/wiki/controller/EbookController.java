package com.jungle.wiki.controller;

import com.jungle.wiki.req.EbookReq;
import com.jungle.wiki.resp.CommonResp;
import com.jungle.wiki.resp.EbookResp;
import com.jungle.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/ebook")
public class EbookController {

    @Resource
    private EbookService ebookService;


    @GetMapping("/list")
    public CommonResp<List<EbookResp>> list(EbookReq req) {
        CommonResp<List<EbookResp>> resp = new CommonResp<>();
        List<EbookResp> list = ebookService.getList(req);
        resp.setContent(list);
        return resp;
    }

}
