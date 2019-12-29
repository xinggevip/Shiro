package com.qiangssvip;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class Realm extends AuthorizingRealm {
    /* 认证 */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /* 判断当前用户是否存在 */
        /* 获取用户名 */
        String username = (String)token.getPrincipal();
        /* 从数据库中查出用户名和密码 真是中是从数据库中取*/
        String name = "itlike";
        String password = "1234";

        if (!name.equals(username)){
            return null;
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, this.getName());
        return info;
    }

    /* 授权 */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
