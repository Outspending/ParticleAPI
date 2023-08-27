package me.outspending.particleapi.nms;

import me.outspending.nms.*;

public class NMSHandler {

    protected static NMS nms;

    public static void setVersion(String version) {
        if (nms != null) return;

        switch (version) {
            case "1.17", "1.17.1" -> {
                nms = new NMS_1_17_R1();
            }
            case "1.18", "1.18.1" -> {
                nms = new NMS_1_18_R1();
            }
            case "1.18.2" -> {
                nms = new NMS_1_18_R2();
            }
            case "1.19", "1.19.1", "1.19.2" -> {
                nms = new NMS_1_19_R1();
            }
            case "1.19.3" -> {
                nms = new NMS_1_19_R2();
            }
            case "1.19.4" -> {
                nms = new NMS_1_19_R3();
            }
            case "1.20", "1.20.1" -> {
                nms = new NMS_1_20_R1();
            }
            default -> {
                throw new IllegalArgumentException("Unsupported version: " + version);
            }
        }
    }

    public static boolean hasNMS() {
        return nms != null;
    }

    public static NMS getNMS() {
        return nms;
    }
}
