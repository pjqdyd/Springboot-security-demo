package com.pjqdyd;

import com.pjqdyd.domain.Perm;
import com.pjqdyd.service.PermService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**   
 * @Description:  [权限查询测试]
 * @Author:       pjqdyd
 * @Version:      [v1.0.0]
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class PermTest {

    @Resource
    private PermService permService;

    @Test
    public void findAllPermTest(){
        List<Perm> permList = permService.getPermByUserId(1001L);
        permList.forEach( perm -> System.out.println(perm));
    }

}
