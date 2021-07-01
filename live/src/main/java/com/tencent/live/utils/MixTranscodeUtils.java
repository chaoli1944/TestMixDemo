package com.tencent.live.utils;

import android.os.Build;
import android.util.Size;

import com.tencent.liteav.debug.GenerateTestUserSig;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.RequiresApi;

public class MixTranscodeUtils {

    static int videoWidth = 544;
    static int videoHeight = 960;

    static int mixMode1 = TRTCCloudDef.TRTC_TranscodingConfigMode_Manual;
    static int mixMode3 = TRTCCloudDef.TRTC_TranscodingConfigMode_Template_PresetLayout;


    public static void mixTransCodeManual(TRTCCloud mTRTCCloud, String roomId, List<String> subUserList) {
        switch (subUserList.size()) {
            case 0:
                mTRTCCloud.setMixTranscodingConfig(null);
                break;
            case 1:
                mixTransCodeManualTwo(mTRTCCloud,roomId, subUserList);
                break;

            case 2:
                mixTransCodeManualThree(mTRTCCloud,roomId, subUserList);
                break;

            case 3:
                mixTransCodeManualFour(mTRTCCloud,roomId, subUserList);
                break;

            case 4:
                mixTransCodeManualFive(mTRTCCloud, roomId,subUserList);
                break;

            case 5:
                mixTransCodeManualSix(mTRTCCloud,roomId, subUserList);
                break;

            case 6:
                mixTransCodeManualSeven(mTRTCCloud,roomId, subUserList);
                break;

        }
    }

    private static void mixTransCodeManualTwo(TRTCCloud mTRTCCloud, String roomId,List<String> subUserList) {


        int mainWidth = 270;
        int mainHeight = 480;

        int mainOffsetX = 2;
        int mainOffsetY = 160;


        TRTCCloudDef.TRTCTranscodingConfig config = setCanvasQuality(2,mixMode1);

        // 设置混流后主播的画面位置
        List<TRTCCloudDef.TRTCMixUser> mainMixUserList = initMainMixUser(roomId,mainWidth, mainHeight, 2);

        TRTCCloudDef.TRTCMixUser oneMixUser = mainMixUserList.get(0);
        TRTCCloudDef.TRTCMixUser twoMixUser = mainMixUserList.get(1);

        oneMixUser.userId = roomId; // 以主播uid为broadcaster为例
        oneMixUser.x = mainOffsetX;
        oneMixUser.y = mainOffsetY;

        twoMixUser.userId = subUserList.get(0); // 以主播uid为broadcaster为例
        twoMixUser.x = mainOffsetX + mainWidth;
        twoMixUser.y = mainOffsetY;


        config.mixUsers = new ArrayList<>();
        config.mixUsers.add(oneMixUser);
        config.mixUsers.add(twoMixUser);


        mTRTCCloud.setMixTranscodingConfig(config);
    }

    private static void mixTransCodeManualThree(TRTCCloud mTRTCCloud, String roomId,List<String> subUserList) {


        int mainWidth = 270;
        int mainHeight = 360;

        int mainOffsetX = 137;
        int mainOffsetY = 80;


        TRTCCloudDef.TRTCTranscodingConfig config = setCanvasQuality(3,mixMode1);


        // 设置混流后主播的画面位置
        List<TRTCCloudDef.TRTCMixUser> mixUserList = initMainMixUser(roomId,mainWidth, mainHeight, 3);
        TRTCCloudDef.TRTCMixUser trtcMixUser1 = mixUserList.get(0);
        TRTCCloudDef.TRTCMixUser trtcMixUser2 = mixUserList.get(1);
        TRTCCloudDef.TRTCMixUser trtcMixUser3 = mixUserList.get(2);

        trtcMixUser1.userId = roomId;
        trtcMixUser1.x = mainOffsetX;
        trtcMixUser1.y = mainOffsetY;

        trtcMixUser2.userId = subUserList.get(0);
        trtcMixUser2.x = 2;
        trtcMixUser2.y = mainOffsetY + mainHeight;

        trtcMixUser3.userId = subUserList.get(1);
        trtcMixUser3.x = 2 + mainWidth;
        trtcMixUser3.y = mainOffsetY + mainHeight;

        config.mixUsers.add(trtcMixUser1);
        config.mixUsers.add(trtcMixUser2);
        config.mixUsers.add(trtcMixUser3);

        mTRTCCloud.setMixTranscodingConfig(config);
    }

