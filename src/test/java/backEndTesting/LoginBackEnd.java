package backEndTesting;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LoginBackEnd {
    HttpClient httpClient = HttpClientBuilder.create().build();
    String baseUrl = "http://siit.atwebpages.com/osc/";

    @Test
    public void loginTest() throws IOException {
        HttpPost httpsPostForLogin = new HttpPost(baseUrl + "index.php");

        final List<Header> headersLoginArray = new ArrayList<>();
        headersLoginArray.add(new BasicHeader("Connection", "keep-alive "));
        headersLoginArray.add(new BasicHeader("Cache-Control", "max-ag=0"));
        headersLoginArray.add(new BasicHeader("Origin", "http://siit.atwebpages.com"));
        headersLoginArray.add(new BasicHeader("Content-Type", "application/x-www-form-urlencoded"));
        headersLoginArray.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.106 Safari/537.36"));
        headersLoginArray.add(new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"));
        headersLoginArray.add(new BasicHeader("Referer", "http://siit.atwebpages.com/osc/index.php?page=login"));
        headersLoginArray.add(new BasicHeader("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8"));
        headersLoginArray.add(new BasicHeader("Cookie", "osclass=fd116e8fad42ed39ac73bab919b0f550"));
        httpsPostForLogin.setHeaders(headersLoginArray.toArray(new Header[0]));
        System.out.println(headersLoginArray);

        String csrfName = "CSRF715945756_347637718";
        String csrfToken = "0662f9dd579d2e6163800d7e4c8d7553fc457fe56d7309e163bb522285da7813fc4d7d2cb10fae8488bea69346999a03e588aba7ce5279d7c80fd17c360bde71";
        String page = "login";
        String action = "login_post";
        String email = "laura@laura.com";
        String password = "aq12AQ!@";
        List<NameValuePair> loginBody = new ArrayList<>();
        loginBody.add(new BasicNameValuePair("CSRFName", csrfName));
        loginBody.add(new BasicNameValuePair("CSRFToken", csrfToken));
        loginBody.add(new BasicNameValuePair("page", page));
        loginBody.add(new BasicNameValuePair("action", action));
        loginBody.add(new BasicNameValuePair("email", email));
        loginBody.add(new BasicNameValuePair("password", password));
        httpsPostForLogin.setEntity(new UrlEncodedFormEntity(loginBody));

        HttpResponse responseLogin = httpClient.execute(httpsPostForLogin);

        Assert.assertEquals(responseLogin.getStatusLine().getStatusCode(), 302);
    }

}
