package iran.alirezanazari.domain.entity;

import java.util.List;

public class ChannelsVideo {


    List<VideoByUser> videobyuser ;

    public List<VideoByUser> getVideobyuser() {
        return videobyuser;
    }

    public class VideoByUser{

        String id ;
        String title ;
        String visit_cnt ;
        String sender_name ;
        String small_poster ;
        String profilePhoto ;
        String sdate ;
        String frame ;

        public String getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getVisit_cnt() {
            return visit_cnt;
        }

        public String getSender_name() {
            return sender_name;
        }

        public String getSmall_poster() {
            return small_poster;
        }

        public String getProfilePhoto() {
            return profilePhoto;
        }

        public String getSdate() {
            return sdate;
        }

        public String getFrame() {
            return frame;
        }
    }

}
