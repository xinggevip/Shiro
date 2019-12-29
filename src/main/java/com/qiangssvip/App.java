package com.qiangssvip;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App
{
    public static void test1(){
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

    public static void test2(){
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
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
        /* 2.通过工厂创建securityManager */
        SecurityManager securityManager = factory.getInstance();
        /* 3.将securityManager设置到运行环境中 */
        SecurityUtils.setSecurityManager(securityManager);
        /* 4.创建一个Subject实例 */
        Subject subject = SecurityUtils.getSubject();
        /* 5.创建token令牌 */
        UsernamePasswordToken token = new UsernamePasswordToken("itlike", "1234");
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

        /* 认证之后才取做授权 */
        /* 判断当前用户是否有某一个角色和某一个权限 */
        System.out.println("当前用户是否拥有role1角色：" + subject.hasRole("role1"));
        /* 判断当前用户是否拥有多个角色 */
        System.out.println("当前用户是否拥有role1和role2角色：" + subject.hasAllRoles(Arrays.asList("role1","role2")));
        /* 判断当前用户是否拥有某一个权限 */
        System.out.println("当前用户是否拥有user:create权限" + subject.isPermitted("user:create"));
        /* 判断当前用户是否拥有多个权限 */
        System.out.println("当前用户是否拥有user:create和user:update权限" + subject.isPermittedAll("user:create","user:update"));

        /* 7.用户退出 */
        subject.logout();
        System.out.println("是否认证成功" + subject.isAuthenticated());






    }
    public static void main( String[] args )
    {
        // test1();
        test2();
    }

}
