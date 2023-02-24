package com.rivtower.rivus.register.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseVo<T extends Serializable> implements Serializable {

  @ApiModelProperty("删除标记")
  protected Integer deleted;
  @ApiModelProperty("id")
  private T id;
  @ApiModelProperty("创建时间")
  private LocalDateTime createdAt;
  @ApiModelProperty("更新时间")
  private LocalDateTime updatedAt;
}
