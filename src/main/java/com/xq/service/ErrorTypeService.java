package com.xq.service;

import com.xq.pojo.ErrorType;

import java.util.List;

/**
 * Created by zhangyuexu on 2019-07-23
 */
public interface ErrorTypeService {

    int addErrorType(ErrorType et);

    List<ErrorType> findAllErrorType();

    ErrorType findErrorTypeById(Long id);

    int edit(ErrorType et);

    int delete(Long errId);
}
