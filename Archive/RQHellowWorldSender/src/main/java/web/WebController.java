package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Service.SendService;
import io.swagger.annotations.Api;
import producer.Producer;
 
//@RestController
public class WebController {
	
	@Autowired
	private static SendService sendService;
	
	public static void main (String [] argus) {
	//	SendService.sendMsg("adfsd");
	}
//	@Autowired
//	Producer producer;
//	
//	@RequestMapping("/send")
//	public String sendMsg(@RequestParam("msg")String msg) {
//		producer.produceMsg(msg);
//		return "Done";
//	}
}
