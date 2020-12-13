package cn.conne.beauty;

public class BeautyPlusPlusBean {

    public String imagePath;
    public int whitening;//美白程度 取值范围 [0-100]
    public int smoothing;//磨皮程度 取值范围 [0-100]
    public int thinface;//瘦脸程度 取值范围 [0-100]
    public int enlarge_eye;//大眼程度 取值范围 [0-100]
    public int remove_eyebrow;//去眉毛程度 取值范围 [0-100]

    public BeautyPlusPlusBean(String imagePath) {
        this.imagePath = imagePath;
    }
}
