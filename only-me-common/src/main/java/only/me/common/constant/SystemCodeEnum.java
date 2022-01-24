package only.me.common.constant;

import only.me.common.api.ResultStatus;

/**
 * @program: only-me->SystemCodeEnum
 * @description:
 * @author: szh
 * @create: 2022-01-18 15:20
 **/
public enum SystemCodeEnum implements ResultStatus {
    SYSTEM_OK(0, "success"),
    SYSTEM_ERROR(500, "网络错误，请稍候再试"),
    SYSTEM_NOT_LOGIN(302, "请先登录！"),
    SYSTEM_BAD_REQUEST(403, "请求频率过快,请稍后再试"),
    SYSTEM_NO_AUTH(401, "无权操作"),
    SYSTEM_NO_FOUND(404, "资源未找到"),
    SYSTEM_NO_VALID(400, "参数验证错误"),
    SYSTEM_METHOD_ERROR(405, "请求方式错误"),
    SYSTEM_REQUEST_TIMEOUT(408, "请求超时"),
    SYSTEM_SERVER_ERROR(1001, "服务调用异常"),
    SYSTEM_NO_SUCH_PARAMENT_ERROR(1003, "参数不存在!"),
    SYSTEM_UPLOAD_FILE_ERROR(1004, "文件上传失败!"),
    SYSTEM_ES_UNSUPPROT_ERROR(1005, "不支持ES服务!");

    final Integer code;
    final String message;

    public static SystemCodeEnum parse(Integer status) {
        SystemCodeEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SystemCodeEnum value = var1[var3];
            if (value.getCode().equals(status)) {
                return value;
            }
        }

        return SYSTEM_ERROR;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    private SystemCodeEnum(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }
}
