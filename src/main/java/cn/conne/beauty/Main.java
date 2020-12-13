package cn.conne.beauty;

import java.io.IOException;

public class Main {

    static final String IMAGE_PATH = "/Users/yangkang/Downloads/IMG_20201212_192740.jpeg";

    public static void main(String[] args) throws IOException {
        testTutuPlastic();
    }

    private static void testTutuPlastic() throws IOException {
        BeautyTutuPlasticBean beautyTutuPlasticBean = new BeautyTutuPlasticBean(IMAGE_PATH);
        BeautyTutuPlasticBean.Args args = new BeautyTutuPlasticBean.Args();
        args.chinSize = 0.6;
        args.eyeEnlargeSize = 0.7;
        beautyTutuPlasticBean.setArgs(args);
        String plastic = BeautyUtils.beautyFaceTutuPlastic(beautyTutuPlasticBean);
        System.out.println(plastic);
    }

    private static void testTutueautify() throws IOException {
        BeautyTutuBeautifyBean beautyTutuBeautifyBean = new BeautyTutuBeautifyBean(IMAGE_PATH);
        BeautyTutuBeautifyBean.Args args = new BeautyTutuBeautifyBean.Args();
        args.fair = 0.6;
        args.ruddy = 0.7;
        beautyTutuBeautifyBean.setArgs(args);
        String beautify = BeautyUtils.beautyFaceTutuBeautify(beautyTutuBeautifyBean);
        System.out.println(beautify);
    }

    private static void testFacePlusPlus() throws IOException {
        BeautyPlusPlusBean beautyPlusPlusBean = new BeautyPlusPlusBean(IMAGE_PATH);
        beautyPlusPlusBean.whitening = 80;
        beautyPlusPlusBean.smoothing = 40;
        beautyPlusPlusBean.remove_eyebrow = 40;
        String result = BeautyUtils.beautyFacePlusPlus(beautyPlusPlusBean);
        System.out.println(result);
    }
}
