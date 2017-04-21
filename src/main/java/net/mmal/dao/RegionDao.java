package net.mmal.dao;

import net.mmal.entity.Region;

import java.util.List;

/**
 * 地区管理
 * @author hanyi
 * @date 2017年04月10日
 */
public interface RegionDao extends BaseDao<Region>{
    List<Region> queryAll();
}
