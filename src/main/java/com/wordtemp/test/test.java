package com.wordtemp.test;

import com.wordtemp.dao.impl.ProblemDAOImpl;
import com.wordtemp.domain.Problem;
import org.junit.jupiter.api.Test;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2018-11-15-16:16
 */
public class test {
    @Test
    public void test(){
        Problem problem = new Problem() ;
        problem.setQid("tk5");
        problem.setTitle("过分偏重教育原理（原则、观念），难免空泛；过分依赖教学经验（技能技巧），易致盲目。");
        ProblemDAOImpl problemDAO = new ProblemDAOImpl();
        problemDAO.save(problem);
    }
}
