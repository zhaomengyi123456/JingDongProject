package http;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sun.net.www.http.HttpClient;

import java.io.IOException;

/**
 * Created by Administrator on 2017/1/11.
 */
public class HttpRequester {

    @Test
    @Parameters("url")
    public void doget(String url) throws IOException {
        //创建HttpClient
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //创建gt请求方法
        HttpGet httpget=new HttpGet(url);
        //执行请求，获取response
        CloseableHttpResponse response=httpClient.execute(httpget);

        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity entity=response.getEntity();
            //org.json包
            JSONObject jsonObject=new JSONObject(EntityUtils.toString(entity));
            //jsonObject.get("access_token");
            System.out.println(jsonObject.get("access_token"));
        }
        else{
            System.out.println("出错了！！");
        }

    }


//    public static void main(String[] args) throws IOException {
//        HttpRequester requester=new HttpRequester();
//        requester.doget("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx66a1cac409819cdf&secret=0e55703a4c17012929ab956e2705eb2c");
//    }
}
