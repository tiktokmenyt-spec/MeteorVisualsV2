package meteorvisuals.mixin;

import net.minecraft.client.render.WorldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public abstract class WorldRendererMixin {
    @Inject(method = "render", at = @At("HEAD"))
    private void meteorvisuals$beforeRender(CallbackInfo ci) {
        // Hook point for custom client-side visual rendering.
        // The mod intentionally does not alter gameplay logic or entity simulation.
    }
}
