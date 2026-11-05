package pl.autorynektoast.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pl.autorynektoast.AutoRynekToast;

/** Hook na AutoRynekAnarchiaClient.recordPurchase(String, int, long) - wola sie przy kazdym zakupie. */
@Pseudo
@Mixin(targets = "pl.swiet.autorynekanarchia.AutoRynekAnarchiaClient", remap = false)
public abstract class ClientMixin {

    @Inject(method = "recordPurchase", at = @At("HEAD"), remap = false)
    private void autorynektoast$onPurchase(String name, int count, long price, CallbackInfo ci) {
        try {
            AutoRynekToast.zakup(name, count, price);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
