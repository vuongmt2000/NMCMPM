package service.service_impl;

import dao.impl.FormInfoDAO;
import java.util.List;
import model.FormInfo;
import service.FormInfoService;

public class FormInfoServiceImpl implements FormInfoService {

    FormInfoDAO formInfoDAO = new FormInfoDAO();

    @Override
    public Long save(FormInfo form) {
        return formInfoDAO.insertRoom(form);
    }
    
    @Override
	public FormInfo findOne(Integer id) {
		return formInfoDAO.findOne(id);
	}
        
    @Override
	public void updateRoom(FormInfo form_info) {
		formInfoDAO.updateRoom(form_info);
	}
        
        @Override
	public List<FormInfo> searchForm(FormInfo form) {
                List<FormInfo> list = formInfoDAO.searchForm(form);
		return list.isEmpty() ? null : list;
	}
        
        @Override
	public List<FormInfo> findAll() {
		return formInfoDAO.findAll();
	}
}
