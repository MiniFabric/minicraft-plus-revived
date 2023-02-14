package minicraft.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import minicraft.core.Game;
import minicraft.core.io.Localization;
import minicraft.core.io.Sound;
import minicraft.entity.Direction;
import minicraft.entity.mob.Player;
import minicraft.gfx.SpriteLinker;
import minicraft.gfx.SpriteLinker.LinkedSprite;
import minicraft.gfx.SpriteLinker.SpriteType;
import minicraft.level.Level;
import minicraft.level.tile.Tile;
import minicraft.level.tile.Tiles;
import org.tinylog.Logger;

public class TileItem extends StackableItem {

	protected static ArrayList<Item> getAllInstances() {
		ArrayList<Item> items = new ArrayList<>();

		/// TileItem sprites all have 1x1 sprites.
		items.add(new TileItem("Flower", new LinkedSprite(SpriteType.Item, "white_flower"), new TileModel("flower"), "grass"));
		items.add(new TileItem("Acorn", new LinkedSprite(SpriteType.Item, "acorn"), new TileModel("tree Sapling"), "grass"));
		items.add(new TileItem("Dirt", new LinkedSprite(SpriteType.Item, "dirt"), new TileModel("dirt"), "hole", "water", "lava"));
		items.add(new TileItem("Natural Rock", new LinkedSprite(SpriteType.Item, "stone"), new TileModel("rock"), "hole", "dirt", "sand", "grass", "path", "water", "lava"));

		items.add(new TileItem("Plank", new LinkedSprite(SpriteType.Item, "plank"), new TileModel("Wood Planks"), "hole", "water", "cloud"));
		items.add(new TileItem("Plank Wall", new LinkedSprite(SpriteType.Item, "plank_wall"), new TileModel("Wood Wall"), "Wood Planks"));
		items.add(new TileItem("Wood Door", new LinkedSprite(SpriteType.Item, "wood_door"), new TileModel("Wood Door"), "Wood Planks"));
		items.add(new TileItem("Stone", new LinkedSprite(SpriteType.Item, "stone"), new TileModel("Stone"), "hole", "water", "cloud", "lava"));
		items.add(new TileItem("Stone Brick", new LinkedSprite(SpriteType.Item, "stone_brick"), new TileModel("Stone Bricks"), "hole", "water", "cloud", "lava"));
		items.add(new TileItem("Ornate Stone", new LinkedSprite(SpriteType.Item, "stone_brick"), new TileModel("Ornate Stone"), "hole", "water", "cloud", "lava"));
		items.add(new TileItem("Stone Wall", new LinkedSprite(SpriteType.Item, "stone_wall"), new TileModel("Stone Wall"), "Stone Bricks"));
		items.add(new TileItem("Stone Door", new LinkedSprite(SpriteType.Item, "stone_wall"), new TileModel("Stone Door"), "Stone Bricks"));
		items.add(new TileItem("Raw Obsidian", new LinkedSprite(SpriteType.Item, "obsidian"), new TileModel("Raw Obsidian"), "hole", "water", "cloud", "lava"));
		items.add(new TileItem("Obsidian Brick", new LinkedSprite(SpriteType.Item, "obsidian_brick"), new TileModel("Obsidian"), "hole", "water", "cloud", "lava"));
		items.add(new TileItem("Ornate Obsidian", new LinkedSprite(SpriteType.Item, "obsidian_brick"), new TileModel("Ornate Obsidian"),"hole", "water", "cloud", "lava"));
		items.add(new TileItem("Obsidian Wall", new LinkedSprite(SpriteType.Item, "obsidian_wall"), new TileModel("Obsidian Wall"), "Obsidian"));
		items.add(new TileItem("Obsidian Door", new LinkedSprite(SpriteType.Item, "obsidian_door"), new TileModel("Obsidian Door"), "Obsidian"));

		items.add(new TileItem("Wool", new LinkedSprite(SpriteType.Item, "wool"), new TileModel("Wool"), "hole", "water"));
		items.add(new TileItem("Red Wool", new LinkedSprite(SpriteType.Item, "red_wool"), new TileModel("Red Wool"), "hole", "water"));
		items.add(new TileItem("Blue Wool", new LinkedSprite(SpriteType.Item, "blue_wool"), new TileModel("Blue Wool"), "hole", "water"));
		items.add(new TileItem("Green Wool", new LinkedSprite(SpriteType.Item, "green_wool"), new TileModel("Green Wool"), "hole", "water"));
		items.add(new TileItem("Yellow Wool", new LinkedSprite(SpriteType.Item, "yellow_wool"), new TileModel("Yellow Wool"), "hole", "water"));
		items.add(new TileItem("Black Wool", new LinkedSprite(SpriteType.Item, "black_wool"), new TileModel("Black Wool"), "hole", "water"));

		items.add(new TileItem("Sand", new LinkedSprite(SpriteType.Item, "sand"), new TileModel("sand"), "hole", "water", "lava"));
		items.add(new TileItem("Cactus", new LinkedSprite(SpriteType.Item, "cactus"), new TileModel("cactus Sapling"), "sand"));
		items.add(new TileItem("Cloud", new LinkedSprite(SpriteType.Item, "cloud"), new TileModel("cloud"), "Infinite Fall"));

		items.add(new TileItem("Wheat Seeds", new LinkedSprite(SpriteType.Item, "seed"), new TileModel("wheat", TileModel.KEEP_DATA), "farmland"));
		items.add(new TileItem("Potato", new LinkedSprite(SpriteType.Item, "potato"), new TileModel("potato", TileModel.KEEP_DATA), "farmland"));
		items.add(new TileItem("Carrot", new LinkedSprite(SpriteType.Item, "carrot"), new TileModel("carrot", TileModel.KEEP_DATA), "farmland"));
		items.add(new TileItem("Beetroot Seeds", new LinkedSprite(SpriteType.Item, "seed"), new TileModel("beetroot", TileModel.KEEP_DATA), "farmland"));
		items.add(new TileItem("Grass Seeds", new LinkedSprite(SpriteType.Item, "seed"), new TileModel("grass"), "dirt"));

		// Creative mode available tiles:
		items.add(new TileItem("Farmland", SpriteLinker.missingTexture(SpriteType.Item), new TileModel("farmland"), "dirt", "grass", "hole"));
		items.add(new TileItem("hole", SpriteLinker.missingTexture(SpriteType.Item), new TileModel("hole"), "dirt", "grass"));
		items.add(new TileItem("lava", SpriteLinker.missingTexture(SpriteType.Item), new TileModel("lava"), "dirt", "grass", "hole"));
		items.add(new TileItem("path", SpriteLinker.missingTexture(SpriteType.Item), new TileModel("path"), "dirt", "grass", "hole"));
		items.add(new TileItem("water", SpriteLinker.missingTexture(SpriteType.Item), new TileModel("water"), "dirt", "grass", "hole"));

		return items;
	}

