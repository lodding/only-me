package only.me.common.config;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @program: only-me->SwaggerConfig
 * @description:
 * @author: szh
 * @create: 2022-01-11 08:47
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * SpringBoot默认已经将classpath:/META-INF/resources/和classpath:/META-INF/resources/webjars/映射
     * 所以该方法不需要重写，如果在SpringMVC中，可能需要重写定义（我没有尝试）
     * 重写该方法需要 extends WebMvcConfigurerAdapter
     */
   /* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }*/

    /**
     *
     * @return
     */
    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                // 排除
                if (declaringClass == BasicErrorController.class) {
                    return false;
                }
                // 被注解的类
                if (declaringClass.isAnnotationPresent(RestController.class)) {
                    return true;
                }
                // 被注解的方法
                if (input.isAnnotatedWith(ResponseBody.class)) {
                    return true;
                }
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(predicate)
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //大标题
                .title("swagger documentation")
                //详细描述
                .description("swagger REST API, all the applications could access the Object model data via JSON.")
                //版本
                .version("1.0")
                .termsOfServiceUrl("NO terms of service")
                //作者
                .contact(new Contact("哇哈哈", "www.baidu.com.com", "1612150596@qq.com"))
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }

}
