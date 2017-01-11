package JingDongProject;

import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2016/12/27.
 */
public class LoginPage {
        private WebElement username;
        private WebElement passwd;

        public void setUsername(WebElement username){
            this.username=username;
        }
        public WebElement getUsername(){
            return this.username;
        }
        public void setPasswd(WebElement passwd){
            this.passwd=passwd;
        }
        public WebElement getPasswd(){
            return this.passwd;
        }



}
