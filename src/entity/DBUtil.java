package entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {
    Map<String, List> userData = new HashMap<String, List>();

    public Map<String, List> getUserData() {
        return userData;
    }

    public void setUserData(Map<String, List> userData) {
        this.userData = userData;
    }

}
