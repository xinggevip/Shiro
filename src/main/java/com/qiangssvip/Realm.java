package com.qiangssvip;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;

public class Realm extends AuthorizingRealm {
    /* 认证 */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        /* 判断当前用户是否存在 */
        /* 获取用户名 */
        String username = (String)token.getPrincipal();
        /* 从数据库中查出用户名和密码 真是中是从数据库中取*/
        String name = "itlike";
        String password = "1c417c8ac6596f5dd639f0924d760e43";

        if (!name.equals(username)){
            return null;
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes("jiayan"), this.getName());
        return info;
    }

    /* 授权 */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        /* 获取当前身份信息 */
        Object primaryPrincipal = principalCollection.getPrimaryPrincipal();

        /* 假设   用户的据角色  权限 */
        ArrayList<String> roles = new ArrayList<>();
        roles.add("role1");
        roles.add("role2");

        ArrayList<String> permissions = new ArrayList<>();
        permissions.add("user:create");
        permissions.add("user:update");

        /* 把角色和权限添加到授权当中 */
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roles);
        info.addStringPermissions(permissions);

        return info;
    }


}
