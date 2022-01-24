package only.me.common.bo;

import io.swagger.annotations.ApiModel;
import only.me.common.api.ResultStatus;
import only.me.common.constant.ResultCode;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @program: only-me->ResponseUtil
 * @description:
 * @author: szh
 * @create: 2022-01-18 15:15
 **/
@ApiModel("统一响应消息报文")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean success;
    private T data;
    private Integer code;
    private String message;
    private Object error;
    private long time;


    public Result() {
        this.success = false;
        this.code = ResultCode.INTERNAL_SERVER_ERROR.getCode();
        this.message = ResultCode.INTERNAL_SERVER_ERROR.getMessage();
    }

    public Result(Integer code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, Object error) {
        this.success = false;
        this.code = code;
        this.message = message;
        this.error = error;
    }

    public Result(ResultStatus resultStatus) {
        this.success = false;
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMessage();
    }

    public Result(ResultStatus resultStatus, Object error) {
        this.success = false;
        this.code = resultStatus.getCode();
        this.message = resultStatus.getMessage();
        this.error = error;
    }

    public Result(final T data) {
        this.success = true;
        this.code = ResultCode.OK.getCode();
        this.message = ResultCode.OK.getMessage();
    }

    public Result(final Boolean success, final T data, ResultCode responseStatus) {
        this.success = success;
        this.code = responseStatus.getCode();
        this.message = responseStatus.getMessage();
    }

    public Result(final Boolean success, final T data, final Integer code, final String message) {
        this.success = success;
        this.data = data;
        this.code = code;
        this.message = message;
    }

    public Result(final Boolean success, final T data, final Integer code, final String message, Object error) {
        this.data = data;
        this.code = code;
        this.message = message;
        this.success = success;
        this.error = error;
    }


    public Boolean getSuccess() {
        return this.success;
    }

    public T getData() {
        return this.data;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getError() {
        return this.error;
    }

    public void setSuccess(final Boolean success) {
        this.success = success;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setError(final Object error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return (new StringJoiner(", ", Result.class.getSimpleName() + "[", "]"))
                .add("success=" + this.success).add("data=" + this.data).add("code=" + this.code)
                .add("message='" + this.message + "'").add("error=" + this.error).toString();
    }

}