    private static void mixTransCodeManualFour(TRTCCloud mTRTCCloud, String roomId,List<String> subUserList) {

        int mainWidth = 270;
        int mainHeight = 480;

        int mainOffsetX = 2;
        int mainOffsetY = 0;

        TRTCCloudDef.TRTCTranscodingConfig config = setCanvasQuality(4,mixMode1);


        // 设置混流后主播的画面位置
        List<TRTCCloudDef.TRTCMixUser> mixUsers = initMainMixUser(roomId,mainWidth, mainHeight, 4);

        TRTCCloudDef.TRTCMixUser trtcMixUser1 = mixUsers.get(0);
        TRTCCloudDef.TRTCMixUser trtcMixUser2 = mixUsers.get(1);
        TRTCCloudDef.TRTCMixUser trtcMixUser3 = mixUsers.get(2);
        TRTCCloudDef.TRTCMixUser trtcMixUser4 = mixUsers.get(3);

        trtcMixUser1.userId = roomId;
        trtcMixUser1.x = mainOffsetX;
        trtcMixUser1.y = mainOffsetY;

        trtcMixUser2.userId = subUserList.get(0);
        trtcMixUser2.x = mainOffsetX + mainWidth;
        trtcMixUser2.y = mainOffsetY;

        trtcMixUser3.userId = subUserList.get(1);
        trtcMixUser3.x = mainOffsetX;
        trtcMixUser3.y = mainOffsetY + mainHeight;

        trtcMixUser4.userId = subUserList.get(2);
        trtcMixUser4.x = mainOffsetX + mainWidth;
        trtcMixUser4.y = mainOffsetY + mainHeight;

        config.mixUsers.add(trtcMixUser1);
        config.mixUsers.add(trtcMixUser2);
        config.mixUsers.add(trtcMixUser3);
        config.mixUsers.add(trtcMixUser4);


        mTRTCCloud.setMixTranscodingConfig(config);
    }

    private static void mixTransCodeManualFive(TRTCCloud mTRTCCloud,String roomId, List<String> subUserList) {

        int mainWidth = 270;
        int mainHeight = 480;

        int mainOffsetX = 2;
        int mainOffsetY = 40;

        int subWidth = 180;
        int subHeight = 320;

        TRTCCloudDef.TRTCTranscodingConfig config = setCanvasQuality(5,mixMode1);


        // 设置混流后主播的画面位置
        List<TRTCCloudDef.TRTCMixUser> mainMixUsers = initMainMixUser(roomId,mainWidth, mainHeight, 2);
        TRTCCloudDef.TRTCMixUser trtcMixUser1 = mainMixUsers.get(0);
        TRTCCloudDef.TRTCMixUser trtcMixUser2 = mainMixUsers.get(1);

        List<TRTCCloudDef.TRTCMixUser> subMixUsers = initSubMixUser(roomId,subWidth, subHeight, 2, 3);
        TRTCCloudDef.TRTCMixUser trtcMixUser3 = subMixUsers.get(0);
        TRTCCloudDef.TRTCMixUser trtcMixUser4 = subMixUsers.get(1);
        TRTCCloudDef.TRTCMixUser trtcMixUser5 = subMixUsers.get(2);

        trtcMixUser1.userId = roomId;
        trtcMixUser1.x = mainOffsetX;
        trtcMixUser1.y = mainOffsetY;

        trtcMixUser2.userId = subUserList.get(0);
        trtcMixUser2.x = mainOffsetX + mainWidth;
        trtcMixUser2.y = mainOffsetY;

        trtcMixUser3.userId = subUserList.get(1);
        trtcMixUser3.x = mainOffsetX;
        trtcMixUser3.y = mainOffsetY + mainHeight;

        trtcMixUser4.userId = subUserList.get(2);
        trtcMixUser4.x = mainOffsetX + subWidth;
        trtcMixUser4.y = mainOffsetY + mainHeight;

        trtcMixUser5.userId = subUserList.get(3);
        trtcMixUser5.x = mainOffsetX + subWidth + subWidth;
        trtcMixUser5.y = mainOffsetY + mainHeight;

        config.mixUsers.add(trtcMixUser1);
        config.mixUsers.add(trtcMixUser2);
        config.mixUsers.add(trtcMixUser3);
        config.mixUsers.add(trtcMixUser4);
        config.mixUsers.add(trtcMixUser5);


        mTRTCCloud.setMixTranscodingConfig(config);
    }

