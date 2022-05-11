package com.MybatisPlus.Test;

import com.MybatisPlus.Test.BaseMapper;
import com.MybatisPlus.Test.IService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created：Jeffrey
 * date   ：2022/3/13 17:46
 */
public class IServiceImpl<K extends BaseMapper> implements IService {
    @Autowired
    BaseMapper baseMapper;

    @Override
    public Object findOne() {
        return baseMapper.findOne();
    }
}
