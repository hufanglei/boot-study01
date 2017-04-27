package com.hfl.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by hfl on 2017-4-27.
 * 在@ConfigurationProperties注释中有两个属性：

 locations：指定配置文件的所在位置
 prefix：指定配置文件中键名称的前缀（我这里配置文件中所有键名都是以web.开头）
 使用@Component是让该类能够在其他地方被依赖使用，即使用@Autowired注释来创建实例。
 */
@ConfigurationProperties(locations = "classpath:config/my-web.properties", prefix = "web")
@Component
public class MyWebConfig {

    private String name;

    private String version;

    private String author;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
