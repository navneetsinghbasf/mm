package org.tcs.fca.service;

import java.util.List;

import org.tcs.fca.vo.BehaviorDetailsResponseVO;

public interface BehaviorService {

	public List<BehaviorDetailsResponseVO> fetchBehaviorDetails(String vehicleNumber, String event);
}