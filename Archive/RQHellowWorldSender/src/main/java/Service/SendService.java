package Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import producer.Producer;

public class SendService {
	
	@Autowired
	Producer producer;
	
	public String sendMsg(String msg) {
		producer.produceMsg(msg);
		return "Done";
	}
}