    private static void mixTransCodeManualSix(TRTCCloud mTRTCCloud, String roomId,List<String> subUserList) {

        int mainWidth = 360;
        int mainHeight = 640;

        int mainOffsetX = 2;
        int mainOffsetY = 0;

        int subWidth = 180;
        int subHeight = 320;

        TRTCCloudDef.TRTCTranscodingConfig config = setCanvasQuality(6,mixMode1);


        // 设置混流后主播的画面位置
        List<TRTCCloudDef.TRTCMixUser> mainMixUsers = initMainMixUser(roomId,mainWidth, mainHeight, 1);

        TRTCCloudDef.TRTCMixUser trtcMixUser1 = mainMixUsers.get(0);
        trtcMixUser1.userId = roomId;
        trtcMixUser1.x = mainOffsetX;
        trtcMixUser1.y = mainOffsetY;

        List<TRTCCloudDef.TRTCMixUser> subMixUsers = initSubMixUser(roomId,subWidth, subHeight, 1, 5);

        TRTCCloudDef.TRTCMixUser trtcMixUser2 = subMixUsers.get(0);
        TRTCCloudDef.TRTCMixUser trtcMixUser3 = subMixUsers.get(1);
        TRTCCloudDef.TRTCMixUser trtcMixUser4 = subMixUsers.get(2);
        TRTCCloudDef.TRTCMixUser trtcMixUser5 = subMixUsers.get(3);
        TRTCCloudDef.TRTCMixUser trtcMixUser6 = subMixUsers.get(4);

        trtcMixUser2.userId = subUserList.get(0);
        trtcMixUser2.x = mainOffsetX + mainWidth;
        trtcMixUser2.y = mainOffsetY;

        trtcMixUser3.userId = subUserList.get(1);
        trtcMixUser3.x = mainOffsetX + mainWidth;
        trtcMixUser3.y = mainOffsetY + subHeight;

        trtcMixUser4.userId = subUserList.get(2);
        trtcMixUser4.x = mainOffsetX;
        trtcMixUser4.y = mainOffsetY + mainHeight;

        trtcMixUser5.userId = subUserList.get(3);
        trtcMixUser5.x = mainOffsetX + subWidth;
        trtcMixUser5.y = mainOffsetY + mainHeight;

        trtcMixUser6.userId = subUserList.get(4);
        trtcMixUser6.x = mainOffsetX + subWidth + subWidth;
        trtcMixUser6.y = mainOffsetY + mainHeight;


        config.mixUsers.add(trtcMixUser1);
        config.mixUsers.add(trtcMixUser2);
        config.mixUsers.add(trtcMixUser3);
        config.mixUsers.add(trtcMixUser4);
        config.mixUsers.add(trtcMixUser5);
        config.mixUsers.add(trtcMixUser6);


        mTRTCCloud.setMixTranscodingConfig(config);
    }

