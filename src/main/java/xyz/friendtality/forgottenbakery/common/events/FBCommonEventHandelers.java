package xyz.friendtality.forgottenbakery.common.events;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.internal.RegistrationEvents;
import net.neoforged.neoforge.registries.RegisterEvent;

import static xyz.friendtality.forgottenbakery.ForrgottenBakery.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.DEDICATED_SERVER)
public class FBCommonEventHandelers {


}
