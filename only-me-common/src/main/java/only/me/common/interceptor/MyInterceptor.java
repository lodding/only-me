package only.me.common.interceptor;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import org.apache.catalina.authenticator.NonLoginAuthenticator;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @program: only-me->MyInterceptor
 * @description:所有拦截器都要实现HandlerInterceptor接口
 * @author: szh
 * @create: 2022-01-09 22:05
 **/

public class MyInterceptor implements HandlerInterceptor {

    /**
     * 预处理回调方法，实现处理器的预处理
     * 返回值：true表示继续流程；false表示流程中断，不会继续调用其他的拦截器或处理器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("执行拦截器");
        if (handler instanceof HandlerMethod) {
            String key = request.getParameter("key");
            if (StrUtil.isBlank(key)){
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write("这是拒绝访问");
                return false;
            }else {
                //逻辑

            }
            System.out.println("MyInterceptor 进入 :"+((HandlerMethod) handler).getBean().getClass().getName());
            System.out.println("Controller Name:" + ((HandlerMethod) handler).getBean().getClass().getName());
            System.out.println("Controller Method Name:" + ((HandlerMethod) handler).getMethod().getName());
        }

        request.setAttribute("startTime", System.currentTimeMillis());

        /**
         * boolean 值： 确定了拦截器其余两方法是否执行
         */
        return true;
    }


    /**
     * 后处理回调方法，实现处理器（controller）的后处理，但在渲染视图之前
     * 此时我们可以通过modelAndView对模型数据进行处理或对视图进行处理
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor 运行 Controller 某个方法时，方法抛出异常将不进入此方法");
        long start = (Long) request.getAttribute("startTime");
        System.out.println("MyInterceptor 处理时长为：" + (System.currentTimeMillis() - start));
    }

    /**
     * 整个请求处理完毕回调方法，即在视图渲染完毕时回调，
     * 如性能监控中我们可以在此记录结束时间并输出消耗时间，
     * 还可以进行一些资源清理，类似于try-catch-finally中的finally，
     * 但仅调用处理器执行链中
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("TimeInterceptor 完成 Controller 某个方法");
        long start = (Long) request.getAttribute("startTime");
        System.out.println("TimeInterceptor 处理时长为：" + (System.currentTimeMillis() - start));
        System.out.println(">>>MyInterceptor1>>>>>>>在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");

    }

}
