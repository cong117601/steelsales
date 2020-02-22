package com.ycxy.steelsales.util;


import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;


/**
 *
 * 项目名称：JavaMail
 * 类名称：SendMail
 * 类描述：
 * 创建人：Ai
 * 创建时间：2018年5月2日 下午3:49:45
 * 修改人：Ai
 * 修改时间：2018年5月2日 下午3:49:45
 * 修改备注：javaMail封装代码
 * @version JM-0.1
 *
 */
@Component
public class SendMail {
    private final String username = "lijiahao961008@qq.com"; //发送邮件的邮箱
    private final String password = "vrueikpmrizsdehe";//发送邮箱的授权码
    private Authenticator auth = null;
    private MimeMessage mimeMessage = null;
    private Properties pros = null;
    private Multipart multipart = null;
    private BodyPart bodypart = null;

    /**
     * 初始化账号密码并验证 创建MimeMessage对象 发送邮件必须的步骤:1
     *
     * @param username
     * @param password
     */
    public SendMail() {
        Map<String, String> map = new HashMap<String, String>();
        // 你的发送邮箱账号 POP3/SMTP服务 授权码
        map.put("mail.smtp.host", "smtp.qq.com");
        map.put("mail.smtp.auth", "true");
        map.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        map.put("mail.smtp.port", "465");
        map.put("mail.smtp.socketFactory.port", "465");
        setPros(map);
        initMessage();
    }

