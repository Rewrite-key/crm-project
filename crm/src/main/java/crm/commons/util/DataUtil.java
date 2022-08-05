package crm.commons.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    public static String formatDateTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataStr = sdf.format(date);
        return dataStr;
    }
}
