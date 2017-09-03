package com.opms.entity;

import java.util.List;

import com.opms.entity.PmsCheckworks;

public class Subtotal {
	private int count;
	private int type;
	private int normal=0;
	private int late=0;
	private int early=0;
	private float workdays=0;
	public float getWorkdays() {
		return workdays;
	}
	public void setWorkdays(float workdays) {
		this.workdays = workdays;
	}

	public int getNormal() {
		return normal;
	}
	public void setNormal(int normal) {
		this.normal = normal;
	}
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getEarly() {
		return early;
	}
	public void setEarly(int early) {
		this.early = early;
	}	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
