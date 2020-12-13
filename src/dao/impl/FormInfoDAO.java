package dao.impl;


import dao.IFormInfoDAO;
import mapper.FormInfoMapper;
import model.FormInfo;

import java.util.List;

public class FormInfoDAO extends AbstractDAO<FormInfo> implements IFormInfoDAO {
	
	@Override
	public List<FormInfo> findAll() {
		String sql = "SELECT * FROM form_info WHERE status = 1";
		return query(sql, new FormInfoMapper());
	}

	@Override
	public Long insertRoom(FormInfo form) {
		StringBuilder sql = new StringBuilder("INSERT INTO form_info");
		sql.append("(full_name, credit_card, birthday,");
		sql.append(" reason, status,");
		sql.append(" date_of_allocation, nation, religion, address_of_allocation, ");
		sql.append("phone, permanent_address, sum_price, number_table, number_chair, number_speaker, number_radio, number_projector, room)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), form.getFullname(), form.getCredit_card(), form.getBirthday(),
				form.getReason(), form.getStatus(),
				form.getDate_of_allocation(), form.getNation(), form.getReligion(), form.getAddress_of_allocation(),
				form.getPhone(), form.getPermanent_address(), form.getSum_price(), form.getTable(), form.getChair(),
				form.getSpeaker(), form.getRadio(), form.getProjector(), form.getRoom());
	}

	@Override
	public void updateRoom(FormInfo form) {
		StringBuilder sql = new StringBuilder("UPDATE form_info SET status = ?");
		sql.append(" WHERE id = ?");
		update(sql.toString(), form.getStatus(), form.getId());
	}

	@Override
	public FormInfo findOne(Integer id) {
		String sql = "SELECT * FROM form_info WHERE id = ?" ;
		List<FormInfo> list = query(sql, new FormInfoMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM form_info WHERE id = ?";
		update(sql, id);
	}
        
        @Override
	public List<FormInfo> searchForm(FormInfo form) {
		StringBuilder sql = new StringBuilder("SELECT * FROM form_info WHERE ");
		boolean flag = false;
		if(!form.getFullname().equals("")) {
			sql.append(" full_name ");
			sql.append("like " + "'%" + form.getFullname() + "%'");
			flag = true;
		}
		if(!form.getPhone().equals("")) {
			if(flag) sql.append(" and ");
			sql.append(" phone like " + "'%"  + form.getPhone() + "%'");
			flag = true;
		}
		return query(sql.toString(), new FormInfoMapper());
	}
}