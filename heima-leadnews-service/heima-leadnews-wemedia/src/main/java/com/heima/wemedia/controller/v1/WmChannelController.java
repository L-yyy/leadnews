package com.heima.wemedia.controller.v1;

import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.wemedia.dtos.ChannelDto;
import com.heima.model.wemedia.dtos.WmChannelDto;
//import com.heima.wemedia.service.WmChannelService;
import com.heima.model.wemedia.pojos.WmChannel;
import com.heima.wemedia.service.WmChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/channel")
public class WmChannelController {

    @Autowired
    private WmChannelService wmChannelService;

//    /**
//     * 查询频道列表下拉框数据
//     * @return
//     */
//    @GetMapping("/channels")
//    public ResponseResult findAll(){
//        return wmChannelService.findAll();
//    }


    /**
     * 添加标签（由admin网关跳转到wemedia）
     * @param dto
     * @return
     */
    @PostMapping("/save")
    public ResponseResult saveChannel(@RequestBody WmChannel dto) {
        return wmChannelService.saveChannel(dto);
    }


    /**
     * 查询频道通过名称和页数
     * @param dto
     * @return
     */
    @PostMapping("/list")
    public ResponseResult findByNameAndPage(@RequestBody ChannelDto dto){
        return wmChannelService.findByNameAndPage(dto);
    }

    /**
     * 修改频道信息
     * @param wmChannel
     * @return
     */
    @PostMapping("/update")
    public ResponseResult updateChannel(@RequestBody WmChannel wmChannel){
        return wmChannelService.updateChannel(wmChannel);
    }

    /**
     * 根据id删除频道
     * @param id
     * @return
     */
    @GetMapping("/del/{id}")
    private ResponseResult deleteById(@PathVariable("id") Integer id){
        return wmChannelService.deleteById(id);
    }
}
