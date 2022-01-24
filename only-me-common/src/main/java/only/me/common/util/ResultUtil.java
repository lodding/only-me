package only.me.common.util;

import only.me.common.Exception.BusinessException;
import only.me.common.bo.Result;
import only.me.common.constant.ResultCode;
import only.me.common.api.ResultStatus;


/**
 * @program: only-me->ResultUtil
 * @description:
 * @author: szh
 * @create: 2022-01-24 15:39
 **/
public class ResultUtil<T> {


    public static <T> Result<T> OK() {
        return (Result<T>) OK((Object) null, ResultCode.OK.getCode(), ResultCode.OK.getMessage());
    }

    public static <T> Result<T> OK(final ResultStatus ResultStatus) {
        return (Result<T>) OK((Object) null, ResultStatus.getCode(), ResultStatus.getMessage());
    }

    public static <T> Result<T> OK(final String message) {
        return (Result<T>) OK((Object) null, ResultCode.OK.getCode(), message);
    }

    public static <T> Result<T> OK(final ResultStatus ResultStatus, final String message) {
        return (Result<T>) OK(ResultStatus, message);
    }

    public static <T> Result<T> OK(final T data) {
        return OK(data, ResultCode.OK.getCode(), ResultCode.OK.getMessage());
    }

    public static <T> Result<T> OK(final T data, final String message) {
        return OK(data, ResultCode.OK.getCode(), message);
    }

    public static <T> Result<T> OK(final T data, final ResultStatus ResultStatus) {
        return OK(data, ResultStatus.getCode(), ResultStatus.getMessage());
    }

    public static <T> Result<T> OK(final T data, final Integer code, final String message) {
        return new Result(true, data, code, message, (Object) null);
    }

    public static <T> Result<T> failed() {
        throw new BusinessException(ResultCode.INTERNAL_SERVER_ERROR.getCode(), ResultCode.INTERNAL_SERVER_ERROR.getMessage());
    }

    public static <T> Result<T> failed(final Integer code, final String message, Object error) {
        throw new BusinessException(code, message, error);
    }

    public static <T> Result<T> failed(final Integer code, final String message) {
        throw new BusinessException(code, message);
    }

    public static <T> Result<T> failed(final ResultStatus resultStatus) {
        throw new BusinessException(resultStatus.getCode(), resultStatus.getMessage());
    }

    public static <T> Result<T> failed(final ResultStatus resultStatus, Object error) {
        throw new BusinessException(resultStatus.getCode(), resultStatus.getMessage(), error);
    }
}
