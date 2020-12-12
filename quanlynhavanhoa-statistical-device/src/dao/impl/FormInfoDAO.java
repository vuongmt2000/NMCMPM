package dao.impl;

import dao.IFormInfoDAO;
import java.util.List;
import mapper.FormInfoMapper;
import model.Form_info;

public class FormInfoDAO extends AbstractDAO<Form_info> implements IFormInfoDAO {
	
	@Override
	public List<Form_info> findAll() {
		String sql = "SELECT * FROM form_info";
		return query(sql, new FormInfoMapper());
	}

	@Override
	public Long insertRoom(Form_info form) {
		StringBuilder sql = new StringBuilder("INSERT INTO form_info");
		sql.append("(fullname, adress, credit_card, birthday, gender,");
		sql.append("resident, reason, deposit, status, status_pay,");
		sql.append("date_of_allocation, nation, religion, address_of_allocation, ");
		sql.append("phone, permanent_address, sum_price");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), form.getFullname(), form.getAdress(), form.getCredit_card(), form.getBirthday(),
				form.getGender(), form.getResident(), form.getReason(), form.getDeposit(), form.getStatus(), form.getStatus_pay(),
				form.getDate_of_allocation(), form.getNation(), form.getReligion(), form.getAddress_of_allocation(),
				form.getPhone(), form.getPermanent_address(), form.getSum_price());
	}

	@Override
	public void updateRoom(Form_info form) {
		StringBuilder sql = new StringBuilder("UPDATE form_info SET fullname = ?, adress = ?, credit_card = ?, birthday = ?, gender = ?,");
		sql.append("resident = ?, reason = ?, deposit = ?, status = ?, status_pay = ?,");
		sql.append("date_of_allocation = ?, nation = ?, religion = ?, address_of_allocation = ?,");
		sql.append("phone = ?, permanent_address = ?, sum_price = ?");
		sql.append(" WHERE id = ?");
		update(sql.toString(), form.getFullname(), form.getAdress(), form.getCredit_card(), form.getBirthday(),
				form.getGender(), form.getResident(), form.getReason(), form.getDeposit(), form.getStatus(), form.getStatus_pay(),
				form.getDate_of_allocation(), form.getNation(), form.getReligion(), form.getAddress_of_allocation(),
				form.getPhone(), form.getPermanent_address(), form.getSum_price(), form.getId());
	}

	@Override
	public Form_info findOne(Long id) {
		String sql = "SELECT * FROM form_info WHERE id = ?" ;
		List<Form_info> list = query(sql, new FormInfoMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM form_info WHERE id = ?";
		update(sql, id);
	}
}