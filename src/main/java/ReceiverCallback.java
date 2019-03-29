import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-03-29
 * Time: 15:28
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
public class ReceiverCallback implements MqttCallback {
    private String threadId;

    public ReceiverCallback(String threadId){
        this.threadId = threadId;
    }

    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("连接中断...");
        System.out.println("原因: " + throwable.getMessage());

    }

    @Override
    public void messageArrived(String s, MqttMessage message) throws Exception {
        String msg = new String(message.getPayload());
        System.out.println(threadId + " " + msg);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }
}
