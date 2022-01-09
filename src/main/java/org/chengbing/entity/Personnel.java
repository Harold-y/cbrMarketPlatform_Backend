package org.chengbing.entity;

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
@ApiModel(value="Personnel对象", description="")
public class Personnel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "personnel_id", type = IdType.AUTO)
    private Integer personnelId;

    private Integer personnelStatus;

    private Integer personnelTypeId;

    private String personnelFirstName;

    private String personnelMidName;

    private String personnelLastName;

    private LocalDateTime personnelEnrollTime;

    private LocalDateTime personnelResignTime;

    private String personnelEmail;

    private String personnelPassword;


}
