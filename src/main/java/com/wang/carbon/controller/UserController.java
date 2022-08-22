package com.wang.carbon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wang.carbon.common.R;
import com.wang.carbon.entity.Company;
import com.wang.carbon.entity.User;
import com.wang.carbon.service.CompanyService;
import com.wang.carbon.service.UserService;
import com.wang.carbon.utils.ValidateCodeUtils;
import com.wang.carbon.utils.VerifyCodeUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户操作API")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CompanyService companyService;

    /**
     * 发送手机短信验证码
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session){
        //获取手机号
        String phone = user.getPhone();

        if(StringUtils.isNotEmpty(phone)){
            //生成随机的4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("code={}",code);

            //调用阿里云提供的短信服务API完成发送短信
            //SMSUtils.sendMessage("瑞吉外卖","",phone,code);

            //需要将生成的验证码保存到Session
            //session.setAttribute(phone,code);

            //将生成的验证码缓存到Redis中，并且设置有效期为5分钟
            redisTemplate.opsForValue().set(phone,code,5,TimeUnit.MINUTES);

            return R.success("手机验证码短信发送成功");
        }

        return R.error("短信发送失败");
    }
    /**
     * @description 用户登录
     * @author  wjy
     * @param user
     * @param request
     * @createTime 2022/8/18 14:23
     * @return com.wang.carbon.common.R<com.wang.carbon.entity.User>
     */
    @PostMapping("/do_login")
    public R<User> login(@RequestBody User user, HttpServletRequest request){
            //1、将页面提交的密码password进行md5加密处理
            String password = user.getPassword();
            password = DigestUtils.md5DigestAsHex(password.getBytes());
            //2、根据页面提交的phone查询数据库
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,user.getPhone());
            User emp = userService.getOne(queryWrapper);
            //3、如果没有查询到则返回登录失败结果
            if(emp == null){
                return R.error("手机号未注册");
            }
            //4、密码比对，如果不一致则返回登录失败结果
            if(!emp.getPassword().equals(password)){
                return R.error("密码错误");
            }
            //5.验证码比对，如果不一致返回登陆失败结果
            if(!request.getSession().getAttribute("verifyCode").equals(request.getParameter("user_code"))){
                return  R.error("验证码输入不正确");
            }
            //6、登录成功，将用户id存入Session并返回登录成功结果
            request.getSession().setAttribute("user",user.getId());
            return R.success(emp);
        }
        /**
         * @description  账号信息设置
         * @author  wjy
         * @param user
         * @createTime 2022/8/18 14:29
         * @return R<java.lang.String>
         */
        @PostMapping("/do_register1")
        public R<String> login(@RequestBody User user){
            log.info("新增用户，用户信息：{}",user.toString());
            userService.save(user);
            return R.success("账号信息设置完成");
        }

        /**
         * @description 公司资质信息
         * @author
         * @param company
         * @createTime 2022/8/18 14:36
         * @return R<java.lang.String>
         */

        @PostMapping("/do_register2")
        public R<String> login(@RequestBody Company company){
            log.info("公司资质信息：{}",company.toString());
            companyService.save(company);
            return R.success("公司资质信息设置完成");
        }

    /** 获取验证码图片
     * @description
     * @author
     * @param response
     * @param request
     * @createTime 2022/8/18 14:50
     */

    @GetMapping("/getVerifyCode")
    public void getVerificationCode(HttpServletResponse response, HttpServletRequest request) {
        try {
            int width = 200;
            int height = 69;
            BufferedImage verifyImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            //生成对应宽高的初始图片
            String randomText = VerifyCodeUtil.drawRandomText(width, height, verifyImg);
            //单独的一个类方法，出于代码复用考虑，进行了封装。
            //功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符
            request.getSession().setAttribute("verifyCode", randomText);
            response.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别
            OutputStream os = response.getOutputStream(); //获取文件输出流
            ImageIO.write(verifyImg, "png", os);//输出图片流
            os.flush();
            os.close();//关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


