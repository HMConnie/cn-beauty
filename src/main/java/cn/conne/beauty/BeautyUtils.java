package cn.conne.beauty;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

public class BeautyUtils {

    private BeautyUtils() {

    }


    private static String getSign(TreeMap<String, Object> map, String apiSecret) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String key : map.keySet()) {
            stringBuilder.append(key).append(map.get(key));
        }
        stringBuilder.append(apiSecret);
        return MD5.md5Digest(stringBuilder.toString());


    }


    private static String getTutuOutputResult(Response response) throws IOException {
        if (response.isSuccessful()) {
            BeautyTutuResult result = JSON.parseObject(response.body().toString(), BeautyTutuResult.class);
            if (result.getData() != null) {
                return result.getData().getOutput();
            } else {
                throw new IOException("美颜失败");
            }
        } else {
            throw new IOException("美颜失败");
        }
    }

    /**
     * face++ 美颜
     */
    public static String beautyFacePlusPlus(BeautyPlusPlusBean beautyPlusPlusBean) throws IOException {
        File srcFile = new File(beautyPlusPlusBean.imagePath);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("api_key", "pQi0-1aLIV5vJPxS-G3lvTFL-B3NfxoH")
                .addFormDataPart("api_secret", "dIvT_s-PxJoeBbw_yknAfHpzP0zHAgvy")
                .addFormDataPart("whitening", "" + beautyPlusPlusBean.whitening)//美白程度
                .addFormDataPart("smoothing", "" + beautyPlusPlusBean.smoothing)//磨皮程度，取值范围 [0,100]
                .addFormDataPart("thinface", "" + beautyPlusPlusBean.thinface)//瘦脸程度，取值范围 [0,100]
                .addFormDataPart("enlarge_eye", "" + beautyPlusPlusBean.enlarge_eye)//大眼程度，取值范围 [0,100]
                .addFormDataPart("remove_eyebrow", "" + beautyPlusPlusBean.remove_eyebrow)//去眉毛程度，取值范围 [0,100]
                .addFormDataPart("image_file", srcFile.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), srcFile))
                .build();
        Request request = new Request.Builder()
                .url("https://api-cn.faceplusplus.com/facepp/v2/beautify")
                .post(requestBody)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        if (response.isSuccessful()) {
            return JSON.parseObject(response.body().string(), BeautyFacePlusPlusResult.class).getResult();
        } else {
            throw new IOException("美颜失败");
        }
    }

    /**
     * 人脸微整形
     */
    public static String beautyFaceTutuPlastic(BeautyTutuPlasticBean beautyTutuPlasticBean) throws IOException {
        String sign = getSign(beautyTutuPlasticBean.getParams(), "dIvT_s-PxJoeBbw_yknAfHpzP0zHAgvy");
        File srcFile = new File(beautyTutuPlasticBean.imagePath);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("api_key", "pQi0-1aLIV5vJPxS-G3lvTFL-B3NfxoH")
                .addFormDataPart("sign", sign)
                .addFormDataPart("img", srcFile.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), srcFile))
                .build();
        Request request = new Request.Builder()
                .url("https://api.portrait.tutucloud.com/v1/plastic")
                .post(requestBody)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        return getTutuOutputResult(response);
    }

    /**
     * 人像美颜
     */
    public static String beautyFaceTutuBeautify(BeautyTutuBeautifyBean beautyTutuPlasticBean) throws IOException {
        String sign = getSign(beautyTutuPlasticBean.getParams(), "dIvT_s-PxJoeBbw_yknAfHpzP0zHAgvy");
        File srcFile = new File(beautyTutuPlasticBean.imagePath);
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("api_key", "pQi0-1aLIV5vJPxS-G3lvTFL-B3NfxoH")
                .addFormDataPart("sign", sign)//美白程度 取值范围 [0-100]
                .addFormDataPart("img", srcFile.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), srcFile))
                .build();
        Request request = new Request.Builder()
                .url("https://api.portrait.tutucloud.com/v1/beautify")
                .post(requestBody)
                .build();
        Response response = new OkHttpClient().newCall(request).execute();
        return getTutuOutputResult(response);
    }

//    public static File saveImage(String base64Image) {
//        byte[] bitmapArray = Base64.decode(base64Image, Base64.DEFAULT);
//        Bitmap bmp = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
//        BaseApplication context = AppContext.getInstance();
//        File appDir = new File(context.getFilesDir(), "beauty");
//        if (!appDir.exists()) {
//            appDir.mkdir();
//        }
//        String fileName = System.currentTimeMillis() + ".jpg";
//        File file = new File(appDir, fileName);
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
//            fos.flush();
//            fos.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return file;
//        return null;
//    }
}
