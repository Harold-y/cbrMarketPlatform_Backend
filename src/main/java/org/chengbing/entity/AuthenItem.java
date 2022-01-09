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
@ApiModel(value="AuthenItem对象", description="")
public class AuthenItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "auth_item_id", type = IdType.AUTO)
    private Integer authItemId;

    private String authItemName;

    private String authItemDescription;


}
