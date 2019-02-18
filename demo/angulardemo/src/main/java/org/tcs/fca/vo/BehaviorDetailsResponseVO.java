package org.tcs.fca.vo;

import java.util.Date;

public class BehaviorDetailsResponseVO {

	private Date label;

	private double value;

	public BehaviorDetailsResponseVO() {
		super();
		
	}

	public BehaviorDetailsResponseVO(Date label, double value) {
		super();
		this.label = label;
		this.value = value;
	}

	public Date getLabel() {
		return label;
	}

	public void setLabel(Date label) {
		this.label = label;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}