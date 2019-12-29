package com.qiangssvip;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void MdTest(){
        /* 散列密码 同样的数据 同样的加密 同样的结果 */
        Md5Hash md5Hash = new Md5Hash("admin", "jiayan", 3); // 1c417c8ac6596f5dd639f0924d760e43
        System.out.println(md5Hash);

        SimpleHash hash = new SimpleHash("md5", "admin", "jiayan", 3); // 1c417c8ac6596f5dd639f0924d760e43
        System.out.println(hash);

    }
}
