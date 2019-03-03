package com.yahoo.util;

import com.yahoo.model.MyBiaoTargetEnum;
import org.apache.commons.lang3.StringUtils;

public class BiaoUtil {
    public static MyBiaoTargetEnum transBiao(String biaoStr) {
        if(StringUtils.isEmpty(biaoStr)){
            return null;
        }
        if("二大王".equals(biaoStr)){
            return MyBiaoTargetEnum.EDW;
        }
        if("空虔禅师".equals(biaoStr)){
            return MyBiaoTargetEnum.KD;
        }
        if("金 程咬".equals(biaoStr)){
            return MyBiaoTargetEnum.CYJ;
        }
        if("观音姐姐".equals(biaoStr)){
            return MyBiaoTargetEnum.GYJJ;
        }
        if("地藏王".equals(biaoStr)){
            return MyBiaoTargetEnum.DZW;
        }
        if("东诲龙王".equals(biaoStr)){
            return MyBiaoTargetEnum.DHLW;
        }
        if("仙 缰兀六".equals(biaoStr)){
            return MyBiaoTargetEnum.ZYDX;
        }
        if("花十娘".equals(biaoStr)){
            return MyBiaoTargetEnum.HSN;
        }
        if("窨浸祖师".equals(biaoStr)){
            return MyBiaoTargetEnum.PTZS;
        }
        if("秦琼".equals(biaoStr)){
            return MyBiaoTargetEnum.QQ;
        }
        if("六六王".equals(biaoStr)){
            return MyBiaoTargetEnum.DDW;
        }
        return null;
    }
}
