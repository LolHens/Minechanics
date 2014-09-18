package org.lolhens.minechanics.core.asm

import org.lolhens.minechanics.core.storageaccess._
import org.lolhens.minechanics.core.storageaccess.json._
import org.objectweb.asm.tree.{InsnList, InsnNode, MethodNode}

import scala.collection._

object Transformations {
  val transformations = mutable.Map[String, Transformation]()

  private def read(file: String) = {
    val insnLists = mutable.Map[String, InsnList]()
    val methods = mutable.Map[String, MethodNode]()
    val triggers = mutable.Map[String, Transformation.Trigger]()

    val root = JsonObject.fromFile(file)

    for (insnList <- root.vars.insnLists) if (insnList.isInstanceOf[JsonMap]) parseInsnList(insnList.asInstanceOf[JsonMap])

    def parseInsnList(map: StorageAccess) = {
      val name: String = map.name
      if (name != null) {
        val test = new InsnList()
        test.add(new InsnNode(5))
        val insns = for (insn <- map.insns) yield insn
      }
    }
  }
}