package com.taiyi.solutions.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 合同类型表
 * </p>
 *
 * @author wangtoye
 * @since 2020-10-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CContractCategory extends Model<CContractCategory> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 类型：1.b端 2.c端
     */
    private Integer type;

    /**
     * 添加时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtUpdate;

    /**
     * 删除标记 0未删除 1删除
     */
    @TableLogic
    private Integer isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
