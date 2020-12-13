package service;

import java.util.List;
import model.FormInfo;

public interface FormInfoService {
    Long save(FormInfo form);
    FormInfo findOne(Integer id);
    void updateRoom(FormInfo form_info);
    List<FormInfo> searchForm(FormInfo form);
    	List<FormInfo> findAll();


}
