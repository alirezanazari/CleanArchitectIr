package iran.alirezanazari.domain.entity;

public class Channel {

    profile profile ;

    public profile getProfile() {
        return profile;
    }

    public class profile{

        String pic_m;
        String pic_s;
        String username;
        String name;
        String video_cnt;
        String descr;
        String cover_src;

        public String getPic_m() {
            return pic_m;
        }

        public String getPic_s() {
            return pic_s;
        }

        public String getName() {
            return name;
        }

        public String getVideo_cnt() {
            return video_cnt;
        }

        public String getDescr() {
            return descr;
        }

        public String getCover_src() {
            return cover_src;
        }

        public String getUsername() {
            return username;
        }
    }

}
