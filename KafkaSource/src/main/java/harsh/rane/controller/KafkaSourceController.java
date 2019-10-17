package harsh.rane.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import harsh.rane.exception.ProducerException;
import harsh.rane.service.EmployeeDaoServiceImpl;
import harsh.rane.service.PatientDaoServiceImpl;

@RestController
public class KafkaSourceController {

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplateString;
	
	@Autowired
	EmployeeDaoServiceImpl empolyeeservice;
	
	@Autowired
	PatientDaoServiceImpl patientservice;
	
	private static final Logger LOGGER = LogManager.getLogger(KafkaSourceController.class);
	
	@GetMapping("/generatestream")//8082 port
	public void GenerateStream() {
		
		Properties props=new Properties();
		props.put("bootstrap.servers","0.0.0.0:9092");
		props.put("key.serializer",StringSerializer.class);
		props.put("value.serializer",StringSerializer.class);
		
//		Map<String, Object> config=new HashMap<>();
//		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"0.0.0.0:9092");
//		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
		Producer <String,String> producer=new KafkaProducer<>(props);
		ProducerRecord<String, String> records=new ProducerRecord<>("topic2", 0,"zkey", empolyeeservice.convertObjecttoString());
	  	producer.send(records, new ProducerException());
	  	producer.close();
//		kafkaTemplateString.send("topic", 0,"zkey", empolyeeservice.convertObjecttoString(),);//.send("topic2","zkey",empolyeeservice.convertObjecttoString(),); 
//		System.out.print(empolyeeservice.convertObjecttoString());
		
		kafkaTemplateString.send("topic3","zkey",patientservice.convertObjecttoString()); 
		System.out.print(patientservice.convertObjecttoString());
		
		LOGGER.info("StringMessage has been sent");
	}
}
