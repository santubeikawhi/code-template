package com.rivtower.rivus.register.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rivtower.rivus.register.domain.req.BasePageReq;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.function.Consumer;

public abstract class RivTowerAbstractServiceImpl<M extends BaseMapper<T>, T, Q extends BasePageReq> extends
    ServiceImpl<M, T> {

  /**
   * 列表查询条件
   *
   * @param req
   * @return
   */
  protected QueryWrapper<T> condition(Consumer<QueryWrapper<T>> select, Q req) {
    QueryWrapper<T> queryWrapper = new QueryWrapper<>();
    if (ObjectUtils.isNotEmpty(select)) {
      select.accept(queryWrapper);
    }
    //自定义字段
    condition(queryWrapper, req);
    //自定义排序
    orderBy(queryWrapper, req);
    return queryWrapper;
  }

  /**
   * 列表查询条件
   *
   * @param req
   * @return
   */
  protected QueryWrapper<T> condition(Q req) {
    QueryWrapper<T> queryWrapper = new QueryWrapper<>();
    //自定义字段
    condition(queryWrapper, req);
    //自定义排序
    orderBy(queryWrapper, req);
    return queryWrapper;
  }

  /**
   * 自定义查询条件逻辑
   *
   * @param queryWrapper
   * @param req
   * @return
   */
  abstract QueryWrapper<T> condition(QueryWrapper<T> queryWrapper, Q req);

  protected void orderBy(QueryWrapper<T> queryWrapper, Q req) {
    if (StringUtils.isNotBlank(req.getField())) {
      FieldOrderBy(queryWrapper, req);
    } else {
      defaultOrderBy(queryWrapper, req);
    }
  }

  /**
   * 字段排序
   *
   * @param queryWrapper
   * @param req
   */
  protected void FieldOrderBy(QueryWrapper<T> queryWrapper, Q req) {
    StringBuilder sb = new StringBuilder(req.getField());
    int temp = 0;
    if (!req.getField().contains("_")) {
      for (int i = 0; i < req.getField().length(); i++) {
        if (Character.isUpperCase(req.getField().charAt(i))) {
          sb.insert(i + temp, "_");
          temp += 1;
        }
      }
    }
    queryWrapper.orderBy(true, req.isAsc(), sb.toString().toLowerCase());
  }

  /**
   * 默认排序
   *
   * @param queryWrapper
   * @param req
   */
  protected void defaultOrderBy(QueryWrapper<T> queryWrapper, Q req) {
    queryWrapper.orderByDesc("created_at", "updated_at", "id");
  }

  /**
   * 分页查询
   *
   * @param req
   * @return
   */
  public Page<T> page(Q req) {
    Page<T> page = new Page<>(req.getPageNum(), req.getPageSize());
    return this.page(page, condition(req));
  }

  /**
   * list查询
   *
   * @param req
   * @return
   */
  public List<T> list(Q req) {
    return this.list(condition(req));
  }

  /**
   * list查询-可选展示列
   *
   * @param req
   * @return
   */
  public Page<T> page(Consumer<QueryWrapper<T>> select, Q req) {
    Page<T> page = new Page<>(req.getPageNum(), req.getPageSize());
    return this.page(page, condition(select, req));
  }

  /**
   * list查询-可选展示列
   *
   * @param req
   * @return
   */
  public List<T> list(Consumer<QueryWrapper<T>> select, Q req) {
    return this.list(condition(select, req));
  }
}
