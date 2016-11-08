package com.example.dllo.gifttalk.beans;

import java.util.List;

/**
 * Created by dllo on 16/10/29.
 */
public class TabLayoutBeansGift {

    /**
     * code : 200
     * data : {"ranks":[{"id":6,"mark_style":1,"name":"双11预售","title":"买神驾到，双11必买清单","update_at":1477648878},{"id":2,"mark_style":1,"name":"TOP100","title":"TOP100榜单，把最受欢迎的好礼打包送上","update_at":1475923666},{"id":3,"mark_style":1,"name":"独立原创榜","title":"独立原创榜，帮你找到独一无二的好礼","update_at":1477584000},{"id":4,"mark_style":1,"name":"新星榜","title":"礼物新星榜，最新最火单品推荐","update_at":1477670400}]}
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
         * id : 6
         * mark_style : 1
         * name : 双11预售
         * title : 买神驾到，双11必买清单
         * update_at : 1477648878
         */

        private List<RanksBean> ranks;

        public List<RanksBean> getRanks() {
            return ranks;
        }

        public void setRanks(List<RanksBean> ranks) {
            this.ranks = ranks;
        }

        public static class RanksBean {
            private int id;
            private int mark_style;
            private String name;
            private String title;
            private int update_at;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMark_style() {
                return mark_style;
            }

            public void setMark_style(int mark_style) {
                this.mark_style = mark_style;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getUpdate_at() {
                return update_at;
            }

            public void setUpdate_at(int update_at) {
                this.update_at = update_at;
            }
        }
    }
}

