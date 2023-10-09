package com.heima.wemedia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.wemedia.dtos.NewsAuthDto;
import com.heima.model.wemedia.pojos.WmNews;
import com.heima.model.wemedia.vo.WmNewsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WmNewsMapper  extends BaseMapper<WmNews> {

    /**
     * 媒体盛和列表分页查询
     * @param dto
     * @return
     */
    List<WmNewsVo> findListAndPage(@Param("dto") NewsAuthDto dto);

    /**
     * 媒体审核总条数
     * @param dto
     * @return
     */
    int findListCount(@Param("dto") NewsAuthDto dto);
}