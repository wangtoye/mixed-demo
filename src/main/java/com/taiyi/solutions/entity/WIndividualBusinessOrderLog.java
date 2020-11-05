package com.taiyi.solutions.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 个体工商户订单操作日志表
 * </p>
 *
 * @author wangtoye
 * @since 2020-09-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WIndividualBusinessOrderLog extends Model<WIndividualBusinessOrderLog> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号
     */
    private Long orderId;

    /**
     * 操作人id
     */
    private Long operatorId;

    /**
     * 操作人姓名
     */
    private String operatorName;

    /**
     * 订单状态
     */
    private Integer orderStatus;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改时间
     */
    private Date gmtUpdated;

    /**
     * 删除标记：0未删除 1已删除
     */
    private Integer isDelete;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
