package cn.conne.beauty;


import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.TreeMap;

public class BeautyTutuBeautifyBean {

    @Ignore
    public String imagePath;
    public String args;

    public BeautyTutuBeautifyBean(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setArgs(Args args) {
        this.args = JSON.toJSONString(args);
    }

    public TreeMap<String, Object> getParams() {
        TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
        Field[] fields = this.getClass().getFields();
        for (Field field : fields) {
            String name = field.getName();
            if (field.getAnnotation(Ignore.class) != null) {
                continue;
            }
            try {
                treeMap.put(name, field.get(this));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return treeMap;

    }

    /**
     * smoothing	[0.0, 1.0]	0.5	磨皮
     * fair	[0.0, 1.0]	0.0	美白
     * ruddy	[0.0, 1.0]	0.0	红润
     */
    public static class Args {
        public double smoothing;//磨皮
        public double fair;//美白
        public double ruddy;//红润
    }
}
