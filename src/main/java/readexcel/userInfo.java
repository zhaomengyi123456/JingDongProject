package readexcel;

/**
 * Created by Administrator on 2016/12/27.
 */
public class userInfo {
    private String username;
    private Object passwd;
    private String jieguo;

    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return this.username;
    }
    public void setPasswd(String passwd){
        this.passwd=passwd;
    }
    public Object getPasswd(){
        return this.passwd;
    }
    public void setJieguo(String jieguo){
        this.jieguo=jieguo;
    }
    public String getResult(){
        return this.jieguo;
    }

}
