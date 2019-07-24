package com.xq.mapper;

import com.xq.pojo.ErrorType;
import com.xq.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zhangyuexu on 2019-07-23
 */
public interface ErrorTypeMapper {

    @Insert("insert into error_type(error_type)VALUES(#{errorType})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(ErrorType et);


    @Select("select * from error_type")
    @Results({
            @Result(column = "error_type",property = "errorType")
    })
    List<ErrorType> getAllErrorType();

    @Select("select * from error_type where id = #{id}")
    @Results({
            @Result(column = "error_type",property = "errorType")
    })
    ErrorType getErrorTypeById(Long id);


    @Update("update error_type set error_type = #{errorType} where id = #{id}")
    int update(ErrorType et);


    @Delete("delete from error_type where id = #{errId}")
    int delete(Long errId);


}
