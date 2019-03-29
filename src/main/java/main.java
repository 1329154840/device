import org.eclipse.paho.client.mqttv3.MqttException;

import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-03-29
 * Time: 16:23
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
public class main {
    private static String topic = "/device/status";

    private static String msg = "";

    public static void main(String[] args){
        int i =0;
        while (true){
            try {
                i++;
                msg = Utils.clientId + "/" + i;
                Utils.publish( msg , topic);
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
