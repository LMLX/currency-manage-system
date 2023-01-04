package com.lmlx.currencymanagesystem;

import cn.hutool.core.date.DateUtil;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author jiahao jin
 * @create 2020-12-31 23:31
 */
public class Test {
    public static void main(String[] args) throws ParseException {
//        LocalDateTime localDateTime = new LocalDateTime()
//        System.out.println( Math.round(3*Math.random()));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//        Date d = sdf.parse("2021");
//        System.out.println(DateUtil.ageOfNow(d));
        String s = "317性别：女\n" +
                "籍贯：埭溪\n" +
                "所在地:市区\n" +
                "出生年月：1993\n" +
                "身高：162\n" +
                "体重：105\n" +
                "学历：本科\n" +
                "职业：法律咨询服务公司\n" +
                "年薪:10W+\n" +
                "婚姻：未\n" +
                "房车:湖州有房全款有车\n" +
                "父母情况:爸爸做生意，妈妈上班\n" +
                "自我评价:\n" +
                "择偶标准:有车有房，工作稳定，本地人，中等身材";
        String[] ss = s.split("\n");
        String line1 = ss[0];
        String[] line1s = null;
        try {
            if (line1.contains("性别:")) {
                line1s = line1.split("性别:");
            }
            if (line1.contains("性别：")) {
                line1s = line1.split("性别：");
            }
        } catch (Exception e) {

        }
        if (null == line1s) {
            String userName = "";
            Integer sex = 0;
        } else {
            String userName = line1s[0].trim();
            String sexStr = line1s[1].trim();
            Integer sex = "女".equals(sexStr) ? 2 : "男".equals(sexStr) ? 1 : 0;
            Integer account = Integer.parseInt(userName);
        }




    }
}
