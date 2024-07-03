package only.me.common.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: only-me->WebMvcConfig
 * @description:配置类 需要添加@Configuration注解
 * 相当于一个Spring的xml配置文件(即application.xml)
 * @author: szh
 * @create: 2022-01-10 08:46
 **/
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    /**
     * 注入拦截器
     * 多个拦截器组成一个拦截器链 addPathPatterns 用于添加拦截规则，
     * /**表示拦截所有请求 excludePathPatterns 用户排除拦截 --白名单
     *
     * @return
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/resources/**", "/only/**");
    }


}
