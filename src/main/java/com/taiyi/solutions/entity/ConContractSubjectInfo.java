package com.taiyi.solutions.entity;

import java.math.BigDecimal;
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
 * 合同主体表
 * </p>
 *
 * @author wangtoye
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConContractSubjectInfo extends Model<ConContractSubjectInfo> {

    private static final long serialVersionUID=1L;

    /**
     * 操作者id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商户id
     */
    private Long dealerId;

    /**
     * 商户名称
     */
    private String dealerName;

    /**
     * 商户别名
     */
    private String dealerProductName;

    /**
     * 所属行业
     */
    private String dealerIndustryCategory;

    /**
     * 合作人群
     */
    private String memberCode;

    /**
     * 服务费
     */
    private BigDecimal feeRate;

    /**
     * 通知类型：1书面通知 2邮件通知
     */
    private Integer notifyType;

    /**
     * 审核状态：1待审核 2驳回 3通过
     */
    private Integer auditStatus;

    /**
     * 数据版本
     */
    private Integer version;

    /**
     * 操作者
     */
    private Long operatorId;

    /**
     * 操作者名称
     */
    private String operatorName;

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
