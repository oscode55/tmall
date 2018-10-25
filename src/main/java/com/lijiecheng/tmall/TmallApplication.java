package com.lijiecheng.tmall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ProjectName: tmall
 * @Package: com.lijiecheng.tmall
 * @ClassName: TmallApplication
 * @Author: myname
 * @Description: ${description}
 * @Date: 2018/10/12 16:46
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.lijiecheng.tmall.dao")
public class TmallApplication {
    public static void main(String[] args) {
        SpringApplication.run(TmallApplication.class, args);
    }
}
