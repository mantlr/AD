package com.imooc.ad.constant;

import lombok.Getter;

/**
 * @author Swallow
 */
@Getter
public enum CreativeMetriaType {

    JPG(1,"jpg"),
    BMP(2,"bmp"),

    MP4(3,"mp4"),
    AVI(4,"avi"),

    TXT(5,"txt");

    private int type;

    private String desc;

    CreativeMetriaType(int type, String desc){
        this.type = type;
        this.desc = desc;
    }



}
