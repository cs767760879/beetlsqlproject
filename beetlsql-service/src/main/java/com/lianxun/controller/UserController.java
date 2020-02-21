package com.lianxun.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.lianxun.constant.StaticSource;
import com.lianxun.entity.User;
import com.lianxun.service.Userservice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName UserController
 * @Description
 * @Author Vera
 * @Date 2020/2/21 11:30
 * @Version 1.0
 **/
@RestController
@Api(description = "用户相关方法说明")
@RequestMapping("user")
public class UserController {
    @Autowired
    private Userservice userservice;

    @GetMapping("selectAll")
    @ResponseBody
    @ApiOperation("查询所有用户")
    public List<User> selectAll() {
        return userservice.selectAll();
    }

    @GetMapping("selectUserPage")
    @ResponseBody
    @ApiOperation("分页查询用户")
    public List<User> selectUserPage() {
        return userservice.selectUserPage(1, 2);
    }

    @GetMapping("insertUser")
    @ResponseBody
    @ApiOperation("新增用户")
    public String insertUser() {
        User user = new User();
        user.setAge(18);
        user.setName("胡歌");
        userservice.insertUser(user);
        return "SUCCESS";
    }

    @GetMapping("updateUser")
    @ResponseBody
    @ApiOperation("更新用户信息")
    public String updateUser() {
        User user = new User();
        user.setId(1);
        user.setAge(18);
        user.setName("赵丽颖");
        userservice.updataUser(user);
        return "SUCCESS";
    }

    @GetMapping("/exporExcel")
    @ResponseBody
    @ApiOperation("将用户数据导出到Excel")
    public String exporExcel(HttpServletResponse response) throws IOException {
        ExcelWriter writer = null;
        OutputStream outputStream = response.getOutputStream();
        try {
            response.setHeader(StaticSource.HEADER_CONTENT_DISPOSITION_KEY, StaticSource.HEADER_CONTENT_DISPOSITION_VALUE + User.class.getName() + ".xls");
            response.setContentType(StaticSource.CONTENTTYPE);//设置类型
            response.setHeader(StaticSource.HEADER_PRAGMA_KEY, StaticSource.HEADER_PRAGMA_VALUE);//设置头
            response.setHeader(StaticSource.HEADER_CACHE_CONTROL_KEY, StaticSource.HEADER_CACHE_CONTROL_VALUE);//设置头
            response.setDateHeader(StaticSource.HEADER_EXPIRES_KEY, 0);//设置日期头
            writer = new ExcelWriter(outputStream, ExcelTypeEnum.XLS, true);
            Sheet sheet = new Sheet(1, 0, User.class);
            sheet.setSheetName("目录");
//            List<User> users = userservice.selectUserPage(0,100);
            writer.write(this.generateUsers(), sheet);
            writer.finish();
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "expor success";
    }

    private List<User> generateUsers() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("杨幂");
        user.setAge(18);
        user.setCreateDate(new Date());
        users.add(user);
        return users;
    }
}
