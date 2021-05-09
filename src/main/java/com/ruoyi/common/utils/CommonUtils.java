package com.ruoyi.common.utils;


import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 公共的数据类型
 */
@Component
public class CommonUtils {

    /**
     * 管理员
     **/
    public static final String USER_ADMIN = "admin";
    /**
     * 正常用户normal
     **/
    public static final String NORMAL_USER = "0";
    /**
     * 特殊用户
     **/
    public static final String SPECIAL_USER = "1";

    /**
     * 参数拼接
     **/
    public static final String PARAM = "1";

    /**
     * 计算积分
     * @param param
     * @return
     */
    public static Integer getIntegralInfo(Integer param)  {
        if(param>=10000){
            return 12;
        }else if(param>=8000 && param<=9999){
            return 9;
        }else if(param>=5000 && param<=7999){
            return 6;
        }else{
            return 3;
        }
    }

    /**
     * 计算月积分
     * @param param
     * @return
     */
    public static  Integer getPlusIntegralInfo(Integer integral,Integer param)  {
        if(param>10000){
            return integral<12?integral+1:12;
        }else if(param<=1000){
            return integral>0?integral-1:0;
        }else if(param>8000){
            return integral<12?integral+1:12;
        }else if(param<=8000){
            return integral>0?integral-1:0;
        }else if(param>5000){
            return integral<12?integral+1:12;
        }else if(param<=5000){
            return integral>0?integral-1:0;
        }else if(param>3000){
            return integral<12?integral+1:12;
        }else{
            return integral>0?integral-1:0;
        }
    }

    public static  String getIntegralJudge(Integer param)  {
        if(param>10000){
            return "+";
        }else if(param<=1000){
            return "-";
        }else if(param>8000){
            return "+";
        }else if(param<=8000){
            return "-";
        }else if(param>5000){
            return "+";
        }else if(param<=5000){
            return "-";
        }else if(param>3000){
            return "+";
        }else{
            return "-";
        }
    }
/** 获取*/
    /**
     * 计算两个集合差数
     **/
    public static <t> List getOthernessInfo(List param, List param1) {
        List<t> c = null;
        List<t> d = null;
        c = new ArrayList(param);
        c.retainAll(param1); // 得到  a, b 的交集。
        d = new ArrayList(param);
        d.addAll(param1); // 合并 a, b 值到 d 中。
        d.removeAll(c);// 去掉交集 c 中的所有条目。留下只出现在a 或 b 中的条目。
        return d;
    }
    /**
     * 截取小数点后两位
     */
    public static String getRateStr(String rateStr) {

        int i = rateStr.indexOf(".");
        if (i != -1) {
            //获取小数点的位置
            int num = 0;
            num = rateStr.indexOf(".");
            System.out.println(num + "=============");

            //获取小数点后面的数字 是否有两位 不足两位补足两位
            String dianAfter = rateStr.substring(0, num + 1);
            String afterData = rateStr.replace(dianAfter, "");
            if (afterData.length() < 2) {
                afterData = afterData + "0";
            }
            return rateStr.substring(0, num) + "." + afterData.substring(0, 2);
        } else {
            rateStr = rateStr + ".00";
            return rateStr;
        }
    }

    /**
     * LocalDateTime获取时间戳
     */
    public static Long getTimestamp(String time1, String time2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long time = null;
        if (time1 != null && time2 != null) {
            try {
                time = df.parse(time2).getTime() - df.parse(time1).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            Date date = new Date();
            try {
                time = date.getTime() - df.parse(time2).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return time;
    }


    /**
     * 生成随机数
     *
     * @return
     */
    public static String getRandom() {
        int max = 1000000, min = 1;
        int ran2 = (int) (Math.random() * (max - min) + min);
        return String.valueOf(ran2);
    }

    /**
     * 保留后两位小数
     *
     * @param param
     * @return
     */
    public static String getDecimaFormat(double param) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(param);
    }

    /**
     * 根据逗号截取字符串
     * @param param
     * @return
     */
    public static List<String> getCutOut(String param){
        List<String> paramList = new ArrayList<>();
        String substring = param.substring(0, param.length() - 1);
        String[] split = substring.split(",");
        for (String string2 : split) {
            paramList.add(string2);
        }
        return paramList;
    }


    /**
     *  读取文件
     * @return
     */
    public static List<String> getParkingIdInfo(){
        List<String> args = new LinkedList<>();
        try{
            ClassPathResource classPathResource = new ClassPathResource("parkingId.txt");
            InputStream inputStream = classPathResource.getInputStream();
            byte b[]=new byte[inputStream.available()];
            inputStream.read(b);
            inputStream.close();

            List<String> cutOut = getCutOut(new String(b));
            cutOut.stream().forEach(str ->{
                args.add(str);
            });
            System.out.println("读取到的内容是："+args.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
        return args;
    }

}





