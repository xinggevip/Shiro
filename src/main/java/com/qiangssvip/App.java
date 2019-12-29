package com.qiangssvip;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        /**
         * 1.构建securityManager工厂
         * 2.通过工厂创建securityManager
         * 3.将securityManager设置到运行环境中
         * 4.创建一个Subject实例
         * 5.创建token令牌
         * 6.用户登录
         * 7.用户退出
         * */

        /* 1.构建securityManager工厂  ini  加载配置 */
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        /* 2.通过工厂创建securityManager */
        SecurityManager securityManager = factory.getInstance();
        /* 3.将securityManager设置到运行环境中 */
        SecurityUtils.setSecurityManager(securityManager);
        /* 4.创建一个Subject实例 */
        Subject subject = SecurityUtils.getSubject();
        /* 5.创建token令牌 */
        UsernamePasswordToken token = new UsernamePasswordToken("itlike", "admin");
        /* 6.用户登录 */

        try {
            subject.login(token);
        }catch (UnknownAccountException e){
            System.out.println("账号不存在");
//            return;
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
//            return;
        }
        System.out.println("是否认证成功" + subject.isAuthenticated());

        /* 7.用户退出 */
        subject.logout();
        System.out.println("是否认证成功" + subject.isAuthenticated());
    }
}
