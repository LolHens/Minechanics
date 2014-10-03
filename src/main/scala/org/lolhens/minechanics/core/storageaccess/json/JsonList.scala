package org.lolhens.minechanics.core.storageaccess.json

import org.lolhens.minechanics.core.storageaccess._

import scala.collection.JavaConversions._
import scala.collection.mutable

class JsonList(override val obj: java.util.List[_]) extends ValidJsonObject[java.util.List[_]](obj) {
  override def apply(i: Int) = if (i >= obj.size || i < 0) JsonObject else JsonObject.fromAny(obj.get(i))

  override def foreach(f: StorageAccess => Unit) = {
    val iterator = obj.iterator;
    while (iterator.hasNext) f(JsonObject.fromAny(iterator.next))
  }

  override def map[B](f: (Any) => B): mutable.Buffer[B] = obj.map(f)
}