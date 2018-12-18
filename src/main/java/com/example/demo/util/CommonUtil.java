package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

public class CommonUtil {
    public final static DateFormat YYYY_MM_DD = new SimpleDateFormat("yyyy-MM-dd");
    public final static DateFormat YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");

    public static Map<String, String> parseMap(Object a) {
        Map map = new HashMap();
        JSONObject json = JSON.parseObject(JSON.toJSONString(a));
        for (Entry entry : json.entrySet()) {
            if (entry.getValue() != null)
                map.put(entry.getKey(), entry.getValue().toString());
        }
        return map;
    }

    public static Map<String, String> parseMap(String a) {
        Map map = new HashMap();
        JSONObject json = JSON.parseObject(a);
        for (Entry entry : json.entrySet()) {
            if (entry.getValue() != null)
                map.put(entry.getKey(), entry.getValue().toString());
        }
        return map;
    }

    public static String formatDate(String format, Date time) {
        DateFormat _f = new SimpleDateFormat(format);
        return _f.format(time);
    }

    public static Map<String, String> parseRequestMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration em = request.getParameterNames();
        while (em.hasMoreElements()) {
            String name = (String) em.nextElement();
            String value = request.getParameter(name);
            map.put(name, value);
        }
        return map;
    }

    public static <T> T parseObject(Map<String, String> map, Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(map), clazz);
    }

    public static String simple(Date date) {
        return YYYYMMDDHHMMSS.format(date);
    }

    public static Date addMonth(Date today, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.MONTH, num);
        return c.getTime();
    }

    public static Date addDay(Date today, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, num);
        return c.getTime();
    }

    public static Date addHour(Date today, int num) {
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.HOUR_OF_DAY, num);
        return c.getTime();
    }


    public static int compareDay(Date fDate, Date oDate) {
        int day = 0;
        long time1 = fDate.getTime();
        long time2 = oDate.getTime();
        //day = (int) ((time2 - time1) / (24 * 60 * 60 * 1000));
        day = (int) (time2 / (24 * 60 * 60 * 1000) - time1 / (24 * 60 * 60 * 1000));
        return day;

    }

    public static String getRandom(int size) {
        String random = "";
        for (int i = 0; i < size; i++) {
            random += (int) (Math.random() * 10);
        }
        return random;
    }

    public static Date stringToDate(String dateString) {
        Date date = null;
        try {
            date = YYYY_MM_DD.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 返回两日期之间相差的日，时 ，分，秒
     *
     * @param param1
     * @param param2
     * @return
     */
    public static long[] getDistanceTimes(Date param1, Date param2) {
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        long time1 = param1.getTime();
        long time2 = param2.getTime();
        long diff;
        if (time2 > time1) {
            diff = time2 - time1;
        } else {
            diff = time1 - time2;
        }
        day = (diff / (24 * 60 * 60 * 1000));
        hour = (diff / (60 * 60 * 1000));
        min = (diff / (60 * 1000));
        sec = (diff / 1000);
        long[] times = {day, hour, min, sec};
        return times;
    }

    public static String getFormatTime(Date date, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String dt = dateFormat.format(date);
        return dt;
    }


    public static String parsePostParam(Map<String, String> map) {
        StringBuilder str = new StringBuilder();
        for (String key : map.keySet()) {
            str.append(key + "=" + map.get(key) + "&");
        }
        if (map.size() > 1)
            return str.toString().substring(0, str.toString().length() - 1);
        return str.toString();
    }

    public static Map extendMap(Map map1, Map map2) {
        for (Object key : map2.keySet()) {
            map1.put(key, map2.get(key));
        }
        return map1;
    }

    /**
     * 获取今天还剩下多少秒
     *
     * @return
     */
    public static int getSecond() {
        Calendar curDate = Calendar.getInstance();
        Calendar tomDate = new GregorianCalendar(curDate
                .get(Calendar.YEAR), curDate.get(Calendar.MONTH), curDate
                .get(Calendar.DATE) + 1, 0, 0, 0);
        return (int) (tomDate.getTimeInMillis() - curDate.getTimeInMillis()) / 1000;
    }

    public static String createPwd(String str, String key) {
        //return MD5Util.GetMD5Code(MD5Util.GetMD5Code(str));
        return MD5Util.MD5(str + key);
    }


}
