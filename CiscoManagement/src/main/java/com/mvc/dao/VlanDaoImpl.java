package com.mvc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.entity.*;

@Repository("vlanDao")
public class VlanDaoImpl implements VlanDao {

	private JdbcTemplate jdbcTemplate;
	private String strQuery;
	@Autowired
	
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	@Override
	public List<Vlan> getAllVlan() {
		// TODO Auto-generated method stub
		List<Vlan> list= null;
		try{
		strQuery="SELECT * FROM vlan";
		list= jdbcTemplate.query(strQuery, new BeanPropertyRowMapper<Vlan>(Vlan.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Vlan getVlan(int vlanid) {
		// TODO Auto-generated method stub
		Vlan vlan= null;
		try{
			strQuery="SELECT * FROM vlan WHERE vlanid=?";
			vlan =  jdbcTemplate.queryForObject(strQuery, new Object[]{vlanid}, new BeanPropertyRowMapper<Vlan>(Vlan.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return vlan;
	}
	
	@Override
	public void createVlan(Vlan vlan) {
		// TODO Auto-generated method stub
		try{
			strQuery="INSERT INTO vlan(vlannum, vlandct, vlantype) VALUES(?,?,?)";
			jdbcTemplate.update(strQuery, new Object[] 
					{ vlan.getVlanNum(), vlan.getVlanDct(), vlan.getVlanType()});
			}catch(Exception e){
				e.printStackTrace();
			}
	}

	@Override
	public void updateVlan(Vlan vlan) {
		// TODO Auto-generated method stub
		try{
			strQuery="UPDATE vlan SET vlannum = ? , vlandct = ? , vlantype = ? WHERE vlanid = ?";
			jdbcTemplate.update(strQuery
				    , new Object[] {
				      vlan.getVlanNum(),vlan.getVlanDct(),vlan.getVlanType(),vlan.getVlanId()});
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void deleteVlan(int vlanid) {
		// TODO Auto-generated method stub
		try{
			strQuery="DELETE FROM vlan WHERE vlanid = ?";
			jdbcTemplate.update(strQuery, new Object[] { vlanid });
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	@Override
	public void deleteDeviceVlan(int vlanid) {
		// TODO Auto-generated method stub
		try{
			strQuery="DELETE FROM vlan_device WHERE id_vlan=?";
			jdbcTemplate.update(strQuery, new Object[]{vlanid});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	public void chooseDeviceOnVlan(int vlanid, int deviceid) {
		// TODO Auto-generated method stub
		try{
			strQuery="INSERT INTO vlan_device(id_vlan,id_device) VALUES(?,?)";
			jdbcTemplate.update(strQuery, new Object[]{vlanid,deviceid});
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
