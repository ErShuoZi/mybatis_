package com.mapper;

import com.entity.IdenCard;

public interface IdenCardMapper {
    //根据 id 获取到身份证序列号
    public IdenCard getIdenCardById(Integer id);
}
