package com.heima.model.wemedia.dtos;

import com.heima.model.common.dtos.PageRequestDto;
import lombok.Data;

@Data
public class WmMateriaDto extends PageRequestDto {

    /**
     * 1表示查询收藏的  0表示未收藏
     */
    private Short isCollection;


}
