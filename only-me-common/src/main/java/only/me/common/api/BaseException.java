package only.me.common.api;

/**
 * @program: only-me->BaseException
 * @description:
 * @author: szh
 * @create: 2022-01-24 16:17
 **/
public interface BaseException {
    int getCode();

    String getMessage();

    Object getError();
}