    private static void mixTransCodeManualSeven(TRTCCloud mTRTCCloud, String roomId,List<String> subUserList) {

        int mainWidth = 360;
        int mainHeight = 480;

        int mainOffsetX = 92;
        int mainOffsetY = 0;

        int subWidth = 180;
        int subHeight = 240;

        TRTCCloudDef.TRTCTranscodingConfig config = setCanvasQuality(7,mixMode1);

        // 设置混流后主播的画面位置
        List<TRTCCloudDef.TRTCMixUser> mainMixUser = initMainMixUser(roomId,mainWidth, mainHeight, 1);
        TRTCCloudDef.TRTCMixUser trtcMixUser1 = mainMixUser.get(0);
        trtcMixUser1.userId = roomId;
        trtcMixUser1.x = mainOffsetX;
        trtcMixUser1.y = mainOffsetY;

        List<TRTCCloudDef.TRTCMixUser> subMixUsers = initSubMixUser(roomId,subWidth, subHeight, 1, 6);

        TRTCCloudDef.TRTCMixUser trtcMixUser2 = subMixUsers.get(0);
        TRTCCloudDef.TRTCMixUser trtcMixUser3 = subMixUsers.get(1);
        TRTCCloudDef.TRTCMixUser trtcMixUser4 = subMixUsers.get(2);
        TRTCCloudDef.TRTCMixUser trtcMixUser5 = subMixUsers.get(3);
        TRTCCloudDef.TRTCMixUser trtcMixUser6 = subMixUsers.get(4);
        TRTCCloudDef.TRTCMixUser trtcMixUser7 = subMixUsers.get(5);

        trtcMixUser2.userId = subUserList.get(0);
        trtcMixUser2.x = 2;
        trtcMixUser2.y = mainOffsetY + mainHeight;

        trtcMixUser3.userId = subUserList.get(1);
        trtcMixUser3.x = 2 + subWidth;
        trtcMixUser3.y = mainOffsetY + mainHeight;

        trtcMixUser4.userId = subUserList.get(2);
        trtcMixUser4.x = 2 + subWidth + subWidth;
        trtcMixUser4.y = mainOffsetY + mainHeight;

        trtcMixUser5.userId = subUserList.get(3);
        trtcMixUser5.x = 2;
        trtcMixUser5.y = mainOffsetY + mainHeight + subHeight;

        trtcMixUser6.userId = subUserList.get(4);
        trtcMixUser6.x = 2 + subWidth;
        trtcMixUser6.y = mainOffsetY + mainHeight + subHeight;

        trtcMixUser7.userId = subUserList.get(5);
        trtcMixUser7.x = 2 + subWidth + subWidth;
        trtcMixUser7.y = mainOffsetY + mainHeight + subHeight;

        config.mixUsers.add(trtcMixUser1);
        config.mixUsers.add(trtcMixUser2);
        config.mixUsers.add(trtcMixUser3);
        config.mixUsers.add(trtcMixUser4);
        config.mixUsers.add(trtcMixUser5);
        config.mixUsers.add(trtcMixUser6);
        config.mixUsers.add(trtcMixUser7);


        mTRTCCloud.setMixTranscodingConfig(config);
    }

