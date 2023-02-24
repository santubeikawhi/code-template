package com.rivtower.rivus.register.domain.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ToString
public class BasePageReq implements Serializable {
  /**
   * 当前页面数据量
   */
  @ApiModelProperty("当前页面数据量")
  private int pageSize = 10;
  /**
   * 当前页码
   */
  @ApiModelProperty("当前页码")
  private int pageNum = 1;

  /**
   * 创建时间范围起点
   */
  @ApiModelProperty("创建时间范围起点")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAtBegin;
  /**
   * 创建时间范围终点
   */
  @ApiModelProperty("创建时间范围终点")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime createdAtEnd;
  /**
   * 修改时间范围起点
   */
  @ApiModelProperty("修改时间范围起点")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updatedAtBegin;
  /**
   * 修改时间范围终点
   */
  @ApiModelProperty("修改时间范围终点")
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime updatedAtEnd;

  /**
   * 排序字段
   */
  @ApiModelProperty("排序字段")
  private String field;

  /**
   * 排序规则,是否升序
   */
  @ApiModelProperty("排序规则,是否升序")
  private boolean asc;
}
