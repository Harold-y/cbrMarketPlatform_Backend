package org.chengbing.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
@ApiModel(value="MerchandiseSub对象", description="")
public class MerchandiseSub implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "merch_sub_id", type = IdType.AUTO)
    private Integer merchSubId;

    private Integer merchId;

    private String merchSubName;

    private BigDecimal merchSubPrice;

    private BigDecimal merchSubOnsalePrice;

    @ApiModelProperty(value = "0 for no longer sale, 1 for sale, 2 for on sale")
    private Integer merchSubStatus;

    private String merchSubPhotoUrl;

    @ApiModelProperty(value = "storage remaining")
    private Long merchSubRemaining;

    private LocalDateTime merchSubCreateDate;

    private LocalDateTime merchSubOnsaleEndDate;


}
