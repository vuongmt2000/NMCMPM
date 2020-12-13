package mapper;

import java.sql.ResultSet;
import model.FormInfo;

public class FormInfoMapper implements RowMapper<FormInfo>{

	@Override
	public FormInfo mapRow(ResultSet rs) {
		try {
			FormInfo form = new FormInfo();
			form.setId(rs.getInt("id"));
			form.setFullname(rs.getString("full_name"));
			form.setAddress(rs.getString("address"));
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
			form.setChair(rs.getInt("number_chair"));
			form.setTable(rs.getInt("number_table"));
			form.setSpeaker(rs.getInt("number_speaker"));
			form.setRadio(rs.getInt("number_radio"));
			form.setProjector(rs.getInt("number_projector"));
			form.setRoom(rs.getString("room"));
			return form;
		} catch (Exception e) {
			return null;
		}
	}

}