package jaiz.jaizmod.item.custom.ancient_horns;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.block.ModBlocks;
import jaiz.jaizmod.sound.ModSounds;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.GoatHornItem;
import net.minecraft.item.Instrument;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class AmethystHornItem extends GoatHornItem {


    public AmethystHornItem(Settings settings, TagKey<Instrument> instrumentTag) {
        super(settings, instrumentTag);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        MutableText mutableText = Text.translatable(Util.createTranslationKey("instrument", Identifier.of("amethyst_horn")));
        tooltip.add(mutableText.formatted(Formatting.GRAY));
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.setCurrentHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), ModSounds.AMETHYST_HORN, SoundCategory.PLAYERS, 15.0f, user.getPitch() * -0.05f + 1f);
        int o = user.getRandom().nextInt(9) + 3;

        if(user.isSneaking()){
            user.getItemCooldownManager().set(this, 320);
            BlockState blockstate = ModBlocks.AMETHYST_THORN.getDefaultState();
            BlockPos blockPos1 = user.getBlockPos().east();
            BlockPos blockPos2 = user.getBlockPos().north();
            BlockPos blockPos3 = user.getBlockPos().west();
            BlockPos blockPos4 = user.getBlockPos().south();
            BlockPos blockPos5 = user.getBlockPos().east().north();
            BlockPos blockPos6 = user.getBlockPos().north().west();
            BlockPos blockPos7 = user.getBlockPos().west().south();
            BlockPos blockPos8 = user.getBlockPos().south().east();

            BlockPos blockPos9 = user.getBlockPos().east(2);
            BlockPos blockPos10 = user.getBlockPos().north(2);
            BlockPos blockPos11 = user.getBlockPos().west(2);
            BlockPos blockPos12 = user.getBlockPos().south(2);


            if(user.getRandom().nextInt(2) == 0){
            if(user.getWorld().getBlockState(user.getBlockPos().east()).isIn(BlockTags.REPLACEABLE)){
            if(user.getWorld().getBlockState(user.getBlockPos().east().down()).isFullCube(world, user.getBlockPos().down())){
            world.setBlockState(blockPos1, blockstate);
            }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.getWorld().getBlockState(user.getBlockPos().north()).isIn(BlockTags.REPLACEABLE)){
                if(user.getWorld().getBlockState(user.getBlockPos().north().down()).isFullCube(world, user.getBlockPos().down())){
                    world.setBlockState(blockPos2, blockstate);
                }}}

                if(user.getRandom().nextInt(2) == 0){
            if(user.getWorld().getBlockState(user.getBlockPos().west()).isIn(BlockTags.REPLACEABLE)){
                if(user.getWorld().getBlockState(user.getBlockPos().west().down()).isFullCube(world, user.getBlockPos().down())){
                    world.setBlockState(blockPos3, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.getWorld().getBlockState(user.getBlockPos().south()).isIn(BlockTags.REPLACEABLE)){
                if(user.getWorld().getBlockState(user.getBlockPos().south().down()).isFullCube(world, user.getBlockPos().down())){
                    world.setBlockState(blockPos4, blockstate);
                }}}



            if(user.getRandom().nextInt(2) == 0){
            if(user.getWorld().getBlockState(user.getBlockPos().east().north()).isIn(BlockTags.REPLACEABLE)){
                if(user.getWorld().getBlockState(user.getBlockPos().east().north().down()).isFullCube(world, user.getBlockPos().down())){
                    world.setBlockState(blockPos5, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.getWorld().getBlockState(user.getBlockPos().north().west()).isIn(BlockTags.REPLACEABLE)){
                if(user.getWorld().getBlockState(user.getBlockPos().north().west().down()).isFullCube(world, user.getBlockPos().down())){
                    world.setBlockState(blockPos6, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.getWorld().getBlockState(user.getBlockPos().west().south()).isIn(BlockTags.REPLACEABLE)){
                if(user.getWorld().getBlockState(user.getBlockPos().west().south().down()).isFullCube(world, user.getBlockPos().down())){
                    world.setBlockState(blockPos7, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.getWorld().getBlockState(user.getBlockPos().south().east()).isIn(BlockTags.REPLACEABLE)){
                if(user.getWorld().getBlockState(user.getBlockPos().south().east().down()).isFullCube(world, user.getBlockPos().down())){
                    world.setBlockState(blockPos8, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.getWorld().getBlockState(user.getBlockPos().east(2)).isIn(BlockTags.REPLACEABLE)){
                if(user.getWorld().getBlockState(user.getBlockPos().east(2).down()).isFullCube(world, user.getBlockPos().down())){
                    world.setBlockState(blockPos9, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.getWorld().getBlockState(user.getBlockPos().north(2)).isIn(BlockTags.REPLACEABLE)){
                if(user.getWorld().getBlockState(user.getBlockPos().north(2).down()).isFullCube(world, user.getBlockPos().down())){
                    world.setBlockState(blockPos10, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.getWorld().getBlockState(user.getBlockPos().west(2)).isIn(BlockTags.REPLACEABLE)){
                if(user.getWorld().getBlockState(user.getBlockPos().west(2).down()).isFullCube(world, user.getBlockPos().down())){
                    world.setBlockState(blockPos11, blockstate);
                }}}

            if(user.getRandom().nextInt(2) == 0){
            if(user.getWorld().getBlockState(user.getBlockPos().south(2)).isIn(BlockTags.REPLACEABLE)){
                if(user.getWorld().getBlockState(user.getBlockPos().south(2).down()).isFullCube(world, user.getBlockPos().down())){
                    world.setBlockState(blockPos12, blockstate);
                }}}




        }else{
            user.getItemCooldownManager().set(this, 120);
            if(user.getWorld() == null || user.getWorld().isClient) {
                Box box = (new Box(user.getBlockPos()).expand(72.0).stretch(0.0, 0.0, 0.0));
                List<LivingEntity> list = user.getWorld().getNonSpectatingEntities(LivingEntity.class, box);
                for (LivingEntity livingEntity  : list) {
                    for (int i = 0; i < o; i++) {
                        livingEntity.getWorld().addParticle(JaizMod.AMETHYST_SPARKLE_PARTICLE, livingEntity.getParticleX(1.2), livingEntity.getRandomBodyY(), livingEntity.getParticleZ(1.2), 0.0, 0.0, 0.0);
                    }
                }
            }

        }
        return TypedActionResult.fail(itemStack);
    }
}
