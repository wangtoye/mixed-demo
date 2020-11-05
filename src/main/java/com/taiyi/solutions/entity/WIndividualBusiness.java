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
 * 
 * </p>
 *
 * @author wangtoye
 * @since 2020-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WIndividualBusiness extends Model<WIndividualBusiness> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 当前进展
     */
    private Integer currentProgress;

    /**
     * 记录id
     */
    private Long recordId;

    /**
     * 签约合同地址
     */
    private String contractUrl;

    /**
     * 状态  0禁用 1启用 
     */
    private Integer status;

    /**
     * 营业执照url
     */
    private String businessUrl;

    /**
     * 统一组织结构编码
     */
    private String businessCode;

    /**
     * 创建人
     */
    private Long creatorId;

    /**
     * 创建人
     */
    private String creatorName;

    /**
     * 最后修改人ID
     */
    private Long updatorId;

    /**
     * 最后修改人
     */
    private String updatorName;

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
    @TableLogic
    private Integer isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
