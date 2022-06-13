import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Q3_CountLinks {

    /*
 The total number of links in a page can be counted with the help of findElements() method.
 The logic is to return a list of web elements with tagname anchor, then getting the size of that list.
  */
    public static void main(String[] args) {
        Driver.getDriver().get("https://theproteinworks.com/");
        String url="";
        List<WebElement> allURLs = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("Total links on the Wb Page: " + allURLs.size());
        for(int i=0;i<allURLs.size();i++)
        {
            WebElement E1= allURLs.get(i);
            url= E1.getAttribute("href");
            verifyLinks(url);
        }
        Driver.getDriver().quit();
    }
    public static void verifyLinks(String linkUrl) {
        try {
            URL url = new URL(linkUrl);
            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() >= 400) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }
            //Fetching and Printing the response code obtained

            else {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
        } catch (Exception e) {
        }
    }}
