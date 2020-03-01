package apitests;

import base.ValueGenerator;
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

public class RegisterApiTests {
    HttpClient httpClient = HttpClientBuilder.create().build();
    String baseUrl = "http://siit.atwebpages.com/osc/";

    @Test
    public void registrationTest() throws IOException {
        HttpPost httpsPostForRegistration = new HttpPost(baseUrl + "index.php");

        final List<BasicHeader> headersRegistrationArray = new ArrayList<>();
        headersRegistrationArray.add(new BasicHeader("Connection", "keep-alive "));
        headersRegistrationArray.add(new BasicHeader("Cache-Control", "max-ag=0"));
        headersRegistrationArray.add(new BasicHeader("Origin", "http://siit.atwebpages.com"));
        headersRegistrationArray.add(new BasicHeader("Upgrade-Insecure-Requests", "1"));
        headersRegistrationArray.add(new BasicHeader("Content-Type", "application/x-www-form-urlencoded"));
        headersRegistrationArray.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.106 Safari/537.36"));
        headersRegistrationArray.add(new BasicHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9"));
        headersRegistrationArray.add(new BasicHeader("Referer", "http://siit.atwebpages.com/osc/index.php?page=login"));
        headersRegistrationArray.add(new BasicHeader("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8"));
        headersRegistrationArray.add(new BasicHeader("Cookie", "osclass=fd116e8fad42ed39ac73bab919b0f550"));
        Header[] headers = new Header[headersRegistrationArray.size()];
        httpsPostForRegistration.setHeaders(headersRegistrationArray.toArray(headers));

        String csrfName = "CSRF715945756_347637718";
        String csrfToken = "0662f9dd579d2e6163800d7e4c8d7553fc457fe56d7309e163bb522285da7813fc4d7d2cb10fae8488bea69346999a03e588aba7ce5279d7c80fd17c360bde71";
        String page = "register";
        String action = "register_post";
        String s_name = ValueGenerator.generateAlphabetic(8);
        String s_email = ValueGenerator.generateAlphabetic(7) + "@google.com";
        String s_password = "aq12AQ!@";
        String s_password2 = "aq12AQ!@";

        List<NameValuePair> registrationBody = new ArrayList<>();
        registrationBody.add(new BasicNameValuePair("CSRFName", csrfName));
        registrationBody.add(new BasicNameValuePair("CSRFToken", csrfToken));
        registrationBody.add(new BasicNameValuePair("page", page));
        registrationBody.add(new BasicNameValuePair("action", action));
        registrationBody.add(new BasicNameValuePair("s_name", s_name));
        registrationBody.add(new BasicNameValuePair("s_email", s_email));
        registrationBody.add(new BasicNameValuePair("s_password", s_password));
        registrationBody.add(new BasicNameValuePair("s_password2", s_password2));
        httpsPostForRegistration.setEntity(new UrlEncodedFormEntity(registrationBody));

        System.out.println(registrationBody);

        HttpResponse response = httpClient.execute(httpsPostForRegistration);

        Assert.assertEquals(response.getStatusLine().getStatusCode(), 302);
    }
}
