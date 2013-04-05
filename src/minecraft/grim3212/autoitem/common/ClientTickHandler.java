package grim3212.autoitem.common;

import grim3212.autoitem.AutomaticItemReplacer;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ClientTickHandler implements ITickHandler {

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		// TODO Auto-generated method stub

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		if (type.equals(EnumSet.of(TickType.RENDER))) {
			onRenderTick();
		} else if (type.equals(EnumSet.of(TickType.CLIENT))) {
			GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
			if (guiscreen != null) {
				onTickInGUI(guiscreen);
			} else {
				onTickInGame();
			}
		}

	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.RENDER, TickType.CLIENT);
	}

	@Override
	public String getLabel() {
		return null;
	}

	public void onRenderTick() {
	}

	public void onTickInGUI(GuiScreen guiscreen) {
	}

	public void onTickInGame() {
		Minecraft mc = FMLClientHandler.instance().getClient().getMinecraft();

		ItemStack currentItemStack = null;

		EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
		int currentItem = player.inventory.currentItem;
		if (mc.currentScreen == null) {
			ItemStack[] inventory = player.inventory.mainInventory;
			currentItemStack = inventory[currentItem];
			if (currentItemStack == null && AutomaticItemReplacer.prevItemStack != null && currentItem == AutomaticItemReplacer.prevItem) {
				Item item = AutomaticItemReplacer.prevItemStack.getItem();
				boolean subTypes = AutomaticItemReplacer.prevItemStack.getHasSubtypes();
				boolean stackable = AutomaticItemReplacer.prevItemStack.isStackable();
				boolean damageable = AutomaticItemReplacer.prevItemStack.isItemStackDamageable();
				int damage = AutomaticItemReplacer.prevItemStack.getItemDamage();

				int found = -1;
				for (int i = 9; i < inventory.length; i++) {
					ItemStack foundItemStack = inventory[i];
					if (foundItemStack != null && item == foundItemStack.getItem() && (!subTypes || damage == foundItemStack.getItemDamage()) && foundItemStack.stackSize > 0) {
						if (found < 0) {
							found = i;
						} else if (!stackable) {
							if (!damageable) {
								found = i;
							} else if (foundItemStack.getItemDamage() > inventory[found].getItemDamage()) {
								found = i;
							}
						} else if (foundItemStack.stackSize > inventory[found].stackSize) {
							found = i;
						}
					}
				}

				if (found >= 0) {
					PlayerControllerMP playerController = mc.playerController;
					int windowId = player.inventoryContainer.windowId;

					playerController.windowClick(windowId, found, 0, 0, player);
					playerController.windowClick(windowId, currentItem + inventory.length, 0, 0, player);

					currentItemStack = inventory[currentItem];
				}
			}
		}

		AutomaticItemReplacer.prevItem = currentItem;
		AutomaticItemReplacer.prevItemStack = currentItemStack;

		return;

	}

}
