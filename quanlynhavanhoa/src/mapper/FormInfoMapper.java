package mapper;

import java.sql.ResultSet;
import model.Form_info;

public class FormInfoMapper implements RowMapper<Form_info>{

	@Override
	public Form_info mapRow(ResultSet rs) {
		try {
			Form_info form = new Form_info();
			form.setId(rs.getInt("id"));
			form.setFullname(rs.getString("fullname"));
			form.setAdress(rs.getString("adress"));
			form.setCredit_card(rs.getString("credit_card"));
			form.setBirthday(rs.getDate("birthday"));
			form.setGender(rs.getString("gender"));
			form.setResident(rs.getString("resident"));
			form.setReason(rs.getString("reason"));
			form.setDeposit(rs.getInt("deposit"));
			form.setStatus(rs.getInt("status"));
			form.setStatus_pay(rs.getInt("status_pay"));
			form.setDate_of_allocation(rs.getDate("date_of_allocation"));
			form.setNation(rs.getString("nation"));
			form.setReligion(rs.getString("religion"));
			form.setAddress_of_allocation(rs.getString("address_of_allocation"));
			form.setPhone(rs.getString("phone"));
			form.setPermanent_address(rs.getString("permanent_address"));
			form.setSum_price(rs.getLong("sum_price"));
			return form;
		} catch (Exception e) {
			return null;
		}
	}

}