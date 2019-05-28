import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-03-29
 * Time: 15:24
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
public class Utils {
    public static final String clientId = "620e13db-f6f6-4887-b945-3358b22397d0";
    private static int qos = 1;
    private static String broker = "tcp://152.136.94.85:1883";
    private static String userName = "bupt-Iot";
    private static String passWord = "bupt-Iot";

    private static MqttClient mqttClient;


    private static void connect() throws MqttException {
        if( mqttClient == null ){
            MemoryPersistence persistence = new MemoryPersistence();
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName(userName);
            connOpts.setPassword(passWord.toCharArray());
            connOpts.setCleanSession(true);
            connOpts.setConnectionTimeout(10);
            connOpts.setKeepAliveInterval(20);
//		String[] uris = {"tcp://10.100.124.206:1883","tcp://10.100.124.207:1883"};
//		connOpts.setServerURIs(uris);  //起到负载均衡和高可用的作用
            mqttClient = new MqttClient(broker, clientId, persistence);
            mqttClient.setCallback(new ReceiverCallback("MqttCallback"));
            mqttClient.connect(connOpts);
        }

    }

    public static void publish(String msg,String topic) throws MqttException{
        connect();
        if (mqttClient != null) {
            pub(msg, topic);
            System.out.println("pub-->" + msg);
        }
    }

    private static void pub(String msg,String topic)
            throws MqttPersistenceException, MqttException {
        MqttMessage message = new MqttMessage(msg.getBytes());
        message.setQos(qos);
        message.setRetained(false);
        mqttClient.publish(topic, message);
    }


}
