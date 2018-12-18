package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类-字符串处理
 *
 * @author zp
 * @since 2017年3月16日
 *
 */
public class StringUtil {

    protected final static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    /**
     * 字符串空处理，去除首尾空格 如果str为null，返回"",否则返回str
     *
     * @param str
     * @return
     */
    public static String isNull(String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    /**
     * 将对象转为字符串
     *
     * @param o
     * @return
     */
    public static String isNull(Object o) {
        if (o == null) {
            return "";
        }
        String str = "";
        if (o instanceof String) {
            str = (String) o;
        } else {
            str = o.toString();
        }
        return str.trim();
    }

    /**
     * 检验是否为空或空字符串
     *
     * @param str
     * @return
     */
    public static boolean isBlank(String str) {
        return StringUtil.isNull(str).equals("");
    }

    public static boolean isBlank(Object o) {
        return StringUtil.isNull(o).equals("");
    }

    /**
     * 检验是否非空字符串
     *
     * @param str
     * @return
     */
    public static boolean isNotBlank(String str) {
        return !StringUtil.isNull(str).equals("");
    }

    /**
     * 检验手机号
     *
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        phone = isNull(phone);
        Pattern regex = Pattern.compile("^1[3456789]{1}[0-9]{9}");
        Matcher matcher = regex.matcher(phone);
        boolean isMatched = matcher.matches();
        return isMatched;
    }

    /**
     * 校验是否全中文，返回true 表示是 反之为否
     *
     * @param realname
     * @return
     */
    public static boolean isChinese(String realname) {
        realname = isNull(realname);
        Pattern regex = Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$");
        Matcher matcher = regex.matcher(realname);
        boolean isMatched = matcher.matches();
        return isMatched;
    }

    /**
     * 校验邮箱格式
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        email = isNull(email);
        Pattern regex = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher matcher = regex.matcher(email);
        boolean isMatched = matcher.matches();
        return isMatched;
    }

    /**
     * 校验身份证号码
     *
     * @param
     * @return
     */
    public static boolean isCard(String cardId) {
        cardId = isNull(cardId);
        // 身份证正则表达式(15位)
        Pattern isIDCard1 = Pattern.compile("^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$");
        // 身份证正则表达式(18位)
        Pattern isIDCard2 = Pattern
                .compile("^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}([0-9]|X)$");
        Matcher matcher1 = isIDCard1.matcher(cardId);
        Matcher matcher2 = isIDCard2.matcher(cardId);
        boolean isMatched = matcher1.matches() || matcher2.matches();
        return isMatched;
    }

    /**
     * 判断字符串是否为整数
     *
     * @param str
     * @return
     */
    public static boolean isInteger(String str) {
        if (isBlank(str)) {
            return false;
        }
        Pattern regex = Pattern.compile("\\d*");
        Matcher matcher = regex.matcher(str);
        boolean isMatched = matcher.matches();
        return isMatched;
    }

    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumber(String str) {
        if (isBlank(str)) {
            return false;
        }
        Pattern regex = Pattern.compile("(-)?\\d*(.\\d*)?");
        Matcher matcher = regex.matcher(str);
        boolean isMatched = matcher.matches();
        return isMatched;
    }

    /**
     * 首字母大写
     *
     * @param s
     * @return
     */
    public static String firstCharUpperCase(String s) {
        StringBuffer sb = new StringBuffer(s.substring(0, 1).toUpperCase());
        sb.append(s.substring(1, s.length()));
        return sb.toString();
    }

    /**
     * 隐藏头几位
     *
     * @param str
     * @param len
     * @return
     */
    public static String hideFirstChar(String str, int len) {
        if (str == null)
            return null;
        char[] chars = str.toCharArray();
        if (str.length() <= len) {
            for (int i = 0; i < chars.length; i++) {
                chars[i] = '*';
            }
        } else {
            for (int i = 0; i < 1; i++) {
                chars[i] = '*';
            }
        }
        str = new String(chars);
        return str;
    }

    /**
     * 隐藏末几位
     *
     * @param str
     * @param len
     * @return
     */
    public static String hideLastChar(String str, int len) {
        if (str == null)
            return null;
        char[] chars = str.toCharArray();
        if (str.length() <= len) {
            return hideLastChar(str, str.length() - 1);
        } else {
            for (int i = chars.length - 1; i > chars.length - len - 1; i--) {
                chars[i] = '*';
            }
        }
        str = new String(chars);
        return str;
    }

    /**
     * 指定起始位置字符串隐藏
     *
     * @param str
     * @param index1
     * @param index2
     * @return
     */
    public static String hideStr(String str, int index1, int index2) {
        if (str == null)
            return null;
        String str1 = str.substring(index1, index2);
        String str2 = str.substring(index2);
        String str3 = "";
        if (index1 > 0) {
            str1 = str.substring(0, index1);
            str2 = str.substring(index1, index2);
            str3 = str.substring(index2);
        }
        char[] chars = str2.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = '*';
        }
        str2 = new String(chars);
        String str4 = str1 + str2 + str3;
        return str4;
    }

