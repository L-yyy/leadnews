package com.heima.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.wemedia.dtos.SensitiveDto;
import com.heima.model.wemedia.pojos.WmSensitive;
import com.heima.wemedia.mapper.WmSensitiveMapper;
import com.heima.wemedia.service.WmSensitiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
@Transactional
public class WmSensitiveServiceImpl extends ServiceImpl<WmSensitiveMapper, WmSensitive> implements WmSensitiveService {

    /**
     * 添加敏感词
     * @param wmSensitive
     * @return
     */
    @Override
    public ResponseResult insert(WmSensitive wmSensitive) {
        //1.检验参数
        if (wmSensitive == null){
            return ResponseResult.okResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //是否已经存在
        WmSensitive sensitive = getOne(Wrappers.<WmSensitive>lambdaQuery().eq(WmSensitive::getSensitives, wmSensitive.getSensitives()));
        if (sensitive != null){
            return ResponseResult.okResult(AppHttpCodeEnum.DATA_EXIST);
        }

        //2.添加
        wmSensitive.setCreatedTime(new Date());
        save(wmSensitive);
        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 敏感词查询
     * @param dto
     * @return
     */
    @Override
    public ResponseResult findByNameAndPage(SensitiveDto dto) {
        //1,参数检验
        if (dto == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID );
        }
        //检查分页
        dto.checkParam();

        //2.模糊查询  分页
        IPage page = new Page(dto.getPage(), dto.getSize());
        LambdaQueryWrapper<WmSensitive> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (dto.getName() != null){
            lambdaQueryWrapper.like(WmSensitive::getSensitives, dto.getName());
        }
        page = page(page, lambdaQueryWrapper);

        //返回参数
        PageResponseResult responseResult = new PageResponseResult(dto.getPage(), dto.getSize(), (int) page.getTotal());
        responseResult.setData(page.getRecords());
        return responseResult;
    }

    /**
     * 修改铭感词
     * @param wmSensitive
     * @return
     */
    @Override
    public ResponseResult updateSensitive(WmSensitive wmSensitive) {

        //1.检查参数
        if (wmSensitive == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }

        //2.检查是否被引用
        WmSensitive one = getOne(Wrappers.<WmSensitive>lambdaQuery().eq(WmSensitive::getSensitives, wmSensitive.getSensitives()));
        if (one != null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "该敏感词已经存在");
        }

        //3.修改
        updateById(wmSensitive);

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }

    /**
     * 删除敏感词
     * @param id
     * @return
     */
    @Override
    public ResponseResult delete(Integer id) {

        //1.检查参数
        if (id == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "参数为空");
        }

        //2.检查是否存在
        WmSensitive one = getOne(Wrappers.<WmSensitive>lambdaQuery().eq(WmSensitive::getId, id));
        if (one == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "敏感词不存在");
        }

        //3.删除
        removeById(id);

        return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS);
    }


}
