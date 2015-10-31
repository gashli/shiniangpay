package com.shin.pay.main;

import com.shin.pay.utils.DateUtil;
import com.shin.pay.utils.Email;
import org.junit.Test;

import java.util.Date;

/**
 * @Author gaoshiliang
 * @Date 15/10/27.
 */
public class MailTest extends BaseTest {

    @Test
    public void MailTest_A() {
        Email.sendEmail(Email.OPERATORS, "这是一封测试邮件", getSubject());
    }

    private String getSubject() {
        StringBuffer strbu = new StringBuffer();
        boolean isNewMsg = true;
        strbu.append("操作时间：")
                .append(DateUtil.date2Str(new Date(), "yyyy-MM-dd HH:mm:ss"))
                .append("<br>");
        strbu.append("操作功能：").append("字典管理-同步DOD").append("<br>");
        strbu.append("同步结果：").append("<br>");
        if (isNewMsg) {
            strbu.append("&nbsp;&nbsp;&nbsp;&nbsp;同步成功，无新内容。").append("<br>");
        } else {
            strbu.append("<br>请运营同学及时添加别名及别名简称。");
        }

        String sign = "<br><br>============================================================<br>"
                + "	地址： 北京市海淀区丹棱街1号互联网金融中心8层，100080<br>"
                + "	Floor 8, Internet Finance Center,yard 1,Danling street, Haidian District, Beijing, China" + "<br>"
                + "============================================================<br>"
                + "	http://www.qunar.com &nbsp;&nbsp;&nbsp;&nbsp; Think.Search.Travel！<br>"
                + "	“去哪儿”旅游搜索 &nbsp;&nbsp;&nbsp;&nbsp; 聪明你的旅行！";
        strbu.append(sign);

        return strbu.toString();
    }
}
