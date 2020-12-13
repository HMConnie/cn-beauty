package cn.conne.beauty;


import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.TreeMap;

public class BeautyTutuPlasticBean {

    @Ignore
    public String imagePath;
    public String args;

    public BeautyTutuPlasticBean(String imagePath) {
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
     * eyeEnlargeSize	[0.0, 1.0]	0.6	大眼
     * chinSize	[0.0, 1.0]	0.5	瘦脸
     * noseSize	[0.0, 1.0]	0.0	瘦鼻
     * mouthWidth	[-1.0, 1.0]	0.0	嘴宽
     * eyebrowArch	[-1.0, 1.0]	0.0	眉宽
     * eyeDis	[-1.0, 1.0]	0.0	眼距
     * eyeAngle	[-1.0, 1.0]	0.0	眼角
     * jawSize	[-1.0, 1.0]	0.0	下巴
     */
    public static class Args {
        public double eyeEnlargeSize;//大眼
        public double chinSize;//瘦脸
        public double noseSize;//瘦鼻
        public double mouthWidth;//嘴宽
        public double eyebrowArch;//眉宽
        public double eyeDis;//眼距
        public double eyeAngle;//眼角
        public double jawSize;//下巴


    }
}
