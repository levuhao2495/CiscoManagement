package com.mvc.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.entity.Type;

@Repository("typeDao")
public class TypeDaoImpl implements TypeDao {

	private JdbcTemplate jdbcTemplate;
	private String strQuery;
	@Autowired
	
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	@Override
	public Type getType(int idType) {
		// TODO Auto-generated method stub
		Type type= null;
		try{
			strQuery="SELECT * FROM type WHERE id=?";
			type= jdbcTemplate.queryForObject(strQuery, new Object[]{idType}, new BeanPropertyRowMapper<Type>(Type.class));
		}catch(Exception e){
			e.printStackTrace();
		}		
		return  type;
	}

}
