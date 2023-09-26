package com.heima.wemedia.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.WmChannelDto;
//import com.heima.wemedia.service.WmChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/channel")
public class WmChannelController {

//    @Autowired
//    private WmChannelService wmChannelService;

//    /**
//     * 查询频道列表下拉框数据
//     * @return
//     */
//    @GetMapping("/channels")
//    public ResponseResult findAll(){
//        return wmChannelService.findAll();
//    }


    @PostMapping("/save")
    public ResponseResult saveChannel(@RequestBody WmChannelDto dto) {
//        return wmChannelService.saveChannel(dto);
        System.out.println("测试");
        System.out.println("测试");
        System.out.println("测试");
        System.out.println("测试");
        System.out.println("测试");
        System.out.println("测试");
        return null;
    }
}