	public final TileModel model;
	public final List<String> validTiles;

	protected TileItem(String name, LinkedSprite sprite, TileModel model, String... validTiles) {
		this(name, sprite, 1, model, Arrays.asList(validTiles));
	}
	protected TileItem(String name, LinkedSprite sprite, int count, TileModel model, String... validTiles) {
		this(name, sprite, count, model, Arrays.asList(validTiles));
	}
	protected TileItem(String name, LinkedSprite sprite, int count, TileModel model, List<String> validTiles) {
		super(name, sprite, count);
		this.model = model;
		this.validTiles = new ArrayList<>();
		for (String tile: validTiles)
			 this.validTiles.add(tile.toUpperCase());
	}

	public static class TileModel {
		public static final TileDataGetter DEFAULT_DATA = ((model, target, level, xt, yt, player, attackDir) -> model.getDefaultData());
		public static final TileDataGetter KEEP_DATA = ((model, target, level, xt, yt, player, attackDir) -> level.getData(xt, yt));

		public final String tile;
		public final TileDataGetter data;

		@FunctionalInterface
		interface TileDataGetter {
			int getTileData(Tile model, Tile target, Level level, int xt, int yt, Player player, Direction attackDir);
		}

		public TileModel(String tile) { this(tile, DEFAULT_DATA); }
		public TileModel(String tile, TileDataGetter data) {
			this.tile = tile.toUpperCase();
			this.data = data;
		}
	}

	public boolean interactOn(Tile tile, Level level, int xt, int yt, Player player, Direction attackDir) {
		for (String tilename : validTiles) {
			if (tile.matches(level.getData(xt, yt), tilename)) {
				Tile t = Tiles.get(model.tile);
				level.setTile(xt, yt, t, model.data.getTileData(t, tile, level, xt, yt, player, attackDir));
				Sound.play("craft");
				return super.interactOn(true);
			}
		}

		Logger.tag("TileItem").debug("{} cannot be placed on {}.", model, tile.name);

		String note = "";
		if (model.tile.contains("WALL")) {
			note = Localization.getLocalized("minicraft.notification.invalid_placement", Tiles.getName(validTiles.get(0)));
		}
		else if (model.tile.contains("DOOR")) {
			note = Localization.getLocalized("minicraft.notification.invalid_placement", Tiles.getName(validTiles.get(0)));
		}
		else if ((model.tile.contains("BRICK") || model.tile.contains("PLANK") || model.tile.equals("STONE") || model.tile.contains("ORNATE"))) {
			note = Localization.getLocalized("minicraft.notification.dig_hole");
		}

		if (note.length() > 0) {
			Game.notifications.add(note);
		}

		return super.interactOn(false);
	}

	@Override
	public boolean equals(Item other) {
		return super.equals(other) && model.equals(((TileItem)other).model);
	}

	@Override
	public int hashCode() { return super.hashCode() + model.hashCode(); }

	public TileItem clone() {
		return new TileItem(getName(), sprite, count, model, validTiles);
	}
}
