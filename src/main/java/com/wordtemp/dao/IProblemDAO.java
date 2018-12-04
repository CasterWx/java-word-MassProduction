package com.wordtemp.dao;

import com.wordtemp.domain.Problem;

import java.util.List;

/**
 * @author CasterWx  AntzUhl
 * @site https://github.com/CasterWx
 * @company Henu
 * @create 2018-11-15-16:09
 */
public interface IProblemDAO {
    void save(Problem problem);
    void update(Problem problem);
    void delete(Problem problem);
    Problem get(Integer id);
    List<Problem> listAll();
}
