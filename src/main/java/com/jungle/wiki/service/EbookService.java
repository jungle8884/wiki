package com.jungle.wiki.service;

import com.jungle.wiki.entity.Ebook;
import com.jungle.wiki.entity.EbookExample;
import com.jungle.wiki.mapper.EbookMapper;
import com.jungle.wiki.req.EbookReq;
import com.jungle.wiki.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用@Service注解, 将这个Service交给Spring来管理 
 * @author Jungle 
 * @version 2022/11/12 12:09
**/
@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> getList(EbookReq req) {
        // 相当于 查询条件 Where
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebooksList = ebookMapper.selectByExample(ebookExample);
        List<EbookResp> ebookRespList = covertEntity(ebooksList);

        return ebookRespList;
    }

    private List<EbookResp> covertEntity(List<Ebook> ebooksList) {
        List<EbookResp> res = new ArrayList<>();
        for (Ebook ebook : ebooksList) {
            EbookResp ebookResp = new EbookResp();
            BeanUtils.copyProperties(ebook, ebookResp);
            res.add(ebookResp);
        }

        return res;
    }


}
