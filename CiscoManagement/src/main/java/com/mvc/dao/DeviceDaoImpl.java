package com.mvc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.entity.Device;
@Repository("deviceDao")
public class DeviceDaoImpl implements DeviceDao{

	private JdbcTemplate jdbcTemplate;
	String strQuery;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	public DeviceDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public List<Device> getAllDevice() {
		// TODO Auto-generated method stub
		List<Device> devices = null;
		try{
	 strQuery= "SELECT * FROM device";
		devices= jdbcTemplate.query(strQuery,
				new BeanPropertyRowMapper<Device>(Device.class));
		}catch(Exception e){
			e.printStackTrace();
		}
		return devices;
	}
	@Override
	public Device getDevice(int deviceId) {
		// TODO Auto-generated method stub
		Device device= null;
		try {
			strQuery="SELECT * FROM device WHERE deviceid= ?";
			device=jdbcTemplate.queryForObject(strQuery, new Object[] {deviceId},new BeanPropertyRowMapper<Device>(Device.class));
			} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
		}
		return device;
	}
	@Override
	public int deleteDevice(int deviceId) {
		// delete device by deviceId
		strQuery="DELETE FROM device WHERE deviceid= ?";
		int count= jdbcTemplate.update(strQuery, new Object[] {deviceId});
		return count;
	}

	@Override
	public int updateDevice(Device device) { 		
		// update name and snmp community
		// example: UPDATE device SET  name = 'update' , snmpr ='public' , snmpw ='private'  WHERE deviceid = 11
		/*strQuery="UPDATE device SET ip= ?, mac= ?, name= ?,type= ?,"
				+ " version=?, snmpv= ?, snmpr= ?, snmpw = ? WHERE deviceid= ?";*/
		strQuery="UPDATE device SET name= ?, snmpr= ?, snmpw = ? WHERE deviceId= ?";
		int count= jdbcTemplate.update(strQuery,new Object[]{
				device.getName(),device.getSnmpr(), device.getSnmpw(), device.getDeviceid()});
		return count;
	}
	@Override
	public int createDevice(Device device) {
		// TODO Auto-generated method stub
		strQuery="INSERT INTO device(ip,mac,name,type,version,snmpv,snmpr,snmpw) VALUES(?,?,?,?,?,?,?,?)";
		int count= jdbcTemplate.update(strQuery, new Object[]{
				device.getIp(),device.getMac(),device.getName(),device.getType(),device.getVersion(),device.getSnmpv(),device.getSnmpr(),device.getSnmpw()
		});
		return count;
	}

}
