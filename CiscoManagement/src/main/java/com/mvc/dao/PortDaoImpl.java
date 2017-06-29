package com.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mvc.entity.Device;
import com.mvc.entity.Port;
import com.thoughtworks.xstream.converters.javabean.BeanProperty;

@Repository("portDao")
public class PortDaoImpl implements PortDao{

	
	private JdbcTemplate jdbcTemplate;
	private String strQuery;
	@Autowired
	
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	@Override
	public List<Port> getAllPort() {
		// TODO Auto-generated method stub
		List<Port> ports= null;
		try{
			strQuery= "SELECT * FROM port_table";
			ports=jdbcTemplate.query(strQuery, 
					new BeanPropertyRowMapper<Port>(Port.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return ports;
	}

	@Override
	public List<Port> getPortByDevice(int iddevice) {
		// TODO Auto-generated method stub
		List<Port> ports = null;
		try{
			strQuery= "SELECT * FROm port_table WHERE iddevice= ?";
			ports=jdbcTemplate.query(strQuery, new Object[] {iddevice},new BeanPropertyRowMapper<Port>(Port.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return ports;
	}

	@Override
	public int deletePort(int iddevice) {
		// TODO Auto-generated method stub
		strQuery="DELETE FROM port_table WHERE iddevice= ?";
		return jdbcTemplate.update(strQuery, new Object[] {iddevice});	
	}

}
