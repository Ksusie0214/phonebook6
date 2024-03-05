package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PersonDao;
import com.javaex.vo.PersonVo;

@Service
public class PhonebookService {
	
	@Autowired
	private PersonDao personDao;	
	
	public int exeWrite(PersonVo personVo) {
		
		personDao.personInsert(personVo);
		return 1;
	}

	public List<PersonVo> exeList() {
		System.out.println("PhonebookService.exeList()");
		List<PersonVo> personList = personDao.personSelect();
		
		return personList;
	}
	
	public int exeDelete(int personId) {
		System.out.println("PhonebookService.exeDelete()");
		
		personDao.personDelete(personId);
		return 1;
	}
	
	public PersonVo exeSelectOne(int personId) {
		System.out.println("PhonebookService.exeSelectOne()");
		
		return personDao.personSelectOne(personId);
	}
	
	public int exeModify(PersonVo personVo) {
		System.out.println("PhonebookService.exeModify()");
		
		int count = personDao.personModify(personVo);
		
		return count;
	}

}
