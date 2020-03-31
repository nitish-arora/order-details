package arora.nitish.orderDetails.services.impl;

import static arora.nitish.orderDetails.constant.ApiEndPointConstants.ORDER_API_PATH;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import arora.nitish.orderDetails.dto.response.OrderResponse;
import arora.nitish.orderDetails.services.OrderService;

/**
 * Service layer to interact with Order Service
 * 
 * @author nitish
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Value("${order.service.url}")
	private String baseURL;

	@Autowired
	RestTemplate restTemplate;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrderResponse getOrderData(String userId) {
		String url = baseURL + String.format(ORDER_API_PATH, userId);
		return restTemplate.getForEntity(url, OrderResponse.class).getBody();
	}
}
