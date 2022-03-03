package com.lmlx.app.model.so;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class ManageUserPhotoInfoSo {

    private static final long serialVersionUID =  1286952874912485248L;

    /**
     * ID主键
     */
    private Long id;
    private Long relationId;
    private String url;
    private Integer type;
}