    public static void mixTransCodeAuto(TRTCCloud mTRTCCloud,String roomId) {

        int mainWidth = 544;
        int mainHeight = 960;

        int mainOffsetX = 0;
        int mainOffsetY = 0;


        int subWidth = 120;
        int subHeight = 160;


        int subOffsetX = 32;
        int subOffsetY = 120;

        TRTCCloudDef.TRTCTranscodingConfig config = setCanvasQuality(2,mixMode3);



        // 设置混流后主播的画面位置
        List<TRTCCloudDef.TRTCMixUser> mainUserList = initMainMixUser(roomId,mainWidth, mainHeight, 1);

        TRTCCloudDef.TRTCMixUser mainMixUser = mainUserList.get(0);

        mainMixUser.userId = "$PLACE_HOLDER_LOCAL_MAIN$"; // 以主播uid为broadcaster为例
        mainMixUser.x = mainOffsetX;
        mainMixUser.y = mainOffsetY;


        config.mixUsers.add(mainMixUser);

        List<TRTCCloudDef.TRTCMixUser> subMixList = initSubMixUser(roomId,subWidth, subHeight, 1, 6);

        for (int i = 0; i < 6; i++) {
            TRTCCloudDef.TRTCMixUser _mixUser = subMixList.get(i);
            _mixUser.userId = "$PLACE_HOLDER_REMOTE$";
            if (i < 3) {
                // 前三个小画面靠右从下往上铺
                _mixUser.x = videoWidth - subOffsetX - subWidth;
                _mixUser.y =  (subOffsetY + subHeight) * (2 - i)+subOffsetY;
                _mixUser.width = subWidth;
                _mixUser.height = subHeight;
            } else if (i >= 3 && i < 6) {
                // 后三个小画面靠左从下往上铺
                _mixUser.x = subOffsetX;
                _mixUser.y = (subOffsetY + subHeight) * (5-i)+subOffsetY;
                _mixUser.width = subWidth;
                _mixUser.height = subHeight;
            } else {
                // 最多只叠加六个小画面
            }
            config.mixUsers.add(_mixUser);
        }
        mTRTCCloud.setMixTranscodingConfig(config);


    }


    public static TRTCCloudDef.TRTCTranscodingConfig setCanvasQuality(int videoNum , int mixMode) {
        TRTCCloudDef.TRTCTranscodingConfig config = new TRTCCloudDef.TRTCTranscodingConfig();
        config.appId = GenerateTestUserSig.APPID;
        config.bizId = GenerateTestUserSig.BIZID;
        config.videoWidth = 544;
        config.videoHeight = 960;
        config.videoGOP = 1;
        config.videoFramerate = 15;
        config.videoBitrate = 1200 + videoNum * 50;
        config.backgroundColor = 0x61B9F1;
        config.audioSampleRate = 48000;
        config.audioBitrate = 64;
        config.audioChannels = 1;
        config.mode = mixMode;
        config.mixUsers = new ArrayList<>();
        return config;

    }


    public static List<TRTCCloudDef.TRTCMixUser> initMainMixUser(String roomId,int mainWidth, int mainHeight, int num) {

        List<TRTCCloudDef.TRTCMixUser> mainUserList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            TRTCCloudDef.TRTCMixUser mixUser = new TRTCCloudDef.TRTCMixUser();
            mixUser.roomId = roomId;
            mixUser.zOrder = i + 1;
            mixUser.streamType = TRTCCloudDef.TRTC_VIDEO_STREAM_TYPE_BIG;
            mixUser.width = mainWidth;
            mixUser.height = mainHeight;
            mainUserList.add(mixUser);
        }

        return mainUserList;
    }


    public static List<TRTCCloudDef.TRTCMixUser> initSubMixUser(String roomId,int subWidth, int subHeight, int mainNum, int subNum) {

        List<TRTCCloudDef.TRTCMixUser> subUserList = new ArrayList<>();
        for (int i = 0; i < subNum; i++) {
            TRTCCloudDef.TRTCMixUser mixUser = new TRTCCloudDef.TRTCMixUser();
            mixUser.roomId = roomId;
            mixUser.zOrder = mainNum + i + 1;
            mixUser.streamType = TRTCCloudDef.TRTC_VIDEO_STREAM_TYPE_BIG;
            mixUser.width = subWidth;
            mixUser.height = subHeight;
            subUserList.add(mixUser);
        }

        return subUserList;
    }


}
