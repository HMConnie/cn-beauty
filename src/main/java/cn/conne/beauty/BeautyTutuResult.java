package cn.conne.beauty;

public class BeautyTutuResult {

    /**
     * message : Success
     * code : 200
     * data : {"input":"https://file.portrait.tutucloud.com/g03/M00/01/0C/wKjIZ1yq69aAecIIAAD5oHJ2ocA15.jpg","output":"https://file.portrait.tutucloud.com/g04/M00/01/0C/wKjIaFyq69qACZArAADvHmvAzBk512.jpg"}
     */

    private String message;
    private int code;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * input : https://file.portrait.tutucloud.com/g03/M00/01/0C/wKjIZ1yq69aAecIIAAD5oHJ2ocA15.jpg
         * output : https://file.portrait.tutucloud.com/g04/M00/01/0C/wKjIaFyq69qACZArAADvHmvAzBk512.jpg
         */

        private String input;
        private String output;

        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }

        public String getOutput() {
            return output;
        }

        public void setOutput(String output) {
            this.output = output;
        }
    }
}
