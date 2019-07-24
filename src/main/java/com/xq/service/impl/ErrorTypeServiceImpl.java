package com.xq.service.impl;

import com.xq.mapper.ErrorTypeMapper;
import com.xq.pojo.ErrorType;
import com.xq.service.ErrorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhangyuexu on 2019-07-23
 */
@Service
public class ErrorTypeServiceImpl implements ErrorTypeService {

    @Autowired
    private ErrorTypeMapper errorTypeMapper;

    @Override
    @Cacheable(cacheNames = "errorType")
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int addErrorType(ErrorType et) {
        int result = errorTypeMapper.insert(et);
        if(result > 0){
            int id = et.getId();
            return id;
        }

        return 0;
    }


    @Override
    @Cacheable(cacheNames = "errorTypes")
    public List<ErrorType> findAllErrorType() {
        return errorTypeMapper.getAllErrorType();
    }

    @Override
    @Cacheable(cacheNames = "errorType")
    public ErrorType findErrorTypeById(Long id) {
        return errorTypeMapper.getErrorTypeById(id);
    }

    @Override
    @CachePut(cacheNames = "updateErrorType",condition = "#et!=null",unless = "#result>0")
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int edit(ErrorType et) {
        return errorTypeMapper.update(et);
    }

    @Override
    @CacheEvict(cacheNames = "delErrorType",allEntries = true,beforeInvocation = true,condition = "#errId>0")
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public int delete(Long errId) {
        return errorTypeMapper.delete(errId);
    }
}
