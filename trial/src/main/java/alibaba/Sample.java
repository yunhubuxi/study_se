package alibaba;

import org.apache.commons.beanutils.BeanUtils;

import java.util.*;

public class Sample {

    public static final Map<String, Class> CLASS_MAP;

    List<UserDO> userDOList;
    List<UserVO> userVOList = new ArrayList<>();

    static {
        Map<String, Class> classMap = new HashMap<>(16);
        classMap.put("VARCHAR", java.lang.String.class);
        CLASS_MAP = Collections.unmodifiableMap(classMap);
    }

    public static void main(String[] args) throws Exception{
        Sample sample = new Sample();
        for (UserVO userVO : sample.userVOList) {
            UserDO userDO = new UserDO();
            BeanUtils.copyProperties(userDO, userVO);
        }

    }
}
