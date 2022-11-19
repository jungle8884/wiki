package com.jungle.wiki.service;

import com.jungle.wiki.entity.Ebook;
import com.jungle.wiki.entity.EbookExample;
import com.jungle.wiki.mapper.EbookMapper;
import com.jungle.wiki.req.EbookReq;
import com.jungle.wiki.resp.EbookResp;
import com.jungle.wiki.util.CopyUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
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
        if (!ObjectUtils.isEmpty(req.getName())) {
            criteria.andNameLike("%" + req.getName() + "%");
        }
        List<Ebook> ebooksList = ebookMapper.selectByExample(ebookExample);
        return clazzConverter(ebooksList);

    }

    /**
     * 类转换器
     * */
    private List<EbookResp> clazzConverter(List<Ebook> ebooksList) {
         /*List<EbookResp> res = new ArrayList<>();
         for (Ebook ebook : ebooksList) {
             //EbookResp ebookResp = new EbookResp();
             //BeanUtils.copyProperties(ebook, ebookResp);
             // 对象复制
             EbookResp ebookResp = CopyUtil.copy(ebook, EbookResp.class);
             res.add(ebookResp);
         }
         return res;*/
        // 列表复制
        return CopyUtil.copyList(ebooksList, EbookResp.class);
    }


}
