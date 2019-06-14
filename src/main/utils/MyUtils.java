package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 自定义工具类Java版本
 *
 * @author Hiwes
 * @version 1.0
 */
public class MyUtils {
    private static List<String> originalList;

    /**
     * 获取数组中不重复的n个元素
     */
    public static String[] getRandomArray(String[] paramArray, int count) {
        if (paramArray.length < count) {
            return paramArray;
        }
        String[] newArray = new String[count];
        Random random = new Random();
        int temp;//接收产生的随机数
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            temp = random.nextInt(paramArray.length);//将产生的随机数作为被抽数组的索引
            if (!(list.contains(temp))) {
                newArray[i - 1] = paramArray[temp];
                list.add(temp);
            } else {
                i--;
            }
        }
        return newArray;
    }

    /**
     * 获取列表中不重复的n个元素
     */
    public static List<String> getRandomList(List<String> top100, int count) {
        if (top100.size() < count) {
            return top100;
        }
        Random random = new Random();
        List<Integer> tempList = new ArrayList<>();
        List<String> newList = new ArrayList<>();
        int temp;
        for (int i = 0; i < count; i++) {
            temp = random.nextInt(top100.size());// 将产生的随机数作为被抽list的索引
            if (!tempList.contains(temp)) {
                tempList.add(temp);
                newList.add(top100.get(temp));
            } else {
                i--;
            }
        }
        return newList;
    }

    /**
     * 获取数组的重新随机排序结果
     */
    public static String[] getRandomSequenceArray(String[] paramArray) {
        String[] tempArr = new String[paramArray.length];
        Random random = new Random(new Date().getTime());
        int randomIndex = -1;
        for (int i = 0; i < tempArr.length; i++) {
            while (tempArr[i] == null) {
                randomIndex = random.nextInt(paramArray.length);
                if (paramArray[randomIndex] != null) {
                    tempArr[i] = paramArray[randomIndex];
                    paramArray[randomIndex] = null;
                }
            }
        }
        return tempArr;
    }

    // 获取去重String数组
    public static String[] getDistinctArray(String[] arr) {
        originalList = new ArrayList<>();
        for (String s : arr) {
            if (!originalList.contains(s)) {
                originalList.add(s);
            }
        }
        String[] newArr = new String[originalList.size()];
        return originalList.toArray(newArr);
    }

    /**
     * 使用 Map按value进行排序
     *
     * @param
     * @return
     */
    public static Map<String, String> sortMapByValue(Map<String, String> oriMap) {
        if (oriMap == null || oriMap.isEmpty()) {
            return null;
        }
        Map<String, String> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<String, String>> entryList = new ArrayList<>(
                oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, String>> iter = entryList.iterator();
        Map.Entry<String, String> tmpEntry;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }

    /**
     * 获取两个时间中的所有天
     *
     * @param time1
     * @param time2
     * @return
     */
    public static List<String> checkTime(String time1, String time2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        Date da1 = null;
        Date da2 = null;
        try {
            da1 = fmt.parse(time1);
            da2 = fmt.parse(time2);
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
        //定义一个接受时间的集合
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(da1);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(da1);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(da2);
        // 测试此日期是否在指定日期之后
        while (da2.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }

        List<String> strList = new ArrayList<>();
        for (Date d : lDate) {
            SimpleDateFormat fmt2 = new SimpleDateFormat("yyyyMMdd");
            String need = fmt2.format(d);
            strList.add(need);
        }
        return strList;
    }

    /**
     * 获取时间所在年的目前为止所有月
     *
     * @param time2
     * @return
     */
    public static List<String> checkMonth(String time2) {
        List<String> strList = new ArrayList<>();
        String year = time2.substring(0, 4);
        int month = Integer.valueOf(time2.substring(4, 6));
        for (int i = 1; i <= month; i++) {
            String monthTime;
            if (i < 10) {
                monthTime = year + "0" + i;
            } else {
                monthTime = year + i;
            }
            strList.add(monthTime);
        }
        return strList;
    }

}
