package com.lmlx.app.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value ="manage_user_photo_info" )
public class ManageUserPhotoInfoPo {

    private static final long serialVersionUID =  1286952874912485248L;

    /**
     * ID主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Long relationId;
    private String url;
    private Integer type;
}
