package only.me.common.api;

/**
 * @program: only-me->IResponseUtilCode
 * @description:
 * @author: szh
 * @create: 2022-01-18 15:18
 **/
public interface ResultStatus {
    /**
     * code
     * @return
     */
    Integer getCode();

    /**
     * message
     * @return
     */
    String getMessage();
}
