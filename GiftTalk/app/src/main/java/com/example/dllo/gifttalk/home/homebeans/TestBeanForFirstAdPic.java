package com.example.dllo.gifttalk.home.homebeans;

import java.util.List;

/**
 * Created by dllo on 16/10/29.
 *  首页精品type:ad
 */
public class TestBeanForFirstAdPic {

    /**
     * code : 200
     * data : {"items":[{"ad_monitors":[],"ad_type":1,"created_at":1477712368,"end_at":1477812806,"gap_days":0,"id":71,"image_url":"http://img02.liwushuo.com/image/161027/t3mua549n.jpg-w720","in_list_order":5,"redirect_type":10,"redirect_value":"liwushuo:///page?type=post&post_id=1046309&page_action=navigation","start_at":1477553606,"title":"双11预告","type":"ad","uri":"liwushuo:///page?type=post&post_id=1046309&page_action=navigation","webp_url":"http://img02.liwushuo.com/image/161027/t3mua549n.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"ad_type":1,"created_at":1477625968,"end_at":1509067497,"gap_days":1,"id":70,"image_url":"http://img03.liwushuo.com/image/161027/zb420b50n.jpg-w720","in_list_order":1,"redirect_type":10,"redirect_value":"liwushuo:///page?type=post&post_id=1046191&page_action=navigation","start_at":1477531497,"title":"礼包广告位","type":"ad","uri":"liwushuo:///page?type=post&post_id=1046191&page_action=navigation","webp_url":"http://img03.liwushuo.com/image/161027/zb420b50n.jpg?imageView2/2/w/720/q/85/format/webp"}],"paging":{"next_url":"http://api.liwushuo.com/v2/channels/108/items?set=0&ad=2&generation=4&gender=1&limit=20&offset=20"}}
     * message : OK
     */

    private int code;
    /**
     * items : [{"ad_monitors":[],"ad_type":1,"created_at":1477712368,"end_at":1477812806,"gap_days":0,"id":71,"image_url":"http://img02.liwushuo.com/image/161027/t3mua549n.jpg-w720","in_list_order":5,"redirect_type":10,"redirect_value":"liwushuo:///page?type=post&post_id=1046309&page_action=navigation","start_at":1477553606,"title":"双11预告","type":"ad","uri":"liwushuo:///page?type=post&post_id=1046309&page_action=navigation","webp_url":"http://img02.liwushuo.com/image/161027/t3mua549n.jpg?imageView2/2/w/720/q/85/format/webp"},{"ad_monitors":[],"ad_type":1,"created_at":1477625968,"end_at":1509067497,"gap_days":1,"id":70,"image_url":"http://img03.liwushuo.com/image/161027/zb420b50n.jpg-w720","in_list_order":1,"redirect_type":10,"redirect_value":"liwushuo:///page?type=post&post_id=1046191&page_action=navigation","start_at":1477531497,"title":"礼包广告位","type":"ad","uri":"liwushuo:///page?type=post&post_id=1046191&page_action=navigation","webp_url":"http://img03.liwushuo.com/image/161027/zb420b50n.jpg?imageView2/2/w/720/q/85/format/webp"}]
     * paging : {"next_url":"http://api.liwushuo.com/v2/channels/108/items?set=0&ad=2&generation=4&gender=1&limit=20&offset=20"}
     */

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
         * next_url : http://api.liwushuo.com/v2/channels/108/items?set=0&ad=2&generation=4&gender=1&limit=20&offset=20
         */

        private PagingBean paging;
        /**
         * ad_monitors : []
         * ad_type : 1
         * created_at : 1477712368
         * end_at : 1477812806
         * gap_days : 0
         * id : 71
         * image_url : http://img02.liwushuo.com/image/161027/t3mua549n.jpg-w720
         * in_list_order : 5
         * redirect_type : 10
         * redirect_value : liwushuo:///page?type=post&post_id=1046309&page_action=navigation
         * start_at : 1477553606
         * title : 双11预告
         * type : ad
         * uri : liwushuo:///page?type=post&post_id=1046309&page_action=navigation
         * webp_url : http://img02.liwushuo.com/image/161027/t3mua549n.jpg?imageView2/2/w/720/q/85/format/webp
         */

        private List<ItemsBean> items;

        public PagingBean getPaging() {
            return paging;
        }

        public void setPaging(PagingBean paging) {
            this.paging = paging;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class PagingBean {
            private String next_url;

            public String getNext_url() {
                return next_url;
            }

            public void setNext_url(String next_url) {
                this.next_url = next_url;
            }
        }

        public static class ItemsBean {
            private int ad_type;
            private int created_at;
            private int end_at;
            private int gap_days;
            private int id;
            private String image_url;
            private int in_list_order;
            private int redirect_type;
            private String redirect_value;
            private int start_at;
            private String title;
            private String type;
            private String uri;
            private String webp_url;
            private List<?> ad_monitors;

            public int getAd_type() {
                return ad_type;
            }

            public void setAd_type(int ad_type) {
                this.ad_type = ad_type;
            }

            public int getCreated_at() {
                return created_at;
            }

            public void setCreated_at(int created_at) {
                this.created_at = created_at;
            }

            public int getEnd_at() {
                return end_at;
            }

            public void setEnd_at(int end_at) {
                this.end_at = end_at;
            }

            public int getGap_days() {
                return gap_days;
            }

            public void setGap_days(int gap_days) {
                this.gap_days = gap_days;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public int getIn_list_order() {
                return in_list_order;
            }

            public void setIn_list_order(int in_list_order) {
                this.in_list_order = in_list_order;
            }

            public int getRedirect_type() {
                return redirect_type;
            }

            public void setRedirect_type(int redirect_type) {
                this.redirect_type = redirect_type;
            }

            public String getRedirect_value() {
                return redirect_value;
            }

            public void setRedirect_value(String redirect_value) {
                this.redirect_value = redirect_value;
            }

            public int getStart_at() {
                return start_at;
            }

            public void setStart_at(int start_at) {
                this.start_at = start_at;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getUri() {
                return uri;
            }

            public void setUri(String uri) {
                this.uri = uri;
            }

            public String getWebp_url() {
                return webp_url;
            }

            public void setWebp_url(String webp_url) {
                this.webp_url = webp_url;
            }

            public List<?> getAd_monitors() {
                return ad_monitors;
            }

            public void setAd_monitors(List<?> ad_monitors) {
                this.ad_monitors = ad_monitors;
            }
        }
    }
}
