package org.chengbing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author HaroldCI
 * @since 2022-01-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Merchandise对象", description="")
public class Merchandise implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "merch_id", type = IdType.AUTO)
    private Integer merchId;

    private Integer merchTypeId;

    private String merchName;

    private String merchPhotoFolder;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "${spring.jackson.time-zone}") //返回时间类型
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") //接收时间类型
    private LocalDateTime merchCreateDate;

    @ApiModelProperty(value = "0 for no longer active, 1 for sale, 2 for on sale")
    private Integer merchStatus;

    @ApiModelProperty(value = "the number of sale item of this year")
    private String merchYearSaleStat;

    @ApiModelProperty(value = "gongyi_zuanshi_prime etc")
    private Integer merchSpecial;

    private Integer personnelId;

    private Integer description;

    private String merchDescription;


}
