import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.UrlResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UrlResourceTest {
    public static void main(String[] args) throws IOException {
        ////获取网络资源
        //UrlResource urlResource = new UrlResource("http://www.baidu.com");
        //BufferedReader reader = new BufferedReader(new InputStreamReader(urlResource.getInputStream()));
        //String str;
        //while ((str = reader.readLine()) != null) {
        //    System.out.println(str);
        //}

        ////获取本地文件资源
        //UrlResource urlResource1 = new UrlResource("file:test.txt");
        //
        //BufferedReader reader1 = new BufferedReader(new InputStreamReader(urlResource1.getInputStream()));
        //String str1;
        //while ((str1 = reader1.readLine()) != null) {
        //    System.out.println(str1);
        //}

        //获取类路径的文件资源
        ClassPathResource classPathResource = new ClassPathResource("test.txt");

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(classPathResource.getInputStream()));
        String str1;
        while ((str1 = reader1.readLine()) != null) {
            System.out.println(str1);
        }
    }
}
