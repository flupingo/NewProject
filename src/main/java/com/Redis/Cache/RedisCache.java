package com.Redis.Cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * Created：Jeffrey
 * date   ：2020/8/8 15:21
 */
public class RedisCache implements Cache {
    //当前放入缓存mapper的namespace
    public String id;

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void putObject(Object o, Object o1) {
        //序列化保存 key-->namespace(id)，field-->findAll生成key，value-->查询结果;
        //一个namespace放在一个key里




    }

    @Override
    public Object getObject(Object o) {
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    //执行增删改操作时，调用，不然缓存里是错误数据(查询)
    @Override
    public void clear() {

    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }

    public RedisCache(String id) {
        this.id = id;
    }
}