    /**
     * 设置email系统参数 接收一个map集合key为string类型，值为String 发送邮件必须的步骤:2
     *
     * @param map
     */
    public boolean setPros(Map<String, String> map) {
        pros = new Properties();
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                pros.setProperty(entry.getKey(), entry.getValue());
            }
            System.out.println("设置email参数成功!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 初始化MimeMessage对象 发送邮件必须的步骤:3
     */
    public boolean initMessage() {
        this.auth = new Email_Autherticator();
        try {
            Session session = Session.getDefaultInstance(pros, auth);
            session.setDebug(false); // 设置获取 debug 信息
            mimeMessage = new MimeMessage(session);
            System.out.println("初始化成功!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 验证账号密码 发送邮件必须的步骤
     *
     * @author Administrator
     *
     */
    public class Email_Autherticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    }

    /**
     * 设置发送邮件的基本参数(去除繁琐的邮件设置)
     *
     * @param sub
     *            设置邮件主题
     * @param text
     *            设置邮件文本内容
     * @param rec
     *            设置邮件接收人
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public boolean setDefaultMessagePros(String sub, String text, String rec)
            throws MessagingException, UnsupportedEncodingException {
        try {
            mimeMessage.setSubject(sub);
            mimeMessage.setText(text);
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(rec));
            mimeMessage.setSentDate(new Date());
            mimeMessage.setFrom(new InternetAddress(username, username));
            System.out.println("设置邮件发送基本参数成功!（主题、内容、接收人）");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 设置主题
     *
     * @param subject
     * @throws MessagingException
     */
    public boolean setSubject(String subject) throws MessagingException {
        try {
            mimeMessage.setSubject(subject);
            System.out.println("设置邮件主题[" + subject + "]成功!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 设置日期
     *
     * @param date
     *            邮件发送的日期
     * @throws MessagingException
     */
    public boolean setDate(Date date) throws MessagingException {

        try {
            mimeMessage.setSentDate(date);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String format = sdf.format(date);
            System.out.println("设置邮件发送日期[" + format + "]成功!");
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    /**
     * 设置日期
     *
     * @param millisecond
     *            邮件延时发送时间(毫秒)  //暂不好使
     * @throws MessagingException
     */
    public boolean setDate(long millisecond) throws MessagingException {
        Date date = new Date();
        System.out.println(date);
        date.setTime(date.getTime() + millisecond);
        try {
            mimeMessage.setSentDate(date);
            System.out.println("设置邮件发送延时[" + millisecond + "]毫秒成功!");
        } catch (Exception e) {
            System.out.println("设置邮件发送日期[" + millisecond + "]失败!");
            return false;
        }
        return true;

    }


    /**
     * 设置邮件接收人地址 <单人发送>
     *
     * @param recipient
     * @throws MessagingException
     */
    public boolean setRecipient(String recipient) throws MessagingException {
        try {
            if (recipient.isEmpty()) {
                System.out.println("接收人地址为空!");
                return false;
            } else {
                mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
                System.out.println("设置接收人地址为[" + recipient + "]成功!");
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 设置邮件接收人地址 <多人发送>
     *
     * @param list
     * @throws MessagingException
     * @throws AddressException
     */
    public boolean setRecipients(List<String> recs) throws AddressException, MessagingException {
        try {
            if (recs.isEmpty()) {
                System.out.println("接收人地址为空!");
                return false;
            }
            for (String str : recs) {
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(str));
            }
            System.out.println("设置接收人地址" + recs + "成功!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 设置邮件接收人地址 <多人发送>
     *
     * @param StringBuffer<parms,parms2,parms.....>
     * @throws MessagingException
     * @throws AddressException
     */
    @SuppressWarnings("static-access")
    public boolean setRecipients(StringBuffer sb) throws AddressException, MessagingException {
        try {
            if (sb == null || "".equals(sb)) {
                System.out.println("字符串数据为空!");
                return false;
            }
            Address[] address = new InternetAddress().parse(sb.toString());
            mimeMessage.addRecipients(Message.RecipientType.TO, address);
            System.out.println("设置接收人地址[" + sb + "]成功!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 设置邮件发送人的名字
     *
     * @param from
     * @throws UnsupportedEncodingException
     * @throws MessagingException
     */
    public boolean setFrom(String from) throws UnsupportedEncodingException, MessagingException {
        try {
            if (from.isEmpty()) {
                System.out.println("邮件发送人名字为空!");
                return false;
            } else {
                mimeMessage.setFrom(new InternetAddress(username, from));
                System.out.println("设置邮件发送人名字[" + from + "]成功!");
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 发送邮件<单人发送> return 是否发送成功
     *
     * @throws MessagingException
     *             发送异常
     */
    public boolean sendMessage() {
        try {
            Transport.send(mimeMessage);
            System.out.println("----------------发送成功----------------");
            return true;
        } catch (MessagingException e) {
            return false;
        }
    }

    /**
     * 设置附件
     *
     * @param file
     *            发送文件的路径
     * @throws MessagingException
     *             发送异常
     * @throws IOException
     *             文件IO异常
     *
     */
    public boolean setMultipart(String file) throws MessagingException, IOException {
        try {
            if (multipart == null) {
                multipart = new MimeMultipart();
            }
            multipart.addBodyPart(writeFiles(file));
            mimeMessage.setContent(multipart);
            System.out.println("设置邮件附件" + file + "成功!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 设置附件<添加多附件>
     *
     * @param fileList<接收List集合>
     * @throws MessagingException
     *             发送异常
     * @throws IOException
     *             文件IO异常
     */
    public boolean setMultiparts(List<String> fileList) throws MessagingException, IOException {
        try {
            if (multipart == null) {
                multipart = new MimeMultipart();
            }
            for (String s : fileList) {
                multipart.addBodyPart(writeFiles(s));
            }
            mimeMessage.setContent(multipart);
            System.out.println("设置邮件附件" + fileList + "成功!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 发送文本内容，设置编码方式 <方法与发送附件配套使用> <发送普通的文本内容请使用setText()方法>
     *
     * @param s
     *            发送的文本内容
     * @param type
     *            编码格式
     * @throws MessagingException
     */
    public boolean setContent(String s, String type) throws MessagingException {
        try {
            if (multipart == null) {
                multipart = new MimeMultipart();
            }
            bodypart = new MimeBodyPart();
            bodypart.setContent(s, type);
            multipart.addBodyPart(bodypart);
            mimeMessage.setContent(multipart);
            mimeMessage.saveChanges();
            System.out.println("设置邮件内容[" + s + "]成功!");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 读取附件
     *
     * @param filePath
     *            文件路径
     * @return
     * @throws IOException
     * @throws MessagingException
     */
    public BodyPart writeFiles(String filePath) throws IOException, MessagingException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("文件不存在!请确定文件路径是否正确");
        }
        bodypart = new MimeBodyPart();
        DataSource dataSource = new FileDataSource(file);
        bodypart.setDataHandler(new DataHandler(dataSource));
        // 文件名要加入编码，不然出现乱码
        bodypart.setFileName(MimeUtility.encodeText(file.getName()));
        return bodypart;
    }
    //----------------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) throws MessagingException, IOException {
        SendMail mail = new SendMail();

        /*
         * 调用setRecipients(list);发送list集合类型 List<String> list = new
         * ArrayList<String>(); list.add("********@qq.com");
         */
        List<String> list = new ArrayList<String>();
        list.add("1981411580@qq.com");
        mail.setRecipients(list); // 输出信息

        // 邮件主题
        mail.setSubject("小比");

        // 发送时间 Date类型(默认即时发送)
        mail.setDate(new Date());
        //mail.setDate(100);

        // 发送者昵称
        mail.setFrom("CG");

        // 邮件内容
        mail.setContent("你的验证码为:<a>365415778</a>", "text/html; charset=UTF-8");

        // 附件集合
        List<String> fileList = new ArrayList<String>();

        // 添加附件
//        fileList.add("");
        mail.setMultiparts(fileList);

        mail.sendMessage(); // 是否发送成功
    }
}

