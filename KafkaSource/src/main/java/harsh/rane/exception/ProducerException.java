package harsh.rane.exception;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerException implements Callback{

	@Override
	public void onCompletion(RecordMetadata metadata, Exception exception) {
		// TODO Auto-generated method stub
		if(exception != null)
		{
			System.out.println("Partition = "+metadata.partition()+"Offset = "+metadata.offset()+
					"Topic = "+metadata.topic()+""+metadata.timestamp());
			System.out.println(exception.getMessage());
		}
		else
			System.err.println("Partition = "+metadata.partition()+"Offset = "+metadata.offset()+
					"Topic = "+metadata.topic()+""+metadata.timestamp());
	}

}
