package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author wer
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class StatisticsApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(StatisticsApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  统计系统启动成功   ლ(´ڡ`ლ)ﾞ  \n" );
    }
}