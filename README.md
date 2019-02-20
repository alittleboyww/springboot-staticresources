1. springboot默认静态资源的访问路径如下
```
classpath:/static
classpath:/public
classpath:/resources
classpath:/META-INF/resources
```

![图片](http://note.youdao.com/noteshare?id=d49927978503fff7094e04e6cc72cb3d&sub=A46610E18BBB4B7BA8B364D68FF45D55)

2. 默认静态资源映射路径其优先级为：META-INF/resources > resources > static > public
3. 静态资源文件配置说明,通过下面配置可以添加外部资源文件路径与映射
```
#默认值为 /**
#没设置在访问资源时为 http://localhost:8888
#设置了则需要加上设置了的路径 http://localhost:8888/dudu/..
#spring.mvc.static-path-pattern=/dudu/**
# 默认值为 classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/
#spring.resources.static-locations= 设置的路径

```
4. 通过类来说明路径和映射，代码如下
```
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurationSupport{
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mystatic/**").addResourceLocations("classpath:/mystatic/");
        super.addResourceHandlers(registry);
    }
}
```
通过addResourceHandler添加映射路径，然后通过addResourceLocations来指定路径。
```
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/waibu/**").addResourceLocations("file:E:/springbootstudy/waibu/");
        super.addResourceHandlers(registry);
    }
```
addResourceLocations指的是文件放置的目录，addResoureHandler指的是对外暴露的访问路径


5. WebMvcConfigurationSupport里面方法的具体方法的用处可以[查看](https://www.cnblogs.com/yangxiansen/p/7859991.html),里面内容都验证可用，[github地址](https://github.com/alittleboyww/springboot-staticresources.git)