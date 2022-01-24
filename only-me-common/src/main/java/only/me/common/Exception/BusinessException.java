package only.me.common.Exception;


import only.me.common.api.BaseException;
import only.me.common.api.ResultStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: w_parent->BusinessException
 * @description:
 * @author: szh
 * @create: 2020-07-28 16:18
 **/
public final class BusinessException extends RuntimeException implements BaseException {

    private static final long serialVersionUID = -5316066944575141688L;
    public int code;
    public String message;
    public Object error;

    private BusinessException() {
    }

    public BusinessException(final int code, final String message) {
        super("code:" + code + ",message:" + message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(final int code, final String message, final Object error) {
        super("code:" + code + ",message:" + message);
        this.code = code;
        this.message = message;
        this.error = error;
    }

    public BusinessException(final ResultStatus ResultStatus) {
        super("code:" +ResultStatus.getCode() + ",message:" + ResultStatus.getMessage());
        this.code = ResultStatus.getCode();
        this.message = ResultStatus.getMessage();
    }

    public BusinessException(final ResultStatus ResultStatus, final Object error) {
        super("code:" + ResultStatus.getCode() + ",message:" + ResultStatus.getMessage());
        this.code = ResultStatus.getCode();
        this.message = ResultStatus.getMessage();
        this.error = error;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public BusinessException append(final String appendMessage) {
        this.message = this.message + "::" + appendMessage;
        return this;
    }

    @Override
    public Throwable fillInStackTrace() {
        super.fillInStackTrace();
        StackTraceElement[] stackTrace = this.getStackTrace();
        this.setStackTrace(stackTrace);
        return this;
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        List<StackTraceElement> stackTraceElementList = new ArrayList();
        StackTraceElement[] stackTraceElementArray = super.getStackTrace();
        StackTraceElement[] var3 = stackTraceElementArray;
        int var4 = stackTraceElementArray.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            StackTraceElement stackTraceElement = var3[var5];
            if (stackTraceElement.getClassName().startsWith("com.vd.canary")) {
                stackTraceElementList.add(stackTraceElement);
            }
        }

        stackTraceElementArray = (StackTraceElement[])stackTraceElementList.toArray(new StackTraceElement[stackTraceElementList.size()]);
        return stackTraceElementArray;
    }


    @Override
    public int getCode() {
        return this.code;
    }


    @Override
    public Object getError() {
        return this.error;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setError(final Object error) {
        this.error = error;
    }
}
