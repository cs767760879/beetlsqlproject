package com.lianxun;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


@Configuration
@EnableSwagger2
public class Swagger2 {

    @Autowired
    private Environment env;

/**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     *
     * @return
     */

    @Bean
    public Docket createRestApi() {

        ParameterBuilder aParameterBuilder = new ParameterBuilder();
        Parameter build = aParameterBuilder
                .parameterType("header") //参数类型支持header, cookie, body, query etc
                .name("Accept-Language") //参数名
                .defaultValue("zh-CN") //默认值
                .description("语言")
                .modelRef(new ModelRef("string"))//指定参数值的类型
                .required(false)
//                .parameterType("header") //参数类型支持header, cookie, body, query etc
//                .name("hospital_id") //参数名
//                .defaultValue("1") //默认值
//                .description("医院")
//                .modelRef(new ModelRef("string"))//指定参数值的类型
//                .required(false)
                .build();//非必需，这里是全局配置

        List<Parameter> pars = new ArrayList<>();
        pars.add(build);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lianxun"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);
    }

/**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     *
     * @return
     */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("联讯面试CRUD")
                .description("dev: http://localhost:8080 \n   " +
                        "本程序现在运行时地址 : http://" + getRealIp() + ":" + env.getProperty("server.port"))
                .termsOfServiceUrl("http://" + getRealIp() + ":" + env.getProperty("server.port"))
                .version("1.0")
                .build();
    }


    public static String getRealIp() {
        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String netip = null;// 外网IP

        Enumeration<NetworkInterface> netInterfaces = null;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        InetAddress ip = null;
        boolean finded = false;// 是否找到外网IP
        while (netInterfaces.hasMoreElements() && !finded) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                ip = address.nextElement();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                    netip = ip.getHostAddress();
                    finded = true;
                    break;
                } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
                        && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                    localip = ip.getHostAddress();
                }
            }
        }

        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }

}