    /**
     * Object数组拼接为字符串
     * @param args
     * @return
     */
    public static String contact(Object[] args) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]);
            if (i < args.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * Long数组拼接为字符串
     * @param args
     * @return
     */
    public static String contact(long[] args) {
        if(args == null){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i]);
            if (i < args.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * 数字数组拼接为字符串
     *
     * @param arr
     * @return
     */
    public static String array2Str(int[] arr) {
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < arr.length; i++) {
            s.append(arr[i]);
            if (i < arr.length - 1) {
                s.append(",");
            }
        }
        return s.toString();
    }

    /**
     * 字符串数组转换为数字数组
     *
     * @param strarr
     * @return
     */
    public static int[] strarr2intarr(String[] strarr) {
        int[] result = new int[strarr.length];
        for (int i = 0; i < strarr.length; i++) {
            result[i] = Integer.parseInt(strarr[i]);
        }
        return result;
    }

    /**
     * 大写字母转成“_”+小写 驼峰命名转换为下划线命名
     *
     * @param str
     * @return
     */
    public static String toUnderline(String str) {
        char[] charArr = str.toCharArray();
        StringBuffer sb = new StringBuffer();
        sb.append(charArr[0]);
        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i] >= 'A' && charArr[i] <= 'Z') {
                sb.append('_').append(charArr[i]);
            } else {
                sb.append(charArr[i]);
            }
        }
        return sb.toString().toLowerCase();
    }

    /**
     * 下划线改成驼峰样子
     *
     * @param str
     * @return
     */
    public static String clearUnderline(String str) {
        char[] charArr = StringUtil.isNull(str).toLowerCase().toCharArray();
        StringBuffer sb = new StringBuffer();
        sb.append(charArr[0]);
        boolean isClear = false;
        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i] == '_') {
                isClear = true;
                continue;
            }
            if (isClear && (charArr[i] >= 'a' && charArr[i] <= 'z')) {
                char c = (char) (charArr[i] - 32);
                sb.append(c);
                isClear = false;
            } else {
                sb.append(charArr[i]);
            }

        }
        return sb.toString();
    }

    /**
     * String to int
     *
     * @param str
     * @return
     */
    public static int toInt(String str) {
        if (StringUtil.isBlank(str))
            return 0;
        int ret = 0;
        try {
            ret = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            ret = 0;
        }
        return ret;
    }

    public static byte toByte(String str) {
        if (StringUtil.isBlank(str))
            return 0;
        byte ret = 0;
        try {
            ret = Byte.parseByte(str);
        } catch (NumberFormatException e) {
            ret = 0;
        }
        return ret;
    }

    /**
     * String to Long
     *
     * @param str
     * @return
     */
    public static long toLong(String str) {
        if (StringUtil.isBlank(str))
            return 0L;
        long ret = 0;
        try {
            ret = Long.parseLong(str);
        } catch (NumberFormatException e) {
            ret = 0;
        }
        return ret;
    }


    /**
     * 字符串按照传入的格式转换为时间类型
     * @author lzy-user
     * @param format 要求时间格式
     * @param dateStr 字符串类型
     * @return 转换后的时间
     */
    public static Date stringToDate(String format,String dateStr){
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据身份证Id获取性别
     * @param cardId
     * @return
     */
    public static int getSex(String cardId) {
        int sexNum = 0;
        //15位的最后一位代表性别，18位的第17位代表性别，奇数为男，偶数为女
        if (cardId.length() == 15) {
            sexNum = cardId.charAt(cardId.length() - 1);
        } else {
            sexNum = cardId.charAt(cardId.length() - 2);
        }

        if (sexNum % 2 == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 根据身份证Id获取出生年月日
     * @param cardId
     * @return
     */
    public static String getBirthday(String cardId) {
        String birthday = "";
        //15位7-12位出生年月日 如590101 代表 19590101; 18位7-14位出生年月日如 19590101
        if (cardId.length() == 15) {
            birthday = "19" + cardId.substring(6, 12);
        } else {
            birthday = cardId.substring(6, 14);
        }
        return birthday;
    }

    /**
     * 根据身份证返回是几零后
     * @param cardId
     * @return
     */
    public static String getYears(String cardId) {
       String  birthday = null;
        //15位7-12位出生年月日 如590101 代表 19590101; 18位7-14位出生年月日如 19590101
        if (cardId.length() == 15) {
            birthday =  cardId.substring(6,7);
        } else if (cardId.length()==18){
            birthday =cardId.substring(8,9);
        }
        return birthday;
    }

    /**下划线转驼峰*/
    public static String lineToHump(String str){
        Pattern linePattern = Pattern.compile("_(\\w)");
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)})*/
    public static String humpToLine(String str){
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**驼峰转下划线,效率比上面高*/
    public static String humpToLine2(String str){
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(sb, "_"+matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 产生唯一 的序列号。
     *
     * @return
     */
    public static String getSerialNumber() {
        int hashCode = UUID.randomUUID().toString().hashCode();
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return sdf.format(DateUtil.getNow()).substring(2, 8)
                + String.format("%010d", hashCode);
    }

}
