package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;



@Repository
public class PersonDao {
	
	@Autowired
	private SqlSession sqlSession;

	public int personInsert(PersonVo personVo) {
		System.out.println("personDao.personInsert()");
		
		int count = sqlSession.insert("phonebook.insert", personVo);
		
		return count;
	}
	
	public List<PersonVo> personSelect() {
		System.out.println("personDao.personSelect()");
		List<PersonVo> pList = sqlSession.selectList("phonebook.select");
		
		return pList;
	}
	
	public int personDelete(int personId) {
		int count = sqlSession.delete("phonebook.delete", personId);
		
		return count;
	}
	
	public PersonVo personSelectOne(int personId) {
		
		return sqlSession.selectOne("phonebook.SelectOne", personId);
	}
	
	public int personModify(PersonVo personVo) {
		int count = sqlSession.update("phonebook.modify", personVo);
		
		return count;
	}
}
