package com.mvc.dao;

import java.util.List;

import com.mvc.entity.Vlan;

public interface VlanDao {

	public List<Vlan> getAllVlan();
	public Vlan getVlan(int vlanid);
	public void createVlan(Vlan vlan);
	public void chooseDeviceOnVlan(int vlanid, int deviceid);
	public void updateVlan(Vlan vlan);
	public void deleteVlan(int vlanid);
	public void deleteDeviceVlan(int vlanid);
}
