/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.List;
import model.Statistical;

/**
 *
 * @author vuong
 */
public interface IStatisticalDAO {
	List<Statistical> findAll();
        Long insertStatistical(Statistical statistical);
	void updateStatistical(Statistical statistical);
	Statistical findOne(Long id);
	void delete(Long id);
}
