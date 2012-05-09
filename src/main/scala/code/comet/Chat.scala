package code.comet

/**
 * Created with IntelliJ IDEA.
 * User: Chris
 * Date: 08/05/12
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */

import net.liftweb._
import http._
import actor._
import util.ClearClearable

//import scala.collection.immutable.Vector

object ChatServer extends LiftActor with ListenerManager {
  private var msgs = Vector("Welcome", "Welcome2")

  def createUpdate = msgs

  override def lowPriority = {
    case s: String => msgs :+= s; updateListeners()
  }
}

class Chat extends CometActor with CometListener {
  private var msgs: Vector[String] = Vector()

  def registerWith = ChatServer

  override def lowPriority = {
    case v: Vector[String] => msgs = v; reRender()

  }

  def render = "li *" #> msgs
}
