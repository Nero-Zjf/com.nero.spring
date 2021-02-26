package test.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

@Configuration//必须在定义@Configuration基础上@PropertySource才有效
@PropertySource("classpath:app.properties")//加载指定properties文件
public class ValueAnnotationTest {
    @Value("nero")
    private String name;// 注入普通字符串
    @Value("#{systemProperties['os.name']}")
    private String osName; // 注入操作系统属性
    @Value("#{ T(java.lang.Math).random() * 100.0 }")
    private double randomNumber; //注入表达式结果
    @Value("#{anotherBean.name}")
    private String fromAnotherBean; // 注入其他Bean属性
    @Value("classpath:beans.xml")
    private Resource resourceFile; // 注入文件资源
    @Value("http://www.baidu.com")
    private Resource testUrl; // 注入URL资源

    @Value("${app.name}")
    private String appName;//注入加载的properties
    @Value("${app.version}")
    private String appVersion;//注入加载的properties

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public double getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(double randomNumber) {
        this.randomNumber = randomNumber;
    }

    public String getFromAnotherBean() {
        return fromAnotherBean;
    }

    public void setFromAnotherBean(String fromAnotherBean) {
        this.fromAnotherBean = fromAnotherBean;
    }

    public Resource getResourceFile() {
        return resourceFile;
    }

    public void setResourceFile(Resource resourceFile) {
        this.resourceFile = resourceFile;
    }

    public Resource getTestUrl() {
        return testUrl;
    }

    public void setTestUrl(Resource testUrl) {
        this.testUrl = testUrl;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\":\"" + name + '\"' +
                ", \"osName\":\"" + osName + '\"' +
                ", \"randomNumber\":" + randomNumber +
                ", \"fromAnotherBean\":\"" + fromAnotherBean + '\"' +
                ", \"resourceFile\":" + resourceFile +
                ", \"testUrl\":" + testUrl +
                ", \"appName\":\"" + appName + '\"' +
                ", \"appVersion\":\"" + appVersion + '\"' +
                '}';
    }
}
