package only.me.common.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Objects;

/**
 * @program: only-me->Result
 * @description:
 * @author: szh
 * @create: 2022-01-18 15:15
 **/
@ApiModel("统一响应消息报文")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
            value = "状态码",
            required = true
    )
    private int code;
    @ApiModelProperty(
            value = "消息内容",
            required = true
    )
    private String msg;
    @ApiModelProperty(
            value = "时间戳",
            required = true
    )
    private long time;
    @ApiModelProperty("业务数据")
    @JsonInclude(Include.NON_NULL)
    private T data;

    private Result() {
        this.time = System.currentTimeMillis();
    }

    private Result(IResultCode resultCode) {
        this(resultCode, (T) null, resultCode.getMsg());
    }

    private Result(IResultCode resultCode, String msg) {
        this(resultCode, (T) null, msg);
    }

    private Result(IResultCode resultCode, T data) {
        this(resultCode, data, resultCode.getMsg());
    }

    private Result(IResultCode resultCode, T data, String msg) {
        this(resultCode.getCode(), data, msg);
    }

    private Result(int code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.time = System.currentTimeMillis();
    }

    public static <T> Result<T> success(IResultCode resultCode) {
        return new Result(resultCode);
    }

    public static <T> Result<T> success() {
        return new Result(ResultCode.SUCCESS);
    }

    public static <T> Result<T> success(String msg) {
        return new Result(ResultCode.SUCCESS, msg);
    }

    public static <T> Result<T> success(IResultCode resultCode, String msg) {
        return new Result(resultCode, msg);
    }

    public static <T> Result<T> data(T data) {
        return data(data, "处理成功");
    }

    public static <T> Result<T> data(T data, String msg) {
        return data(ResultCode.SUCCESS.code, data, msg);
    }

    public static <T> Result<T> data(int code, T data, String msg) {
        return new Result(code, data, data == null ? "承载数据为空" : msg);
    }

    public static <T> Result<T> failed() {
        return new Result(ResultCode.FAILURE);
    }

    public static <T> Result<T> failed(String msg) {
        return new Result(ResultCode.FAILURE, msg);
    }

    public static <T> Result<T> failed(int code, String msg) {
        return new Result(code, (Object)null, msg);
    }

    public static <T> Result<T> failed(IResultCode resultCode) {
        return new Result(resultCode);
    }

    public static <T> Result<T> failed(IResultCode resultCode, String msg) {
        return new Result(resultCode, msg);
    }

    public static <T> Result<T> condition(boolean flag) {
        return flag ? success("处理成功") : failed("处理失败");
    }

    public boolean hasSuccess() {
        return Objects.equals(ResultCode.SUCCESS.getCode(), this.code);
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public void setTime(final long time) {
        this.time = time;
    }

    public void setData(final T data) {
        this.data = data;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result<?> other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else if (this.getTime() != other.getTime()) {
                return false;
            } else {
                label40: {
                    Object this$msg = this.getMsg();
                    Object other$msg = other.getMsg();
                    if (this$msg == null) {
                        if (other$msg == null) {
                            break label40;
                        }
                    } else if (this$msg.equals(other$msg)) {
                        break label40;
                    }

                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Result;
    }

    @Override
    public int hashCode() {
        boolean PRIME = true;
        int resultInt = 1;
        int result = resultInt * 59 + this.getCode();
        long $time = this.getTime();
        result = result * 59 + (int)($time >>> 32 ^ $time);
        Object $msg = this.getMsg();
        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Result(code=" + this.getCode()+ ", " +
                "msg=" + this.getMsg() + ", time=" + this.getTime() + ", data=" + this.getData() + ")";
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public long getTime() {
        return this.time;
    }

    public T getData() {
        return this.data;
    }
}
