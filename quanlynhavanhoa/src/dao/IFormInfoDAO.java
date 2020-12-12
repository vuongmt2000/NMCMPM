package dao;

import java.util.List;
import model.Form_info;

public interface IFormInfoDAO extends GenericDAO<Form_info>{
	List<Form_info> findAll();
	Long insertRoom(Form_info form_info);
	void updateRoom(Form_info form_info);
	Form_info findOne(Long id);
	void delete(Long id);
}
