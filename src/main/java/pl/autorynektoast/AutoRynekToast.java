package pl.autorynektoast;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.text.Text;

import java.util.Locale;

public class AutoRynekToast implements ClientModInitializer {
    @Override
    public void onInitializeClient() {}

    public static void zakup(String name, int count, long price) {
        MinecraftClient mc = MinecraftClient.getInstance();
        String cena = String.format(Locale.US, "%,d", price).replace(',', ' ');
        Text tytul = Text.literal("Kupiono: " + name);
        Text opis = Text.literal(count + "x za " + cena);
        // toasty musza isc z glownego watku gry
        mc.execute(() -> SystemToast.add(mc.getToastManager(),
                SystemToast.Type.PERIODIC_NOTIFICATION, tytul, opis));
    }
}
