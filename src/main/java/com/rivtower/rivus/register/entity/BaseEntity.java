package com.rivtower.rivus.register.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseEntity<T extends Serializable> implements Serializable {

  @TableId(type = IdType.AUTO)
  private T id;

  @TableField(fill = FieldFill.INSERT)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAt;

  private String createdBy;

  @TableField(fill = FieldFill.UPDATE)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updatedAt;

  @TableLogic
  protected Integer deleted = 0;

  private String updatedBy;
}
