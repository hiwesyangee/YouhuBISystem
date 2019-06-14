package test;

import engine.*;
import engine.Number;
import org.apache.htrace.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 对结果数据进行封装
 */
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        String reqBody = sb.toString();
        String[] arr = reqBody.split("\"");

        // 获取前端参数
        String type = arr[3];
        String time1 = arr[7];
        String time2 = arr[11];
        System.out.println(arr[3]);
        System.out.println(arr[7]);
        System.out.println(arr[11]);

        List<Object> list = new ArrayList<>();

        String startTime = time1.replaceAll("-", "");
        String stopTime = time2.replaceAll("-", "");

        if (type.equals("number")) {
            if (startTime.equals(stopTime)) {  // 查询一天人数
                System.out.println("查询一天人数");
                List<Number> inList = NumberInterface.getDayNumber(startTime);  // 人数方法1
                list.addAll(inList);
            } else {  // 查询多天人数
                System.out.println("查询多天人数");
                List<Number> inList = NumberInterface.getManyDayNumber(startTime, stopTime); // 人数方法2
                list.addAll(inList);
            }
        } else if (type.equals("amount")) {
            if (startTime.equals(stopTime)) {  // 查询一天金额
                System.out.println("查询一天金额");
                List<Amount> inList = AmountInterface.getDayAmount(startTime);  // 金额方法1
                list.addAll(inList);
            } else {  // 查询多天金额
                System.out.println("查询多天金额");
                List<Amount> inList = AmountInterface.getManyDayAmount(startTime, stopTime); // 金额方法2
                list.addAll(inList);
            }
        } else if (type.equals("stat")) {
            if (startTime.equals(stopTime)) {  // 查询一天统计
                System.out.println("查询一天统计");
                List<Stat> inList = StatInterface.getDayStat(startTime);  // 统计方法1
                list.addAll(inList);
            } else {  // 查询多天统计
                System.out.println("查询多天统计");
                List<Stat> inList = StatInterface.getManyDayStat(startTime, stopTime); // 统计方法2
                list.addAll(inList);
            }
        } else if (type.equals("payRank")) {
            if (startTime.equals(stopTime)) {  // 查询一天充值排行
                System.out.println("查询");
                List<PayRank> inList = PayRankInterface.getDayRank(startTime);
                list.addAll(inList);
            } else {  // 查询多天充值排行
                System.out.println("查询");
                List<PayRank> inList = PayRankInterface.getManyDayRank(startTime, stopTime);
                list.addAll(inList);
            }
        } else if (type.equals("cronsRank")) {
            if (startTime.equals(stopTime)) {  // 查询一天充值排行
                System.out.println("查询");
                List<CronsRank> inList = CronsRankInterface.getDayRank(startTime);
                list.addAll(inList);
            } else {  // 查询多天充值排行
                System.out.println("查询");
                List<CronsRank> inList = CronsRankInterface.getManyDayRank(startTime, stopTime);
                list.addAll(inList);
            }
        }

        ObjectMapper mapper = new ObjectMapper();    //提供java-json相互转换功能的类

        String json = mapper.writeValueAsString(list);    //将list中的对象转换为Json格式的数组

        System.out.println(json);

        //将json数据返回给客户端
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write(json);
    }
}
