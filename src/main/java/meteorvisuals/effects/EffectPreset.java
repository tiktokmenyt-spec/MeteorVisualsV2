package meteorvisuals.effects;

import com.google.gson.annotations.SerializedName;

public class EffectPreset {
    private String id = "preset_id";
    private String name = "Untitled Effect";
    private String particleShape = "circle";
    private String spawnPattern = "burst";
    private int particleCount = 12;
    private int lifetime = 800;
    private float size = 1.0f;
    private float speed = 0.5f;
    private float gravity = 0.0f;
    private String colorMode = "Solid";
    private int colorStart = 0xFFFFFFFF;
    private int colorEnd = 0xFF00FFAA;
    private String opacityCurve = "linear";
    private String triggerEvent = "Hit";
    private String textureRef = "";

    public static EffectPreset createDefault() {
        return new EffectPreset();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParticleShape() {
        return particleShape;
    }

    public void setParticleShape(String particleShape) {
        this.particleShape = particleShape;
    }

    public String getSpawnPattern() {
        return spawnPattern;
    }

    public void setSpawnPattern(String spawnPattern) {
        this.spawnPattern = spawnPattern;
    }

    public int getParticleCount() {
        return particleCount;
    }

    public void setParticleCount(int particleCount) {
        this.particleCount = particleCount;
    }

    public int getLifetime() {
        return lifetime;
    }

    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public String getColorMode() {
        return colorMode;
    }

    public void setColorMode(String colorMode) {
        this.colorMode = colorMode;
    }

    public int getColorStart() {
        return colorStart;
    }

    public void setColorStart(int colorStart) {
        this.colorStart = colorStart;
    }

    public int getColorEnd() {
        return colorEnd;
    }

    public void setColorEnd(int colorEnd) {
        this.colorEnd = colorEnd;
    }

    public String getOpacityCurve() {
        return opacityCurve;
    }

    public void setOpacityCurve(String opacityCurve) {
        this.opacityCurve = opacityCurve;
    }

    public String getTriggerEvent() {
        return triggerEvent;
    }

    public void setTriggerEvent(String triggerEvent) {
        this.triggerEvent = triggerEvent;
    }

    public String getTextureRef() {
        return textureRef;
    }

    public void setTextureRef(String textureRef) {
        this.textureRef = textureRef;
    }
}
