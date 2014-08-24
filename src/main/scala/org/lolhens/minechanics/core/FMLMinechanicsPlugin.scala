package org.lolhens.minechanics.core

import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions
import org.lolhens.minechanics.Minechanics
import cpw.mods.fml.relauncher.IFMLLoadingPlugin
import java.io.File
import cpw.mods.fml.relauncher.IFMLCallHook
import org.lolhens.minechanics.common.util.LogHelper
import org.lolhens.minechanics.core.asm.ClassTransformer
import FMLMinechanicsPlugin._

@TransformerExclusions(Array("org.lolhens.minechanics.core"))
@MCVersion(Minechanics.McVersion)
class FMLMinechanicsPlugin extends IFMLLoadingPlugin {
  override def getASMTransformerClass() = Array(classOf[ClassTransformer].getName)
  override def getModContainerClass() = null
  override def getAccessTransformerClass() = null
  override def getSetupClass() = classOf[SetupClass].getName
  override def injectData(data: java.util.Map[String, Object]) = {}
}

object FMLMinechanicsPlugin {
  var location: File = null;

  class SetupClass extends IFMLCallHook {
    override def call() = {
      LogHelper.info("coremod loaded")
      null
    }
    override def injectData(data: java.util.Map[String, Object]) = location = data.get("coremodLocation").asInstanceOf[File];
  }

  class AccessTransformer extends cpw.mods.fml.common.asm.transformers.AccessTransformer(Minechanics.AccessTransformer) {
  }
}