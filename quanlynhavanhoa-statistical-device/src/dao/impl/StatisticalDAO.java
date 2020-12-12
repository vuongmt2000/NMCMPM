/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.IStatisticalDAO;
import java.util.List;
import mapper.DeviceMapper;
import mapper.StatisticalMapper;
import model.Statistical;


 
public class StatisticalDAO extends AbstractDAO<Statistical> implements IStatisticalDAO{

    @Override
    public List<Statistical> findAll() {
        String sql = "SELECT * FROM (room_device INNER JOIN device ON room_device.device_id = device.id) ";
        return query(sql, new StatisticalMapper()); 
    }

    @Override
    public Long insertStatistical(Statistical statistical) {
        StringBuilder sql = new StringBuilder("INSERT INTO device");
        sql.append("id, name, quantity,unit, status, comment");
        sql.append("VALUES(?, ?, ?, ?, ?, ?)");
        return insert(sql.toString(), statistical.getId(), statistical.getName(), statistical.getQuantity(), statistical.getUnit(), statistical.getStatus(), statistical.getComment());
    }

    @Override
    public void updateStatistical(Statistical statistical) {
       
    }

    @Override
    public Statistical findOne(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
