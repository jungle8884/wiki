package com.jungle.utils;

import cn.hutool.core.date.StopWatch;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import com.jungle.utils.entity.ExcelEntity;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class postUtils {

    private static final String postUrl = "https://www.baidu.com/search/index?";
    private static String filePath = "/Users/jungle/Desktop/LYJ/file";
    private static String fileName = "test.xlsx";
    private static String fileOutName = "testOut.xlsx";
    private static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException {
        doPost();
    }

    private static void doPost() throws UnsupportedEncodingException, InterruptedException {
        ExcelReader reader = ExcelUtil.getReader(filePath + "//" + fileName);
        List<ExcelEntity> all = reader.readAll(ExcelEntity.class);
        ExcelWriter writer = ExcelUtil.getWriter(filePath + "//" + fileOutName);
        List<String> outList = new ArrayList<>();
        StopWatch stopWatch = new StopWatch("---执行时间统计---");
        int cnt = 0;
        for (ExcelEntity entity : all) {
            stopWatch.start("任务: " + (++cnt) + "开始");
            HttpClient client = HttpClients.createDefault();
            HttpPost post = setPostData(entity);
            try {
                HttpResponse response = client.execute(post);
                if (response != null){
                    System.out.println("任务:" + cnt + ":" + entity.getName()
                            + " request-->" + JSON.toJSONString(entity)
                            + " response-->" + JSON.toJSONString(response));
                }

                if (response.getStatusLine().getStatusCode() != 200
                        && !EntityUtils.toString(response.getEntity(), "UTF-8").contains("true")) {
                    outList.add(entity.getName() + "执行失败!");
                    System.out.println("执行失败!");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            } finally {
                Thread.sleep(1000);
            }
            stopWatch.stop();
            stopWatch.start("任务: " + (cnt) + "结束");
        }
        writer.write(outList);
        writer.close();
        System.out.println("总耗时: " + stopWatch.getTotalTimeSeconds());
    }

    private static HttpPost setPostData(ExcelEntity entity) throws UnsupportedEncodingException {
        HttpPost post = new HttpPost(postUrl);
        post.addHeader("Content-type", "application/x-www-form-urlencoded");

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        // nameValuePairs.add(new BasicNameValuePair("参数名", "参数值"));
        // 设置当前时间：date2String(new Date(), YYYY_MM_DD_HH_MM_SS);
        HttpEntity httpEntity = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
        post.setEntity(httpEntity);

        return post;
    }

    private static String date2String(Date date, String formatString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }

}
