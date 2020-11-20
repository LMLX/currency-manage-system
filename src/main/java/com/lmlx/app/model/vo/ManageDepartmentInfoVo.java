package com.lmlx.app.model.vo;

import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * @author jiahao jin
 * @create 2020-11-13 14:55
 */
@Data
public class ManageDepartmentInfoVo {
    private Long id;
    private String label;
//    private Long pDepartId;
//    private Long leader;
//    private Long creator;
//    private Date createTime;
//    private Long updator;
//    private Date updateTime;
    private List<ManageDepartmentInfoVo> child;
}
