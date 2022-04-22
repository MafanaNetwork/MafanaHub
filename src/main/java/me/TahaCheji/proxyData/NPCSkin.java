package me.TahaCheji.proxyData;

public class NPCSkin {

    public final String uniqueId;
    public final String signature;
    public final String texture;

    public NPCSkin(String uniqueId, String signature, String texture) {
        this.uniqueId = uniqueId;
        this.signature = signature;
        this.texture = texture;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getSignature() {
        return signature;
    }

    public String getTexture() {
        return texture;
    }
}
