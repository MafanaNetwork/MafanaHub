package me.TahaCheji.proxyData;

public enum Server {

    MAIN_HUB("HUB"),
    SKY_WARS_HUB("SW_HUB"),
    BRIDGE_WIZZERDS_HUB("BW_HUB"),
    MAGIC_TAG_HUB("MT_HUB");


    private final String text;

    Server(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
    

}
