package com.example.dllo.gifttalk.beans;

import java.util.List;

/**
 * Created by dllo on 16/11/14.
 */
public class SearchListBean {

    /**
     * code : 200
     * data : {"words":[{"cnt":1,"word":"香水"},{"cnt":543,"word":"香水"},{"cnt":16,"word":"香奈儿香水"},{"cnt":5,"word":"香水小样"},{"cnt":13,"word":"香水套装"},{"cnt":2,"word":"香水中性"},{"cnt":2,"word":"香水十八"},{"cnt":2,"word":"香水Burberry"},{"cnt":1,"word":"香水去"},{"cnt":21,"word":"ck香水"},{"cnt":67,"word":"香水男士"},{"cnt":3,"word":"香水喷雾"},{"cnt":17,"word":"香水女"},{"cnt":114,"word":"香水女士"},{"cnt":3,"word":"日系香水"},{"cnt":3,"word":"小样香水"},{"cnt":5,"word":"雏菊香水"},{"cnt":4,"word":"淡香水"},{"cnt":9,"word":"香水男"},{"cnt":2,"word":"Crabtree香水"},{"cnt":3,"word":"古驰香水"},{"cnt":3,"word":"兰蔻香水"},{"cnt":2,"word":"海藻香水"},{"cnt":27,"word":"少女香水"},{"cnt":17,"word":"香水礼盒"}]}
     * message : OK
     */

    private int code;
    private DataBean data;
    private String message;

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * cnt : 1
         * word : 香水
         */

        private List<WordsBean> words;

        public List<WordsBean> getWords() {
            return words;
        }

        public void setWords(List<WordsBean> words) {
            this.words = words;
        }

        public static class WordsBean {
            private int cnt;
            private String word;

            public int getCnt() {
                return cnt;
            }

            public void setCnt(int cnt) {
                this.cnt = cnt;
            }

            public String getWord() {
                return word;
            }

            public void setWord(String word) {
                this.word = word;
            }
        }
    }
}
