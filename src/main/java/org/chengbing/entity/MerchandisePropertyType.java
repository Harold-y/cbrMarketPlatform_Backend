package org.chengbing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="MerchandisePropertyType对象", description="")
public class MerchandisePropertyType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "merch_property_type_id", type = IdType.AUTO)
    private Integer merchPropertyTypeId;

    private String merchPropertyTypeName;

    private Integer merchTypeId;
}
