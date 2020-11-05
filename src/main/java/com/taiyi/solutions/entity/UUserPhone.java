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
 * 用户手机信息
 * </p>
 *
 * @author wangtoye
 * @since 2020-10-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UUserPhone extends Model<UUserPhone> {

    private static final long serialVersionUID=1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 归属地省编码
     */
    private Integer addrProvinceCode;

    /**
     * 归属地省
     */
    private String addrProvince;

    /**
     * 归属地市编码
     */
    private Integer addrCityCode;

    /**
     * 归属地市
     */
    private String addrCity;

    /**
     * 运营商:0未知 1移动 2联通 3电信
     */
    private Integer phoneType;

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
