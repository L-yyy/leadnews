//package com.heima.wemedia.test;
//
//import com.heima.common.aliyun.GreenImageScan;
//import com.heima.common.aliyun.GreenTextScan;
//import com.heima.file.service.FileStorageService;
//import com.heima.wemedia.WemediaApplication;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
////@SpringBootTest(classes = WemediaApplication.class)
////@RunWith(SpringRunner.class)
//public class AliyunTest {
//
//    @Autowired
//    private GreenTextScan greenTextScan;
//
//    @Autowired
//    private FileStorageService fileStorageService;
//    @Autowired
//    private GreenImageScan greenImageScan;
//
//    /**
//     * 测试文本审核
//     */
//    @Test
//    public void testScanText() throws Exception{
//        Map map = greenTextScan.greeTextScan("审核内容");
//        System.out.println(map);
//    }
//
//    /**
//     * 测试图片审核
//     */
//    @Test
//    public void testScanImage() throws Exception {
//
//        byte[] bytes = fileStorageService.downLoadFile("http://192.168.200.130:9000/leadnews/2023/09/09/d955707b6b26435ebd7f0cbbe457c3c2.png");
//
//        List<byte []> list = new ArrayList<>();
//        list.add(bytes);
//
//        Map map = greenImageScan.imageScan(list);
//        System.out.println(map);
//    }
//
//}
