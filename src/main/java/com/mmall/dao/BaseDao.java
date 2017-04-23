package com.mmall.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author hanyi
 * @date 2017年04月08日
 */
public interface BaseDao<T> {
    int save(T t);

    int saveBatch(List<T> list);

    int update(T t);

    int delete(Object id);

    int deleteBatch(Object[] id);

    T queryById(@Param("id") Object id);

    List<T> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    int queryTotal();
}
