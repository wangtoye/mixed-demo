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
 * 
 * </p>
 *
 * @author wangtoye
 * @since 2020-10-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class USign extends Model<USign> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户ID
     */
    private Long userId;

    private String realName;

    private String idCard;

    private String phone;

    /**
     * 商户ID
     */
    private Long dealerId;

    /**
     * 商户别名
     */
    private String dealerProductName;

    /**
     * 经济公司ID
     */
    private Long brokerId;

    /**
     * 经济公司别名
     */
    private String brokerProductName;

    /**
     * 审核人ID
     */
    private Long auditorId;

    /**
     * 审核人姓名
     */
    private String auditorName;

    /**
     * 签约状态 1 未签约 2 已签约 3 解除签约 -1无效状态
     */
    private Long auditeStatus;

    private Date gmtAudited;

    /**
     * 合约版本
     */
    private String principleVersion;

    /**
     * 签约来源:7:小程序(包含不签约),6:H5(包含不签约),5:api(包含商户签约调用api接口),4:批量签约(包含纸质签约和线下签约),3:excel导入预签约,2.任务库批量导入
     */
    private Integer signResource;

    /**
     * 当前用户签约类型:7:小程序(包含不签约),6:H5(包含不签约),5:api(包含商户签约调用api接口),4:批量签约(包含纸质签约和线下签约),3:excel导入预签约
     */
    private Integer currentSignModel;

    private Integer signResourceSupplement;

    /**
     * 月度限额超出校验
     */
    private Boolean monthQuotaCheck;

    /**
     * 2:两方协议,3:三方协议
     */
    private Integer signAgreement;

    /**
     * r_dealer_sign_order表中的id
     */
    private Long signOrderId;

    private Date gmtCreated;

    private Date gmtUpdated;

    /**
     * 1:信息未采集，2:办理中，3:已办理
     */
    private Integer processStatus;

    /**
     * 代付协议是否签约 0 未签约 1已签约
     */
    private Boolean pliAgreementSign;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
