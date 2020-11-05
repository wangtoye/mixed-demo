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
 * 合同表
 * </p>
 *
 * @author wangtoye
 * @since 2020-10-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConContractInfo extends Model<ConContractInfo> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 主体id
     */
    private Integer subjectId;

    /**
     * 合同类型
     */
    private Integer contractType;

    /**
     * 合同编号
     */
    private String contractNo;

    /**
     * 是否标准协议 1是 2否
     */
    private Integer isStandard;

    /**
     * 是否特殊条款 1是 2否
     */
    private Integer isSpecial;

    /**
     * 特殊条款内容
     */
    private String specialProvisions;

    /**
     * 协议版本
     */
    private String contractVersion;

    /**
     * 授信额度
     */
    private BigDecimal creditAmount;

    /**
     * 授信周期
     */
    private Integer creditCycle;

    /**
     * 合作终止日期
     */
    private Date subjectEndTime;

    /**
     * 协议生效时间
     */
    private Date effectiveTime;

    /**
     * 协议失效时间
     */
    private Date expirationTime;

    /**
     * 协议文件地址
     */
    private String fileUrl;

    /**
     * 数据版本
     */
    private Integer version;

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
