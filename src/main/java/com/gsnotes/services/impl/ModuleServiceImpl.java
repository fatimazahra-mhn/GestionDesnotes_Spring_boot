package com.gsnotes.services.impl;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gsnotes.dao.IModule;
import com.gsnotes.services.IModuleService;
import com.gsnotes.bo.Module;

@Service 
@Transactional
public class ModuleServiceImpl  implements IModuleService{
	
	
	@Autowired
	private IModule moduleDao;

	@Override
	public List<Module> getAllModuleByIdNiveau(Long id) {
		return moduleDao.getModulesByNiveau(id);
	}

	

}
